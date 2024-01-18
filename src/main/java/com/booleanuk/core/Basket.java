package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    protected HashMap<Product, Integer> products;
    protected User user;
    protected int capacity;
    protected int items;

    public Basket(User user) {
        this.user = user;
        products = new HashMap<>();
        setCapacity(10);
        items = 0;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) throws IllegalArgumentException {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Invalid value for capacity.");
        }
    }

    public int getItems() {
        return items;
    }

    public boolean add(String SKU) {
        if (items < capacity) {
            if (getProduct(SKU) != null) {
                Product product = getProduct(SKU);
                products.put(product, products.get(product) + 1);
            } else {
                try {
                    products.put(new Product(SKU), 1);
                } catch (IllegalStateException e) {
                    System.out.println("This item is not on the menu.");
                    return false;
                }
            }
            items++;
            return true;
        }
        System.out.println("Your basket is full.");
        return false;
    }

    public boolean remove(String SKU) {
        if (getProduct(SKU) != null) {
            Product product = getProduct(SKU);

            if (products.get(product) > 1) {
                products.put(product, products.get(product) - 1);
            } else {
                products.remove(product);
            }
            items--;
            return true;
        } else {
            System.out.println("This product is not in your cart.");
            return false;
        }
    }

    public void updateCapacity(int newCapacity) {
        if (user instanceof Manager){
            setCapacity(newCapacity);

            if (newCapacity < items) {
                products = new HashMap<>();
                items = 0;

                System.out.println("The capacity has been updated. " +
                        "Cart can only hold " + newCapacity + " items. " +
                        "Your basket has been reset.");
            }
        } else {
            System.out.println("You cannot do that");
        }
    }


    public double totalCost(){
        double totalCost = 0;
        for (Product product : products.keySet()){
            totalCost += product.price*products.get(product);
        }
        return totalCost;
    }

    private Product getProduct(String SKU){
        for (Product product : products.keySet()){
            if (SKU.equals(product.SKU)) {
                return product;
            }
        }
        return null;
    }

    public void displayMenu(){
        System.out.printf("=============================================%n");
        System.out.printf("                  Bob's Bagels               %n");

        System.out.printf("=============================================%n");
        System.out.printf("| %-5s | %-8s | %-15s | %-5s|%n", "SKU", "Type", "Name", "Price");
        System.out.printf("---------------------------------------------%n");

        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "BGLO", "Bagel", "Onion", 0.49);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "BGLP", "Bagel", "Plain", 0.39);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "BGLE", "Bagel", "Everything", 0.49);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "BGLS", "Bagel", "Sesame", 0.49);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "COFB", "Coffee", "Black", 0.99);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "COFW", "Coffee", "White", 1.19);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "COFC", "Coffee", "Cappuccino", 1.29);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "COFL", "Coffee", "Latte", 1.29);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "FILB", "Filling", "Bacon", 0.12);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "FILE", "Filling", "Egg", 0.12);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "FILC", "Filling", "Cheese", 0.12);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "FILX", "Filling", "Cream Cheese", 0.12);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "FILS", "Filling", "Smoked Salmon", 0.12);
        System.out.printf("| %-5s | %-8s | %-15s | %5.2f|%n", "FILH", "Filling", "Ham", 0.12);
    }
}
