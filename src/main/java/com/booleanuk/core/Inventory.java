package com.booleanuk.core;

import java.util.HashMap;

/*SKU	Price	Name	Variant
BGLO	0.49	Bagel	Onion
BGLP	0.39	Bagel	Plain
BGLE	0.49	Bagel	Everything
BGLS	0.49	Bagel	Sesame
COFB	0.99	Coffee	Black
COFW	1.19	Coffee	White
COFC	1.29	Coffee	Capuccino
COFL	1.29	Coffee	Latte
FILB	0.12	Filling	Bacon
FILE	0.12	Filling	Egg
FILC	0.12	Filling	Cheese
FILX	0.12	Filling	Cream Cheese
FILS	0.12	Filling	Smoked Salmon
FILH	0.12	Filling	Ham */
public class Inventory {
    HashMap<String, Double> bagel;
    HashMap<String, Double> filling;
    HashMap<String, Double> coffee;

    public Inventory() {
        bagel = new HashMap<>(5);
        bagel.put("Plain", 0.39);
        bagel.put("Everything", 0.49);
        bagel.put("Sesame", 0.49);
        bagel.put("Onion", 0.49);
        filling = new HashMap<>(7);
        filling.put("Bacon", 0.12);
        filling.put("Egg", 0.12);
        filling.put("Cheese", 0.12);
        filling.put("Cream Cheese", 0.12);
        filling.put("Smoked Salmon", 0.12);
        filling.put("Ham", 0.12);
        coffee = new HashMap<>(5);
        coffee.put("Black", 0.99);
        coffee.put("White", 1.19);
        coffee.put("Cappuccino", 1.29);
        coffee.put("Latte", 1.29);



    }





}
