package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

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

    public double getCostOfFillingsInBasket(ArrayList<Item> basket) {
        return this.getTotalCost(basket.stream().filter(item -> item.getName().equalsIgnoreCase("Filling")).collect(Collectors.toCollection(ArrayList::new)));
    }


    public Map<String, Double> getFillingsInInventory() {
        Inventory inventory = new Inventory();

        return inventory.getFillings();


    }


}