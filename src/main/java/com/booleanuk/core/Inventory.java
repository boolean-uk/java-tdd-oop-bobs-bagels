package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory extends Basket {

    private String SKU;
    private double price;
    private String name;
    private String variant;

    private HashMap<String, Double> inventoryPriceList;
    private ArrayList<String> fullInventoryList;



    public HashMap<String, Double> getInventoryPriceList(){
        this.inventoryPriceList = new HashMap<>();
        inventoryPriceList.put("BGLO", 0.49);
        inventoryPriceList.put("BGLP", 0.39);
        inventoryPriceList.put("BGLE", 0.49);
        inventoryPriceList.put("BGLS", 0.49);

        inventoryPriceList.put("COFB", 0.99);
        inventoryPriceList.put("COFW", 1.19);
        inventoryPriceList.put("COFC", 1.29);
        inventoryPriceList.put("COFL", 1.29);

        inventoryPriceList.put("FILB", 0.12);
        inventoryPriceList.put("FILE", 0.12);
        inventoryPriceList.put("FILC", 0.12);
        inventoryPriceList.put("FILX", 0.12);
        inventoryPriceList.put("FILS", 0.12);
        inventoryPriceList.put("FILH", 0.12);

        return inventoryPriceList;
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
