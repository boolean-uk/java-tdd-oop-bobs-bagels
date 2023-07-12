package com.booleanuk.core;

public class Bagel extends Product{
    
    private Product filling = null;

    public Bagel(String sku, double price, String name, String variant){
        super(sku, price, name, variant);
    }
    
    
    public Bagel(String sku, double price, String name, String variant, Product filling){
        super(sku, price, name, variant);
        this.filling = filling;
    }

    public Product getFilling() {
        return filling;
    }


}
