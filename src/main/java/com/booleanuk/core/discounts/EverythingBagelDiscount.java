package com.booleanuk.core.discounts;

import com.booleanuk.core.products.Product;
import com.booleanuk.core.products.bagels.Bagel;
import com.booleanuk.core.products.bagels.EverythingBagel;
import com.booleanuk.core.products.coffees.Coffee;

import java.util.ArrayList;

public class EverythingBagelDiscount extends Discount {
    public EverythingBagelDiscount() {
        super(2.49);
    }

    public boolean checkIfApplies(ArrayList<Product> products) {
        ArrayList<Product> productsInDiscount = new ArrayList<>();

        for (Product p : products) {
            if (p instanceof EverythingBagel) productsInDiscount.add(p);
        }

        if (productsInDiscount.size() != 6) return false;

        this.setProductsInDiscount(productsInDiscount);
        return true;
    }

    @Override
    public String toString() {
        return "6 for " + this.getPriceAfterDiscount();
    }
}
