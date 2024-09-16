package com.booleanuk.core;

import java.util.List;

public class Store {
    private StoreInventory storeInventory;

    public Store(StoreInventory storeInventory) {
        this.storeInventory = storeInventory;
    }

    // Display available products in the store
    public void displayAvailableProducts() {
        List<Item> availableItems = storeInventory.getAllItems();
        System.out.println("Available Items:");
        for (Item item : availableItems) {
            System.out.println(item.getSku() + " - " + item.getItemName() +
                    " (" + item.getVariant() + ") - $" + item.getPrice());
        }
    }

    // Add a product to the basket based on SKU
    public boolean addToBasket(Basket basket, String sku) {
        Item item = storeInventory.getItemBySku(sku);
        if (item != null) {
            return basket.add(item);
        }
        return false; // Item with the given SKU doesn't exist in the store's inventory
    }

    public StoreInventory getStoreInventory() {
        return storeInventory;
    }
}
