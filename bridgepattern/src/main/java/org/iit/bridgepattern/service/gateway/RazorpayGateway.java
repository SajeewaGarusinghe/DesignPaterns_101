package org.iit.bridgepattern.service.gateway;

import org.springframework.stereotype.Component;

@Component
public class RazorpayGateway implements PaymentGateway {
    public void processPayment(String paymentType, double amount) {
        System.out.println("Processing " + paymentType + " payment via Razorpay: $" + amount);
    }
}