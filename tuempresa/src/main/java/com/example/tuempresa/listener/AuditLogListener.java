package com.example.tuempresa.listener;

import com.example.tuempresa.event.OrderCreatedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {

    private static final Logger logger = LogManager.getLogger(AuditLogListener.class);

    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        logger.info("📝 Auditando pedido con ID: {}", event.getOrder().getId());
    }
}
