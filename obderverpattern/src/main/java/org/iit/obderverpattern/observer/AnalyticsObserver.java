package org.iit.obderverpattern.observer;


import org.iit.obderverpattern.model.Order;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsObserver implements OrderObserver {
    Logger logger = org.slf4j.LoggerFactory.getLogger(AnalyticsObserver.class);

    @Override
    public void update(Order order) {
        // In a real application, this would record analytics data
        logger.info("Order analytics updated for order: {} with amount: {}", order.getOrderId(), order.getAmount());

    }
}