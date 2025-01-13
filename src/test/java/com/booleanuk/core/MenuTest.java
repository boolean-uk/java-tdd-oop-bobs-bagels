package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MenuTest {

    ArrayList<Item> itemsOnMenu = new ArrayList<>(){{
        // Adding the bagels
        Item onionBagel = new OnionBagel(0.49, "BGLO", "Onion"){};
        add(onionBagel);
        Item plainBagel = new PlainBagel(0.39, "BGLP", "Plain"){};
        add(plainBagel);
        Item everythingBagel = new EverythingBagel(0.49, "BGLE", "Everything"){};
        add(everythingBagel);
        Item sesameBagel = new SesameBagel(0.49, "BGLS", "Sesame"){};
        add(sesameBagel);

        // Adding the coffees
        Item blackCoffee = new BlackCoffee(0.99, "COFB", "Black"){};
        add(blackCoffee);
        Item whiteCoffee = new WhiteCoffee(1.19, "COFW", "White"){};
        add(whiteCoffee);
        Item cappucinoCoffee = new CappucinoCoffee(1.29, "COFC", "Cappuccino"){};
        add(cappucinoCoffee);
        Item latteCoffee = new LatteCoffee(1.29, "COFL", "Latte"){};
        add(latteCoffee);

        // Adding the fillings
        Item baconFilling = new BaconFilling(0.12, "FILB", "Bacon"){};
        add(baconFilling);
        Item eggFilling = new EggFilling(0.12, "FILE", "Egg"){};
        add(eggFilling);
        Item cheeseFilling = new CheeseFilling(0.12, "FILC", "Cheese"){};
        add(cheeseFilling);
        Item creamCheeseFilling = new CreamCheeseFilling(0.12, "FILX", "Cream Cheese"){};
        add(creamCheeseFilling);
        Item smokedSalmonFilling = new SmokedSalmonFilling(0.12, "FILS", "Smoked Salmon"){};
        add(smokedSalmonFilling);
        Item hamFilling = new HamFilling(0.12, "FILH", "Ham"){};
        add(hamFilling);
    }};



}
