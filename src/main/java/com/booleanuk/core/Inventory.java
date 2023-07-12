package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Bagle> bagels;
    private List<Coffee> coffees;
    private List<Filling> fillings;

    public Inventory(){
        this.bagels = new ArrayList<>();
        this.coffees = new ArrayList<>();
        this.fillings = new ArrayList<>();
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
        Filling filling1 = new Filling("FILB", 0.12, "Bacon");
        Filling filling2 = new Filling("FILB", 0.12, "Bacon");
        Filling filling3 = new Filling("FILB", 0.12, "Bacon");
        Filling filling4 = new Filling("FILB", 0.12, "Bacon");
        fillings.add(filling1);
        fillings.add(filling2);
        fillings.add(filling3);
        fillings.add(filling4);

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
        return 0.0;
    }



}
