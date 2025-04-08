package org.iit.factorypattern.factory;

import org.iit.factorypattern.serice.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {

    private final ApplicationContext context;

    @Autowired
    public NotificationFactory(ApplicationContext context) {
        this.context = context;
    }

    public NotificationService getNotificationService(String channel) {
        if (!context.containsBean(channel.toLowerCase())) {
            throw new IllegalArgumentException("Unknown notification channel: " + channel);
        }
        return context.getBean(channel.toLowerCase(), NotificationService.class);// this will return the bean of type NotificationService
    }
}
