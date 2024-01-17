package com.booleanuk.core.model;

import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

@Data
public class Store {
    private static final String FILE_NAME = "inventory";
    private static final String EXT = ".csv";
    private final String name;
    private ArrayList<Item> items;
    private HashMap<Item, Integer> inventory;

    public Store(String name) throws FileNotFoundException {
        this.name = name;
        this.items = new ArrayList<>();
        this.inventory = new HashMap<>();
        fetchItems();
    }

    public Item getItemBySKU(String sku) {
        for (Item item : items) {
            if (item.getSKU().equalsIgnoreCase(sku)) {
                return item;
            }
        }
        return null;
    }

    private void fetchItems() throws FileNotFoundException {
        // Should be some kind of db that is updated when something (price, inventory) changes
        String file = FILE_NAME + EXT;
        Scanner scanner = new Scanner(new File(file));

        scanner.nextLine(); // Skip .csv header
        while (scanner.hasNext()) {
            String[] values = scanner.nextLine().split(",");
            Item item = new Item(values[0], Double.parseDouble(values[1]), values[2], values[3]);
            items.add(item);
            inventory.put(item, Integer.valueOf(values[4]));
        }
    }
}
