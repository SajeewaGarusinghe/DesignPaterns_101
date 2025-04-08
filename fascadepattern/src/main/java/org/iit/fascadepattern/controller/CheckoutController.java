package org.iit.fascadepattern.controller;

import org.iit.fascadepattern.facade.CheckoutFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutFacade checkoutFacade;

    public CheckoutController(CheckoutFacade checkoutFacade) {
        this.checkoutFacade = checkoutFacade;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<String> placeOrder(@PathVariable Long userId) {
        checkoutFacade.checkout(userId);
        return ResponseEntity.ok("Order placed successfully!");
    }
}
