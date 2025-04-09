package org.iit.singletonpattern.service;

import org.iit.singletonpattern.util.AppLogger;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final AppLogger logger;

    public ProductService(AppLogger logger) {
        this.logger = logger;
    }

    public void addProduct(String product) {
        if (product == null) {
            logger.error("Failed to create product: null");
        } else {
            logger.info("Product added: " + product);
        }
    }
}
