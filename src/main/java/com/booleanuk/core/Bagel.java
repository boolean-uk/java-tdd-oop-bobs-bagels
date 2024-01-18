package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{


    private ArrayList<Filling> fillings;
    public Bagel(String SKU, String name, String type, double price){
        super(SKU, name, type, price);
        fillings = new ArrayList<>();
    }
    public void addFillings(ArrayList<Filling> f){
        fillings.addAll(f);
    }
    public ArrayList<Filling> getFillings(){
        return this.fillings;
    }
    public void removeFilling(String name){

    }
    public void removeAllFillings(){
        for (Filling f : fillings){
            Inventory.getInstance().addItems(f);
        }
        fillings.clear();
    }
    @Override
    public String toString() {
        return "Bagel{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

}
