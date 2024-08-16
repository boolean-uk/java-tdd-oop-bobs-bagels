package com.booleanuk.core;

public class Bagel {

    public String sku;
    public double price;
    public String name;
    public BagelVariant variant;


    public Bagel(String sku, double price, String name, BagelVariant variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;

    }

    public enum BagelVariant {
        ONION, PLAIN, EVERYTHING, SESAME;
    }





}
