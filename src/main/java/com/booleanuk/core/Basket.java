package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.round;

public class Basket {
    private HashMap<String, BasketItem> basket;
    private HashMap<String, String> bglbMap = new HashMap<>();
    private int capacity;
    private double total;
    Inventory inventory;
    Discount discount;
    int bglbIncrementor = 0;

    public Basket(Inventory inventory) {
        this.inventory = inventory;
        this.basket = new HashMap<>();
        this.capacity = 30;
        this.total = 0.0;
    }

    public Basket(Inventory inventory, Discount discount) {
        this.inventory = inventory;
        this.discount = discount;
        this.basket = new HashMap<>();
        this.capacity = 30;
        this.total = 0.0;
    }

    public BasketItem getBasketItem(String sku) {
        return this.basket.get(sku);
    }

    public int getBasketSize() {
        int basketSize = 0;
        for (BasketItem basketItem: basket.values()) {
            basketSize += basketItem.getQuantity();
        }
        return basketSize;
    }

    public boolean addItem(String item, int quantity) {
        // Basket is full
        if (getBasketSize() + quantity > this.capacity)
            return false;

        // The item is not in the inventory
        if (!this.inventory.mapTypeVariantToSKU.containsKey(item))
            return false;

        String sku = inventory.mapTypeVariantToSKU.get(item);
        double price = this.inventory.items.get(sku).getPrice();
        // Item is already in the basket, then increment quantity
        if (this.basket.containsKey(sku)) {
            int currentQuantity = basket.get(sku).getQuantity();
            basket.get(sku).setQuantity(currentQuantity + quantity);
        }
        // Item not in basket, then put key by sku and value as BasketItem with name, price and quantity.
        else {
            String name = inventory.items.get(sku).getName();
            String type = inventory.items.get(sku).getType();
            this.basket.put(sku, new BasketItem(name, type, quantity, price));
        }

        // Update total
        updateTotal();

        return true;
    }

    public void updateTotal() {

        int quantity = 0;
        int num12 = 0;
        int num6 = 0;
        int rest = 0;

        BasketItem basketItem;

        ArrayList<Double> bagelsNotBundled = new ArrayList<Double>();
        double priceTotal = 0.0;
        double priceTotalNoDiscount = 0;
        double priceSavedTotal = 0.0;
        double priceSaved = 0.0;
        double discountPrice = 0.0;
        // iterate basket by keys

        for (String sku: basket.keySet())
        {
            // Extract value object
            basketItem = basket.get(sku);

            // Reset all discount statuses
            basketItem.resetDiscount();

            // Check is current basket item is a bagel
            if (sku.startsWith("BGL")){
                // Check quantity of bagels
                quantity = basketItem.getQuantity();

                // Check if quantity is in sets of 12 or 6 or both
                num12 = quantity / 12;
                num6 = (quantity - 12 * num12) / 6;

                // Check remaining number of bagels
                rest = quantity - 12 * num12 - 6 * num6;
                if (num12 > 0) {
                    basketItem.setNumDiscountItems(basketItem.getNumDiscountItems()+num12);
                    basketItem.setNum12Discount(num12);
                    discountPrice += discount.discountMap.get("BGL12").getPrice();
                    priceSaved += (12*num12*basketItem.getPrice()) - discountPrice;
                }
                if (num6 > 0) {
                    basketItem.setNumDiscountItems(basketItem.getNumDiscountItems()+num6);
                    basketItem.setNum6Discount(num6);
                    discountPrice += discount.discountMap.get("BGL6").getPrice();
                    priceSaved += (6 * num6 * basketItem.getPrice()) - discountPrice;
                }
                if (rest > 0) {
                    priceTotal += rest * basketItem.getPrice();
                    for (int i = 0; i < rest; i++){
                        bagelsNotBundled.add(basketItem.getPrice());
                    }
                }
                priceTotal += discountPrice;
                priceSavedTotal += priceSaved;
                basketItem.setDiscountPrice(Math.round((discountPrice*100.0)/100.0));
                basketItem.setSaved(Math.round((priceSaved*100.0)/100.0));

                priceTotalNoDiscount += quantity * basketItem.getPrice();

                discountPrice = 0.0;
                priceSaved = 0.0;
            }

        }

        // Iterate through to view coffee and fillings
        for (String sku: basket.keySet())
        {
            // Extract value object
            basketItem = basket.get(sku);

            // Reset all discount statuses
            basketItem.resetDiscount();

            if (sku.startsWith("FIL")) {
                // Check quantity of fillings
                quantity = basketItem.getQuantity();
                priceTotal += quantity * basketItem.getPrice();

            }

            // Check is current basket item is a bagel
            if (sku.startsWith("COF")){
                // Check quantity of coffee
                quantity = basketItem.getQuantity();

                // check for left over bagels that has not been discounted in a 6 or 12 bundle
                int i = 0;
                while (!bagelsNotBundled.isEmpty() && i <= quantity){
                    // find most expensive bagel
                    double max = 0.0;
                    for (double price: bagelsNotBundled) {
                        if (price > max){
                            max = price;
                        }
                    }
                    int index = bagelsNotBundled.indexOf(max);
                    double bagelPrice = bagelsNotBundled.get(index);
                    bagelsNotBundled.remove(index);

                    double originalPrice = bagelPrice + basketItem.getPrice();
                    double newPrice = discount.discountMap.get("COF").getPrice();

                    discountPrice += newPrice;
                    priceSaved += (originalPrice - newPrice);
                    priceTotal -= bagelPrice;

                    priceSavedTotal += priceSaved;
                    priceTotal += discountPrice;

                    discountPrice = 0.0;
                    priceSaved = 0.0;

                    i++;
                }
                if (i < quantity){
                    int restCoffee = quantity - i;
                    priceTotal += restCoffee * basketItem.getPrice();

                }
                priceSavedTotal += priceSaved;
                priceTotal += discountPrice;

                discountPrice = 0.0;
                priceSaved = 0.0;
            }
        }

        this.total = Math.round(priceTotal*100.0) / 100.0;
    }

    public boolean removeItem(String item, int quantity) {

        String sku;
        if (inventory.mapTypeVariantToSKU.containsKey(item)) {
            sku = inventory.mapTypeVariantToSKU.get(item);
        } else if (bglbMap.containsKey(item)) {
            sku = bglbMap.get(item);
        } else {
            return false;
        }

        if (basket.containsKey(sku)) {
            int currentQuantity = basket.get(sku).getQuantity();
            // Catch attempts to remove more than what is in the basket.
            if (currentQuantity-quantity < 0) {
                return false;
            } else if (currentQuantity == quantity) { // Noting left, remove from basket
                basket.remove(sku);
                if (bglbMap.containsKey(item)) {
                    bglbMap.remove(item);           // remove from build a bagel sku map
                }
            } else { // Decrease quantity by number of item to be removed
                basket.get(sku).setQuantity(currentQuantity - quantity);
            }
        } else { // Item is not in the basket
            return false;
        }

        // update total
        updateTotal();

        return true;
    }

    public int changeCapacity(int newCapacity) {
        this.capacity = newCapacity;
        return this.capacity;
    }

    public double getTotal() {
        updateTotal();
        return this.total;
    }

    public double getPrice(String item) {
        String sku = this.inventory.mapTypeVariantToSKU.get(item);
        return this.inventory.items.get(sku).getPrice();
    }

    public boolean buildBagel(int quantity, String[] fillings) {

        this.bglbIncrementor++;
        String sku = "BGLB" + Integer.toString(bglbIncrementor); // Bagel Build
        String item;
        double bagelCost;
        String fillingItem;


        // Add plain bagel
        item = "Bagel ";
        bagelCost = this.inventory.items.get("BGLP").getPrice();
        fillingItem = "";

        for (String filling: fillings) {
            fillingItem = "Filling " + filling;
            if (!inventory.mapTypeVariantToSKU.containsKey(fillingItem)) {
                return false;
            }
            item = item + filling + ", ";
            bagelCost += this.inventory.items.get(inventory.mapTypeVariantToSKU.get(fillingItem)).getPrice();
        }

        // Add to basket and build a bagel to sku map
        bagelCost = Math.round(bagelCost*100.0) / 100.0;
        String nametype = item.substring(0, item.length()-2);
        this.bglbMap.put(nametype, sku);
        this.basket.put(sku, new BasketItem("Bagel", nametype, quantity, bagelCost, fillings));

        // Update total
        updateTotal();

        return true;
    }

}
