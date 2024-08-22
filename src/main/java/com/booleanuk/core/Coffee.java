package com.booleanuk.core;

public class Coffee extends Product implements Helper {

    Coffee(String SKU, double price, String variant) {
        super(SKU, price, variant);
    }

    public boolean addProduct(Order order) {
        order.getBasket().put(this.getSKU(), order.getBasket().getOrDefault(this.getSKU(), 0) + 1);
        order.addToTotalPrice(this.getPrice());
        order.getCoffeeList().add(this);
        System.out.println(order.sizeOfBasket());
        return true;
    }

}
