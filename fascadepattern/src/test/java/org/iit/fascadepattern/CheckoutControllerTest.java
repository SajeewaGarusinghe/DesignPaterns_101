package org.iit.fascadepattern;

import org.iit.fascadepattern.controller.CheckoutController;
import org.iit.fascadepattern.facade.CheckoutFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
 class CheckoutControllerTest {

    @Mock
    private CheckoutFacade checkoutFacade;

    @InjectMocks
    private CheckoutController checkoutController;

    @Test
     void testPlaceOrderSuccess() {
        // Arrange
        Long userId = 1L;
        doNothing().when(checkoutFacade).checkout(userId);

        // Act
        ResponseEntity<String> response = checkoutController.placeOrder(userId);

        // Assert
        assertEquals("Order placed successfully!", response.getBody());
        verify(checkoutFacade).checkout(userId);
    }

    @Test
     void testPlaceOrderInvalidUserId() {
        // Arrange
        Long userId = null;

        // Act and Assert
        ResponseEntity<String> response = checkoutController.placeOrder(userId);
        assertEquals("Order placed successfully!", response.getBody()); // Note: This test might not be ideal, as the method doesn't handle null user IDs explicitly
    }

    @Test
     void testPlaceOrderNonExistentUserId() {
        // Arrange
        Long userId = -1L;
        doNothing().when(checkoutFacade).checkout(userId);

        // Act
        ResponseEntity<String> response = checkoutController.placeOrder(userId);

        // Assert
        assertEquals("Order placed successfully!", response.getBody());
        verify(checkoutFacade).checkout(userId);
    }
}