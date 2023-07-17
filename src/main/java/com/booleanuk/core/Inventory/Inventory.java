package com.booleanuk.core.Inventory;

import com.booleanuk.core.products.Bagel;
import com.booleanuk.core.products.Coffee;
import com.booleanuk.core.products.Filling;
import com.booleanuk.core.products.Product;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final static String bagels = "/bagel.json";
    private final static String fillings = "/filling.json";
    private final static String coffees = "/coffee.json";
    private static Inventory INSTANCE;
    private List<Discount> availableDiscounts = new ArrayList<>(0);
    private List<Product> availableProducts = new ArrayList<>(0);

    private Inventory() {
        loadAvailableBagels();
        loadAvailableCoffees();
        loadAvailableFillings();
    }

    public static Inventory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Inventory();
        }
        return INSTANCE;
    }

    private static String getJsonAsString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder jsonContentBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonContentBuilder.append(line);
        }

        return jsonContentBuilder.toString();
    }

    public List<Discount> getAvailableDiscounts() {
        return availableDiscounts;
    }

    public void setAvailableDiscounts(List<Discount> availableDiscounts) {
        this.availableDiscounts = availableDiscounts;
    }

    public void addDiscount(Discount discount) {
        if (!availableDiscounts.contains(discount)) {
            this.availableDiscounts.add(discount);
        }
    }

    private void loadAvailableBagels() {
        try {
            InputStream inputStream = Inventory.class.getResourceAsStream(bagels);
            String json = getJsonAsString(inputStream);

            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(json, JsonArray.class);

            for (JsonElement jsonElement : jsonArray) {
                Bagel product = gson.fromJson(jsonElement, Bagel.class);
                addAvailableProducts(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAvailableProducts(Product product) {
        availableProducts.add(product);
    }

    public boolean isProductAvailable(Product product) {
        return getAvailableProducts().contains(product);
    }

    private void loadAvailableCoffees() {
        try {
            InputStream inputStream = Inventory.class.getResourceAsStream(coffees);
            String json = getJsonAsString(inputStream);

            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(json, JsonArray.class);

            for (JsonElement jsonElement : jsonArray) {
                var product = gson.fromJson(jsonElement, Coffee.class);
                addAvailableProducts(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAvailableFillings() {
        try {
            InputStream inputStream = Inventory.class.getResourceAsStream(fillings);
            String json = getJsonAsString(inputStream);

            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(json, JsonArray.class);

            for (JsonElement jsonElement : jsonArray) {
                var product = gson.fromJson(jsonElement, Filling.class);
                addAvailableProducts(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(List<Product> newAvailableProducts) {
        availableProducts = newAvailableProducts;
    }
}