package org.iit.fascadepattern.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    Logger logger = org.slf4j.LoggerFactory.getLogger(CartService.class);
    public void validateCart(Long userId) {
        logger.info("Cart validated for user: {}", userId);
    }
}