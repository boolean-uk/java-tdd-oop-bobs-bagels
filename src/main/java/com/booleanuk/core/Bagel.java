package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collection;

public class Bagel extends Product {
    private ArrayList<Filling> fillings;
    Inventory inventory = new Inventory();
    public Bagel(String SKU, double price, String variant) {
        super(SKU, "Bagel", price, variant);
        this.fillings = new ArrayList<Filling>();
    }

    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }

    public boolean addFilling(String SKU){

        if(inventory.productIsInStock(SKU)){
            for (Filling filling:this.fillings) {
                if (filling.getSKU().equals(SKU)) {
                    return false;
                }
            }
            Filling newFilling= new Filling(SKU,inventory.products.get(SKU).getProductCost(),inventory.products.get(SKU).getVariant());
            this.fillings.add(newFilling);
            return true;
        }
        return false;
    }
}
