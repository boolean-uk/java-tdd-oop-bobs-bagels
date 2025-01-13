package com.booleanuk.core;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Basket {

    private ArrayList<Item> items;
    private int basketSize;

    public Basket(){
        items = new ArrayList<>();
        basketSize = 100;
    }

    public String add(Item item, Menu menu){
        String msg = "";
        if(!menu.isInMenu(item)){
            msg = "Item not on the menu";
            return msg;
        }
        if(items.size() >= basketSize){
            return msg = "Basket is full";
        }
        items.add(item);
        if(menu.isInMenu(item)){
            msg = "Successfully added";

        }
        return msg;

    }

    public String remove(String itemName){
        String msg = "";
        for (Item i : items){
            if(i.getName() == itemName){
                items.remove(i);
                msg = "Successfully removed";
                return msg;
            }

        }

        msg = "No item found";

        return msg;
    }

    public Boolean resizeBasket(int newSize){
        if(newSize>15){
            return false;
        }
        basketSize = newSize;
        return true;
    }

    public Double calculateTotalCostOfBasket(){
        double total = 0;

        for(Item i : items){
            total += i.getPrice();
        }

        return total;
    }

    public Double calculateTotalCostOfBasketWithDiscounts(){
        double total = 0;
        int numOfBagels = 0;
        int numOfPlainBagels = 0;
        int numOfOnionBagels = 0;
        int numOfEverythingBagels = 0;
        int numOfSesameBagels = 0;
        int numbOfCoffees = 0;

        for(Item i : items){
            if(i.getAbbreviation().equals("BGLO")){
                numOfOnionBagels++;
                numOfBagels++;
            }
            if(i.getAbbreviation().equals("BGLP")){
                numOfPlainBagels++;
                numOfBagels++;
            }
            if(i.getAbbreviation().equals("BGLE")){
                numOfEverythingBagels++;
                numOfBagels++;
            }
            if(i.getAbbreviation().equals("BGLS")){
                numOfSesameBagels++;
                numOfBagels++;
            }
            if(i.getAbbreviation().contains("COF")){
                numbOfCoffees++;
                total += i.getPrice();
            }
            if(i.getAbbreviation().contains("FIL")){

                total += i.getPrice();
            }

        }


        if(numOfOnionBagels >= 12){
            numOfOnionBagels = numOfOnionBagels % 12;
            //total += numOfOnionBagels * 0.49 + 3.99;
            total += 3.99;
        }
        if(numOfOnionBagels >= 6){
            numOfOnionBagels = numOfOnionBagels % 6;
            total += 2.49;
        }
        total += numOfOnionBagels * 0.49d;


        if(numOfPlainBagels >= 12){
            numOfPlainBagels = numOfPlainBagels % 12;
            total += 3.99;
        }
        if(numOfPlainBagels >= 6){
            numOfPlainBagels = numOfPlainBagels % 6;
            total += 2.49;
        }
        total += numOfPlainBagels * 0.39d;

        if(numOfEverythingBagels >= 12){
            numOfEverythingBagels = numOfEverythingBagels % 12;
            total += 3.99;
        }
        if(numOfEverythingBagels >= 6){
            numOfEverythingBagels = numOfEverythingBagels % 6;
            total += 2.49;
        }
        total += numOfEverythingBagels * 0.49d;

        if(numOfSesameBagels >= 12){
            numOfSesameBagels = numOfSesameBagels % 12;
            total += 3.99;
        }
        if(numOfSesameBagels >= 6){
            numOfSesameBagels = numOfSesameBagels % 6;
            total += 2.49;
        }
        total += numOfSesameBagels * 0.49d;


        if (numOfBagels == 1 && numbOfCoffees == 1) {
            total = 1.25;
        }

        return total;
    }
}
