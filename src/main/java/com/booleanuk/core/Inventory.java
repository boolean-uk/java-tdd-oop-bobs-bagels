package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> inventoryList;


    public Inventory() {
        this.inventoryList = new ArrayList<>();
        getInventoryList();
    }

    public void getInventoryList(){
        this.inventoryList.add(new Item("BGLO",0.49,"Bagel", "Onion"));
        this.inventoryList.add(new Item("BGLP",0.39,"Bagel", "Plain"));
        this.inventoryList.add(new Item("BGLE",0.49,"Bagel", "Everything"));
        this.inventoryList.add(new Item("BGLS",0.49,"Bagel", "Sesame"));
        this.inventoryList.add(new Item("COFB",0.99,"Coffee", "Black"));
        this.inventoryList.add(new Item("COFW",1.19,"Coffee", "White"));
        this.inventoryList.add(new Item("COFC",1.29,"Coffee", "Cappuccino"));
        this.inventoryList.add(new Item("COFL",1.29,"Coffee", "Latte"));
        this.inventoryList.add(new Item("FILB",0.12,"Filling", "Bacon"));
        this.inventoryList.add(new Item("FILE",0.12,"Filling", "Egg"));
        this.inventoryList.add(new Item("FILC",0.12,"Filling", "Cheese"));
        this.inventoryList.add(new Item("FILX",0.12,"Filling", "Cream Cheese"));
        this.inventoryList.add(new Item("FILS",0.12,"Filling", "Smoked Salmon"));
        this.inventoryList.add(new Item("FILH",0.12,"Filling", "Ham"));
    }
}
