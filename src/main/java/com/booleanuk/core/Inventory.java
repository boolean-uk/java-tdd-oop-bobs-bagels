package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventoryList;

    // Constructor
    public Inventory() {
        this.setInventoryList(new ArrayList<>());
        this.getInventoryList().add(new Bagel("BGLO",0.49,"Bagel", "Onion"));
        this.getInventoryList().add(new Bagel("BGLP",0.39,"Bagel", "Plain"));
        this.getInventoryList().add(new Bagel("BGLE",0.49,"Bagel", "Everything"));
        this.getInventoryList().add(new Bagel("BGLS",0.49,"Bagel", "Sesame"));
        this.getInventoryList().add(new Coffee("COFB",0.99,"Coffee", "Black"));
        this.getInventoryList().add(new Coffee("COFW",1.19,"Coffee", "White"));
        this.getInventoryList().add(new Coffee("COFC",1.29,"Coffee", "Cappuccino"));
        this.getInventoryList().add(new Coffee("COFL",1.29,"Coffee", "Latte"));
        this.getInventoryList().add(new Filling("FILB",0.12,"Filling", "Bacon"));
        this.getInventoryList().add(new Filling("FILE",0.12,"Filling", "Egg"));
        this.getInventoryList().add(new Filling("FILC",0.12,"Filling", "Cheese"));
        this.getInventoryList().add(new Filling("FILX",0.12,"Filling", "Cream Cheese"));
        this.getInventoryList().add(new Filling("FILS",0.12,"Filling", "Smoked Salmon"));
        this.getInventoryList().add(new Filling("FILH",0.12,"Filling", "Ham"));
    }

    // Getters & Setters
    public ArrayList<Item> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }

    // Methods
    public double getPrice(Item order){
        for (Item item : this.inventoryList) {
            if (item.getSku().equals(order.getSku())) {
                return item.getPrice();
            }
        }
        System.out.println("This item does not exist");
        return 0.0;
    }
}
