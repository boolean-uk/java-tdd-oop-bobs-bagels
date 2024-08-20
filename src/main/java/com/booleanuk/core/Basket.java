package com.booleanuk.core;

import com.booleanuk.core.products.Product;
import com.booleanuk.core.products.bagels.Bagel;

import java.util.ArrayList;

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

        // Bagel with filling needs two spots in basket.
        if (p instanceof Bagel && ((Bagel) p).getFilling() != null && (this.basket.size() + 2) > this.capacity) {
            return false;
        }

        // If product is a bagel and it has filling, adding its filling to basket also
        if (p instanceof Bagel && ((Bagel) p).getFilling() != null) {
            this.basket.add(((Bagel) p).getFilling());
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

    public boolean changeCapacity(int newCapacity, boolean isManager) {
        if (isManager && newCapacity > 0) {
            this.capacity = newCapacity;
            return true;
        }
        return false;
    }

}
