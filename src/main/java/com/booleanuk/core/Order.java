package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Order {

    private Inventory inventory;

    public Order() {
    }
    public Order(Inventory inventory) {
        this.inventory = inventory;
    }

    public double getTotalCost(ArrayList<String> list) {
        HashMap<String, Double> inventoryPriceList = inventory.getInventoryPriceList();

        double totalCost = 0.00d;

        for(String item : list) {
            if(inventoryPriceList.containsKey(item)){

                totalCost += inventoryPriceList.get(item);
            } else {
                System.out.println("Item \"" + item + "\" in order is not in inventory");
            }
        }
        return totalCost;
    }

    public String generateReceipt(ArrayList<String> itemList){

        HashMap<String, Double> inventoryPriceList = inventory.getInventoryPriceList();
        HashMap<String, Integer> itemCounts = new HashMap<>();

        StringBuilder receipt = new StringBuilder();

        // Real time date
        SimpleDateFormat formatting = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date todaysDate = new Date();
        String date = formatting.format(todaysDate);

        receipt.append("\t~~~ Bob's Bagels ~~~\t\n\n");
        receipt.append("\t").append(date).append("\t");
        receipt.append("\n\n");
        receipt.append("---------------------------\n\n");


        double totalCost = 0.0;

        // Add items from itemsList to itemCounts to avoid duplicated items
        for (String item : itemList) {
            if (inventoryPriceList.containsKey(item)) {
                // Set to 1 if item is unique in itemCounts, increment if item is there
                itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
            }
        }

        // Iterate unique items
        for (String item : itemCounts.keySet()) {
            int count = itemCounts.get(item);
            double itemCost = inventoryPriceList.get(item);

            receipt.append(String.format("%s\t\t%d\t\t  £%.2f\n",item, count, itemCost));

            totalCost += itemCost * count;
        }

        receipt.append("\n---------------------------\n");
        receipt.append(String.format("Total\t\t\t\t  £%.2f\n\n", totalCost));
        receipt.append("\t\tThank you\n\t for your order!");

        return receipt.toString();
    }
}
