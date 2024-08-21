package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private int maxBasketSize;
    private int basketSize;
    private HashMap<String, Integer> basketItems;
    Menu menu = new Menu();


    public Basket(){
        this.maxBasketSize = 15;
        this.basketItems = new HashMap<>();
        this.basketSize = 0;
    }

    public Boolean setMaxBasketSize(int size){
        if (size>-1){
            this.maxBasketSize = size;
            return true;
        }
        return false;
    }

    public int getMaxBasketSize(){
        return maxBasketSize;
    }

    public int getBasketSize(){
        return this.basketSize;
    }

    public HashMap<String, Integer> getBasketItems(){
        return this.basketItems;
    }

    public String addItem(String itemId, int quantity){
        if (menu.itemExistsMenu(itemId)){
            if (basketSize < maxBasketSize){
                if (basketItems.containsKey(itemId)){
                    basketItems.put(itemId, quantity += basketItems.get(itemId));
                    basketSize+=quantity;
                    return quantity + " " + menu.getMenuItem(itemId).getItemVariant() + " " + menu.getMenuItem(itemId).getItemName() + " added to basket.";
                }
                basketItems.put(itemId, quantity);
                basketSize+=quantity;
                return quantity + " " + menu.getMenuItem(itemId).getItemVariant() + " " + menu.getMenuItem(itemId).getItemName() + " added to basket.";
            }
            return "Basket is full.";
        }
        return "This item is not on the menu.";
    }

    public String removeItem(String itemId, Boolean removeDuplicates){
        Item item = menu.getMenuItem(itemId);
        if (basketItems.containsKey(itemId)){
            if (removeDuplicates){
                int quantity = basketItems.get(itemId);
                basketItems.remove(itemId);
                basketSize -= quantity;
                return quantity + " " + item.getItemVariant() + " " + item.getItemName() + "s removed from basket.";
            }else {
                basketItems.put(itemId, basketItems.get(itemId)-1);
                basketSize -= 1;
                if (basketItems.get(itemId) == 0){
                    basketItems.remove(itemId);
                }
                return item.getItemVariant() + " " + item.getItemName() + " removed from basket.";
            }

        }
        return "This item does not exist in your basket.";
    }

    public String sumOrder(){
        if (basketSize == 0){
            return "Your basket is empty.";
        }

        float totalSum = 0;
        for (HashMap.Entry<String, Integer> entry : basketItems.entrySet()){
            int quantity = entry.getValue();
            float price = menu.getMenuItem(entry.getKey()).getItemPrice();

            float sum = price * quantity;
            totalSum += sum;
        }
        return "The sum of your order is: " + String.format("%.2f", totalSum);
    }

    public String sumOrderDiscount(){
        return "SUM";
    }

}
