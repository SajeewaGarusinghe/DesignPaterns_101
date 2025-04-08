package org.iit.fascadepattern.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    Logger logger = org.slf4j.LoggerFactory.getLogger(InventoryService.class);
    public void updateInventory(Long userId) {
        logger.info("Inventory updated for user: {}", userId);
    }
}