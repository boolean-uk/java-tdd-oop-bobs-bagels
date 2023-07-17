package com.booleanuk.core;

import com.booleanuk.extension.SpecialOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<Product> products;
    private Map<String, SpecialOffer> specialOffers;

    public Inventory(){
        this.products = new ArrayList<>();
        specialOffers = new HashMap<>();

        initializeInventory();
    }

    public void initializeInventory() {
        Bagle bagle1 = new Bagle("BGLO",  	0.49,"Onion");
        Bagle bagle2 = new Bagle("BGLP",  	0.39,"Plain");
        Bagle bagle3 = new Bagle("BGLE",  	0.49,"Everything");
        Bagle bagle4 = new Bagle("BGLS",  	0.49,"Sesame");
        products.add(bagle1);
        products.add(bagle2);
        products.add(bagle3);
        products.add(bagle4);
        Coffee coffee1 = new Coffee("COFB",  	0.99,"Black");
        Coffee coffee2 = new Coffee("COFW",  	1.19,"White");
        Coffee coffee3 = new Coffee("COFC",  	1.29,"Capuccino");
        Coffee coffee4 = new Coffee("COFL",  	1.29,"Latte");

        products.add(coffee1);
        products.add(coffee2);
        products.add(coffee3);
        products.add(coffee4);

        Filling filling1 = new Filling("FILB", 0.12, "Bacon");
        Filling filling2 = new Filling("FILE", 0.12, "Egg");
        Filling filling3 = new Filling("FILC", 0.12, "Cheese");
        Filling filling4 = new Filling("FILX", 0.12, "Cream Cheese");
        Filling filling5 = new Filling("FILS", 0.12, "Smoked Salmon");
        Filling filling6 = new Filling("FILH", 0.12, "Ham");
        products.add(filling1);
        products.add(filling2);
        products.add(filling3);
        products.add(filling4);
        products.add(filling5);
        products.add(filling6);

        specialOffers.put("BGLO", new SpecialOffer(6,2.49));
        specialOffers.put("BGLP", new SpecialOffer(12,3.99));
        specialOffers.put("BGLE", new SpecialOffer(6,2.49));
        specialOffers.put("COFB", new SpecialOffer(1,1.25));




    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductBySKU(String SKU){
        for (Product product : products){
            if (product.getSKU().equals(SKU)){
                return product;
            }
        }
        return null;
    }

    public String getProductVariant(String SKU){
        for (Product product : products){
            if (product.getVariant().equals(SKU)){
                return product.getVariant();
            }
        }
        return null;
    }



    public boolean checkAvailability(String item) {
        for (Product product : products) {
            if (product.getSKU().equals(item)) {
                return true;
            }
        }
        return false;
    }

    public double getItemPrice(String item) {
        for (Product product : products) {
            if (product.getSKU().equals(item)) {
                return product.getPrice();
            }
        }

        if (item.equals("COFB")) {
            Product bagle = getProductBySKU("BGLP");
            if (bagle!=null){
                double baglePrice = bagle.getPrice();
                double coffeeBagelPrice = 1.25;
                return Math.min(baglePrice,coffeeBagelPrice);
            }
        }
        return 0.0;
    }
    public SpecialOffer getSpecialOffer(String SKU){
        return specialOffers.get(SKU);
    }



}
