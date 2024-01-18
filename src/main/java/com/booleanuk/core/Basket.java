package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private ArrayList<Bagel> products;
    //private HashMap<Bagel, Integer> products;
    private static final Inventory inventory = new Inventory();
    private int maxSize;

    public Basket(){
        //this.products = new HashMap<>();
        this.products = new ArrayList<>();
        this.maxSize = 10;
    }

    public boolean add(Bagel bagel){

        //If there is an invalid id or a filling
        if(!Inventory.isInInventory(bagel.getId()) || Inventory.isFilling(bagel.getId())){
            return false;
        }
        //If basket is full
        if(isBasketFull()){
            return false;
        }
        //Add bagel
        this.products.add(bagel);

        return true;
    }

    public boolean remove(Bagel bagel){
        if (products.contains(bagel)){
            products.remove(bagel);
            return true;
        }
        return false;
    }

    public boolean addFillings(Bagel bagel,  Filling[] fillings){
        if(products.contains(bagel)){
            for (Filling filling : fillings){
                bagel.addFilling(filling);
                return true;
            }
        }
        return false;
    }

    public boolean setMaxSize(int max){
        if(max < 0){
            return false;
        }
        this.maxSize = max;
        return true;
    }

    public double getCostOfBasket(){
        double total = 0;

        for (Bagel bagel: products){
            total += getCostOfBagel(bagel);
        }
        return total;
    }

    public double getCostOfBagel(Bagel bagel){
        double total = bagel.getPrice();
        for(Filling filling : bagel.getFillings()){
            total += getCostOfFilling(filling);
        }
        return total;
    }

    public double getCostOfFilling(Filling filling){
        return filling.getPrice();
    }

    private boolean isBasketFull(){
        return (this.products.size()) >= maxSize;
    }

}
