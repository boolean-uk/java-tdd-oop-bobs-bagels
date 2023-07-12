package com.booleanuk.extension;

import com.booleanuk.core.Item;

import java.util.ArrayList;

public class Bagel extends AbstractItem  {
    private ArrayList<Filling> fillings;

    public Bagel(Sku sku, double price, int quantity, String name, String variant)
    {
        super(sku,  price, quantity,  name, variant);
        this.fillings = new ArrayList<>();
    }

    public ArrayList<Filling> getFillings() {
        return fillings;
    }

    public double  getFillingsTotalPrice(){
        double subitemPrice=0.0;
        for (Filling filling : this.getFillings()) {
            subitemPrice+= filling.getPrice() * filling.getQuantity();
        }
        return subitemPrice;
    }
}
