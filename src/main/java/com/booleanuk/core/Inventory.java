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
        this.menu.put("EverythingBagel", new Bagel("BGLE",	0.49,	"Bagel",	"Everything"));
        this.menu.put("SesameBagel", new Bagel("BGLS",	0.49,	"Bagel",	"Sesame"));

        //Coffees
        this.menu.put("BlackCoffee", new Coffee("COFB",	0.99,	"Coffee",	"Black"));
        this.menu.put("WhiteCoffee", new Coffee("COFW",	1.19,	"Coffee",	"White"));
        this.menu.put("CapuccinoCoffee", new Coffee("COFC",	1.29,	"Coffee",	"Capuccino"));
        this.menu.put("LatteCoffee", new Coffee("COFL",	1.29,	"Coffee",	"Latte"));

        //Fillings
        this.menu.put("BaconFilling", new Filling("FILB",	0.12,	"Filling",	"Bacon"));
        this.menu.put("EggFilling", new Filling("FILE",	0.12,	"Filling",	"Egg"));
        this.menu.put("CheeseFilling", new Filling("FILC",	0.12,	"Filling",	"Cheese"));
        this.menu.put("SmokedSalmonFilling", new Bagel("FILS",	0.12,	"Filling",	"Smoked Salmon"));
        this.menu.put("HamFilling", new Bagel("FILH",	0.12,	"Filling",	"Ham"));

    }

    public HashMap<String, Product> getProducts(){
        return menu;
    }


}
