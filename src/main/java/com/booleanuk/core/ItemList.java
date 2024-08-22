package com.booleanuk.core;

import java.util.HashMap;

public class ItemList {
    private HashMap<String, Float> priceList;
    private HashMap<String, String> typeList;
    private HashMap<String, String> nameList;
    public ItemList() {
        this.priceList = new HashMap<>();
        populatePriceList();
        this.typeList = new HashMap<>();
        populateTypeList();
        this.nameList = new HashMap<>();
        populateNameList();
    }

    private void populateNameList() {
        this.nameList.put("BGLO", "Onion");
        this.nameList.put("BGLP", "Plain");
        this.nameList.put("BGLE", "Everything");
        this.nameList.put("BGLS", "Sesame");
        this.nameList.put("COFB", "Black");
        this.nameList.put("COFW", "White");
        this.nameList.put("COFC", "Cappuccino");
        this.nameList.put("COFL", "Latte");
        this.nameList.put("FILB", "Bacon");
        this.nameList.put("FILE", "EGG");
        this.nameList.put("FILC", "Cheese");
        this.nameList.put("FILX", "Cream Cheese");
        this.nameList.put("FILS", "Smoked Salmon");
        this.nameList.put("FILH", "Ham");
    }

    private void populateTypeList() {
        this.typeList.put("BGLO", "Bagel");
        this.typeList.put("BGLP", "Bagel");
        this.typeList.put("BGLE","Bagel");
        this.typeList.put("BGLS", "Bagel");
        this.typeList.put("COFB", "Coffee");
        this.typeList.put("COFW", "Coffee");
        this.typeList.put("COFC", "Coffee");
        this.typeList.put("COFL", "Coffee");
        this.typeList.put("FILB", "Filling");
        this.typeList.put("FILE", "Filling");
        this.typeList.put("FILC", "Filling");
        this.typeList.put("FILX", "Filling");
        this.typeList.put("FILS", "Filling");
        this.typeList.put("FILH", "Filling");
    }


    private void populatePriceList() {
        this.priceList.put("BGLO", 0.49f);
        this.priceList.put("BGLP", 0.39f);
        this.priceList.put("BGLE", 0.49f);
        this.priceList.put("BGLS", 0.49f);
        this.priceList.put("COFB", 0.99f);
        this.priceList.put("COFW", 1.19f);
        this.priceList.put("COFC", 1.29f);
        this.priceList.put("COFL", 1.29f);
        this.priceList.put("FILB", 0.12f);
        this.priceList.put("FILE", 0.12f);
        this.priceList.put("FILC", 0.12f);
        this.priceList.put("FILX", 0.12f);
        this.priceList.put("FILS", 0.12f);
        this.priceList.put("FILH", 0.12f);
    }

    public HashMap<String, Float> getPriceList() {
        return this.priceList;
    }

    public HashMap<String, String> getTypeList() {
        return this.typeList;
    }

    public HashMap<String, String> getNameList() {
        return this.nameList;
    }

    public float getPriceFromList(String sku) {
        return this.priceList.get(sku);
    }

    public String getTypeFromList(String sku) {
        return this.typeList.get(sku);
    }

    public String getNameFromList(String sku) {
        return this.nameList.get(sku);
    }
}
