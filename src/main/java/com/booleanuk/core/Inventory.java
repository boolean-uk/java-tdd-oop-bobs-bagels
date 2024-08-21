package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> inventoryItems;

    public Inventory() {
        this.inventoryItems = new HashMap<>();
        fillInventory();
    }

    private void fillInventory() {

        // TODO: Weird to have them here, should move
        // Initialize list with inventory products
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Bagel(0.49f, BagelVariant.ONION));
        products.add(new Bagel(0.39f, BagelVariant.PLAIN));
        products.add(new Bagel(0.49f, BagelVariant.EVERYTHING));
        products.add(new Bagel(0.49f, BagelVariant.SESAME));

        products.add(new Coffee(0.99f, CoffeeVariant.BLACK));
        products.add(new Coffee(1.19f, CoffeeVariant.WHITE));
        products.add(new Coffee(1.29f, CoffeeVariant.CAPUCCINO));
        products.add(new Coffee(1.29f, CoffeeVariant.LATTE));

        products.add(new Filling(0.12f, FillingVariant.BACON));
        products.add(new Filling(0.12f, FillingVariant.EGG));
        products.add(new Filling(0.12f, FillingVariant.CHEESE));
        products.add(new Filling(0.12f, FillingVariant.CREAM_CHEESE));
        products.add(new Filling(0.12f, FillingVariant.SMOKED_SALMON));
        products.add(new Filling(0.12f, FillingVariant.HAM));

        // Add products to HashMap
        for (Product p : products) {
            inventoryItems.put(p.getSKU(), p);
        }
    }

    public void printMenu() {
        // Variables for e.g. "%-15s %-15s %n", keep blank space
        String centerSmall = "%4s ";
        String center = "%7s ";
        String skuAlign = "%-8s ";
        String leftAlign = "%-16s ";
        String newLine = "%n";
        String divider = "-------------------------------";

        // TODO: Unnecassary looping
        // TODO: Duplicate code
        // Simplify, doesn't have to have multiple center
        System.out.println();
        System.out.printf(centerSmall + centerSmall + centerSmall + newLine,"", "=== Bob's Bagels ===", "");
        System.out.printf(center + center + center + newLine,"", "   ~ Menu ~   ", "");
        System.out.println(divider);

        // Coffee menu
        System.out.printf(center + center + center + newLine,"", "    COFFEE    ", "");
        for (Product item : inventoryItems.values()) {
            if (item.getName() == ProductName.COFFEE) {
                System.out.printf(
                        skuAlign + leftAlign + leftAlign + newLine,
                        item.getSKU()+"  | ", item.getVariant().toString(), "$" + item.getPrice()
                );
            }
        }
        System.out.println();

        // Bagel Menu Bagels
        System.out.printf(center + center + center + newLine,"", "    Bagels    ", "");
        for (Product item : inventoryItems.values()) {
            if (item.getName() == ProductName.BAGEL) {
                System.out.printf(
                        skuAlign + leftAlign + leftAlign + newLine,
                        item.getSKU()+"  | ", item.getVariant().toString(), "$" + item.getPrice()
                );
            }
        }
        System.out.println();

        // Bagel Menu Bagels
        System.out.printf(center + center + center + newLine,"", "Bagel Fillings", "");
        for (Product item : inventoryItems.values()) {
            if (item.getName() == ProductName.FILLING) {
                System.out.printf(
                        skuAlign + leftAlign + leftAlign + newLine,
                        item.getSKU()+"  | ", item.getVariant().toString(), "$" + item.getPrice()
                );
            }
        }
        System.out.println();
//       System.out.printf(leftAlign + leftAlign + newLine, "hello", "world");
    }

    // TODO: Duplication code, abstraction, but not good otherwise, Factory pattern?
    public Coffee getCoffeeProduct(String SKU) {
        Product coffeeProduct = inventoryItems.get(SKU);
        return (Coffee) coffeeProduct;
    }

    public Bagel getBagelProduct(String SKU) {
        Product bagelProduct = inventoryItems.get(SKU);
        return (Bagel) bagelProduct;
    }

    public Filling getFillingProduct(String SKU) {
        Product fillingProduct = inventoryItems.get(SKU);
        return (Filling) fillingProduct;
    }

    // TODO:Refactor or good to have the above methods for the Basket class?
    public Product getProduct(String SKU) {
        return inventoryItems.get(SKU);
    }


    /**
     * Return a String that can be used as key for the HashMap inventoryIten
     * @param product
     * @return
     */
//    private String hash(Product product) {
//        String productCode = product.getName().toString().substring(0,2);
//        String variantCode = product.getVariant().toString().substring(0,2);
//        String hashCode = productCode + variantCode;
//        return hashCode.toUpperCase();
//    }













//    public void printMenu() {
//        ArrayList<Coffee> coffee = getAllCoffee();
//        ArrayList<Bagel> bagels = getAllBagels();
//        ArrayList<Filling> fillings = getAllFillings();
//
//        System.out.println("========== Coffee Menu ==========");
//        System.out.println("\t Coffe \t:\t Variant  /  Price ");
//        System.out.println("----------------------------------");
//        for (Coffee c : coffee) {
//            System.out.println("\t\t\t\t " + c.getVariant() + "\t $" + c.getPrice());
//        }
//        System.out.println();
//
//        System.out.println("========== Bagel Menu ==========");
//        System.out.println("\t Bagels \t:\t Variant  /  Price ");
//        System.out.println("----------------------------------");
//        for (Bagel b : bagels) {
//            System.out.println("\t\t\t\t " + b.getVariant() + "\t $" + b.getPrice());
//        }
//        System.out.println();
//
//        System.out.println("\t Fillings \t:\t Variant  /  Price ");
//        System.out.println("----------------------------------");
//        for (Filling f : fillings) {
//            System.out.println("\t\t\t\t " + f.getVariant() + "\t $" + f.getPrice());
//        }
//        System.out.println();
//    }
//
//    private String calulcateSKU(String name, String variant) {
//        // TODO: This can now override SKU if it calculates the same value, fix this.
//        // TODO: Not as in example, this takes the whole words
//        return name + variant;
//    }
//
//    private void addProduct(float price, Enum name, Enum variant) {
//        String SKU = calulcateSKU(name.toString(), variant.toString());
//
//        // TODO: Change to switch statement
//        if (ProductName.COFFEE == name) {
//            this.products.add(new Coffee(0, SKU, price, name, variant));
//        } else if (ProductName.BAGEL == name) {
//            this.products.add(new Bagel(0, SKU, price, name, variant));
//        } else if (ProductName.FILLING == name) {
//            this.products.add(new Filling(0, SKU, price, name, variant));
//        }
//    }
//
//    private void fillInventory() {
//        this.addProduct(0.49f, ProductName.BAGEL, BagelVariant.ONION);
//        this.addProduct(0.39f, ProductName.BAGEL, BagelVariant.PLAIN);
//        this.addProduct(0.49f, ProductName.BAGEL, BagelVariant.EVERYTHING);
//        this.addProduct(0.49f, ProductName.BAGEL, BagelVariant.SESAME);
//
//        this.addProduct(0.99f, ProductName.COFFEE, CoffeeVariant.BLACK);
//        this.addProduct(1.19f, ProductName.COFFEE, CoffeeVariant.WHITE);
//        this.addProduct(1.29f, ProductName.COFFEE, CoffeeVariant.CAPUCCINO);
//        this.addProduct(1.29f, ProductName.COFFEE, CoffeeVariant.LATTE);
//
//        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.BACON);
//        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.EGG);
//        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.CHEESE);
//        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.CREAM_CHEESE);
//        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.SMOKED_SALMON);
//        this.addProduct(0.12f, ProductName.FILLING, FillingVariant.HAM);
//    }
//
//    // TODO: duplication code not good.
//    private ArrayList<Coffee> getAllCoffee() {
//        ArrayList<Coffee> coffeList = new ArrayList<>();
//
//        for (Product product : products) {
//            if (product.getName() == ProductName.COFFEE) {
//                coffeList.add((Coffee) product);
//            }
//        }
//        return coffeList;
//    }
//
//    // TODO: duplication code not good.
//    private ArrayList<Bagel> getAllBagels() {
//        ArrayList<Bagel> bagelList = new ArrayList<>();
//
//        for (Product product : products) {
//            if (product.getName() == ProductName.BAGEL) {
//                bagelList.add((Bagel) product);
//            }
//        }
//        return bagelList;
//    }
//
//    // TODO: duplication code not good.
//    private ArrayList<Filling> getAllFillings() {
//        ArrayList<Filling> fillingsList = new ArrayList<>();
//
//        for (Product product : products) {
//            if (product.getName() == ProductName.FILLING) {
//                fillingsList.add((Filling) product);
//            }
//        }
//        return fillingsList;
//    }
}
