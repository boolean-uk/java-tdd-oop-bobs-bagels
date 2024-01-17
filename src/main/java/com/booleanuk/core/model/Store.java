package com.booleanuk.core.model;

import com.booleanuk.core.model.item.Bagel;
import com.booleanuk.core.model.item.Coffee;
import com.booleanuk.core.model.item.Filling;
import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@Data
public class Store {
    private static final String FILE_NAME = "inventory";
    private static final String EXT = ".csv";
    private final String name;
    private ArrayList<Item> inventory;

    public Store(String name) throws FileNotFoundException {
        this.name = name;
        this.inventory = new ArrayList<>();
        fetchItems();
    }

    public Item getItemBySKU(String sku) {
        for (Item item : inventory) {
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

            switch (values[2]) {
                case "Bagel" -> {
                    Bagel item = new Bagel(values[0], Double.parseDouble(values[1]), values[2], values[3]);
                    inventory.add(item);
                }
                case "Coffee" -> {
                    Coffee item = new Coffee(values[0], Double.parseDouble(values[1]), values[2], values[3]);
                    inventory.add(item);
                }
                case "Filling" -> {
                    Filling item = new Filling(values[0], Double.parseDouble(values[1]), values[2], values[3]);
                    inventory.add(item);
                }
            }
        }
    }
}
