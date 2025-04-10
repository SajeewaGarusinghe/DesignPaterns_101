package org.iit.bridgepattern.service.payment;

import org.iit.bridgepattern.service.gateway.PaymentGateway;

public class CardPayment extends Payment {
    public CardPayment(PaymentGateway gateway) {
        super(gateway);
    }

    @Override
    public void makePayment(double amount) {
        gateway.processPayment("Card", amount);
    }
}