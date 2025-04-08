package org.iit.fascadepattern.facade;

import org.iit.fascadepattern.service.CartService;
import org.iit.fascadepattern.service.InventoryService;
import org.iit.fascadepattern.service.NotificationService;
import org.iit.fascadepattern.service.OrderService;
import org.iit.fascadepattern.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class CheckoutFacade {

    private final CartService cartService;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final OrderService orderService;
    private final NotificationService notificationService;

    public CheckoutFacade(
            CartService cartService,
            InventoryService inventoryService,
            PaymentService paymentService,
            OrderService orderService,
            NotificationService notificationService
    ) {
        this.cartService = cartService;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.notificationService = notificationService;
    }

    public void checkout(Long userId) {
        cartService.validateCart(userId);
        inventoryService.updateInventory(userId);
        paymentService.processPayment(userId);
        orderService.createOrder(userId);
        notificationService.sendConfirmation(userId);
    }
}
