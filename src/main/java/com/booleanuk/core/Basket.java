package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Bagel> bagels;

    public Basket() {
        bagels = new ArrayList<Bagel>();
    }

    public ArrayList<Bagel> getBagels() {
        return bagels;
    }

    public void addBagel(Bagel bagel) {
        bagels.add(bagel);
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

    //TODO: refactor so we dont have to create bagel obj
    public boolean removeBagel(String bagel, ArrayList<String> fillings) {
        ArrayList<String> upperCasedFillings = new ArrayList<>();
        for(String filling: fillings) {
            upperCasedFillings.add(filling.toUpperCase());
        }
        return bagels.remove(new Bagel(bagel, upperCasedFillings));
    }

}
