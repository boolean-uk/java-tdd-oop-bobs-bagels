package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    private List<Product> menu;
    private HashMap<String, Integer> inventory;

    public Inventory() {
        this.menu = new ArrayList<>();
        this.inventory = new HashMap<>();

        Bagel onionBagel = new Bagel("BGLO", "Onion", 0.49 );
        Bagel plainBagel = new Bagel("BGLP", "Plain", 0.49 );
        Bagel everythingBagel = new Bagel("BGLE", "Everything", 0.49 );
        Bagel sesameBagel = new Bagel("BGLS", "Sesame", 0.49 );
        Coffee blackCoffee = new Coffee("COFB", "Black",0.99);
        Filling baconFilling = new Filling("FILB", "Bacon",0.12);
    }

    public Integer getInventory(String sku) {
        return inventory.get(sku);
    }

    public void addToMenu(Product item, int stock){
        menu.add(item);
        inventory.put(item.getSku(), stock);
    }

    public boolean isInStock(String sku){
        return inventory.containsKey(sku) && inventory.get(sku) > 0;
    }
    /*
    public Product getProduct(String sku){
        for (Product item: menu){
            if (item.getSku().equals(sku)){
                return item;
            }
        }return null;
    }

     */

    public void decreaseStock(String sku){
        if (inventory.containsKey(sku)){
            int inStock = inventory.get(sku);
            if (inStock > 0){
                inventory.put(sku, inStock -1 );
            }
            else {
                System.out.println("Item out of stock");
            }

        }else {
            System.out.println("Item Not Found");
        }
    }
}
