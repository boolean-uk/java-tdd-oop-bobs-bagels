package com.booleanuk.extension;

public class SpecialOffer {
    private int quantity;
    private double price;

    public SpecialOffer(int quantity,double price){
        this.quantity = quantity;
        this.price=price;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
}
