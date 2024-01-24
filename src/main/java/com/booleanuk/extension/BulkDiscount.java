package com.booleanuk.extension;

import com.booleanuk.core.Inventory;

import java.util.HashMap;

public class BulkDiscount extends Discount{
    private int number;

    public BulkDiscount(String sku, int number, double price) {
        super(sku, price);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public double calculateDiscount(String sku, HashMap<String, Integer> map, Inventory inventory){
        if (this.getNumber() <= map.get(sku)) {
            return (double) Math.round((((double) this.getNumber() * inventory.getProductCost(sku))
                    - this.getPrice()) * 100) /100;
        }
        return 0;
    }
}
