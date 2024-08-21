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
        this.discounts = discounts;
        this.date = new Date(); // TODO: format date?

        this.setProductsAndQuantity(products);
        this.setTotalCost();
        this.setTotalSaved();
    }

    private void setTotalCost() {
        for (Map.Entry<Product, Integer> kvp : this.products.entrySet()) {
            System.out.println("Adding " + kvp.getKey());
            this.totalCost += (kvp.getKey().getPrice() * kvp.getValue());
        }

        for (Discount d : this.discounts) this.totalCost += d.getPriceAfterDiscount();
    }

    private void setTotalSaved() {
        for (Discount d : this.discounts) {
            this.totalSaved += d.getSavedMoney();
        }
    }

    private void setProductsAndQuantity(ArrayList<Product> products) {
        for (Product p : products) {
            Product currentP = this.getProduct(p);
            if (currentP != null) this.products.replace(currentP, this.products.get(currentP) + 1);
            else this.products.put(p, 1);
        }
    }

    private Product getProduct(Product p) {
        for (Product product : this.products.keySet()) {
            if (product.getSKU().equals(p.getSKU())) return product;
        }
        return null;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public double getTotalSaved() {
        return this.totalSaved;
    }

    public ArrayList<String> getReceiptPrintout() {
        ArrayList<String> toReturn = new ArrayList<>();

        toReturn.add("\n");
        toReturn.add("\t~~~ Bob's Bagels ~~~");
        toReturn.add("");
        toReturn.add(this.date.toString());
        toReturn.add("");
        toReturn.add("----------------------------");
        toReturn.add("");

        for (Map.Entry<Product, Integer> kvp : this.products.entrySet()) {
            toReturn.add(kvp.getKey().toString() + "\t x" + kvp.getValue() + " $" + kvp.getKey().getPrice());
        }

        if (!this.discounts.isEmpty()) {
            for (Discount d : this.discounts) {
                toReturn.add(d.toString() + "\t\t" + "$" + Double.toString(d.getPriceAfterDiscount()));
                toReturn.add("\t\t\t\t(-$" + Double.toString(d.getSavedMoney()) + ")");
            }
        }

        toReturn.add("----------------------------");
        toReturn.add("Total \t$" + this.getTotalCost());
        toReturn.add("");
        toReturn.add("You saved a total of $" + this.getTotalSaved() + " on this shop.");
        toReturn.add("");
        toReturn.add("Thank you for your order!");

        return toReturn;
    }

}
