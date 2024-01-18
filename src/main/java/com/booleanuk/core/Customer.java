package com.booleanuk.core;

public class Customer {

    private Basket basket;
    private Inventory inventory;

    public Customer(){

    }

    public boolean addToBasket(String id, String[] fillingIds){
        return false;
    }

    public boolean removeFromBasket(String id, String[] fillingIds){
        return false;
    }

    public double getCostOfProduct(String id){
        return -1;
    }

    public double getCostOfbasket(){
        return -1;
    }
}
