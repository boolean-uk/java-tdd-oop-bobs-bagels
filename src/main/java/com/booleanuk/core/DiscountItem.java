package com.booleanuk.core;

public class DiscountItem extends Item{

    private String name;
    private String type;
    private String nametype;
    private double price;
    private int quantity;

    public DiscountItem(String name, String type, double price, int quantity) {
        super(name, type, price, quantity);
    }

}
