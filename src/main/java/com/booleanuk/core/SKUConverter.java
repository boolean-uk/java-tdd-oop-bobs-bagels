package com.booleanuk.core;

import java.util.HashMap;

public class SKUConverter {

    private HashMap<String, String> nameToSKU;

    public SKUConverter() {
        this.nameToSKU = new HashMap<>();
        createNameToSKU();
    }

    public String getSKU(String name) {
        if (this.nameToSKU.containsKey(name)) {
            return this.nameToSKU.get(name);
        }
        return "Not in the inventory";
    }

    private void createNameToSKU() {
        this.nameToSKU.put("Onion", "BGLO");
        this.nameToSKU.put("Plain", "BGLP");
        this.nameToSKU.put("Everything", "BGLE");
        this.nameToSKU.put("Sesame", "BGLS");
        this.nameToSKU.put("Bacon", "FILB");
        this.nameToSKU.put("Egg", "FILE");
        this.nameToSKU.put("Cheese", "FILC");
        this.nameToSKU.put("Cream Cheese", "FILX");
        this.nameToSKU.put("Smoked Salmon", "FILS");
        this.nameToSKU.put("Ham", "FILH");
        this.nameToSKU.put("Black", "COFB");
        this.nameToSKU.put("White", "COFW");
        this.nameToSKU.put("Cappuccino", "COFC");
        this.nameToSKU.put("Latte", "COFL");
    }
}
