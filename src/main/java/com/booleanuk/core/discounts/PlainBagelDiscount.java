package com.booleanuk.core.discounts;

import com.booleanuk.core.products.Product;
import com.booleanuk.core.products.bagels.PlainBagel;

import java.util.ArrayList;

public class PlainBagelDiscount extends Discount {
    public PlainBagelDiscount() {
        super(3.99);
    }

    public boolean checkIfApplies(ArrayList<Product> products) {
        ArrayList<Product> productsInDiscount = new ArrayList<>();

        for (Product p : products) {
            if (p instanceof PlainBagel) productsInDiscount.add(p);
        }

        if (productsInDiscount.size() != 12) return false;

        this.setProductsInDiscount(productsInDiscount);
        return true;
    }

    @Override
    public String toString() {
        return "12 for " + this.getPriceAfterDiscount();
    }
}
