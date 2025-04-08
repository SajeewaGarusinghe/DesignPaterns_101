package org.iit.obderverpattern.subject;

import org.iit.obderverpattern.model.Order;
import org.iit.obderverpattern.observer.OrderObserver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderManager implements OrderSubject {

    private final List<OrderObserver> observers = new ArrayList<>();
    private Order order;

    @Override
    public void registerObserver(OrderObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(order);
        }
    }

    public void createOrder(Order order) {
        this.order = order;
        // Order is created, notify all observers
        notifyObservers();
    }
}