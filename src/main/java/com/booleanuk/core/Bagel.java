package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel {
    private String variant = "";
    private ArrayList<String> fillings = new ArrayList<String>();


    public Bagel(String variant){
        this.variant = variant;
    }


    public void addFilling(String fillingName){
        Inventory inventory = new Inventory();
        if(!(inventory.getInventoryItemDetails(fillingName) == null)){
            if((inventory.getInventoryItemDetails(fillingName).getName() == "Filling")) {
                this.fillings.add(fillingName);
            }
        }else{
            System.out.println("This filling is not offered by Bob's bagels.");
        }
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public ArrayList<String> getFillings() {
        return fillings;
    }

    public void setFillings(ArrayList<String> fillings) {
        this.fillings = fillings;
    }
}
