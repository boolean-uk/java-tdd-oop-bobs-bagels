package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BasketManager {

    //TODO: convert stock to HashMap with key = SKU || [name, variant]
    // new keySet[name,variant]
    static List<Item> stock;
    private List<Product> basket;
    private int capacity;

    public BasketManager(int capacity) {
        this.capacity = capacity;
        this.basket = new ArrayList<>();
    }

    static {
        stock = new ArrayList<>();
        // Bagels
        stock.add(new Bagel("BGLO", 0.49, "Bagel", "Onion") {
        });
        stock.add(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        stock.add(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        stock.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));

        // Coffees
        stock.add(new Coffee("COFB", 0.99, "Coffee", "Black"));
        stock.add(new Coffee("COFW", 1.19, "Coffee", "White"));
        stock.add(new Coffee("COFC", 1.29, "Coffee", "Cappuccino"));
        stock.add(new Coffee("COFL", 1.29, "Coffee", "Latte"));

        // Fillings
        stock.add(new Filling("FILB", 0.12, "Filling", "Bacon"));
        stock.add(new Filling("FILE", 0.12, "Filling", "Egg"));
        stock.add(new Filling("FILC", 0.12, "Filling", "Cheese"));
        stock.add(new Filling("FILX", 0.12, "Filling", "Cream Cheese"));
        stock.add(new Filling("FILS", 0.12, "Filling", "Smoked Salmon"));
        stock.add(new Filling("FILH", 0.12, "Filling", "Ham"));

    }

    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private Product getProductFromStockByNameAndVariant(String name, String variant) {

        Optional<Item> foundItem = stock.stream()
                .filter(item -> item.getName()
                        .equals(name) && item.getVariant().equals(variant)).findFirst();

        if (foundItem.isEmpty()) return null;
        if (!(foundItem.get() instanceof Product)) return null;

        return (Product) foundItem.get();
    }

    private Product getProductFromBasketById(String id) {

        return this.basket.stream()
                .filter(product -> product.getId().equals(id)).findFirst().orElse(null);

    }

    public boolean add(String name, String variant) {

        if (basket.size() >= capacity) return false;

        Product product = getProductFromStockByNameAndVariant(name, variant);

        if (product == null) {
            System.out.println("Given product is not currently in stock");
            return false;
        }
        if (product instanceof Bagel) {
            this.basket.add(new Bagel((Bagel) product));
            return true;
        }

        return false;
    }

    public boolean remove(String id) {
        Product productToRemove = getProductFromBasketById(id);
        boolean result = basket.remove(productToRemove);

        System.out.println(result ? "Product removed from basket" : "Product not in basket");
        return result;
    }

    public boolean expandBasket(int capacity) {
        if (capacity > this.capacity) {
            this.capacity = capacity;
            return true;
        }
        return false;
    }

    public double totalPrice() {
        double sum = 0;
        for (Product product : basket) {
            sum += product.getPrice();
        }
        return sum;
    }

    public double getPrice(String name, String variant) {
        Optional<Item> foundItem = stock.stream()
                .filter(item -> item.getName().equals(name)
                        && item.getVariant().equals(variant))
                .findFirst();

        return foundItem.map(Item::getPrice).orElse(-1.0);
    }

    public boolean add (String name, String variant, String ...fillings) {
        if (basket.size() >= capacity) return false;

        // Find Product if it is in stock
        Product product = getProductFromStockByNameAndVariant(name, variant);
        if (product == null) {
            System.out.println("Given product is not currently in stock");
            return false;
        }

        //Add Bagel with fillings to basket
        if (product instanceof Bagel) {
            Bagel newBagel = new Bagel((Bagel) product);
            if (fillings.length != 0) {
                //Find fillings if it is in stock
                for (String fillVariant: fillings) {
                    Optional<Item> foundFilling = stock.stream().filter(item -> item.getName().equals("Filling"))
                            .filter(item -> item.getVariant().equals(fillVariant)).findFirst();

                    if (foundFilling.isPresent()) {
                        newBagel.addFilling((Filling) foundFilling.get());
                    } else {
                        System.out.println("Filling doesn't exist");
                    }
                }
            }
            this.basket.add(newBagel);
            return true;
        }

        return false;
    }
}
