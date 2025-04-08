package org.iit.strategypattern.exception;

public class InvalidPaymentTypeException extends Exception {
    public InvalidPaymentTypeException(String message) {
        super(message);
    }
}