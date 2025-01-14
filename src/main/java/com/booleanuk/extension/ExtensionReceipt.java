package com.booleanuk.extension;

import com.booleanuk.core.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ExtensionReceipt {
    HashMap<Item, Integer> itemsThatArePurchased;
    String dateOfPurchase;

    public ExtensionReceipt(HashMap<Item, Integer> itemsThatArePurchased){
        this.itemsThatArePurchased = itemsThatArePurchased;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dateOfPurchase = sdf.format(new Date());
    }

    public double totalCostWithDiscounts(){
        double totalCost = 0;

        int numOnionBagel = 0;
        int numPlainBagel = 0;
        int numEverythingBagel = 0;
        int numSesameBagel = 0;
        int numBagel = 0;
        int numCoffee = 0;

        for(Item item : itemsThatArePurchased.keySet()){
            if(item.getAbbreviation() == "BGLO"){
                for(int i = 0; i < itemsThatArePurchased.get(item); i++){
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
                }

            } else if (item.getAbbreviation() == "BGLP") {
                for(int i = 0; i < itemsThatArePurchased.get(item); i++){
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
                }

            } else if (item.getAbbreviation() == "BGLE") {
                for(int i = 0; i < itemsThatArePurchased.get(item); i++){
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
                }

            } else if (item.getAbbreviation() == "BGLS") {
                for(int i = 0; i < itemsThatArePurchased.get(item); i++){
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
                }

            } else if (item.getAbbreviation().contains("COF")) {
                numCoffee = itemsThatArePurchased.get(item);
                totalCost += item.getPrice()*itemsThatArePurchased.get(item);
            } else{
                totalCost += item.getPrice();
            }


        }
        if(numBagel == 1 && numCoffee == 1){
            totalCost = 1.25;
        }

        return Math.round(totalCost * 100.0) / 100.0;
    }




    public double costWithDiscounts(Item itemToCheck, int quantity){
        int numBagel = 0;
        double cost = 0;

        if(itemToCheck.getAbbreviation().contains("BGL")){

            for(int i = 0; i < quantity; i++){
                numBagel++;
                if(numBagel == 12){
                    numBagel = 0;
                    cost -= 5*itemToCheck.getPrice();
                    cost += 1.50;
                } else if (numBagel == 6) {
                    cost -= 5*itemToCheck.getPrice();
                    cost += 2.49;
                } else {
                    cost += itemToCheck.getPrice();
                }
            }
        } else {
            cost += itemToCheck.getPrice()*quantity;
        }

        return Math.round(cost * 100.0) / 100.0;
    }







    public String printReceipt(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~~~ Bob's Bagels ~~~ \n\n");
        stringBuilder.append(dateOfPurchase);
        stringBuilder.append("\n----------------------------\n");

        for(Item anItem : itemsThatArePurchased.keySet()){
            stringBuilder.append(anItem.getName() + " " + anItem.getTypeOfItem() + " " + itemsThatArePurchased.get(anItem) + " " + (anItem.getPrice()*itemsThatArePurchased.get(anItem)) + "\n");
        }

        stringBuilder.append("\n----------------------------\n");
        stringBuilder.append("Total " + "£" + totalCostWithDiscounts() + "\n");


        stringBuilder.append("Thank you\n");
        stringBuilder.append("for your order!");

        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
}
