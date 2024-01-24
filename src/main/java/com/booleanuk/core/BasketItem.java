package com.booleanuk.core;

public class BasketItem extends Item {
    private String name;
    private String type;
    private String nametype;
    private int quantity;
    private double price;
    private String[] fillings;

    public BasketItem(String name, String type, int quantity, double price) {
        super(name, type, price, quantity);
    }

    public BasketItem(String name, String type, int quantity, double price, String[] fillings) {
        super(name, type, price, quantity, fillings);
    }

}
