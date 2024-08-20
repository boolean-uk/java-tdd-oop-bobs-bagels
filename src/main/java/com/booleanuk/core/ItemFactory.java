package com.booleanuk.core;

public class ItemFactory {

    public static Coffee coffeeFactory(String sku) {
        return new Coffee(sku);
    }

    public static Filling fillingFactory(String sku) {
        return new Filling(sku);
    }

    public static Bagel bagelFactory(String sku) {
        return new Bagel(sku);
    }

    public static Bagel bagelWithFillingFactory(String bagel, String fillingSKU){
        Filling filling = fillingFactory(fillingSKU);
        return new Bagel(bagel, filling);
    }
}
