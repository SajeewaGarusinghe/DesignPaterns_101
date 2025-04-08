package org.iit.strategypattern.strategies;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("paypal")
public class PayPalPayment implements PaymentStrategy {
    Logger logger = Logger.getLogger(getClass().getName());
    public void pay(double amount) {
        logger.log(java.util.logging.Level.INFO, "Paid LKR {0} using PayPal", amount);
    }
}