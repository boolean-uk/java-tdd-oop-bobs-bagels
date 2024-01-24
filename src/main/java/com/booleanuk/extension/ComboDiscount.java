package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

import java.util.HashMap;
import java.util.Set;

public class ComboDiscount extends Discount{
    private String name;

    public ComboDiscount(String sku, String name, double price) {
        super(sku, price);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public double calculateDiscount(String sku, HashMap<String, Integer> map, Inventory inventory) {
        Set<String> skuList = map.keySet();
        double lowest = 0;
        double curr;
        for (String basketSku: skuList) {
            if (inventory.findProduct(basketSku).getName().equals(this.getName())) {
                curr = (double) Math.round(((inventory.findProduct(sku).getPrice() + inventory.findProduct(basketSku).getPrice())
                        - this.getPrice()) * 100) / 100;
                if (lowest == 0 || curr < lowest) {
                    lowest = curr;
                }
            }
        }
        return lowest;
    }
}