package com.booleanuk.core;

import com.booleanuk.core.discounts.Discount;
import com.booleanuk.core.discounts.DiscountManager;
import com.booleanuk.core.products.Product;
import com.booleanuk.core.products.bagels.Bagel;

import java.util.ArrayList;

public class Basket {

    private final int DEFAULT_CAPACITY = 5;

    private ArrayList<Product> basket; // String=SKU
    private ArrayList<Discount> discounts; // Current discounts in this basket
    private int capacity;
    private DiscountManager discountManager;

    public Basket() {
        this.capacity = DEFAULT_CAPACITY;
        this.basket = new ArrayList<>();
        this.discounts = new ArrayList<>();
        this.discountManager = new DiscountManager();
    }

    public boolean addProduct(Product p) {
        if (isFull() || this.basket.contains(p)) {
            return false;
        }

        // Bagel with filling needs two spots in basket.
        if (p instanceof Bagel && ((Bagel) p).getFilling() != null && (this.basket.size() + 2) > this.capacity) {
            return false;
        }

        // If product is a bagel, and it has filling, adding its filling to basket also
        if (p instanceof Bagel && ((Bagel) p).getFilling() != null) {
            this.basket.add(((Bagel) p).getFilling());
        }

        this.basket.add(p);
        this.checkDiscounts(p);

        return true;
    }

    private void checkDiscounts(Product p) {
        this.discounts.addAll(this.discountManager.checkDiscount(p));
        for (Discount c : this.discounts) {
            // this.discounts keeps track of the discounted products in basket, so remove them from here
            this.basket.removeAll(c.getProductsInDiscount());
        }
    }

    public ArrayList<Product> getBasket() {
        ArrayList<Product> toReturn = new ArrayList<>();
        toReturn.addAll(this.basket);
        for (Discount d : this.discounts) toReturn.addAll(d.getProductsInDiscount());

        return toReturn;
    }

    public boolean isFull() {
        int currentCapacity = 0;

        for (Product p : this.basket) {
            currentCapacity += 1;
        }

        for (Discount d : this.discounts) {
            for (Product p : d.getProductsInDiscount()) {
                currentCapacity += 1;
            }
        }

        return currentCapacity == this.capacity;
    }

    public boolean remove(Product p) {
        if (!this.basket.contains(p) || this.isFull()) return false;

        this.basket.remove(p);
        return true;
    }

    public double getTotalCost() {
        double totalPrice = 0;
        for (Product p : this.basket) {
            totalPrice += p.getPrice();
        }

        for (Discount c : this.discounts) {
            totalPrice += c.getPriceAfterDiscount();
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

    protected ArrayList<Discount> getDiscounts() {
        return this.discounts;
    }

    public ArrayList<Product> getProductsNotInDiscount() {
        return this.basket;
    }

}
