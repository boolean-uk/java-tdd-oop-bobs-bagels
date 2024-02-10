package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Filling> fillings;
    private List<Bagel> bagels;

    public Inventory(){
        bagels = new ArrayList<>();
        fillings = new ArrayList<>();
    }

    public boolean isItemExisting(String sku){
        for (Bagel bagel : bagels){
            if(bagel.getSku().equals(sku)){
                return true;
            }
        }
        for (Filling filling : fillings){
            if (filling.getSku().equals(sku)){
                return true;
            }
        }
        return false;
    }

    public void addFilling(Filling filling){
        fillings.add(filling);
        System.out.println("Added filling");
    }

    public void removeFilling(Filling filling){
        fillings.remove(filling);
        System.out.println("Removed filling");
    }

    public Bagel getBagelBySku(String sku){
        for (Bagel bagel : bagels){
            if(bagel.getSku().equals(sku)){
                return bagel;
            }
        }
        return null;
    }
}
