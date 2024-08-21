package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.ItemList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Discount {

    HashMap<String, Integer> basketMap;
    HashMap<String, Integer> discountBasketMap;
    HashMap<String, String> typeList;
    ArrayList<String> bagelSKU;
    ArrayList<String> coffeeSKU;
    ArrayList<String> fillingSKU;
    int amountOfBagel = 0;
    int amountOfCoffee = 0;
    int amountOfFilling = 0;
    public Discount(Basket basket) {
        this.basketMap = basket.getBasket();
        this.discountBasketMap = this.basketMap;
        this.typeList = new ItemList().getTypeList();
    }

    public int getNewPrice() {
        
    }

    public void populateSKUList() {
        for (Map.Entry<String, String> entry: typeList.entrySet()) {
            switch (entry.getValue()) {
                case "Bagel" -> bagelSKU.add(entry.getKey());
                case "Coffee" -> coffeeSKU.add(entry.getKey());
                case "Filling" -> fillingSKU.add(entry.getKey());
            }
        }
    }

}
