package com.booleanuk.core;

public class Coffee extends Foods{
    public Coffee(String sku,double price,String variant) {
        super(sku,price,variant);
    }
    public Coffee (String sku){
        super(sku);
        setPrice();
        setVariant();
    }
}
