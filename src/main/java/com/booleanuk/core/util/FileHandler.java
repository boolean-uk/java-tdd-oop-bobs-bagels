package com.booleanuk.core.util;

import com.booleanuk.core.Item;
import com.booleanuk.core.enums.ItemType;
import com.booleanuk.core.items.Bagel;
import com.booleanuk.core.items.Coffee;
import com.booleanuk.core.items.Filling;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static com.booleanuk.core.util.Constants.EXT;
import static com.booleanuk.core.util.Constants.FILE_NAME_INVENTORY;

public class FileHandler {
    public static ArrayList<Item> fetchInventoryItemsToStore() throws FileNotFoundException, URISyntaxException {
        ArrayList<Item> inventory = new ArrayList<>();
        // Should be some kind of db that is updated when something (price) changes
        URL url = FileHandler.class.getClassLoader().getResource(FILE_NAME_INVENTORY + EXT);
        assert url != null;
        File file = new File(url.toURI());
        Scanner scanner = new Scanner(file);

        scanner.nextLine(); // Skip .csv header
        while (scanner.hasNext()) {
            String[] values = scanner.nextLine().split(",");
            ItemType itemType = ItemType.getItemTypeFromString(values[2]);

            switch (itemType) {
                case BAGEL -> {
                    Bagel item = new Bagel(values[0], Double.parseDouble(values[1]), values[2], values[3]);
                    inventory.add(item);
                }
                case COFFEE -> {
                    Coffee item = new Coffee(values[0], Double.parseDouble(values[1]), values[2], values[3]);
                    inventory.add(item);
                }
                case FILLING -> {
                    Filling item = new Filling(values[0], Double.parseDouble(values[1]), values[2], values[3]);
                    inventory.add(item);
                }
                default -> {
                    Item item = new Item(values[0], Double.parseDouble(values[1]), values[2], values[3]);
                    inventory.add(item);
                }
            }
        }

        return inventory;
    }
}
