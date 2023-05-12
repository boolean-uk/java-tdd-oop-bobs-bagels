package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory {
    private final ArrayList <Item> inventoryItems;

    public Inventory() {
        this.inventoryItems = new ArrayList<>();
        this.inventoryItems.add(new Item("BGLO",0.49,"Bagel","Onion"));
        this.inventoryItems.add(new Item("BGLP",0.39,"Bagel","Plain"));
        this.inventoryItems.add(new Item("BGLE",0.49,"Bagel","Everything"));
        this.inventoryItems.add(new Item("BGLS",0.49,"Bagel","Sesame"));
        this.inventoryItems.add(new Item("COFB",0.99,"Coffee","Black"));
        this.inventoryItems.add(new Item("COFW",1.19,"Coffee","White"));
        this.inventoryItems.add(new Item("COFC",1.29,"Coffee","Capuccino"));
        this.inventoryItems.add(new Item("COFL",1.29,"Coffee","Latte"));
        this.inventoryItems.add(new Item("FILB",0.12,"Filling","Bacon"));
        this.inventoryItems.add(new Item("FILE",0.12,"Filling","Egg"));
        this.inventoryItems.add(new Item("FILC",0.12,"Filling","Cheese"));
        this.inventoryItems.add(new Item("FILX",0.12,"Filling","Cream Cheese"));
        this.inventoryItems.add(new Item("FILS",0.12,"Filling","Smoked Salmon"));
        this.inventoryItems.add(new Item("FILH",0.12,"Filling","Ham"));
    }

    public ArrayList<Item> getInventoryItems() {
        return inventoryItems;
    }

    public double showPrice(Item item){
        for(Item i:this.inventoryItems){
            if(i.getSku().equals(item.getSku())){
                System.out.println("Item price: "+item.getPrice());
                return i.getPrice();

            }
        }
        System.out.println("Item is not in inventory");
        return -1.0;
    }
    public boolean isValid(Item item){
        for(Item i:this.inventoryItems){
            if (i.getSku().equals(item.getSku()) && i.getName().equals(item.getName()) && i.getPrice() == item.getPrice() && i.getVariant().equals(item.getVariant())) {
                return true;

            }
        }
        return false;
    }
}

