package com.booleanuk.core;

public class Receipt {

    private final Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public boolean printReceipt() {
        System.out.println("Receipt for order: " + order);
        return true;
    }
}
