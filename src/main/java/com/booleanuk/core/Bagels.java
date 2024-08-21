package com.booleanuk.core;

import java.util.HashMap;


public class Bagels extends Product {
    private HashMap<Fillings, Integer> fillings;

    Bagels(String SKU, double price, String variant) {
        super(SKU, price, variant);
        fillings = new HashMap<>();
    }

    public HashMap<Fillings, Integer> getFillings() {
        return fillings;
    }

    public void addFilling(Fillings filling) {
        fillings.put(filling, fillings.getOrDefault(filling, 0) + 1);
    }

    public void removeFilling(Fillings filling) {
        fillings.remove(filling);
    }

    public void printFillings() {
            if(!fillings.isEmpty()) {
                for (HashMap.Entry<Fillings, Integer> entry : fillings.entrySet()) {
                    int quantity = entry.getValue();
                    Fillings filling = entry.getKey();
                    System.out.printf(" -"+ "%-14s %5d %15s %n",
                            filling.getVariant() + " Filling",
                            quantity,
                            "$" + String.format("%.2f", filling.getPrice() * quantity));
                }
            }
        }


    }


