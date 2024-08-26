package com.booleanuk.core;

public class Bagel extends Product {
    private Filling filling;

    public Bagel (String SKU, double price, String name, String variant){
        super(SKU, price, name, variant);
        filling = null;
    }

    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return super.toString()+
                " filling= " + filling +
                '}';
    }
}
