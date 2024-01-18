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

    //Add if there are fillings
//    public boolean add(String id, String[] fillingIds){
//
//        if(Inventory.isBagel(id)){
//            //If basket is full
//            if (isBasketFull()){
//                return false;
//            }else{
//                //if one of the filling ids are wrong
//                for (String fillingId : fillingIds){
//                    if(!Inventory.isFilling(fillingId)){
//                        return false;
//                    }
//                }
//                this.products.add(new Bagel(id,fillingIds));
//            }
//            return true;
//    }
//        return false;
//    }

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
        return false;
    }

    public boolean addFillings(Bagel bagel,  String[] fillingIds){
        return false;
    }

    public String setMaxSize(int max){
        this.maxSize = max;
        return "";
    }

    private boolean isIdInKeys(String id){
        for (Bagel bagel : products){
            if (bagel.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    private boolean isBasketFull(){
        return (this.products.size()) >= maxSize;
    }

}
