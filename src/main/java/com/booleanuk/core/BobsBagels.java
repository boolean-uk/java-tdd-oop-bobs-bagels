package com.booleanuk.core;

import com.booleanuk.extension.Discounts;
import com.booleanuk.extension.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BobsBagels {
    private Map<String, Basket> baskets;
    private List<User> users;
    private Inventory inventory;
    private Discounts discounts;
    private Checkout checkout;

    public BobsBagels() {
        this.baskets = new HashMap<>();
        this.users = new ArrayList<>();
        this.inventory = new Inventory();
        this.discounts = new Discounts(inventory);
        this.checkout = new Checkout(inventory, discounts);
    }

    public Map<String, Basket> getBaskets() {
        return baskets;
    }

    public Basket getBasket(String phoneNumber) {
        this.baskets.putIfAbsent(phoneNumber, new Basket(this.inventory, this.checkout));
        return this.baskets.get(phoneNumber);
    }

    public User getUser(String phoneNumber) {
        List<User> l = this.users.stream().filter(x->x.getPhoneNumber().equals(phoneNumber)).toList();
        if (l.isEmpty()) {
            this.users.add(new User(phoneNumber));
        }
        l = this.users.stream().filter(x->x.getPhoneNumber().equals(phoneNumber)).toList();
        return l.get(0);
    }

    public String setBasketCapacity(int cap) {
        if (cap < 1) {
            return "Minimum capacity for baskets are 1";
        }
        boolean overCap = false;
        for(Map.Entry<String, Basket> entry: baskets.entrySet()) {
            if (entry.getValue().getNumberOfItems() > cap) {
                overCap = true;
            }
            entry.getValue().setCapacity(cap);
        }
        if (overCap) {
            return "Capacity set to 1. There are customers with more than 1 product in basket";
        }
        return "Capacity set to 3";
    }

}