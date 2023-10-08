package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> item;


    protected Inventory() {
        this.item = new ArrayList<>();

        this.item.add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        this.item.add(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        this.item.add(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        this.item.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));

        this.item.add(new Coffee("COFB", 0.99, "Coffee", "Black"));
        this.item.add(new Coffee("COFW", 1.19, "Coffee", "White"));
        this.item.add(new Coffee("COFC", 1.29, "Coffee", "Cappuccino"));
        this.item.add(new Coffee("COFL", 1.29, "Coffee", "Latte"));

        this.item.add(new Fillings("FILB", 0.12, "Filling", "Bacon"));
        this.item.add(new Fillings("FILE", 0.12, "Filling", "Egg"));
        this.item.add(new Fillings("FILC", 0.12, "Filling", "Cheese"));
        this.item.add(new Fillings("FILX", 0.12, "Filling", "Cream Cheese"));
        this.item.add(new Fillings("FILS", 0.12, "Filling", "Smoked Salmon"));
        this.item.add(new Fillings("FILH", 0.12, "Filling", "Ham"));
    }

    public List<Item> getItem() {
        return item;
    }

}