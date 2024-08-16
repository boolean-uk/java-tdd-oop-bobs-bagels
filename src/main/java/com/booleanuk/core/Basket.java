package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    public ArrayList<Bagel> listOfBasket;
    public int capacity;


    public Basket(int capacity) {
        this.listOfBasket = new ArrayList<>();
        this.capacity = capacity;

    }

    public void addBagel(Bagel bagel){
        if (getListOfBasket().size()<capacity) {
            listOfBasket.add(bagel);
        } else {
            System.out.println("Basket is full! Cannot add more bagels.");
        }

    }

    public void removeBagel(Bagel bagel){
        listOfBasket.remove(bagel);
    }

    public ArrayList<Bagel> getListOfBasket(){
        return listOfBasket;

    }




}


