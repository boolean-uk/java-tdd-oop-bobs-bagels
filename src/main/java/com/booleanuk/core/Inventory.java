package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private String SKU;
    private double price;
    private String name;
    private String variant;

    private HashMap<String, Double> inventoryPriceList;
    private ArrayList<String> fullInventoryList;
    private Order order;

    public Inventory() {
        this.inventoryPriceList = new HashMap<>();
    }
    public Inventory(Order order) {
        this.order = new Order();
        this.inventoryPriceList = new HashMap<>();
    }

    public HashMap<String, Double> getInventoryPriceList(){
        this.inventoryPriceList = new HashMap<>();
        this.inventoryPriceList.put("BGLO", 0.49);
        this.inventoryPriceList.put("BGLP", 0.39);
        this.inventoryPriceList.put("BGLE", 0.49);
        this.inventoryPriceList.put("BGLS", 0.49);

        this.inventoryPriceList.put("COFB", 0.99);
        this.inventoryPriceList.put("COFW", 1.19);
        this.inventoryPriceList.put("COFC", 1.29);
        this.inventoryPriceList.put("COFL", 1.29);

        this.inventoryPriceList.put("FILB", 0.12);
        this.inventoryPriceList.put("FILE", 0.12);
        this.inventoryPriceList.put("FILC", 0.12);
        this.inventoryPriceList.put("FILX", 0.12);
        this.inventoryPriceList.put("FILS", 0.12);
        this.inventoryPriceList.put("FILH", 0.12);

        return inventoryPriceList;
    }

    public double getItemPrice(String key) {
        return inventoryPriceList.get(key);
    }

    public ArrayList<String> getFullInventoryList() {
        this.fullInventoryList = new ArrayList<>();
        this.fullInventoryList.add("Bagels:\n");
        this.fullInventoryList.add("    Onion 0.49\n");
        this.fullInventoryList.add("    Cheese 0.49\n");
        this.fullInventoryList.add("Coffee:\n");
        this.fullInventoryList.add("    Black 0.49\n");
        this.fullInventoryList.add("    White 0.49\n");

        this.fullInventoryList.add("Fillings:\n");
        this.fullInventoryList.add("    Cheese 0.49\n");

        return this.fullInventoryList;
    }

    // How I Want the menu to look:
    public void printMenu() {
        System.out.println("Bobs Bagels");
        System.out.println("Bagels:");
        System.out.println("\tOnion\t 0.49");
        System.out.println("\tPlain\t 0.39");
        System.out.println("Coffee:");
        System.out.println("\tBlack\t 0.99");
        System.out.println("\tWhite\t 0.99");
        System.out.println("Fillings:");
        System.out.println("\tCheese\t 0.12");

    }



}
