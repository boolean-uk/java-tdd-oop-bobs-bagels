package com.booleanuk.extension;

public class Bagel extends Product {

    private Filling filling;

    public Bagel(String sku, String variant, int price){
        super(sku, variant, price);
    }

    public Filling getFilling(){
        return this.filling;
    }

    public void setFilling(Filling newFilling){
        this.filling = newFilling;
    }

}
