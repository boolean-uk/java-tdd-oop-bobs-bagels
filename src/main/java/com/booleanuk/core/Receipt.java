package com.booleanuk.core;

import java.util.Date;
import java.util.HashMap;

import com.booleanuk.core.products.Product;

public class Receipt {

    private HashMap<Product, Integer> products; // Integer is the quantity of the product
    private double totalCost;
    private double totalSaved;
    private Date date;

    public Receipt() {
        this.products = new HashMap<Product, Integer>();
        this.date = new Date(); // TODO: format date?

        this.setTotalCost();
        this.setTotalSaved();
    }

    private void setTotalCost() {

    }

    private void setTotalSaved() {
        
    }

}
