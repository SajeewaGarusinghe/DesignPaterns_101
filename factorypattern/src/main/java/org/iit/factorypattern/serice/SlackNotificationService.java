package org.iit.factorypattern.serice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("slack")
public class SlackNotificationService implements NotificationService {
    public void sendNotification(String message) {
        log.info("Sending Slack message: {}", message);
    }
}
