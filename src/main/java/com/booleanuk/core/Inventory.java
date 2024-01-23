package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> inventory;
    public Inventory(){
        this.inventory = new ArrayList<>();
        this.inventory.add(new Bagel("BGLO",0.49, "Bagel", "Onion"));
        this.inventory.add(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        this.inventory.add(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        this.inventory.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));

        this.inventory.add(new Coffee("COFB",0.99, "Coffee", "Black"));
        this.inventory.add(new Coffee("COFW",0.19, "Coffee", "White"));
        this.inventory.add(new Coffee("COFC",0.29, "Coffee", "Capuccino"));
        this.inventory.add(new Coffee("COFL",0.29, "Coffee", "Latte"));

        this.inventory.add(new Filling("FILB",0.12, "Filling", "Bacon"));
        this.inventory.add(new Filling("FILE",0.12, "Filling", "Egg"));
        this.inventory.add(new Filling("FILC",0.12, "Filling", "Cheese"));
        this.inventory.add(new Filling("FILX",0.12, "Filling", "Cream Cheese"));
        this.inventory.add(new Filling("FILS",0.12, "Filling", "Smoked Salmon"));
        this.inventory.add(new Filling("FILH",0.12, "Filling", "Ham"));

    }
    public ArrayList<Product> getInventoryItem(){
        return inventory;
    }

    public static void main(String[] arg){
        Inventory object = new Inventory();
        for(Product p : object.getInventoryItem()){
            System.out.println(p);
        }

    }
}
