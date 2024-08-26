package com.booleanuk.core;

public class Item {

    private String itemSKU;
    private float itemPrice;
    private String itemName;
    private String itemVariant;

    public Item(String itemSKU, float itemPrice, String itemName, String itemVariant){
        this.itemSKU = itemSKU;
        this.itemPrice=itemPrice;
        this.itemName=itemName;
        this.itemVariant=itemVariant;
    }

    public String getItemSKU(){
        return itemSKU;
    }

    public float getItemPrice(){
        return itemPrice;
    }

    public String getItemName(){
        return itemName;
    }

    public String getItemVariant(){
        return itemVariant;
    }

}
