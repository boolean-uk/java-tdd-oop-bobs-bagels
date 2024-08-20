package com.booleanuk.extension.extension;

public abstract class Item {
    private String sku;
    private double price;
    private String name;
    private SpecialOffer specialOffer;

    public Item(String sku, double price, String name, SpecialOffer specialOffer) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.specialOffer = specialOffer;
    }

    public String getSku() {
        return sku;
    }



    public double getPrice() {
        return price;
    }



    public String getName() {
        return name;
    }


    public SpecialOffer getSpecialOffer() {
        return specialOffer;
    }
}


