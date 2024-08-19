package com.booleanuk.core;

import java.util.HashMap;

public class Item {
    private final String SKU;
    private double price;
    private String type;
    private String name;
    private final ItemList itemList;
    public Item(String SKU) {
        this.SKU = SKU;
        itemList = new ItemList();
        setPriceFromList();
        setTypeFromList();
        setNameFromList();
    }

    public String getSKU() {
        return this.SKU;
    }

    public double getPrice() {
        return this.price;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    private void setPriceFromList() {
        HashMap<String, Double> priceList = itemList.getPriceList();
        this.price = priceList.get(this.SKU);
    }

    private void setTypeFromList() {
        HashMap<String, String> typeList = itemList.getTypeList();
        this.type = typeList.get(this.SKU);
    }

    private void setNameFromList() {
        HashMap<String, String> nameList = itemList.getNameList();
        this.name = nameList.get(this.SKU);
    }



}
