package com.booleanuk.core;

import java.util.HashMap;
// Item is an abstract class serving as a blueprint for bagels, fillings and coffee
// It contains, SKU, name, Price and functions to access and set these values
// it also contains a boolean "Purchase" which determines if the item can be bought
// This can be used to prevent a customer from buying a filling without a bagel, or buying something out of stock
public abstract class Item {
    protected String SKU;
    protected Double Price;
    protected Boolean Purchase=false;
    protected String name;

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


}
