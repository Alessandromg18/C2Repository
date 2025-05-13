package com.example.tuempresa.event;

import com.example.tuempresa.model.Product;
import com.example.tuempresa.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        productRepository.deleteAll(); // Limpia datos anteriores

        productRepository.save(new Product("mouse gamer", 3));
        productRepository.save(new Product("teclado mecánico", 2));
        productRepository.save(new Product("monitor 24 pulgadas", 1));
    }
}
