package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.BasketItem;
import com.booleanuk.core.models.Coffee;
import com.booleanuk.core.models.Filling;

import java.util.ArrayList;
import java.util.List;

public class Invetory {

    List<Bagel> bagels = new ArrayList<>();
    List<Coffee> coffees = new ArrayList<>();
    List<Filling> fillings = new ArrayList<>();

    public Invetory() {
        Bagel bagel0 = new Bagel("Onion", 0.49, "BGLO");
        Bagel bagel1 = new Bagel("Plain", 0.39, "BGLP");
        Bagel bagel2 = new Bagel("Everything", 0.49, "BGLE");
        Bagel bagel3 = new Bagel("Sesame", 0.49, "BGLS");

        Filling filling0 = new Filling("Bacon",0.12, "FILB");
        Filling filling1 = new Filling("Egg",0.12, "FILE");
        Filling filling2 = new Filling("Cheese",0.12, "FILC");
        Filling filling3 = new Filling("Cream Cheese",0.12, "FILX");
        Filling filling4 = new Filling("Smoked Salmon",0.12, "FILS");
        Filling filling5 = new Filling("Ham",0.12, "FILH");

        Coffee coffee0 = new Coffee("Black", 0.99, "COFB");
        Coffee coffee1 = new Coffee("White", 1.19, "COFW");
        Coffee coffee2 = new Coffee("Capuccino", 1.29, "COFC");
        Coffee coffee3 = new Coffee("Latte", 1.29, "COFL");

        bagels.add(bagel0);
        bagels.add(bagel1);
        bagels.add(bagel2);
        bagels.add(bagel3);

        coffees.add(coffee0);
        coffees.add(coffee1);
        coffees.add(coffee2);
        coffees.add(coffee3);

        fillings.add(filling0);
        fillings.add(filling1);
        fillings.add(filling2);
        fillings.add(filling3);
        fillings.add(filling4);
        fillings.add(filling5);
    }
}
