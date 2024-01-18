package com.booleanuk.core.util;

import com.booleanuk.core.models.Item;
import com.booleanuk.core.models.item.Bagel;
import com.booleanuk.core.models.item.Coffee;
import com.booleanuk.core.models.item.Filling;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private static final String FILE_NAME = "inventory";
    private static final String EXT = ".csv";

    public static ArrayList<Item> fetchInventoryItemsToStore() throws FileNotFoundException, URISyntaxException {
        ArrayList<Item> inventory = new ArrayList<>();
        // Should be some kind of db that is updated when something (price, inventory) changes
        URL url = FileHandler.class.getClassLoader().getResource(FILE_NAME + EXT);
        assert url != null;
        File file = new File(url.toURI());
        Scanner scanner = new Scanner(file);

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
        return inventory;
    }
}
