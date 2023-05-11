package com.booleanuk.core;

public class Order {

    Inventory inv = new Inventory();

    Basket basket = new Basket(4);

    public boolean add(Bagel bagel){
        return true;
    }

    public boolean add(Filling filling){
        return true;
    }

    public boolean add(Coffee coffee){
        return true;
    }

    public boolean remove(Bagel bagel){
        return true;
    }

    public boolean remove(Coffee coffee){
        return true;
    }




}
