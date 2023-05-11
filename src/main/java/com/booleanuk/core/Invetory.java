package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Coffee;
import com.booleanuk.core.models.Filling;

import java.util.ArrayList;
import java.util.List;

public class Invetory {

    List<String> bagels = new ArrayList<>();
    List<String> coffees = new ArrayList<>();
    List<String> fillings = new ArrayList<>();

    public Invetory() {
//        Bagel bagel0 = new Bagel("Onion", 0.49, "BGLO");
//        Bagel bagel1 = new Bagel("Plain", 0.39, "BGLP");
//        Bagel bagel2 = new Bagel("Everything", 0.49, "BGLE");
//        Bagel bagel3 = new Bagel("Sesame", 0.49, "BGLS");
//
//        Filling filling0 = new Filling("Bacon", "FILB");
//        Filling filling1 = new Filling("Egg", "FILE");
//        Filling filling2 = new Filling("Cheese", "FILC");
//        Filling filling3 = new Filling("Cream Cheese", "FILX");
//        Filling filling4 = new Filling("Smoked Salmon", "FILS");
//        Filling filling5 = new Filling("Ham", "FILH");
//
//        Coffee coffee0 = new Coffee("Black", 0.99, "COFB");
//        Coffee coffee1 = new Coffee("White", 1.19, "COFW");
//        Coffee coffee2 = new Coffee("Capuccino", 1.29, "COFC");
//        Coffee coffee3 = new Coffee("Latte", 1.29, "COFL");

        bagels.add("BGLO");
        bagels.add("BGLP");
        bagels.add("BGLE");
        bagels.add("BGLS");

        coffees.add("COFB");
        coffees.add("COFW");
        coffees.add("COFC");
        coffees.add("COFL");

        fillings.add("FILB");
        fillings.add("FILE");
        fillings.add("FILC");
        fillings.add("FILX");
        fillings.add("FILS");
        fillings.add("FILH");
    }
}
