package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Customer {

    private Basket basket;

    public Customer() {
    }

    public double getTotalCost(Map<Item,Integer> items) {
        double cost = 0.00;
        int discount12 = 0;
        int discount6 = 0;

        Inventory inventory = new Inventory();
        for(Map.Entry<Item, Integer> entry : items.entrySet()) {
            if(inventory.getBagels().containsKey(entry.getKey().getSkuCode())) {

                int quantity = entry.getValue();

                int rest = entry.getValue() % 12;
                if(rest >= 6) {
                    discount6++;
                }
                while(quantity % 12 == 0) {
                    quantity /= 12;
                    discount12++;
                }

                cost += getCostOfItem(entry.getKey()) * (rest % 6);
            }
        }
        cost += discount12 * 3.99;
        cost += discount6 * 2.49;

        return cost;

      /*  return items.entrySet().stream().map()
                .map(Item::getPrice)
                .reduce(0.00, Double::sum);*/
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

/*
    public double getCostOfFillingsInBasket(Map<Item, Integer> basket) {
        return this.getTotalCost(basket.entrySet().stream().filter(item -> item.getKey().getName().equalsIgnoreCase("Filling")).collect(Collectors.toList()));
    }
*/


    public Map<String, Double> getFillingsInInventory() {
        Inventory inventory = new Inventory();

        return inventory.getFillings();


    }


    public boolean order(String skuCode) {
        Inventory inventory = new Inventory();

        return inventory.getInventoryMap().containsKey(skuCode);
    }
}