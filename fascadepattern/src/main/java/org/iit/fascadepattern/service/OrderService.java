package org.iit.fascadepattern.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    Logger logger = org.slf4j.LoggerFactory.getLogger(OrderService.class);
    public void createOrder(Long userId) {
        logger.info("Order created for user: {}", userId);
    }
}