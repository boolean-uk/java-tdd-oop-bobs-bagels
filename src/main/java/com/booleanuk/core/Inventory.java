package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
        this.products.add(new Product("BGLO",	0.49,	"Bagel",	"Onion"));
        this.products.add(new Product("BGLP",	0.39,	"Bagel",	"Plain"));
        this.products.add(new Product("BGLE",	0.49,	"Bagel",	"Everything"));
        this.products.add(new Product("BGLS",	0.49,	"Bagel",	"Sesame"));
        this.products.add(new Product("COFB",	0.99,	"Coffee",	"Black"));
        this.products.add(new Product("COFW",	1.19,	"Coffee",	"White"));
        this.products.add(new Product("COFC",	1.29,	"Coffee",	"Capuccino"));
        this.products.add(new Product("COFL",	1.29,	"Coffee",	"Latte"));
        this.products.add(new Product("FILB",	0.12,	"Filling",	"Bacon"));
        this.products.add(new Product("FILE",	0.12,	"Filling",	"Egg"));
        this.products.add(new Product("FILC",	0.12,	"Filling",	"Cheese"));
        this.products.add(new Product("FILX",	0.12,	"Filling",	"Cream Cheese"));
        this.products.add(new Product("FILS",	0.12,	"Filling",	"Smoked Salmon"));
        this.products.add(new Product("FILH",	0.12,	"Filling",	"Ham"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getProductCost(String sku) {
        if (this.products.stream().anyMatch(x -> x.getSku().equals(sku))) {
            return this.products.stream().filter(x -> x.getSku().equals(sku)).findFirst().get().getPrice();
        } else {
            return 0;
        }
    }
}
