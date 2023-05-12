package com.booleanuk.core;

import java.util.ArrayList;

import static com.booleanuk.core.Inventory.productIsInStock;
import static com.booleanuk.core.Inventory.inventoryProducts;

public class Product {
    private String SKU;
    private String name;
    private double price;
    private String variant;
    //Inventory inventory = new Inventory();

    private ArrayList<Filling> fillings;



    public Product(String SKU, String name, double price, String variant) {
        this.SKU = SKU;
        this.name = name;
        this.price = price;
        this.variant = variant;
        this.fillings = new ArrayList<Filling>();
    }

    public String getSKU() {
        return SKU;
    }

    public String getName() {
        return name;
    }

    public double getProductCost() {
        return price;
    }

    public String getVariant() {
        return variant;
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
