package com.booleanuk.core.discounts;

import com.booleanuk.core.products.Product;

import java.util.ArrayList;

public class DiscountManager {

    private ArrayList<Product> products;
    private ArrayList<Discount> discounts;

    public DiscountManager() {
        this.products = new ArrayList<>(); // Products from Basket that are not in a discount yet
        this.discounts = new ArrayList<>(); // The various discounts that exists

        // Adding the various discounts
        this.discounts.add(new CoffeeAndBagelDiscount());
        this.discounts.add(new EverythingBagelDiscount());
        this.discounts.add(new OnionBagelDiscount());
        this.discounts.add(new PlainBagelDiscount());
    }

    // 'p' will be checked together with this.products to see if they together form a discount
    public ArrayList<Discount> checkDiscount(Product p) {
        ArrayList<Discount> toReturn = new ArrayList<>();
        this.products.add(p);

        for (Discount d : this.discounts) {
            if (d.checkIfApplies(this.products)) {
                toReturn.add(d);
            }
        }

        for (Discount d : toReturn) {
            // If discounts were found, remove them from this.products and return Discount objects to caller
            this.products.removeAll(d.getProductsInDiscount());
        }

        return toReturn;
    }

}
