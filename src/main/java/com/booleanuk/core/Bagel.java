package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item{


    private ArrayList<Item> fillings;
    public Bagel(String SKU, String name, String type, double price){
        super(SKU, name, type, price);
        fillings = new ArrayList<>();
    }
    public void addFillings(ArrayList<Item> f){
        fillings.addAll(f);
    }
    public ArrayList<Item> getFillings(){
        return this.fillings;
    }
    public void removeFilling(String name){

    }
    public void removeAllFillings(){
        for (Item f : fillings){
            Inventory.getInstance().addItems(f);
        }
        fillings.clear();
    }

    @Override
    public String toString() {
        return "Bagel{" +
                ", SKU='" + SKU + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                "fillings=" + fillings +
                '}';
    }

}
