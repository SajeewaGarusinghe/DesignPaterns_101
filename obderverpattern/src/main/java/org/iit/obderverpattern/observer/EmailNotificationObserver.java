package org.iit.obderverpattern.observer;

import org.iit.obderverpattern.model.Order;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationObserver implements OrderObserver {
    Logger logger = org.slf4j.LoggerFactory.getLogger(EmailNotificationObserver.class);

    @Override
    public void update(Order order) {
        // In a real application, this would send an actual email
        logger.info("Email sent to {} for order {} with status: {}", order.getCustomerName(), order.getOrderId(), order.getStatus());
    }
}