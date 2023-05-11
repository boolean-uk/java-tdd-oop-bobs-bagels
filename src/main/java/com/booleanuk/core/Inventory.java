package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<Bagel> existingBagels = List.of(new Bagel("Onion", 0.49),
            new Bagel("Plain", 0.39), new Bagel("Everything", 0.49),
            new Bagel("Sesame", 0.49));

    List<Filling> existingFillings = List.of(new Filling("Bacon", 0.12),
            new Filling("Egg", 0.12), new Filling("Cheese", 0.12),
            new Filling("Cream Cheese", 0.12), new Filling("Smoked Salmon", 0.12),
            new Filling("Ham", 0.12));;

    List<Coffee> existingCoffees = List.of(new Coffee("Black", 0.99),
            new Coffee("White", 1.19), new Coffee("Capuccino", 1.29),
            new Coffee("Latte", 1.29));;


    public boolean contains(Bagel bagel){
        return this.existingBagels.contains(bagel);

    }

    public boolean contains(Filling filling){
        return this.existingFillings.contains(filling);

    }

    public boolean contains(Coffee coffee){
        return this.existingCoffees.contains(coffee);

    }




}
