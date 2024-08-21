package com.booleanuk.core;

import java.util.HashMap;

public class ItemList {
    private HashMap<String, Double> priceList;
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
        this.priceList.put("BGLO", 0.49);
        this.priceList.put("BGLP", 0.39);
        this.priceList.put("BGLE", 0.49);
        this.priceList.put("BGLS", 0.49);
        this.priceList.put("COFB", 0.99);
        this.priceList.put("COFW", 1.19);
        this.priceList.put("COFC", 1.29);
        this.priceList.put("COFL", 1.29);
        this.priceList.put("FILB", 0.12);
        this.priceList.put("FILE", 0.12);
        this.priceList.put("FILC", 0.12);
        this.priceList.put("FILX", 0.12);
        this.priceList.put("FILS", 0.12);
        this.priceList.put("FILH", 0.12);
    }

    public HashMap<String, Double> getPriceList() {
        return this.priceList;
    }

    public HashMap<String, String> getTypeList() {
        return this.typeList;
    }

    public HashMap<String, String> getNameList() {
        return this.nameList;
    }

    public double getPriceFromList(String sku) {
        return this.priceList.get(sku);
    }

    public String getTypeFromList(String sku) {
        return this.typeList.get(sku);
    }
}
