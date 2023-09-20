package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Fillings {
    private HashMap<String, Double> customerList;
    public HashMap<String, Double> inventoryList;
    public double fillingPrice;

    public Fillings() {
        this.inventoryList = new HashMap<>();
        inventoryList.put("BGLO", 0.49);
        inventoryList.put("BGLP", 0.39);
        inventoryList.put("BGLE", 0.49);
        inventoryList.put("BGLS", 0.49);
        inventoryList.put("COFB", 0.99);
        inventoryList.put("COFW", 1.19);
        inventoryList.put("COFC", 1.29);
        inventoryList.put("COFL", 1.29);
        inventoryList.put("FILB", 0.12);
        inventoryList.put("FILE", 0.12);
        inventoryList.put("FILC", 0.12);
        inventoryList.put("FILX", 0.12);
        inventoryList.put("FILS", 0.12);
        inventoryList.put("FILH", 0.12);

        this.customerList = new HashMap<>();
        this.fillingPrice = 0.00d;
    }

    public void addFillings(String name, double price) {
        if (inventoryList.containsKey(name)) {
            System.out.println("The price of the filling you added costs " + price);
            customerList.put(name, price);
//            System.out.println("The filling has been added to your list");

        } else {
            System.out.println("This item does not exist in our inventory.");
        }

    }

    public double getFillingCost() {
        for (Double value : customerList.values()) {
            fillingPrice += value;
        }
        System.out.println(fillingPrice);
        return fillingPrice;

    }





}
