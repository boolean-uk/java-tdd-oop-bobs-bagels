package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    public ArrayList<Item> listOfBasket;
    public int capacity;


    public Basket(int capacity) {
        this.listOfBasket = new ArrayList<>();
        this.capacity = capacity;

    }

    public void addBagel(Item item){
        if (getListOfBasket().size()<capacity) {
            listOfBasket.add(item);
        } else {
            System.out.println("Basket is full! Cannot add more bagels.");
        }

    }

    public String removeBagel(Item item){
        if (listOfBasket.contains(item)) {
                listOfBasket.remove(item);

        } else {
            return "The bagel do not exist in the basket";
        }
        return "The bagel was sucessfully removed";
    }

    public ArrayList<Item> getListOfBasket(){
        return listOfBasket;

    }

    public double getTotalCost(){
        double totalCost = 0;
        for (Item item: listOfBasket){
            totalCost += item.getPrice();
        }
        return totalCost;
    }




}


