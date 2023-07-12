package com.booleanuk.core;

import java.util.HashMap;

public class Item {
    private String sku;
    private double price;
    private String variant;
    public static HashMap<String, ItemPriceVariant> itemPriceVariants;
    public static void fillItemPriceVariants() {
        itemPriceVariants = new HashMap<String, ItemPriceVariant>();
        itemPriceVariants.put("BGLO", new ItemPriceVariant("Onion", 0.49));
        itemPriceVariants.put("BGLP", new ItemPriceVariant("Plain", 0.39));
        itemPriceVariants.put("BGLE", new ItemPriceVariant("Everything", 0.49));
        itemPriceVariants.put("BGLS", new ItemPriceVariant("Sesame", 0.49));
        itemPriceVariants.put("COFB", new ItemPriceVariant("Black", 0.99));
        itemPriceVariants.put("COFW", new ItemPriceVariant("White", 1.19));
        itemPriceVariants.put("COFC", new ItemPriceVariant("Capuccino", 1.29));
        itemPriceVariants.put("COFL", new ItemPriceVariant("Latte", 1.29));
        itemPriceVariants.put("FILB", new ItemPriceVariant("Bacon", 0.12));
        itemPriceVariants.put("FILE", new ItemPriceVariant("Egg", 0.12));
        itemPriceVariants.put("FILC", new ItemPriceVariant("Cheese", 0.12));
        itemPriceVariants.put("FILX", new ItemPriceVariant("Cream Cheese", 0.12));
        itemPriceVariants.put("FILS", new ItemPriceVariant("Smoked Salmon", 0.12));
        itemPriceVariants.put("FILH", new ItemPriceVariant("Ham", 0.12));
    }
    public Item(String sku) {
        ItemPriceVariant ipv = com.booleanuk.core.Item.itemPriceVariants.get(sku);
        this.setSku(sku);
        this.setVariant(ipv.getVariant());
        this.setPrice(ipv.getPrice());
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setVariant(String variant) {
        this.variant = variant;
    }
    public String getVariant() {
        return variant;
    }
}

