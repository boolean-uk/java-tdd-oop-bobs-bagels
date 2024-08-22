package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.ItemList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiscountManager {

    HashMap<String, Integer> basket;
    HashMap<String, Double> discountBasket;
    HashMap<String, String> typeList;
    ArrayList<String> bagelSKU;
    ArrayList<String> coffeeSKU;
    float totalPrice = 0;

    public DiscountManager() {
        this.typeList = new ItemList().getTypeList();
        this.discountBasket = new HashMap<>();
        bagelSKU = new ArrayList<>();
        coffeeSKU = new ArrayList<>();
        populateSKUList();
    }

    public float totalValueOfDiscount() {
        if(discountBasket == null) return 0;
        for (Map.Entry<String, Double> kvp : discountBasket.entrySet()) {
            this.totalPrice += kvp.getValue();
        }
        return this.totalPrice;
    }

    public int checkBagelDiscount(HashMap<String, Integer> basket) {
        System.out.println(basket);
        this.basket = basket;
        for (String sku : bagelSKU) {
            if(basket.containsKey(sku)) {
                int bagelQuantity = basket.get(sku);
                System.out.println(bagelQuantity);
                if (bagelQuantity >= 6 && bagelQuantity < 12) {
                    if(this.discountBasket.containsKey(sku)) {
                        double val = discountBasket.get(sku);
                        discountBasket.replace(sku, val, val+2.49);
                    }else {
                        discountBasket.put(sku, 2.49);
                    }
                    return 6;

                } else if (bagelQuantity >= 12) {
                    if(discountBasket.containsKey(sku)) {
                        double val = discountBasket.get(sku);
                        discountBasket.replace(sku, val, val + 3.99);
                    }else {
                        discountBasket.put(sku, 3.99);
                    }
                    return 12;
                }
            }
        }
        return 0;
    }

    public HashMap<String, Double> getDiscountBasket() {
        return discountBasket;
    }

    public void populateSKUList() {
        for (Map.Entry<String, String> entry: typeList.entrySet()) {
            switch (entry.getValue()) {
                case "Bagel" -> this.bagelSKU.add(entry.getKey());
                case "Coffee" -> this.coffeeSKU.add(entry.getKey());
            }
        }
    }

}
