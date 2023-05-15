package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventoryList;

    // Constructor
    public Inventory() {
        this.setInventoryList(new ArrayList<>());
        this.getInventoryList().add(new Item("BGLO",0.49,"Bagel", "Onion"));
        this.getInventoryList().add(new Item("BGLP",0.39,"Bagel", "Plain"));
        this.getInventoryList().add(new Item("BGLE",0.49,"Bagel", "Everything"));
        this.getInventoryList().add(new Item("BGLS",0.49,"Bagel", "Sesame"));
        this.getInventoryList().add(new Item("COFB",0.99,"Coffee", "Black"));
        this.getInventoryList().add(new Item("COFW",1.19,"Coffee", "White"));
        this.getInventoryList().add(new Item("COFC",1.29,"Coffee", "Cappuccino"));
        this.getInventoryList().add(new Item("COFL",1.29,"Coffee", "Latte"));
        this.getInventoryList().add(new Item("FILB",0.12,"Filling", "Bacon"));
        this.getInventoryList().add(new Item("FILE",0.12,"Filling", "Egg"));
        this.getInventoryList().add(new Item("FILC",0.12,"Filling", "Cheese"));
        this.getInventoryList().add(new Item("FILX",0.12,"Filling", "Cream Cheese"));
        this.getInventoryList().add(new Item("FILS",0.12,"Filling", "Smoked Salmon"));
        this.getInventoryList().add(new Item("FILH",0.12,"Filling", "Ham"));
    }

    public ArrayList<Item> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }

    // Methods
    public double getPrice(Item order){
        for (Item item : this.inventoryList) {
            if (item.getSKU().equals(order.getSKU())) {
                return item.getPrice();
            }
        }
        System.out.println("This item does not exist");
        return 0.0;
    }
}
