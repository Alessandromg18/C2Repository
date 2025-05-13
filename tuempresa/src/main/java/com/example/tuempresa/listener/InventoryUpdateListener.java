package com.example.tuempresa.listener;

import com.example.tuempresa.event.OrderCreatedEvent;
import com.example.tuempresa.exception.ProductoNoExisteException;
import com.example.tuempresa.exception.SinStockException;
import com.example.tuempresa.model.Product;
import com.example.tuempresa.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InventoryUpdateListener {

    @Autowired
    private ProductRepository productRepository;
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        Map<String, Integer> productCount = new HashMap<>();
        for (String producto : event.getOrder().getProductos()) {
            productCount.put(producto, productCount.getOrDefault(producto, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            String nombreProducto = entry.getKey();
            int cantidad = entry.getValue();

            Product producto = productRepository.findById(nombreProducto)
                    .orElseThrow(() -> new ProductoNoExisteException(nombreProducto));

            if (producto.getStock() < cantidad) {
                throw new SinStockException("Sin stock suficiente para: " + nombreProducto);
            }
        }

        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            Product producto = productRepository.findById(entry.getKey()).get();
            producto.setStock(producto.getStock() - entry.getValue());
            productRepository.save(producto);
        }
    }

}

