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
    int bglbIncrementor = 0;

    public Basket() {
        inventory = new Inventory();

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
            this.basket.put(sku, new BasketItem(item, quantity, price));
        }

        // Update total
        updateTotal();

        return true;
    }

    public void updateTotal() {
        double priceTotal = 0.0;
        for (BasketItem basketItem: basket.values())
        {
            priceTotal += (basketItem.getQuantity() * basketItem.getPrice());

            // Discount detection for number of same objects here
        }

        // Check for combo discounts
        //for (BasketItem basketItem: basket.values())
        //{
            // Discount detection for number of same objects here
        //}

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
        this.bglbMap.put(item.substring(0, item.length()-2), sku);
        this.basket.put(sku, new BasketItem(item.substring(0, item.length()-2), quantity, bagelCost, fillings));

        // Update total
        updateTotal();

        return true;
    }

}
