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
public class Coffee {

    String coffeeSku;
    String itemType;
    String coffeeName;
    double coffeePrice;


    HashMap<String, Double> bagel;
    HashMap<String, Double> filling;
    HashMap<String, Double> coffee;

    public Coffee(String coffeeSku, String itemType, String coffeeName, double coffeePrice) {

        this.coffeeSku = coffeeSku;
        this.itemType = itemType;
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;







       /* bagel = new HashMap<>(5);
       var plain = bagel.put("Plain", 0.39);
       var everything = bagel.put("Everything", 0.49);
       var sesame =  bagel.put("Sesame", 0.49);
       var onion =  bagel.put("Onion", 0.49);
        filling = new HashMap<>(7);
       var bacon = filling.put("Bacon", 0.12);
       var egg =  filling.put("Egg", 0.12);
       var cheese = filling.put("Cheese", 0.12);
       var creamCheese = filling.put("Cream Cheese", 0.12);
        filling.put("Smoked Salmon", 0.12);
        filling.put("Ham", 0.12);
        coffee = new HashMap<>(5);
       var black = coffee.put("Black", 0.99);
       var white = coffee.put("White", 1.19);
       var cappuccino = coffee.put("Cappuccino", 1.29);
       var latte = coffee.put("Latte", 1.29); */



    }


    public String getSku() {
        return coffeeSku;
    }

    public String getItemTypeCoffee() {
        return itemType;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public double getCoffeePrice() {
        return coffeePrice;
    }

    public Coffee coffee1 = new Coffee("COFB", "Bagel", "Onion", 0.99);
   public Coffee coffee2 = new Coffee("COFW", "Bagel", "Onion", 1.19);
   public Coffee coffee3 = new Coffee("COFC", "Bagel", "Onion", 1.29);
   public Coffee coffee4 = new Coffee("COFL", "Bagel", "Onion", 1.29);







}
