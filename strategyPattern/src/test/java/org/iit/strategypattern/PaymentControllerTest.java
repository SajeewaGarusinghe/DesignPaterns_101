package org.iit.strategypattern;

import org.iit.strategypattern.controller.PaymentController;
import org.iit.strategypattern.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    @Test
     void testMakePayment_Success() {
        // Given
        String type = "creditCard";
        double amount = 10.99;

        // When
        ResponseEntity<String> response = paymentController.makePayment(type, amount);

        // Then
        assertEquals("Payment processed using: " + type, response.getBody());
        verify(paymentService).processPayment(type, amount);
    }

    @Test
     void testMakePayment_InvalidType() {
        // Given
        String type = "invalidType";
        double amount = 10.99;
        doThrow(new RuntimeException("Invalid payment type: " + type)).when(paymentService).processPayment(type, amount);

        // When and Then
        assertThrows(RuntimeException.class, () -> paymentController.makePayment(type, amount));
    }

    @Test
     void testMakePayment_ZeroAmount() {
        // Given
        String type = "creditCard";
        double amount = 0.0;

        // When
        ResponseEntity<String> response = paymentController.makePayment(type, amount);

        // Then
        assertEquals("Payment processed using: " + type, response.getBody());
        verify(paymentService).processPayment(type, amount);
    }

    @Test
     void testMakePayment_NegativeAmount() {
        // Given
        String type = "creditCard";
        double amount = -10.99;

        // When
        ResponseEntity<String> response = paymentController.makePayment(type, amount);

        // Then
        assertEquals("Payment processed using: " + type, response.getBody());
        verify(paymentService).processPayment(type, amount);
    }
}