package org.iit.bridgepattern.controller;

import org.iit.bridgepattern.service.gateway.RazorpayGateway;
import org.iit.bridgepattern.service.gateway.StripeGateway;
import org.iit.bridgepattern.service.payment.CardPayment;
import org.iit.bridgepattern.service.payment.Payment;
import org.iit.bridgepattern.service.payment.UpiPayment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final RazorpayGateway razorpayGateway;
    private final StripeGateway stripeGateway;

    public PaymentController(RazorpayGateway razorpayGateway, StripeGateway stripeGateway) {
        this.razorpayGateway = razorpayGateway;
        this.stripeGateway = stripeGateway;
    }

    @GetMapping("/razorpay/card")
    public String payCardRazorpay() {
        Payment payment = new CardPayment(razorpayGateway);
        payment.makePayment(150.0);
        return "Paid via Razorpay with Card!";
    }

    @GetMapping("/stripe/upi")
    public String payUpiStripe() {
        Payment payment = new UpiPayment(stripeGateway);
        payment.makePayment(99.0);
        return "Paid via Stripe with UPI!";
    }
}