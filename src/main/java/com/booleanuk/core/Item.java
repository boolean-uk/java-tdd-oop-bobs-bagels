package com.booleanuk.core;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Item {
    private String sku;
    private double price;
    private String name;

    private String variant;
    private ArrayList<Item> fillings;

    public Item(String sku, double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.fillings = new ArrayList<>();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {

        for (Item item : this.getFillings()) {
            this.price+= item.getPrice();
        }
        return price;
    }

    public void setPrice(double price) {this.price = price; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public ArrayList<Item> getFillings() {
        return fillings;
    }

    public void setFillings(ArrayList<Item> fillings) {
        boolean isCorrect = true;
        for(Item filling:fillings){
            if(!filling.getName().equals("Filling")){
                isCorrect = false;
            }
        }
        if(isCorrect){
            this.fillings = fillings;
        }

    }
    public void addFilling(Item newFilling){
        if(newFilling.getName().equals("Filling")){
            System.out.println("Added a filling to your bagel");
            this.fillings.add(newFilling);
        }else {
            System.out.println("Not a filling");
        }
    }
}
