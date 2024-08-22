package com.booleanuk.core;

import java.util.HashMap;

import static com.booleanuk.core.Menu.*;

public class Basket {
    private int maxBasketSize;
    private HashMap<String, Integer> basketItems;


    public Basket(){
        this.maxBasketSize = 15;
        this.basketItems = new HashMap<>();
    }

    public Boolean setMaxBasketSize(int size){
        if (size<0){
            return false;
        }
        this.maxBasketSize = size;
        return true;
    }

    public int getMaxBasketSize(){
        return this.maxBasketSize;
    }

    public int getBasketSize(){
        if (isEmpty()){
            return 0;
        }

        int basketSize = 0;
        for (HashMap.Entry<String, Integer> entry : basketItems.entrySet()){
            basketSize += entry.getValue();
        }
        return basketSize;
    }

    public boolean isEmpty(){
        return this.basketItems.isEmpty();
    }

    public HashMap<String, Integer> getBasketItems(){
        return this.basketItems;
    }

    public String addItem(String itemId, int quantity) {
        if (getBasketSize() == maxBasketSize){
            return "Basket is full.";
        }

        if (!itemExistsMenu(itemId)){
            return "This item is not on the menu.";
        }

        basketItems.merge(itemId, quantity, Integer::sum);
        Item item = getMenuItem(itemId);

        return quantity + " " + item.getItemVariant()
                + " " + item.getItemName() + " added to basket.";
    }


    public String removeItem(String itemId, Boolean removeDuplicates){

        if (!basketItems.containsKey(itemId)){
            return "This item does not exist in your basket.";
        }

        Item item = getMenuItem(itemId);
        int quantity = basketItems.get(itemId);

        if (removeDuplicates | quantity == 1 ){
            basketItems.remove(itemId);
            return quantity + " " + item.getItemVariant() + " " + item.getItemName() + " removed from basket.";
        }

        basketItems.merge(itemId, -1, Integer::sum);
        return "1 " + item.getItemVariant() + " " + item.getItemName() + " removed from basket.";
    }

}
