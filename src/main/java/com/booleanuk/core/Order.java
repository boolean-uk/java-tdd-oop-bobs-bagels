package com.booleanuk.core;

import java.util.ArrayList;
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
                System.out.println("Item: " + item + " is not in order is not in inventory");
            }
        }
      return totalCost;
    }

}
