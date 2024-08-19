package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    HashMap<String, Product> menu;

    public Inventory(){
        this.menu = new HashMap<>();

        //Bagels
        this.menu.put("OnionBagel", new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        this.menu.put("PlainBagel", new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        this.menu.put("BaconFilling", new Bagel("FILB",	0.12,	"Filling",	"Bacon"));

    }

    public HashMap<String, Product> getProducts(){
        return menu;
    }


}
