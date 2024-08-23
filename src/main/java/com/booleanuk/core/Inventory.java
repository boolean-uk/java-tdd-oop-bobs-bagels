package com.booleanuk.core;
import java.util.HashMap;

public class Inventory {
    HashMap<String, Product> inventory;

    public Inventory(){
        this.inventory = new HashMap<>();

        //Fillings
        Filling bacon = new Filling("FILB",	0.12,	"Filling",	"Bacon");
        Filling egg = new Filling("FILE",	0.12,	"Filling",	"Egg");
        Filling cheese =  new Filling("FILC",	0.12,	"Filling",	"Cheese");
        Filling creamCheese = new Filling("FILX", 0.12, "Filling", "Cream Cheese");
        Filling smokedSalmon = new Filling("FILS",	0.12,	"Filling",	"Smoked Salmon");
        Filling ham = new Filling("FILH",	0.12,	"Filling",	"Ham");

        //Bagels
        this.inventory.put("BGLO", new Bagel("BGLO", 0.49, "Bagel", "Onion", null));
        this.inventory.put("BGLP", new Bagel("BGLP", 0.39, "Bagel", "Plain", null));
        this.inventory.put("BGLE", new Bagel("BGLE",	0.49,	"Bagel",	"Everything", null));
        this.inventory.put("BGLS", new Bagel("BGLS",	0.49,	"Bagel",	"Sesame", null));

        //Coffees
        this.inventory.put("COFB", new Coffee("COFB",	0.99,	"Coffee",	"Black"));
        this.inventory.put("COFW", new Coffee("COFW",	1.19,	"Coffee",	"White"));
        this.inventory.put("COFC", new Coffee("COFC",	1.29,	"Coffee",	"Cappuccino"));
        this.inventory.put("COFL", new Coffee("COFL",	1.29,	"Coffee",	"Latte"));

        //Bagel Combinations
        this.inventory.put("BGLO-FILB", new Bagel("BGLO", 0.49, "Bagel", "Onion", bacon));
        this.inventory.put("BGLO-FILE", new Bagel("BGLO", 0.49, "Bagel", "Onion", egg));
        this.inventory.put("BGLO-FILC",  new Bagel("BGLO", 0.49, "Bagel", "Onion",cheese));
        this.inventory.put("BGLO-FILX", new Bagel("BGLO", 0.49, "Bagel", "Onion",creamCheese));
        this.inventory.put("BGLO-FILS", new Bagel("BGLO", 0.49, "Bagel", "Onion", smokedSalmon));
        this.inventory.put("BGLO-FILH", new Bagel("BGLO", 0.49, "Bagel", "Onion", ham));

        this.inventory.put("BGLP-FILB", new Bagel("BGLP", 0.39, "Bagel", "Plain", bacon));
        this.inventory.put("BGLP-FILE", new Bagel("BGLP", 0.39, "Bagel", "Plain", egg));
        this.inventory.put("BGLP-FILC", new Bagel("BGLP", 0.39, "Bagel", "Plain", cheese));
        this.inventory.put("BGLP-FILX", new Bagel("BGLP", 0.39, "Bagel", "Plain", creamCheese));
        this.inventory.put("BGLP-FILS", new Bagel("BGLP", 0.39, "Bagel", "Plain", smokedSalmon));
        this.inventory.put("BGLP-FILH", new Bagel("BGLP", 0.39, "Bagel", "Plain", ham));

        this.inventory.put("BGLE-FILB", new Bagel("BGLE", 0.49, "Bagel", "Plain", bacon));
        this.inventory.put("BGLE-FILE", new Bagel("BGLE", 0.49, "Bagel", "Plain", egg));
        this.inventory.put("BGLE-FILC", new Bagel("BGLE", 0.49, "Bagel", "Plain", cheese));
        this.inventory.put("BGLE-FILX", new Bagel("BGLE", 0.49, "Bagel", "Plain", creamCheese));
        this.inventory.put("BGLE-FILS", new Bagel("BGLE", 0.49, "Bagel", "Plain", smokedSalmon));
        this.inventory.put("BGLE-FILH", new Bagel("BGLE", 0.49, "Bagel", "Plain", ham));

        this.inventory.put("BGLS-FILB", new Bagel("BGLS", 0.49, "Bagel", "Plain", bacon));
        this.inventory.put("BGLS-FILE", new Bagel("BGLS", 0.49, "Bagel", "Plain", egg));
        this.inventory.put("BGLS-FILC", new Bagel("BGLS", 0.49, "Bagel", "Plain", cheese));
        this.inventory.put("BGLS-FILX", new Bagel("BGLS", 0.49, "Bagel", "Plain", creamCheese));
        this.inventory.put("BGLS-FILS", new Bagel("BGLS", 0.49, "Bagel", "Plain", smokedSalmon));
        this.inventory.put("BGLS-FILH", new Bagel("BGLS", 0.49, "Bagel", "Plain", ham));

    }
    public Product getItem(String sku){
        return inventory.get(sku);
    }

    public Product getItem(String sku, String fillingSku){
        return inventory.get(sku + "-" + fillingSku);
    }

    public double getFilling(String sku){
        Product item = getItem("BGLO-" + sku);
        System.out.println(item);

        Bagel bagel = (Bagel) item;

        return bagel.getFilling().retrievePrice();
    }

}