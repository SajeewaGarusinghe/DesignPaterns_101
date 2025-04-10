package org.iit.bridgepattern.service.gateway;

public interface PaymentGateway {
    void processPayment(String paymentType, double amount);
}