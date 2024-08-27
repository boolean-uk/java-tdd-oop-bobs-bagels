package com.booleanuk.core;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket(10, new Inventory());
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", Bagel.BagelVariant.ONION);
        basket.addItem(bagel1);
        Bagel bagel2 = new Bagel("BGLO", 0.49, "Bagel", Bagel.BagelVariant.ONION);
        basket.addItem(bagel2);
        Filling baconFilling = new Filling("FILB", 0.12, "Filling", "Bacon");
        bagel1.setFilling(baconFilling);

        Coffee coffee = new Coffee("COFB",0.99,"Coffee","Black");
        basket.addItem(coffee);


        double result = basket.getTotalCost();
        System.out.println(result);
    }
}
