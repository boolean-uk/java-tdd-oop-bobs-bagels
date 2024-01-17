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

    public boolean isInStock(String sku){
        if (bagelInventory.containsKey(sku)){
            return bagelInventory.get(sku) > 0;
        }
        else if (coffeeInventory.containsKey(sku)){
            return coffeeInventory.get(sku) > 0;
        }
        else if (fillingInventory.containsKey(sku)){
            return coffeeInventory.get(sku) > 0;
        }
        return false;
    }

    public String updateStock(String sku, int amount){
        if (bagelInventory.containsKey(sku)){
            bagelInventory.put(sku,amount);
        }
        else if (coffeeInventory.containsKey(sku)){
            coffeeInventory.put(sku,amount);
        }
        else if (fillingInventory.containsKey(sku)){
            fillingInventory.put(sku, amount);
        }
        return sku + " stock has been updated";
    }

}
