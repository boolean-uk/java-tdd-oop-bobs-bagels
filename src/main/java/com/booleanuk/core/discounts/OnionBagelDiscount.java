package com.booleanuk.core.discounts;

import com.booleanuk.core.products.Product;
import com.booleanuk.core.products.bagels.OnionBagel;

import java.util.ArrayList;

public class OnionBagelDiscount extends Discount {
    public OnionBagelDiscount() {
        super(2.49);
    }

    public boolean checkIfApplies(ArrayList<Product> products) {
        ArrayList<Product> productsInDiscount = new ArrayList<>();

        for (Product p : products) {
            if (p instanceof OnionBagel) productsInDiscount.add(p);
        }

        if (productsInDiscount.size() != 6) return false;

        this.setProductsInDiscount(productsInDiscount);
        return true;
    }

    @Override
    public String toString() {
        return "6 Onion Bagel for " + this.getPriceAfterDiscount();
    }
}
