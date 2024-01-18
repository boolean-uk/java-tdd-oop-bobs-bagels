package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {

    private Basket basket;

    public Customer() {
    }

    public double getTotalCost(ArrayList<Item> items) {
        return items.stream()
                .map(Item::getPrice)
                .reduce(0.00, Double::sum);
    }

    public double getCostOfItem(Item item) {
        return item.getPrice();
    }

    public boolean setBasket(Basket basket) {
        this.basket = basket;
        return true;

    }

    public Basket getBasket() {
        return this.basket;
    }

    public double getCostOfFillings(ArrayList<Item> fillings) {
        return this.getTotalCost(fillings);
    }
}
