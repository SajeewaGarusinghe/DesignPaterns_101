package org.iit.obderverpattern.service;

import org.iit.obderverpattern.model.Order;
import org.iit.obderverpattern.observer.AnalyticsObserver;
import org.iit.obderverpattern.observer.EmailNotificationObserver;
import org.iit.obderverpattern.observer.InventoryObserver;
import org.iit.obderverpattern.subject.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class OrderService {

    private final OrderManager orderManager;
    private final EmailNotificationObserver emailObserver;
    private final InventoryObserver inventoryObserver;
    private final AnalyticsObserver analyticsObserver;

    @Autowired
    public OrderService(OrderManager orderManager,
                        EmailNotificationObserver emailObserver,
                        InventoryObserver inventoryObserver,
                        AnalyticsObserver analyticsObserver) {
        this.orderManager = orderManager;
        this.emailObserver = emailObserver;
        this.inventoryObserver = inventoryObserver;
        this.analyticsObserver = analyticsObserver;
    }

    @PostConstruct
    public void init() {
        // Register all observers
        orderManager.registerObserver(emailObserver);
        orderManager.registerObserver(inventoryObserver);
        orderManager.registerObserver(analyticsObserver);
    }

    public void processOrder(String orderId, String customerName, double amount) {
        Order order = new Order(orderId, customerName, amount);
        orderManager.createOrder(order);
    }
}