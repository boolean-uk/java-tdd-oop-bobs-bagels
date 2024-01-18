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




    public Coffee(String coffeeSku, String itemType, String coffeeName, double coffeePrice) {

        this.setCoffeeSku(coffeeSku);
        this.setItemType(itemType);
        this.setCoffeeName(coffeeName);
        this.setCoffeePrice(coffeePrice);





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

    public void setCoffeeSku(String coffeeSku) {
        this.coffeeSku = coffeeSku;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public void setCoffeePrice(double coffeePrice) {
        this.coffeePrice = coffeePrice;
    }
}
