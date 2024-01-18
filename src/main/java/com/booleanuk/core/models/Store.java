package com.booleanuk.core.models;

import com.booleanuk.core.enums.ItemType;
import com.booleanuk.core.util.FileHandler;
import lombok.Data;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Data
public class Store {
    private final String name;
    private ArrayList<Item> inventory;

    public Store(String name) throws FileNotFoundException, URISyntaxException {
        this.name = name;
        this.inventory = FileHandler.fetchInventoryItemsToStore();
    }

    public Item getItemBySKU(String sku) {
        for (Item item : inventory) {
            if (item.getSKU().equalsIgnoreCase(sku)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getItemsByItemType(ItemType itemType) {
        ArrayList<Item> itemsByType = new ArrayList<>();

        for (Item item : inventory) {
            if (item.getName().equals(itemType.getDisplayName())) {
                itemsByType.add(item);
            }
        }

        return itemsByType;
    }
}
