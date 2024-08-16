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
        listOfBasket.add(bagel);

    }

    public void removeBagel(Bagel bagel){
        listOfBasket.remove(bagel);
    }

    public ArrayList<Bagel> getListOfBasket(){
        return listOfBasket;

    }




}


