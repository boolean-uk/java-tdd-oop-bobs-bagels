package com.booleanuk.extension;

import com.booleanuk.core.Item;
import com.booleanuk.core.Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Receipt {
    private ArrayList<Item> basketItems;
    private ArrayList<Item> receiptItems;
    private Menu menu;
    private double total = 0;
    private double totalPriceOfPlainBagels = 0;
    private double totalPriceOfOnionBagels = 0;
    private double totalPriceOfEverythingBagels = 0;
    private double totalPriceOfSesameBagels = 0;
    private double totalPriceOfBlackCoffee = 0;
    private double totalPriceOfWhiteCoffee = 0;
    private double totalPriceOfCappuccino = 0;
    private double totalPriceOfLatte = 0;
    private double totalPriceOfBacon = 0;
    private double totalPriceOfEgg = 0;
    private double totalPriceOfCheese = 0;
    private double totalPriceOfCreamCheese = 0;
    private double totalPriceOfSmokedSalmon = 0;
    private double totalPriceOfHam = 0;

    public Receipt(ArrayList<Item> basketItems){
        this.basketItems = basketItems;
        menu = new Menu();
        receiptItems = new ArrayList<>();
        populateReceiptItems();
    }

    public String printReceipt(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        String topOfReceipt =
                "    ~~~ Bob's Bagels ~~~\n" +
                "\n" +
                "    " + timestamp + "\n" +
                "\n" +
                "----------------------------\n" +
                "\n";

        total = calculatePriceOfBasket();

        String purchasedItems = turnPurchasedItemsToString();

        String totalCostOfItems =
                "\n----------------------------\n" +
                "Total                  £"+total+"\n" +
                "\n" +
                "        Thank you\n" +
                "      for your order!";

        String receiptString = topOfReceipt + purchasedItems + totalCostOfItems;

        return receiptString;
    }

    private String turnPurchasedItemsToString(){
        String purchasedItems = "";
        double itemCost = 0;
        int numOfItems = 0;


        for (var itemSet : receiptItems){

            switch(itemSet.getAbbreviation()){
                case "BGLO":
                    itemCost = totalPriceOfOnionBagels;
                    break;
                case "BGLP":
                    itemCost = totalPriceOfPlainBagels;
                    break;
                case "BGLE":
                    itemCost = totalPriceOfEverythingBagels;
                    break;
                case "BGLS":
                    itemCost = totalPriceOfSesameBagels;
                    break;
                case "COFB":
                    itemCost = totalPriceOfBlackCoffee;
                    break;
                case "COFW":
                    itemCost = totalPriceOfWhiteCoffee;
                    break;
                case "COFC":
                    itemCost = totalPriceOfCappuccino;
                    break;
                case "COFL":
                    itemCost = totalPriceOfLatte;
                    break;
                case "FILB":
                    itemCost = totalPriceOfBacon;
                    break;
                case "FILE":
                    itemCost = totalPriceOfEgg;
                    break;
                case "FILC":
                    itemCost = totalPriceOfCheese;
                    break;
                case "FILX":
                    itemCost = totalPriceOfCreamCheese;
                    break;
                case "FILS":
                    itemCost = totalPriceOfSmokedSalmon;
                    break;
                case "FILH":
                    itemCost = totalPriceOfHam;
                    break;
            }
            for(Item item : basketItems){
                if(item.getName() == itemSet.getName()){
                    numOfItems++;
                }
            }
            if(numOfItems > 0){
                double roundedItemCost = Math.round(itemCost * 100.0) / 100.0;
                purchasedItems += itemSet.getName() + "        " + numOfItems + "  £" + roundedItemCost + "\n";
                numOfItems = 0;
            }

        }
        return purchasedItems;
    }

    private double calculatePriceOfBasket(){

        int numOfBagels = 0;
        int numOfPlainBagels = 0;
        int numOfOnionBagels = 0;
        int numOfEverythingBagels = 0;
        int numOfSesameBagels = 0;
        int numbOfCoffees = 0;


        for(Item i : basketItems){
            switch(i.getAbbreviation()){
                case "BGLO":
                    numOfOnionBagels++;
                    numOfBagels++;
                    break;
                case "BGLP":
                    numOfPlainBagels++;
                    numOfBagels++;
                    break;
                case "BGLE":
                    numOfEverythingBagels++;
                    numOfBagels++;
                    break;
                case "BGLS":
                    numOfSesameBagels++;
                    numOfBagels++;
                    break;
                case "COFB":
                    numbOfCoffees++;
                    totalPriceOfBlackCoffee += i.getPrice();
                    total += i.getPrice();
                    break;
                case "COFW":
                    numbOfCoffees++;
                    totalPriceOfWhiteCoffee += i.getPrice();
                    total += i.getPrice();
                    break;
                case "COFC":
                    numbOfCoffees++;
                    totalPriceOfCappuccino += i.getPrice();
                    total += i.getPrice();
                    break;
                case "COFL":
                    numbOfCoffees++;
                    totalPriceOfLatte += i.getPrice();
                    total += i.getPrice();
                    break;
                case "FILB":
                    totalPriceOfBacon += i.getPrice();
                    total += i.getPrice();
                    break;
                case "FILC":
                    totalPriceOfCheese += i.getPrice();
                    total += i.getPrice();
                    break;
                case "FILE":
                    totalPriceOfEgg += i.getPrice();
                    total += i.getPrice();
                    break;
                case "FILX":
                    totalPriceOfCreamCheese += i.getPrice();
                    total += i.getPrice();
                    break;
                case "FILS":
                    totalPriceOfSmokedSalmon += i.getPrice();
                    total += i.getPrice();
                    break;
                case "FILH":
                    totalPriceOfHam += i.getPrice();
                    total += i.getPrice();
                    break;
            }


        }


        if(numOfOnionBagels >= 12){
            numOfOnionBagels = numOfOnionBagels % 12;
            totalPriceOfOnionBagels +=3.99;
            //total += 3.99;
        }
        if(numOfOnionBagels >= 6){
            numOfOnionBagels = numOfOnionBagels % 6;
            totalPriceOfOnionBagels += 2.49;
            //total += 2.49;
        }
        totalPriceOfOnionBagels += numOfOnionBagels * 0.49;
        //total += numOfOnionBagels * 0.49d;


        if(numOfPlainBagels >= 12){
            numOfPlainBagels = numOfPlainBagels % 12;
            totalPriceOfPlainBagels += 3.99;
            //total += 3.99;
        }
        if(numOfPlainBagels >= 6){
            numOfPlainBagels = numOfPlainBagels % 6;
            totalPriceOfPlainBagels += 2.49;
            //total += 2.49;
        }
        totalPriceOfPlainBagels += numOfPlainBagels * 0.39;
        //total += numOfPlainBagels * 0.39d;

        if(numOfEverythingBagels >= 12){
            numOfEverythingBagels = numOfEverythingBagels % 12;
            totalPriceOfEverythingBagels += 3.99;
            //total += 3.99;
        }
        if(numOfEverythingBagels >= 6){
            numOfEverythingBagels = numOfEverythingBagels % 6;
            totalPriceOfEverythingBagels += 2.49;
            //total += 2.49;
        }
        totalPriceOfEverythingBagels += numOfEverythingBagels * 0.49;


        if(numOfSesameBagels >= 12){
            numOfSesameBagels = numOfSesameBagels % 12;
            totalPriceOfSesameBagels += 3.99;

        }
        if(numOfSesameBagels >= 6){
            numOfSesameBagels = numOfSesameBagels % 6;
            totalPriceOfSesameBagels += 2.49;

        }
        totalPriceOfSesameBagels += numOfSesameBagels * 0.49;


        if (numOfBagels == 1 && numbOfCoffees == 1) {
            total = 1.25;
        }

        total = total + totalPriceOfSesameBagels + totalPriceOfPlainBagels + totalPriceOfEverythingBagels
                + totalPriceOfOnionBagels;

        double roundedTotalCost = Math.round(total * 100.0) / 100.0;

        return roundedTotalCost;
    }

    private void populateReceiptItems(){
        ArrayList<String>itemNames = new ArrayList<>();

        for(Item item : basketItems){
            if(!itemNames.contains(item.getName())){
                itemNames.add(item.getName());
                receiptItems.add(item);
            }
        }

    }
}
