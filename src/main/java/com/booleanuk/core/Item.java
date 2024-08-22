package com.booleanuk.core;

import java.util.HashMap;

public abstract class Item {
    private final String SKU;
    private float price;
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

    public float getPrice() {
        return this.price;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    private void setPriceFromList() {
        HashMap<String, Float> priceList = itemList.getPriceList();
        if(priceList.get(this.SKU) != null) {
            this.price = priceList.get(this.SKU);
        } else {
            this.type = null;
        }
    }

    private void setTypeFromList() {
        HashMap<String, String> typeList = itemList.getTypeList();
        if(typeList.get(this.SKU) != null) {
            this.type = typeList.get(this.SKU);
        } else {
            this.type = null;
        }
    }

    private void setNameFromList() {
        HashMap<String, String> nameList = itemList.getNameList();
        if(nameList.get(this.SKU) != null) {
            this.name = nameList.get(this.SKU);
        } else {
            this.name = null;
        }
    }
}
