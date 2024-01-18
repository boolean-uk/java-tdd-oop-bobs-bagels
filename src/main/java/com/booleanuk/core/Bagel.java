package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Bagel implements Product {

    String bagel;
    String filling;
    double price;
    double priceFilling;
    Map<String, Double> fillings = new HashMap<>();

    public void initFillings(){
        fillings.put("Bacon", 1.50);
        fillings.put("Egg", 1.25);
        fillings.put("Cheese", 2.00);
        fillings.put("Cream Cheese", 1.50);
        fillings.put("Smoked Salmon", 2.50);
        fillings.put("Ham", 3.00);
    }

    public Bagel(String name){
        this.bagel = name;
        this.price = 2.00;
        this.filling = "bland";
        this.priceFilling = 0.00;
        initFillings();
    }
    public Bagel(String name, double price){

        this.bagel = name;
        this.price = price;
        this.filling = "bland";
        initFillings();
    }

    public boolean addFilling(String filling){
        if (fillings.containsKey(filling)){
            this.filling = filling;
            this.priceFilling = fillings.get(filling);
            System.out.println("Filling " + this.filling + " added to bagel");
            System.out.println("Price of filling: $" + this.priceFilling);
            return true;
        }
        System.out.println("Could not find filling in fillingList");
        return false;
    }

    public double checkPriceOfFilling(String filling){
        if(fillings.containsKey(filling)){
            System.out.println("Price of filling: $" + fillings.get(filling));
            return fillings.get(filling);
        }
        System.out.println("Price of filling not found");
        return 0;
    }

    @Override
    public String getName(){
        return this.bagel;
    }
    @Override
    public double getPrice(){
        return this.price;
    }

    public String getFilling(){
        return this.filling;
    }

}
