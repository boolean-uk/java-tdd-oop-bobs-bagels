package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bagel {
    private String bagelVariant = "";
    private HashMap<String, Integer> fillingsMap = new HashMap<>();
    private double cost;

    public Bagel(String variant){
        this.bagelVariant = variant;
    }
    public Bagel(String variant, HashMap<String, Integer> fillings){
        this.bagelVariant = variant;
        this.bagelVariant = fillingsMap;
    }
    public Bagel(String variant, HashMap<String, Integer> fillings){
        this.bagelVariant = variant;
        this.bagelVariant = fillingsMap;
    }


    public void addFilling(String fillingSku){
        Inventory inventory = new Inventory();
        if(!(inventory.getInventoryItemDetails(fillingSku) == null)){
            if((inventory.getInventoryItemDetails(fillingSku).getName() == "Filling")) {
                this.fillingsMap.put(fillingSku, 1);
            }
        }else{
            System.out.println("This filling is not offered by Bob's bagels.");
        }
    }

    public void removeFilling(String fillingSku){
        Inventory inventory = new Inventory();
        if(!(inventory.getInventoryItemDetails(fillingSku) == null)){
                this.fillingsMap.remove(fillingSku);
        }else{
            System.out.println("This filling is not currently on this bagel.");
        }
    }

    public String getBagelVariant() {
        return bagelVariant;
    }

    private void setBagelVariant(String variant) {
        this.bagelVariant = variant;
    }

    public HashMap<String, Integer> getFillings() {
        return fillingsMap;
    }

    public double getCost() {
        return cost;
    }


}
