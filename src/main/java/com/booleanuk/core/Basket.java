package com.booleanuk.core;

import java.util.ArrayList;

public class Basket implements Inventory {
    private ArrayList<Product> basketItems;
    private int basketLimit;

    public Basket() {
        this.basketItems = new ArrayList<>();
        this.basketLimit = 14; // Probably should be some way to set default limit.
    }

    public Basket(int basketLimit) {
        this.basketItems = new ArrayList<>();
        this.basketLimit = basketLimit;
    }

    @Override
    public ArrayList<Product> getInventory() {
        return this.basketItems;
    }

    @Override
    public void addProduct(Product product) {
        if(basketItems.size() < basketLimit) {
            System.out.println(
                    product.getSku() + " " + product.getName() + " " + product.getVariant() + ": " + product.getPrice()
            );
            basketItems.add(product);
        } else {
            System.out.println("Your basket is at capacity. " + product.getName() + " not added.");
        }
    }

    public void addProduct(Product product, int number) {
        System.out.println(
                product.getSku() + " " + product.getName() + " " + product.getVariant() + ": " + product.getPrice()
                        + "\nNumber: " + number + " \tTotal: " + (product.getPrice() * number)
        );
        for(int i = 0; i < number; i++) {
            addProduct(product);
        }

    }

    public void addProduct(ArrayList<Product> products) {
        if((products.size() + this.basketItems.size()) < basketLimit) {
            double sumPrice = 0;
            for(Product product : products) {
                sumPrice += product.getPrice();
                System.out.println(
                        product.getSku() + " " + product.getName() + " " + product.getVariant() + ": " + product.getPrice()
                );
            }
            System.out.println("The total cost of the items added to the basket: " + sumPrice +"£");
            this.basketItems.addAll(products);
        } else {
            System.out.println("Your basket is at capacity. Product(s) not added");
        }
    }

    public void removeProduct(Product product) {
        if(this.basketItems.contains(product)) {
            this.basketItems.remove(product);
        } else {
            System.out.println(product.getName() + " doesen't seem to be in your basket");
        }
    }

    public void removeProduct(String productVariant) {
        for(int i = 0; i < this.basketItems.size(); i++) {
            if(basketItems.get(i).getVariant().equals(productVariant)) {

                this.basketItems.remove(i);
                return;
            }
        }
        System.out.println(productVariant + " doesen't seem to be in your basket");
    }



    public int getCapacity() {
        return this.basketLimit;
    }

    public void setCapacity(int capacity) {
        if(this.basketItems.size() < capacity) {
            this.basketLimit = capacity;
        }
        System.out.println("This basket contains more items than the specified capacity");
    }

    public boolean isBasketFull() {
        if(this.basketItems.size() >= basketLimit) {
            return true;
        }
        return false;
    }

    @Override
    public boolean inInventory(Product product) {
        return basketItems.contains(product);
    }

}
