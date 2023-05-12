package com.booleanuk.core;

import java.util.ArrayList;

import static com.booleanuk.core.Inventory.productIsInStock;
import static com.booleanuk.core.Inventory.inventoryProducts;

public class Bagel extends Product {
    private ArrayList<Filling> fillings;
    public Bagel(String SKU, double price, String variant) {
        super(SKU, "Bagel", price, variant);
        this.fillings = new ArrayList<Filling>();
    }

    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }

    public boolean addFilling(String SKU){

        if(productIsInStock(SKU)){
            for (Filling filling:this.fillings) {
                if (filling.getSKU().equals(SKU)) {
                    return false;
                }
            }
            Filling newFilling= new Filling(SKU, inventoryProducts.get(SKU).getProductCost(), inventoryProducts.get(SKU).getVariant());
            this.fillings.add(newFilling);
            return true;
        }
        return false;
    }
}
