package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bagel {
    private String variant = "";
    private HashMap<String, Integer> fillingsMap = new HashMap<>();


    public Bagel(String variant){
        this.variant = variant;
    }


    public void addFilling(String fillingName){
        Inventory inventory = new Inventory();
        if(!(inventory.getInventoryItemDetails(fillingName) == null)){
            if((inventory.getInventoryItemDetails(fillingName).getName() == "Filling")) {
                this.fillingsMap.put(fillingName, 1);
            }
        }else{
            System.out.println("This filling is not offered by Bob's bagels.");
        }
    }

    public void removeFilling(String fillingName){
        Inventory inventory = new Inventory();
        if(!(inventory.getInventoryItemDetails(fillingName) == null)){
                this.fillingsMap.remove(fillingName);
        }else{
            System.out.println("This filling is not currently on this bagel.");
        }
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public HashMap<String, Integer> getFillings() {
        return fillingsMap;
    }
}
