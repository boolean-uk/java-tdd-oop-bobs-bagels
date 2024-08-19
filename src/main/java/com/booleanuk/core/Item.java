package com.booleanuk.core;

import java.util.HashMap;

public class Item {
    private String SKU;
    private Double Price;
    private Boolean Purchase;
    private String name;
    private String type;

    public Double getPrice(){
        return Price;
    }

    public boolean canPurchase(){
        return  Purchase;
    }

    public String getSKU(){
        return SKU;
    }

    public String getName(){
        return name;
    }

    public void setPrice(Double price){
        this.Price= price;
    }

    public void setSku(String sku){
        this.SKU= sku;
    }

    public void setPurchase(boolean status){
        this.Purchase=status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type){
        this.type=type;
    }

    public String getType() {
        return type;
    }
}
