package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private HashMap<String, Integer> basket;
    private ItemList itemList = new ItemList();

    public Basket() {
        this.basket = new HashMap<>();
    }

    public int countTotalItems() {
        return this.basket.size();
    }

    public HashMap<String, Integer> checkAllItems() {
        return this.basket;
    }

    public void addItemToBasket(Item item){
        if(this.basket.containsKey(item.getSKU())) {
            int oldQuantity = this.basket.get(item.getSKU());
            this.basket.replace(item.getSKU(), oldQuantity, oldQuantity + 1);
        }else {
            this.basket.put(item.getSKU(), 1);
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
}
