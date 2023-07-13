package com.booleanuk.core.store;

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

public class Store {

    private final static String bagels = "/bagel.json";
    private final static String fillings = "/filling.json";
    private final static String coffees = "/coffee.json";
    private static Store INSTANCE;
    private static String json;
    private List<Product> availableProducts = new ArrayList<>(0);


    public Store() {
        loadAvailableBagels();
        loadAvailableCoffees();
        loadAvailableFillings();
    }

    public static Store getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Store();
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

    private void loadAvailableBagels() {
        try {
            InputStream inputStream = Store.class.getResourceAsStream(bagels);
            String json = getJsonAsString(inputStream);

            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(json, JsonArray.class);


            for (JsonElement jsonElement : jsonArray) {
                var product = gson.fromJson(jsonElement, Bagel.class);
                addAvailableProducts(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAvailableCoffees() {
        try {
            InputStream inputStream = Store.class.getResourceAsStream(coffees);
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
            InputStream inputStream = Store.class.getResourceAsStream(fillings);
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

    public void setAvailableProducts(List<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public void addAvailableProducts(Product product) {
        this.availableProducts.add(product);
    }

    public String getJson() {
        return json;
    }

    public static void setJson(String json) {
        Store.json = json;
    }
}
