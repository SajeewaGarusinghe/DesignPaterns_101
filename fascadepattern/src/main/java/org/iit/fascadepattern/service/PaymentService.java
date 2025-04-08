package org.iit.fascadepattern.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    Logger logger = org.slf4j.LoggerFactory.getLogger(PaymentService.class);
    public void processPayment(Long userId) {
        logger.info("Payment processed for user: {}", userId);
    }
}