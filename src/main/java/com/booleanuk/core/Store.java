package com.booleanuk.core;

import java.util.ArrayList;

public class Store {
    private int capacity = 6;
    private ArrayList<Product> inventory = new ArrayList<>();

    public void addToInventory(Product product) {
        int maxSizeInventory = 15;
        if (inventory.size() < maxSizeInventory) {
            inventory.add(product);
            System.out.println(inventory.contains(product));
        } else System.out.println("Inventory should not be able to consist of more then 15 items");

    }

    public void updateCapacity(int capacity) {
        this.capacity += capacity;

    }

    public int getCapacity() {
        return capacity;
    }

    public boolean findProductInInventory(String SKU) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getSKU().equals(SKU)) {
                return true;
            }

        }
        System.out.println("Didn't find item in invenrtoty");
        return false;
    }
}

   /* private String generateId(){
        return UUID.randomUUID().toString().replace("-", "");
    }*/


