package org.iit.obderverpattern.observer;

import org.iit.obderverpattern.model.Order;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class InventoryObserver implements OrderObserver {
    Logger logger = org.slf4j.LoggerFactory.getLogger(InventoryObserver.class);

    @Override
    public void update(Order order) {
        // In a real application, this would update inventory
       logger.info("Inventory updated for order: {}", order.getOrderId());
    }
}
