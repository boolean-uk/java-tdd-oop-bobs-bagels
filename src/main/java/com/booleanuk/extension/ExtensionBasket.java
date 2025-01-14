package com.booleanuk.extension;

import com.booleanuk.core.Item;

import java.util.ArrayList;

public class ExtensionBasket {
    private ArrayList<Item> itemsInBasket;
    private int size;

    public ExtensionBasket(ArrayList<Item> itemsInBasket, int size){
        this.itemsInBasket = itemsInBasket;
        this.size = size;
    }

    public double totalCostWithDiscounts(){
        double totalCost = 0;

        int numOnionBagel = 0;
        int numPlainBagel = 0;
        int numEverythingBagel = 0;
        int numSesameBagel = 0;
        int numBagel = 0;
        int numCoffee = 0;

        for(Item item : itemsInBasket){
            if(item.getAbbreviation().equals("BGL0")){
                numBagel++;
                numOnionBagel++;
                if(numOnionBagel == 12){
                    numOnionBagel = 0;
                    totalCost -= 5*item.getPrice();
                    totalCost += 1.50;
                } else if (numOnionBagel == 6) {
                    totalCost -= 5*item.getPrice();
                    totalCost += 2.49;
                } else {
                    totalCost += item.getPrice();
                }

            } else if (item.getAbbreviation().equals("BGLP")) {
                numBagel++;
                numPlainBagel++;
                if(numPlainBagel == 12){
                    numPlainBagel = 0;
                    totalCost -= 5*item.getPrice();
                    totalCost += 1.50;
                } else if (numPlainBagel == 6) {
                    totalCost -= 5*item.getPrice();
                    totalCost += 2.49;
                } else {
                    totalCost += item.getPrice();
                }

            } else if (item.getAbbreviation().equals("BGLE")) {
                numBagel++;
                numEverythingBagel++;
                if(numEverythingBagel == 12){
                    numEverythingBagel = 0;
                    totalCost -= 5*item.getPrice();
                    totalCost += 1.50;
                } else if (numEverythingBagel == 6) {
                    totalCost -= 5*item.getPrice();
                    totalCost += 2.49;
                } else {
                    totalCost += item.getPrice();
                }

            } else if (item.getAbbreviation().equals("BGLS")) {
                numBagel++;
                numSesameBagel++;
                if(numSesameBagel == 12){
                    numSesameBagel = 0;
                    totalCost -= 5*item.getPrice();
                    totalCost += 1.50;
                } else if (numSesameBagel == 6) {
                    totalCost -= 5*item.getPrice();
                    totalCost += 2.49;
                } else {
                    totalCost += item.getPrice();
                }

            } else if (item.getAbbreviation().contains("COF")) {
                numCoffee++;
                totalCost += item.getPrice();
            } else{
                totalCost += item.getPrice();
            }


        }
        if(numBagel == 1 && numCoffee == 1){
            totalCost = 1.25;
        }
        double roundOff = Math.round(totalCost * 100.0) / 100.0;
        return roundOff;
    }
}
