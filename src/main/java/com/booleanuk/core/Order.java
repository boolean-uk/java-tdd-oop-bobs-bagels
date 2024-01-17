package com.booleanuk.core;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Order extends Inventory {
    public int totalCost;
    DecimalFormat df = new DecimalFormat("####.##");
    public double getTotalCost(ArrayList<String> list) {
        HashMap<String, Double> inventoryPriceList = makeInventoryPriceList();

        double total = 0.00d;

        for(String item : list) {
            if(inventoryPriceList.containsKey(item)){

                total += Double.parseDouble(df.format(inventoryPriceList.get(item)));
//                total += inventoryPriceList.get(item);
            } else {
                System.out.println("Item: " + item + " is not in order is not in inventory");
            }
        }
      return total;
    }
}
