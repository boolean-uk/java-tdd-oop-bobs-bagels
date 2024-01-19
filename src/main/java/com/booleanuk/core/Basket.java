package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Bagel> products;
    private static int maxSize;

    public Basket(){

        this.products = new ArrayList<>();
        maxSize = 10;
    }

    public boolean add(Bagel bagel){

//        //If there is an invalid id or a filling
//        if(!Inventory.isInInventory(bagel.getId()) || Inventory.isFilling(bagel.getId())){
//            return false;
//        }

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

    public ArrayList<Bagel> getProducts() {
        return products;
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

    public void clearBasket(){
        this.products.clear();
    }

    private boolean isBasketFull(){
        return (this.products.size()) >= maxSize;
    }

}
