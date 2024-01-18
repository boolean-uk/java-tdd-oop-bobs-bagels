package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Bagel> bagels;
    private ArrayList<String> coffees;

    public Basket() {
        bagels = new ArrayList<>();
        coffees = new ArrayList<>();
    }

    public ArrayList<Bagel> getBagels() {
        return new ArrayList<>(bagels);
    }

    public void addBagel(String bagel) {
        bagels.add(new Bagel(bagel));
    }

    public int getNoOfBagels() {
        return bagels.size();
    }

    public String addFilling(String filling, String bagel) {
        boolean bagelExists = false;
        for(Bagel b: bagels) {
            if(b.getName().equalsIgnoreCase(bagel)) {
                bagelExists = true;
                if(!b.hasFilling(filling)) {
                    b.addFilling(filling);
                    return "Filling added.";
                }
            }
        }
        return bagelExists? "All bagels of that kind in your basket already has that filling."
                : "Your basket doesn't contain that bagel.";
    }

    public boolean removeBagel(String bagel, ArrayList<String> fillings) {
        ArrayList<String> upperCasedFillings = new ArrayList<>();
        for(String filling: fillings) {
            upperCasedFillings.add(filling.toUpperCase());
        }
        return bagels.remove(new Bagel(bagel, upperCasedFillings));
    }

    @Override
    public String toString() {
        return bagels.toString();
    }

    public void addCoffee(String coffee) {
        coffees.add(coffee.toUpperCase());
    }

    public ArrayList<String> getCoffees() {
        return new ArrayList<>(coffees);
    }

    public boolean removeCoffee(String coffee) {
        return coffees.remove(coffee.toUpperCase());
    }
}
