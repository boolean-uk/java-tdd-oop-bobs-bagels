package com.booleanuk.extension.extension;


import com.booleanuk.core.Item;

public class Filling extends Item {
    private String fillingType;

    public Filling(String sku, double price, String name, String fillingType) {
        super(sku, price, name);
        this.fillingType = fillingType;
    }

    public String getFillingType() {
        return fillingType;
    }

}
