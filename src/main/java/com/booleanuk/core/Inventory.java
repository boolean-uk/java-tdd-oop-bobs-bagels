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
