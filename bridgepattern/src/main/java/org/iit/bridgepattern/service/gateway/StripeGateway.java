package org.iit.bridgepattern.service.gateway;

import org.springframework.stereotype.Component;

@Component
public class StripeGateway implements PaymentGateway {
    public void processPayment(String paymentType, double amount) {
        System.out.println("Processing " + paymentType + " payment via Stripe: $" + amount);
    }
}