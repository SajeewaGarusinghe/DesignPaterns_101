package org.iit.obderverpattern.controller;

import org.iit.obderverpattern.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public String createOrder(@RequestParam String orderId,
                              @RequestParam String customerName,
                              @RequestParam double amount) {
        orderService.processOrder(orderId, customerName, amount);
        return "Order processed successfully";
    }
}