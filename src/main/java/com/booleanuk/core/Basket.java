package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private HashMap<String, Integer> basket;
    private ItemList itemList = new ItemList();
    private int capacity = 10;

    public Basket() {
        this.basket = new HashMap<>();
    }

    public int countTotalItems() {
        int totalItems = 0;
        for (Map.Entry<String, Integer> kvp: this.basket.entrySet()) {
            totalItems += kvp.getValue();
        }
        return  totalItems;
    }

    public HashMap<String, Integer> checkAllItems() {
        return this.basket;
    }

    public void printOutHashMap() {
        System.out.println(this.basket);
    }

    public String addItemToBasket(Item item){
        if(countTotalItems() < this.capacity) {
            if(this.basket.containsKey(item.getSKU())) {
                int oldQuantity = this.basket.get(item.getSKU());
                this.basket.replace(item.getSKU(), oldQuantity, oldQuantity + 1);
                return "Added another " + item.getName() + " to basket.";
            }else {
                this.basket.put(item.getSKU(), 1);
                return "Added " + item.getName() + " to basket.";
            }
        }
        return "Basket is full.";
    }

    public String addItemToBasket(Bagel bagel, Filling filling) {
        if(!addItemToBasket(filling).equals("Basket is full.") && !addItemToBasket(bagel).equals("Basket is full.")) {
            bagel.addFilling(filling);
            return "Added " + bagel.getName() + " with filling " + filling.getName() + " to basket.";
        }else {
            return "Basket is full.";
        }
    }

    public int getItemQuantityFromSKU(String sku) {
        if(this.basket.containsKey(sku)) {
            return this.basket.get(sku);
        }
        return 0;
    }

    public double countTotalValueOfItems() {
        double totalPrice = 0;
        for (Map.Entry<String, Integer> kvp: this.basket.entrySet()) {
           totalPrice += (itemList.getPriceFromList(kvp.getKey()) * kvp.getValue());
        }
       return  totalPrice;
    }

    public void removeItemFromBasket(String sku) {
        if(this.basket.get(sku) > 1) {
            int oldQuantity = this.basket.get(sku);
            this.basket.replace(sku, oldQuantity, oldQuantity - 1);
        }else this.basket.remove(sku);
    }

    //To remove Bagel and checks if it has filling
    public void removeItemFromBasket(Bagel bagel) {
        removeItemFromBasket(bagel.getSKU());
        if(bagel.getFilling() != null) {
            removeItemFromBasket(bagel.getFilling().getSKU());
        }
    }

    //To remove a specific bagel with a specific filling
    public void removeItemFromBasket(Bagel bagel, Filling filling) {
        removeItemFromBasket(bagel.getSKU());
        if(bagel.getFilling() != null) {
            removeItemFromBasket(filling.getSKU());
        }
    }


}
