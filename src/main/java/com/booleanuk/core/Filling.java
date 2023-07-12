package com.booleanuk.core;

import java.util.HashSet;

public class Filling extends Item {

    public static HashSet<String> fillingsSkus;
    public static void fillFillingsSkus() {
        fillingsSkus = new HashSet<String>();
        fillingsSkus.add("FILB");
        fillingsSkus.add("FILE");
        fillingsSkus.add("FILC");
        fillingsSkus.add("FILX");
        fillingsSkus.add("FILS");
        fillingsSkus.add("FILH");
    }
    public Filling(String sku) {
        super(sku);
        ItemPriceVariant ipv = Item.itemPriceVariants.get(sku);
    }
}
