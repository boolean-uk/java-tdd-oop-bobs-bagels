package com.booleanuk.extension;

public class Discount {
    double discountAmount;
    double price;
    int amount;
    String name;

    public Discount(double price, int amount, String name, double discountAmount) {
        this.price = price;
        this.amount = amount;
        this.name = name;
        this.discountAmount = discountAmount;

    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }
}
