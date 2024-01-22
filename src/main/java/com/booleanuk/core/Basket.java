package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private HashMap<Bagel, Integer> products;
    private static int maxSize;

    public Basket(){

        this.products = new HashMap<>();
        maxSize = 10;
    }

    public boolean add(Bagel bagel){

        //If the product is not in inventory
        if(!Inventory.isValidBagel(bagel)){
            return false;
        }

        //If basket is full
        if(isBasketFull()){
            return false;
        }

        //If there is a bagel of same sort
        for (Bagel b : products.keySet()){
            if(b.getId().equals(bagel.getId())){

            }
        }

        //Add bagel
        this.products.put(bagel, 1);

        return true;
    }

    public boolean remove(Bagel bagel){
        if (products.containsKey(bagel)){
            products.remove(bagel);
            return true;
        }
        return false;
    }

    public boolean addFillings(Bagel bagel,  ArrayList<Filling> fillings){
        if(products.containsKey(bagel)){
            return bagel.addFillings(fillings);
        }
        return false;
    }

    public static boolean setMaxSize(int max){
        if(max < 0){
            return false;
        }
        maxSize = max;
        return true;
    }

    public static int getMaxSize() {
        return maxSize;
    }

    public HashMap<Bagel, Integer> getProducts() {
        return products;
    }

    public double getCostOfBasket(){
        double total = 0;

        for (Bagel bagel: products.keySet()){
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

    protected void clearBasket(){
        this.products.clear();
    }

    private boolean isBasketFull(){
        return (this.products.size()) >= maxSize;
    }

}
