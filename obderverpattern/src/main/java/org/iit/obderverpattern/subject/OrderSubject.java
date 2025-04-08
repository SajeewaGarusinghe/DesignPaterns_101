package org.iit.obderverpattern.subject;

import org.iit.obderverpattern.observer.OrderObserver;

public interface OrderSubject {
    void registerObserver(OrderObserver observer);
    void removeObserver(OrderObserver observer);
    void notifyObservers();
}