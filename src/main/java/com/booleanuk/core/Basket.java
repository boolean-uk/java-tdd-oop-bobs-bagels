package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private HashMap<String, Integer> basket;
    private ItemList itemList = new ItemList();
    private int maxCapacity = 10;

    public Basket() {
        this.basket = new HashMap<>();
    }

    public HashMap<String, Double> getFillingPriceList() {
        HashMap<String, Double> price = new HashMap<>();
        for (Map.Entry<String, Double> kvp: this.itemList.getPriceList().entrySet()) {
            if(kvp.getKey().contains("FIL")) {
                //.equals("FIL")
                price.put(kvp.getKey(), kvp.getValue());
            }
        }
        return price;
    }

    public int countTotalItems() {
        int totalItems = 0;
        for (Map.Entry<String, Integer> kvp: this.basket.entrySet()) {
            totalItems += kvp.getValue();
        }
        return  totalItems;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void increaseBasketSize(int increasedSize) {
        this.maxCapacity += increasedSize;
    }

    public HashMap<String, Integer> checkAllItems() {
        return this.basket;
    }

    public void printOutHashMap() {
        System.out.println(this.basket);
    }

    public String addItemToBasket(Item item){
        if(item.getName() == null) {
            return "This item does not exist.";
        }
        if(countTotalItems() < this.maxCapacity) {
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
        if(
                !addItemToBasket(filling).equals("Basket is full.") &&
                !addItemToBasket(bagel).equals("Basket is full.") &&
                !addItemToBasket(bagel).equals("This item does not exist.")
        ){

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

    public boolean removeItemFromBasket(String sku) {
        if(this.basket.containsKey(sku)) {
            if(this.basket.get(sku) > 1) {
                int oldQuantity = this.basket.get(sku);
                this.basket.replace(sku, oldQuantity, oldQuantity - 1);
                return true;
            }else {
                this.basket.remove(sku);
                return true;
            }
        }else {
            return false;
        }

    }

    //To remove Bagel and checks if it has filling
    public String removeItemFromBasket(Bagel bagel) {
        if(removeItemFromBasket(bagel.getSKU())){
            if(bagel.getFilling() != null) {

                removeItemFromBasket(bagel.getFilling().getSKU());
                return "Bagel with filling " + bagel.getFilling().getName() + " is removed.";
            } else {
                return "Bagel is removed";
            }
        }else {
            return "Bagel with the SKU: " + bagel.getSKU() + " Does not exist";
        }

    }

    //To remove a specific bagel with a specific filling
    public String removeItemFromBasket(Bagel bagel, Filling filling) {
        removeItemFromBasket(bagel.getSKU());
        if(bagel.getFilling() == filling) {
            removeItemFromBasket(filling.getSKU());
            return "Bagel with filling " + filling.getName() + " is removed.";
        }else {
            return "Bagel with filling " + filling.getName() + " does not exist.";
        }
    }


}
