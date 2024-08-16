package com.booleanuk.core;

import java.util.HashMap;

public class Store {

    public Product[] inventory = new Product[14];
    public HashMap<String, Order> orders;
    private int basketCapacity;

    public Store(int basketCapacity) {
        this.basketCapacity = basketCapacity;

        Bagel bagel1 = new Bagel("BGLO", "Onion", 0.49);
        Bagel bagel2 = new Bagel("BGLP", "Plain", 0.39);
        Bagel bagel3 = new Bagel("BGLE", "Everything", 0.49);
        Bagel bagel4 = new Bagel("BGLS", "Sesame", 0.49);
        Coffee coffee1 = new Coffee("COFB", "Black", 0.99);
        Coffee coffee2 = new Coffee("COFW", "White", 1.19);
        Coffee coffee3 = new Coffee("COFC", "Capuccino", 1.29);
        Coffee coffee4 = new Coffee("COFL", "Latte", 1.29);
        Filling filling1 = new Filling("FILB", "Bacon", 0.12);
        Filling filling2 = new Filling("FILE", "Egg", 0.12);
        Filling filling3 = new Filling("FILC", "Cheese", 0.12);
        Filling filling4 = new Filling("FILX", "Cream Cheese", 0.12);
        Filling filling5 = new Filling("FILS", "Smoked Salmon", 0.12);
        Filling filling6 = new Filling("FILH", "Ham", 0.12);

        inventory[0] = bagel1;
        inventory[1] = bagel2;
        inventory[2] = bagel3;
        inventory[3] = bagel4;
        inventory[4] = coffee1;
        inventory[5] = coffee2;
        inventory[6] = coffee3;
        inventory[7] = coffee4;
        inventory[8] = filling1;
        inventory[9] = filling2;
        inventory[10] = filling3;
        inventory[11] = filling4;
        inventory[12] = filling5;
        inventory[13] = filling6;
    }
}