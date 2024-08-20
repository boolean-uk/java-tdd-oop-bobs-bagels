package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
        fillInventory();
    }

    public void printMenu() {
        ArrayList<Coffee> coffee = getAllCoffee();
        ArrayList<Bagel> bagels = getAllBagels();
        ArrayList<Filling> fillings = getAllFillings();

        System.out.println("========== Coffee Menu ==========");
        System.out.println("\t Coffe \t:\t Variant  /  Price ");
        System.out.println("----------------------------------");
        for (Coffee c : coffee) {
            System.out.println("\t\t\t\t " + c.getVariant() + "\t $" + c.getPrice());
        }
        System.out.println();

        System.out.println("========== Bagel Menu ==========");
        System.out.println("\t Bagels \t:\t Variant  /  Price ");
        System.out.println("----------------------------------");
        for (Bagel b : bagels) {
            System.out.println("\t\t\t\t " + b.getVariant() + "\t $" + b.getPrice());
        }
        System.out.println();

        System.out.println("\t Fillings \t:\t Variant  /  Price ");
        System.out.println("----------------------------------");
        for (Filling f : fillings) {
            System.out.println("\t\t\t\t " + f.getVariant() + "\t $" + f.getPrice());
        }
        System.out.println();
    }

    private String calulcateSKU(String name, String variant) {
        // TODO: This can now override SKU if it calculates the same value, fix this.
        // TODO: Not as in example, this takes the whole words
        return name + variant;
    }

    private void addProduct(float price, Enum name, Enum variant) {
        String SKU = calulcateSKU(name.toString(), variant.toString());

        // TODO: Change to switch statement
        if (ProductName.COFFEE == name) {
            this.products.add(new Coffee(0, SKU, price, name, variant));
        } else if (ProductName.BAGEL == name) {
            this.products.add(new Bagel(0, SKU, price, name, variant));
        } else if (ProductName.FILLING == name) {
            this.products.add(new Filling(0, SKU, price, name, variant));
        }
    }

    private void fillInventory() {
        this.addProduct(0.49f, ProductName.BAGEL, BagelVariant.ONION);
        this.addProduct(0.39f, ProductName.BAGEL, BagelVariant.PLAIN);
        this.addProduct(0.49f, ProductName.BAGEL, BagelVariant.EVERYTHING);
        this.addProduct(0.49f, ProductName.BAGEL, BagelVariant.SESAME);

        this.addProduct(0.99f, ProductName.COFFEE, CoffeeVariant.BLACK);
        this.addProduct(1.19f, ProductName.COFFEE, CoffeeVariant.WHITE);
        this.addProduct(1.29f, ProductName.COFFEE, CoffeeVariant.CAPUCCINO);
        this.addProduct(1.29f, ProductName.COFFEE, CoffeeVariant.LATTE);

        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.BACON);
        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.EGG);
        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.CHEESE);
        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.CREAM_CHEESE);
        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.SMOKED_SALMON);
        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.HAM);
    }

    // TODO: duplication code not good.
    private ArrayList<Coffee> getAllCoffee() {
        ArrayList<Coffee> coffeList = new ArrayList<>();

        for (Product product : products) {
            if (product.getName() == ProductName.COFFEE) {
                coffeList.add((Coffee) product);
            }
        }
        return coffeList;
    }

    // TODO: duplication code not good.
    private ArrayList<Bagel> getAllBagels() {
        ArrayList<Bagel> bagelList = new ArrayList<>();

        for (Product product : products) {
            if (product.getName() == ProductName.BAGEL) {
                bagelList.add((Bagel) product);
            }
        }
        return bagelList;
    }

    // TODO: duplication code not good.
    private ArrayList<Filling> getAllFillings() {
        ArrayList<Filling> fillingsList = new ArrayList<>();

        for (Product product : products) {
            if (product.getName() == ProductName.FILLING) {
                fillingsList.add((Filling) product);
            }
        }
        return fillingsList;
    }
}
