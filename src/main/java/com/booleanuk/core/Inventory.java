package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
        this.products.add(new Bagel("BGLO",	0.49,	"Bagel",	"Onion"));
        this.products.add(new Bagel("BGLP",	0.39,	"Bagel",	"Plain"));
        this.products.add(new Bagel("BGLE",	0.49,	"Bagel",	"Everything"));
        this.products.add(new Bagel("BGLS",	0.49,	"Bagel",	"Sesame"));
        this.products.add(new Coffee("COFB",	0.99,	"Coffee",	"Black"));
        this.products.add(new Coffee("COFW",	1.19,	"Coffee",	"White"));
        this.products.add(new Coffee("COFC",	1.29,	"Coffee",	"Capuccino"));
        this.products.add(new Coffee("COFL",	1.29,	"Coffee",	"Latte"));
        this.products.add(new Filling("FILB",	0.12,	"Filling",	"Bacon"));
        this.products.add(new Filling("FILE",	0.12,	"Filling",	"Egg"));
        this.products.add(new Filling("FILC",	0.12,	"Filling",	"Cheese"));
        this.products.add(new Filling("FILX",	0.12,	"Filling",	"Cream Cheese"));
        this.products.add(new Filling("FILS",	0.12,	"Filling",	"Smoked Salmon"));
        this.products.add(new Filling("FILH",	0.12,	"Filling",	"Ham"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findProduct(String sku) {
        if (this.products.stream().anyMatch(x->x.getSku().equals(sku))) {
            return this.products.stream().filter(x->x.getSku().equals(sku)).findFirst().get();
        }
        return null;
    }

    public double getProductCost(String sku) {
        if (this.products.stream().anyMatch(x -> x.getSku().equals(sku))) {
            return this.products.stream().filter(x -> x.getSku().equals(sku)).findFirst().get().getPrice();
        } else {
            return 0;
        }
    }

    public String listFillingCosts() {
        String fillingsList = "";
        for (Product product: this.getProducts().stream().filter(x -> x.getName().equals("Filling")).toList()) {
            fillingsList = fillingsList.concat(product.getVariant()+": "+product.getPrice()+"$\n");
        }
        if (fillingsList.isEmpty()) {
            return "No fillings available";
        }
        return fillingsList.substring(0,fillingsList.length()-1);
    }
}
