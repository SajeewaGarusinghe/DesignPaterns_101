package org.iit.obderverpattern.observer;

import org.iit.obderverpattern.model.Order;

public interface OrderObserver {
    void update(Order order);
}