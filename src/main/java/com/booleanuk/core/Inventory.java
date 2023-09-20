package com.booleanuk.core;

import java.io.InputStream;
import java.util.ArrayList;

import com.booleanuk.core.Products.Bagel;
import com.booleanuk.core.Products.Coffee;
import com.booleanuk.core.Products.Filling;
import com.booleanuk.core.Products.Item;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;


public class Inventory {
    private final static String bagels = "/bagels.json";
    private final static String fillings = "/fillings.json";
    private final static String coffees = "/coffees.json";
    private static Inventory INSTANCE;

    private ArrayList<Item> inventoryList;


    public Inventory() {
        this.inventoryList = new ArrayList<>();

        loadBagels();
        loadCoffees();
        loadFillings();
    }

    public static Inventory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Inventory();
        }
        return INSTANCE;
    }

    public ArrayList<Item> getInventoryList() {
        return inventoryList;
    }


    public boolean itemIsAvailable(Item currentItem) {
        return getInventoryList().stream()
                .filter(f -> f.getSku().equals(currentItem.getSku()))
                .findFirst()
                .orElse(null) != null;
    }
    public void addProductToInventory(Item item) {
        this.inventoryList.add(item);
    }

    private void loadProducts(String jsonFilePath, Class<? extends Item> itemClass) {
        try {
            InputStream inputStream = Inventory.class.getResourceAsStream(jsonFilePath);
            String json = Utils.getJsonAsString(inputStream);

            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(json, JsonArray.class);

            for (JsonElement jsonElement : jsonArray) {
                Item item = gson.fromJson(jsonElement, itemClass);
                addProductToInventory(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBagels() {
        loadProducts(bagels, Bagel.class);
    }

    private void loadCoffees() {
        loadProducts(coffees, Coffee.class);
    }

    private void loadFillings() {
        loadProducts(fillings, Filling.class);
    }

}
