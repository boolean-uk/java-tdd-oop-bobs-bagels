package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.ItemList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiscountManager extends ItemList {

    HashMap<String, Integer> basket;
    HashMap<String, Float> discountBasket;
    HashMap<String, Integer> numberOfItems;
    ArrayList<String> bagelSKU;
    ArrayList<String> coffeeSKU;
    float totalPrice = 0;

    public DiscountManager() {
        this.discountBasket = new HashMap<>();
        bagelSKU = new ArrayList<>();
        coffeeSKU = new ArrayList<>();
        numberOfItems = new HashMap<>();
        populateSKUList();
    }

    public float totalValueOfDiscount() {
        if(discountBasket == null) return 0;
        for (Map.Entry<String, Float> kvp : discountBasket.entrySet()) {
            this.totalPrice += kvp.getValue();
        }
        return this.totalPrice;
    }

    public int checkBagelDiscount(HashMap<String, Integer> basket) {
        this.basket = basket;
        for (String sku : bagelSKU) {
            if(basket.containsKey(sku)) {
                int bagelQuantity = basket.get(sku);
                if (bagelQuantity >= 6 && bagelQuantity < 12) {
                    if(this.discountBasket.containsKey(sku)) {
                        float val = discountBasket.get(sku);
                        discountBasket.replace(sku, val, val+2.49f);
                        if(numberOfItems.containsKey(sku)) {
                            numberOfItems.compute(sku, (k, quantity) -> quantity + 6);
                        }else {
                            numberOfItems.put(sku, 6);
                        }
                    }else {
                        discountBasket.put(sku, 2.49f);
                        if(numberOfItems.containsKey(sku)) {
                            numberOfItems.compute(sku, (k, quantity) -> quantity + 6);
                        }else {
                            numberOfItems.put(sku, 6);
                        }
                    }

                    return 6;

                } else if (bagelQuantity >= 12) {
                    if(discountBasket.containsKey(sku)) {
                        float val = discountBasket.get(sku);
                        discountBasket.replace(sku, val, val + 3.99f);
                        if(numberOfItems.containsKey(sku)) {
                            numberOfItems.compute(sku, (k, quantity) -> quantity + 12);
                        }else {
                            numberOfItems.put(sku, 12);
                        }
                    }else {
                        discountBasket.put(sku, 3.99f);
                        if(numberOfItems.containsKey(sku)) {
                            numberOfItems.compute(sku, (k, quantity) -> quantity + 12);
                        }else {
                            numberOfItems.put(sku, 12);
                        }
                    }
                    return 12;
                }
            }
        }
        return 0;
    }

    public HashMap<String, Float> getDiscountBasket() {
        return discountBasket;
    }

    public void populateSKUList() {
        for (Map.Entry<String, String> entry: getTypeList().entrySet()) {
            switch (entry.getValue()) {
                case "Bagel" -> this.bagelSKU.add(entry.getKey());
                case "Coffee" -> this.coffeeSKU.add(entry.getKey());
            }
        }
    }

    public void bagelAndCoffeeDiscount(String bagelSKU, String coffeeSKU, int amountOfDiscountedItem) {
        String bagelCoffeeSku = bagelSKU + ":" + coffeeSKU;
        if(!discountBasket.containsKey(bagelCoffeeSku)) {
            if(numberOfItems.containsKey(bagelCoffeeSku)) {
                discountBasket.put(bagelCoffeeSku, 1.25f);
                numberOfItems.replace(bagelCoffeeSku, amountOfDiscountedItem);
            }else {
                numberOfItems.put(bagelCoffeeSku, amountOfDiscountedItem);
                discountBasket.put(bagelCoffeeSku, 1.25f);
            }
        }else {
            float val = discountBasket.get(bagelCoffeeSku);
            discountBasket.replace(bagelCoffeeSku, val, val + 1.25f);
            if(numberOfItems.containsKey(bagelCoffeeSku)) {
                numberOfItems.put(bagelCoffeeSku, amountOfDiscountedItem);
            }else {
                numberOfItems.put(bagelCoffeeSku, amountOfDiscountedItem);
            }
        }
    }

    public HashMap<String, Integer> getNumberOfItems() {
        return this.numberOfItems;
    }

    public float getDiscountPrice(String sku) {
        return this.discountBasket.get(sku);
    }
}
