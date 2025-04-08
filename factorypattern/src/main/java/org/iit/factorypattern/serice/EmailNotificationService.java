package org.iit.factorypattern.serice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("email")
public class EmailNotificationService implements NotificationService {
    public void sendNotification(String message) {
        log.info("Sending Email: {}", message);
    }
}
