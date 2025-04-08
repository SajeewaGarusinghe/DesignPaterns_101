package org.iit.strategypattern.service;

import org.iit.strategypattern.exception.InvalidPaymentTypeException;
import org.iit.strategypattern.strategies.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {

    private final Map<String, PaymentStrategy> paymentStrategies;

    // Spring will inject all strategies using @Component + @Qualifier map
    public PaymentService(Map<String, PaymentStrategy> paymentStrategies) {
        this.paymentStrategies = paymentStrategies;
    }

    public void processPayment(String type, double amount) {
        PaymentStrategy strategy = paymentStrategies.get(type.toLowerCase());
        if (strategy == null) try {
            throw new InvalidPaymentTypeException("Invalid payment type: " + type);
        } catch (InvalidPaymentTypeException e) {
            throw new RuntimeException(e);
        }
        strategy.pay(amount);
    }
}
