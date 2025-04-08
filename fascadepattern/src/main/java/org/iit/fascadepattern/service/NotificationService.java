package org.iit.fascadepattern.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    Logger logger = org.slf4j.LoggerFactory.getLogger(NotificationService.class);
    public void sendConfirmation(Long userId) {
        logger.info("Notification sent for user: {}", userId);
    }
}