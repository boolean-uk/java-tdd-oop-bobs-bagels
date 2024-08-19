
package com.booleanuk.core;

public class Order {
    private final Basket basket;
    private Double totalCost;

    public Order() {
        this.basket = new Basket();
        this.totalCost = 0.0;
    }

    public Basket getBasket() {
        return basket;
    }

    public Integer getTotalCost() {
        for (Product product : this.basket.getProducts()) {
            this.totalCost += product.getPrice();

        }
        return totalCost.intValue();
    }
}
