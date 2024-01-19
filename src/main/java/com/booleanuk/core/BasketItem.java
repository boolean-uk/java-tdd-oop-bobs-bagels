package com.booleanuk.core;

public class BasketItem {
    private String item;
    private int quantity;
    private double price;
    private String[] fillings;
    private int numFillings;



    public BasketItem(String item, int quantity, double price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public BasketItem(String item, int quantity, double price, String[] fillings) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.fillings = fillings;
        this.numFillings = fillings.length;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getItem() {
        return item;
    }

    public String[] getFillings() {
        return fillings;
    }

    public void setFillings(String[] fillings) {
        this.fillings = fillings;
    }

    public int getNumFillings() {
        return numFillings;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
