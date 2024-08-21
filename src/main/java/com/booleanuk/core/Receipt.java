package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.booleanuk.core.discounts.Discount;
import com.booleanuk.core.products.Product;

public class Receipt {

    private HashMap<Product, Integer> products; // Integer is the quantity of the product
    private ArrayList<Discount> discounts;
    private double totalCost = 0;
    private double totalSaved = 0;
    private Date date;

    public Receipt(ArrayList<Product> products, ArrayList<Discount> discounts) {
        this.products = new HashMap<Product, Integer>();
        this.discounts = new ArrayList<>();
        this.date = new Date(); // TODO: format date?

        this.setProductsAndQuantity(products);
        this.setTotalCost();
        this.setTotalSaved();
    }

    private void setTotalCost() {
        for (Map.Entry<Product, Integer> kvp : this.products.entrySet()) {
            this.totalCost += (kvp.getKey().getPrice() * kvp.getValue());
        }
    }

    private void setTotalSaved() {
        for (Discount d : this.discounts) {
            this.totalSaved += d.getSavedMoney();
        }
    }

    private void setProductsAndQuantity(ArrayList<Product> products) {
        for (Product p : products) {
            if (this.isProductInReceipt(p)) this.products.replace(p, this.products.get(p) + 1);
            else this.products.put(p, 1);
        }
    }

    private boolean isProductInReceipt(Product p) {
        for (Product product : this.products.keySet()) {
            if (product.getSKU().equals(p.getSKU())) return true;
        }
        return false;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public double getTotalSaved() {
        return this.totalSaved;
    }

}
