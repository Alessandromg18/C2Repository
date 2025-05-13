package com.example.tuempresa.controller;

import com.example.tuempresa.event.OrderCreatedEvent;
import com.example.tuempresa.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public OrderController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        // Publicar el evento personalizado
        OrderCreatedEvent event = new OrderCreatedEvent(this, order);
        eventPublisher.publishEvent(event);

        return ResponseEntity.ok("Orden recibida y evento publicado.");
    }
}
