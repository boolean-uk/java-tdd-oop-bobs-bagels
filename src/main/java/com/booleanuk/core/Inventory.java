package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    Bagel bagels = new Bagel();
    Coffee coffee = new Coffee();
    Filling filling = new Filling();

    HashMap<String, Integer> bagelInventory = new HashMap<>();
    HashMap<String, Integer> coffeeInventory = new HashMap<>();
    HashMap<String, Integer> fillingInventory = new HashMap<>();

    public Inventory(){
        for (int i = 0; i < filling.sku.length; i++){
            if (i < 4){
                bagelInventory.put(bagels.sku[i], 30);
                coffeeInventory.put(coffee.sku[i],25);
            }
            fillingInventory.put(filling.sku[i],50);
        }
    }

}
