package com.booleanuk.core.inventory;

import com.booleanuk.core.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, InventoryItem> inventoryItems;

    public Inventory() {
        this.inventoryItems = new HashMap<>();
        fillInventory();
    }

    /**
     * Fill inventory with pre-prepared data.
     */
    private void fillInventory() {

        // TODO: Is it okay to initialize the data here?
        // For a more general approach -> Use Dependency Injection:
        // make product list as input instead of creating it here.

        // Create list with inventory items
        ArrayList<InventoryItem> items = new ArrayList<>();

        items.add(new BagelItem(0.49f, BagelVariant.ONION));
        items.add(new BagelItem(0.39f, BagelVariant.PLAIN));
        items.add(new BagelItem(0.49f, BagelVariant.EVERYTHING));
        items.add(new BagelItem(0.49f, BagelVariant.SESAME));

        items.add(new CoffeeItem(0.99f, CoffeeVariant.BLACK));
        items.add(new CoffeeItem(1.19f, CoffeeVariant.WHITE));
        items.add(new CoffeeItem(1.29f, CoffeeVariant.CAPUCCINO));
        items.add(new CoffeeItem(1.29f, CoffeeVariant.LATTE));

        items.add(new FillingItem(0.12f, FillingVariant.BACON));
        items.add(new FillingItem(0.12f, FillingVariant.EGG));
        items.add(new FillingItem(0.12f, FillingVariant.CHEESE));
        items.add(new FillingItem(0.12f, FillingVariant.CREAM_CHEESE));
        items.add(new FillingItem(0.12f, FillingVariant.SMOKED_SALMON));
        items.add(new FillingItem(0.12f, FillingVariant.HAM));

        // Add items to inventoryItems and put the SKU value as the key
        for (InventoryItem item : items) {
            inventoryItems.put(item.getSKU(), item);
        }
    }

    public Map<String, InventoryItem> getAllItems() {
        return inventoryItems;
    }

    public InventoryItem getItem(String SKU) {

        // TODO: Should SKU be converted to uppercase here?

        InventoryItem item = inventoryItems.get(SKU);
        if (item == null) {
            throw new InventoryItemException("SKU '" + SKU + "' does not exist.");
        }
        return item;
    }
}
