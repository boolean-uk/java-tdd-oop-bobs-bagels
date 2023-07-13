package com.booleanuk.core;

import com.booleanuk.extension.SpecialOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<Bagle> bagels;
    private List<Coffee> coffees;
    private List<Filling> fillings;
    private Map<String, SpecialOffer> specialOffers;

    public Inventory(){
        this.bagels = new ArrayList<>();
        this.coffees = new ArrayList<>();
        this.fillings = new ArrayList<>();
        specialOffers = new HashMap<>();
        initializeInventory();
    }

    public void initializeInventory() {
        Bagle bagle1 = new Bagle("BGLO",  	0.49,"Onion");
        Bagle bagle2 = new Bagle("BGLP",  	0.39,"Plain");
        Bagle bagle3 = new Bagle("BGLE",  	0.49,"Everything");
        Bagle bagle4 = new Bagle("BGLS",  	0.49,"Sesame");
        bagels.add(bagle1);
        bagels.add(bagle2);
        bagels.add(bagle3);
        bagels.add(bagle4);
        Coffee coffee1 = new Coffee("COFB",  	0.99,"Black");
        Coffee coffee2 = new Coffee("COFW",  	1.19,"White");
        Coffee coffee3 = new Coffee("COFC",  	1.29,"Capuccino");
        Coffee coffee4 = new Coffee("COFL",  	1.29,"Latte");

        coffees.add(coffee1);
        coffees.add(coffee2);
        coffees.add(coffee3);
        coffees.add(coffee4);

        Filling filling1 = new Filling("FILB", 0.12, "Bacon");
        Filling filling2 = new Filling("FILE", 0.12, "Egg");
        Filling filling3 = new Filling("FILC", 0.12, "Cheese");
        Filling filling4 = new Filling("FILX", 0.12, "Cream Cheese");
        Filling filling5 = new Filling("FILS", 0.12, "Smoked Salmon");
        Filling filling6 = new Filling("FILH", 0.12, "Ham");
        fillings.add(filling1);
        fillings.add(filling2);
        fillings.add(filling3);
        fillings.add(filling4);
        fillings.add(filling5);
        fillings.add(filling6);

        specialOffers.put("BGLO", new SpecialOffer(6,2.49));
        specialOffers.put("BGLP", new SpecialOffer(12,3.99));
        specialOffers.put("BGLE", new SpecialOffer(6,2.49));
        specialOffers.put("COFB", new SpecialOffer(1,1.25));




    }
    public void addBagel(Bagle bagel) {
        bagels.add(bagel);
    }
    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }
    public void addFilling(Filling filling) {
        fillings.add(filling);
    }
    public Bagle getBagelBySKU(String SKU){
        for (Bagle bagel : bagels){
            if (bagel.getSKU().equals(SKU)){
                return bagel;
            }
        }
        return null;
    }
    public Coffee getCoffeeBySKU(String SKU) {
        for (Coffee coffee : coffees) {
            if (coffee.getSKU().equals(SKU)) {
                return coffee;
            }
        }
        return null;
    }

    public Filling getFillingBySKU(String SKU) {
        for (Filling filling : fillings) {
            if (filling.getSKU().equals(SKU)) {
                return filling;
            }
        }
        return null;
    }

    public boolean checkAvailability(String item) {
        for (Bagle bagel : bagels) {
            if (bagel.getSKU().equals(item)) {
                return true;
            }
        }
        for (Coffee coffee : coffees) {
            if (coffee.getSKU().equals(item)) {
                return true;
            }
        }
        for (Filling filling : fillings) {
            if (filling.getSKU().equals(item)) {
                return true;
            }
        }
        return false;
    }

    public double getItemPrice(String item) {
        for (Bagle bagel : bagels) {
            if (bagel.getSKU().equals(item)) {
                return bagel.getPrice();
            }
        }
        for (Coffee coffee : coffees) {
            if (coffee.getSKU().equals(item)) {
                return coffee.getPrice();
            }
        }
        for (Filling filling : fillings) {
            if (filling.getSKU().equals(item)) {
                return filling.getPrice();
            }
        }
        if (item.equals("COFB")) {
            Bagle bagle = getBagelBySKU("BGLP");
            if (bagle!=null){
                double baglePrice = bagle.getPrice();
                double coffeeBagelPrice = 1.25;
                return Math.min(baglePrice,coffeeBagelPrice);
            }
        }
        return 0.0;
    }
    public SpecialOffer getSpecialOffer(String SKU){
        return specialOffers.get(SKU);
    }



}
