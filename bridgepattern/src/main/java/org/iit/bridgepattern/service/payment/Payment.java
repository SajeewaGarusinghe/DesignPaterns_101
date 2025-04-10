package org.iit.bridgepattern.service.payment;

import org.iit.bridgepattern.service.gateway.PaymentGateway;

public abstract class Payment {
    protected PaymentGateway gateway;

    public Payment(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public abstract void makePayment(double amount);
}