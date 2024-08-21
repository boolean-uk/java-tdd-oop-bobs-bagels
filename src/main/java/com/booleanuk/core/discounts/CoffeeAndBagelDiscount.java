package com.booleanuk.core.discounts;

import com.booleanuk.core.products.Product;
import com.booleanuk.core.products.bagels.Bagel;
import com.booleanuk.core.products.bagels.OnionBagel;
import com.booleanuk.core.products.coffees.BlackCoffee;
import com.booleanuk.core.products.coffees.Coffee;

import java.util.ArrayList;
import java.util.Collections;

public class CoffeeAndBagelDiscount extends Discount {

    public CoffeeAndBagelDiscount() {
        super(1.25);
    }

    public boolean checkIfApplies(ArrayList<Product> products) {
        ArrayList<Product> productsInDiscount = new ArrayList<>();
        boolean coffeeFound = false;
        boolean bagelFound = false;
        for (Product p : products) {
            if (p instanceof Coffee && !coffeeFound) {
                coffeeFound = true;
                productsInDiscount.add(p);
            }
            if (p instanceof Bagel && !bagelFound) {
                bagelFound = true;
                productsInDiscount.add(p);
            }
        }

        if (!coffeeFound || !bagelFound) return false;
        this.setProductsInDiscount(productsInDiscount);
        return true;
    }

    @Override
    public String toString() {
        return "Coffee & Bagel for " + this.getPriceAfterDiscount();
    }

}
