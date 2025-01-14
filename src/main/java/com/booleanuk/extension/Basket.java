package com.booleanuk.extension;

import jdk.jfr.Label;

import java.security.cert.Extension;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Basket {
    private final ArrayList<Item> basket = new ArrayList<>();
    private int maxCapacity = 25;
    private double totalCost = 0.0;

    public boolean addItem(Item item) {
        if (this.basket.size() <= this.maxCapacity - 1) {
            this.basket.add(item);
            this.totalCost += item.getPrice();
            return true;
        }
        System.out.println("Basket full!");
        return false;

    }

    public boolean removeItem(Item item) {
        if (this.basket.contains(item)) {
            this.basket.remove(item);
            this.totalCost -= item.getPrice();
            return true;
        }
        System.out.println("No such item in the basket!");
        return false;
    }

    public boolean changeCapacity(int newCapacity) {
        if (newCapacity > 0) {
            this.maxCapacity = newCapacity;
            return true;
        }
        return false;
    }

    public ArrayList<Item> getBasket(){
        return this.basket;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }


    //This methods will allow multiple discounts to be applied and likely got this ugly because of it
    //I.e. if there are 18 bagels of the same type, first the 12 bagel discount is given and then the 6 bagel discount for the remaining bagles
    //The coffee discount needs "stand-alone" bagels, so not bagles that are already part of another discount calculation
    public void checkDiscounts() {
        HashMap<String, ArrayList<Item>> counterMap = new HashMap<>();
        double counter = 0.0;

        for (Item item : this.basket) {
            counterMap.computeIfAbsent(item.getId(), k -> new ArrayList<>()).add(item);
        }

        for (String id : counterMap.keySet()) {
            int remainder12;
            int finalRemainder;
            if (id.startsWith("BGL")) {
                //Check for 12 bagel discount
                int quotient12 = counterMap.get(id).size() / 12;
                counter += 3.99 * quotient12;
                if (quotient12 != 0) {
                    remainder12 = counterMap.get(id).size() % (12 * quotient12);
                } else {
                    remainder12 = counterMap.get(id).size();
                }

                //Check for 6 bagel discount
                int quotient6 = remainder12 / 6;
                counter += 2.49 * quotient6;
                if (quotient6 != 0) {
                    finalRemainder = remainder12 % (6 * quotient6);
                } else {
                    finalRemainder = remainder12;
                }

                //Check for bagel and coffee discounts
                if (counterMap.containsKey("COFB")) {
                    while (!counterMap.get("COFB").isEmpty() && finalRemainder > 0) {
                        counter += 1.25;
                        counterMap.get("COFB").removeFirst();
                        finalRemainder--;
                    }

                }
                //Good chance that the coffee check has removed all elements in the list so need to check if null
                //before the remaining (non-discounted) items are calculated
                if (counterMap.get(id).getFirst() != null) {
                    counter += finalRemainder * counterMap.get(id).getFirst().getPrice();
                }
            }
        }
        this.totalCost = counter;
    }


}
