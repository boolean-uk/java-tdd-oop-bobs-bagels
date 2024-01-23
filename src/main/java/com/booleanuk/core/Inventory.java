package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    public ArrayList<Filling> getAllFillings() {
        ArrayList<Filling> fillings = new ArrayList<>();

        Filling bacon = new Filling("Bacon", "FILB");
        fillings.add(bacon);
        Filling egg = new Filling("Egg", "FILE");
        fillings.add(egg);
        Filling cheese = new Filling("Cheese", "FILC");
        fillings.add(cheese);
        Filling creamCheese = new Filling("Cream Cheese", "FILX");
        fillings.add(creamCheese);
        Filling smokedSalmon = new Filling("Smoked Salmon", "FILS");
        fillings.add(smokedSalmon);
        Filling ham = new Filling("Ham", "FILH");
        fillings.add(ham);

        return fillings;
    }
}
