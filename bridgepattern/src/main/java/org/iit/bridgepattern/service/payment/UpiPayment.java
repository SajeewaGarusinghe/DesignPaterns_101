package org.iit.bridgepattern.service.payment;

import org.iit.bridgepattern.service.gateway.PaymentGateway;

public class UpiPayment extends Payment {
    public UpiPayment(PaymentGateway gateway) {
        super(gateway);
    }

    @Override
    public void makePayment(double amount) {
        gateway.processPayment("UPI", amount);
    }
}