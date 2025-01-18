package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> stock = new HashMap<>();


    public Inventory(){

    }

    public int getStockSize(){
        return this.stock.size();
    }

    public int getItemStock(String sku){
        return this.stock.get(sku);
    }

    public void addStockItem(String sku, int amount){
        if (!stock.containsKey(sku)){
            stock.put(sku, amount);
            return;
        }
        stock.put(sku, stock.get(sku) + amount);
    }

    public void removeStockItem(String sku, int amount){
        if (stock.containsKey(sku) && stock.get(sku) >= amount){
            stock.put(sku, stock.get(sku) - amount);
            if (stock.get(sku) == 0){
                stock.remove(sku);
            }
            return;
        }
        System.out.println("Not enough stock in inventory!");
    }


}
