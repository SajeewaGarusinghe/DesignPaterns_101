package org.iit.singletonpattern.controller;

import org.iit.singletonpattern.service.ProductService;
import org.iit.singletonpattern.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    private final UserService userService;
    private final ProductService productService;

    public AppController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/test")
    public String testLogging() {
        userService.createUser("john_doe");
        productService.addProduct("MacBook");
        productService.addProduct(null);
        return "Logging completed.";
    }
}