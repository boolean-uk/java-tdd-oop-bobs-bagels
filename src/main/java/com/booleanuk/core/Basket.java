package com.booleanuk.core;

import com.booleanuk.core.Products.Bagel;
import com.booleanuk.core.Products.Filling;
import com.booleanuk.core.Products.Item;
import com.booleanuk.core.Products.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private int capacity;
    private Map<Item, Integer> itemsMap;


    private Inventory inventory;

    public Basket(Inventory inventory, int capacity) {
        this.itemsMap = new HashMap<Item, Integer>();

        this.setCapacity(capacity);
        this.setInventory(inventory);
    }

    public int getBasketSize() {
        int sum = this.itemsMap.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        return sum;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean setCapacity(int capacity) {
        if (capacity < this.getBasketSize()) {
            //add a print message for the mistake
            return false;
        }
        this.capacity = capacity;
        return true;
    }

    public Map<Item, Integer> getItemsMap() {
        return this.itemsMap;
    }

    public void setItemsMap(Map<Item, Integer> itemsMap) {
        this.itemsMap = itemsMap;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean addToBasket(Item item, int amount) {
        if (this.inventory.getInventoryList().contains(item)) {
            this.itemsMap.put(item, amount);
            return true;
        }
        return false;
        //handle item already exists
        //handle capacity is (almost) full
    }


    public boolean removeFromBasket(Item item, int amount) {
        if (this.itemsMap.containsKey(item)
//                && this.itemsMap.get(item)<=amount
                && amount > 0) {
            if (amount >= this.itemsMap.get(item)) {
                this.itemsMap.remove(item);
            } else {
                this.itemsMap.put(item, this.itemsMap.get(item) - amount);
            }
            return true;
        }
        return false;
    }

    public boolean removeFromBasket(Item item) {
        if (this.itemsMap.containsKey(item)) {
            this.itemsMap.remove(item);
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return this.capacity <= this.getBasketSize();
    }

    public BigDecimal getTotalCost() {
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (Map.Entry<Item, Integer> entry : itemsMap.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(quantity)));
        }

        return totalPrice;
    }

    public BigDecimal getItemCost(String sku) {
//        BigDecimal totalPrice = BigDecimal.ZERO;
//
//        for (Map.Entry<Item, Integer> entry : itemsMap.entrySet()) {
//            Item item = entry.getKey();
//            int quantity = entry.getValue();
//
//            totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(quantity)));
//        }
//
//        return totalPrice;
//        if(this.inventory.getInventoryList().contains(item))
        return this.inventory.getItemBySku(sku) != null ? this.inventory.getItemBySku(sku).getPrice() : BigDecimal.valueOf(0.00);
    }

    public boolean isProductInBasket(Product product) {
        return this.itemsMap.containsKey(product);

    }

    public boolean itemIsAvailable(Item item) {
        return this.inventory.getInventoryList().contains(item);

    }


    @Override
    public String toString() {

        StringBuilder basket = new StringBuilder();
        int number = 0;
        for (Map.Entry<Item, Integer> entry : itemsMap.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            // Append item name, quantity, and total cost for the item
            basket.append(String.format("%-30s x %5s pcs x %10s = %10s",
                            number + "." + item.getName(),
                            quantity,
                            "EUR" + item.getPrice(),
                            "EUR" + item.getPrice().multiply(BigDecimal.valueOf(quantity))))
                    .append("\n");

            if (item instanceof Bagel) {
                for (Filling filling : ((Bagel) item).getFillings()) {
                    basket.append(String.format("%-30s %5s %10s",
                                    "  >>" + filling.getName(),
                                    "",
                                    "EUR" + filling.getPrice()))
                            .append("\n");
                }
            }

            number++;
        }

        return basket.toString();

    }
}
