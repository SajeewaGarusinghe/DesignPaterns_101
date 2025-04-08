package org.iit.obderverpattern.model;

public class Order {
    private String orderId;
    private String customerName;
    private double amount;
    private String status;

    // Constructor
    public Order(String orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.status = "CREATED";
    }

    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}