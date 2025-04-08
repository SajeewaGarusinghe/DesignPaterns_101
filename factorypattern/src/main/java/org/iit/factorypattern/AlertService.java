package org.iit.factorypattern;

import org.iit.factorypattern.factory.NotificationFactory;
import org.iit.factorypattern.serice.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

    private final NotificationFactory notificationFactory;

    public AlertService(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void sendAlert(String channel, String message) {
        NotificationService service = notificationFactory.getNotificationService(channel);
        service.sendNotification(message);
    }
}
