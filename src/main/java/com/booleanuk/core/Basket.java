package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private final int DEFAULT_CAPACITY = 5;

    private ArrayList<Product> basket; // String=SKU, Integer=quantity in the basket
    private int capacity;

    public Basket() {
        this.capacity = DEFAULT_CAPACITY;
        this.basket = new ArrayList<>();
    }

    public boolean addProduct(Product p) {
        if (isFull() || this.basket.contains(p)) {
            return false;
        }

        this.basket.add(p);
        return true;
    }

    public ArrayList<Product> getBasket() {
        return this.basket;
    }

    public boolean isFull() {
        return this.basket.size() == this.capacity;
    }

    public boolean remove(Product p) {
        if (!this.basket.contains(p) || this.isFull()) return false;

        this.basket.remove(p);
        return true;
    }

    public double getTotalCost() {
        double totalPrice = 0;
        for (Product p : this.basket) {
            if (p instanceof Bagel && ((Bagel) p).getFilling() != null) {
                totalPrice += ((Bagel) p).getFilling().getPrice(); // If bagel has a filling, add to total price
                continue;
            }
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }

}
