package com.booleanuk.core;

import java.util.*;

public class Manager {
    private int basketCapacity = 0;
    private static final List<Product> inventory = List.of(
            new Bagel("BGLO", 0.49, "Onion", Collections.emptyList()),
            new Bagel("BGLP", 0.39, "Plain", Collections.emptyList()),
            new Bagel("BGLE", 0.49, "Everything", Collections.emptyList()),
            new Bagel("BGLS", 0.49, "Sesame", Collections.emptyList()),
            new Coffee("COFB", 0.99, "Black"),
            new Coffee("COFW", 1.19, "White"),
            new Coffee("COFC", 1.29, "Cappuccino"),
            new Coffee("COFL", 1.29, "Latte"),
            new Filling("FILB", 0.12, "Bacon"),
            new Filling("FILE", 0.12, "Egg"),
            new Filling("FILC", 0.12, "Cheese"),
            new Filling("FILX", 0.12, "Cream Cheese"),
            new Filling("FILS", 0.12, "Smoked Salmon"),
            new Filling("FILH", 0.12, "Ham")
    );

    public Manager(int basketCapacity) {
        changeBasketsCapacity(basketCapacity);
    }

    public int getBasketCapacity() {
        return basketCapacity;
    }

    public static List<Product> getInventory(){
        return new ArrayList<>(inventory);
    }

    public void changeBasketsCapacity(int newCapacity){
        if(newCapacity < basketCapacity){
            throw new IllegalArgumentException("New capacity can't be less than current capacity!");
        }
        setBasketCapacity(newCapacity);
    }

    private void setBasketCapacity(int basketCapacity) {
        this.basketCapacity = basketCapacity;
        Basket.setCapacity(basketCapacity);
    }

    public static Bagel getBagelByVariant(String variant) {
        for (Product product : inventory) {
            if(product instanceof Bagel && product.getVariant().equals(variant)){
                return ((Bagel) product).clone();
            }
        }
        throw new IllegalArgumentException("Bagel with variant " + variant + " is not in the inventory!");
    }

    public static Filling getFillingByVariant(String variant) {
        for (Product product : inventory) {
            if(product instanceof Filling && product.getVariant().equals(variant)){
                return ((Filling) product).clone();
            }
        }
        throw new IllegalArgumentException("Filling with variant " + variant + " is not in the inventory!");
    }

    public static List<Filling> getFillingsByVariants(List<String> variants) {
        List<Filling> fillings = new ArrayList<>();
        for (String variant : variants) {
            fillings.add(getFillingByVariant(variant));
        }
        return fillings;
    }

    public static void prettyPrintAllBagels() {
        System.out.println("All bagels in my inventory: ");

        List<Bagel> bagels = getInventory().stream()
                .filter(product -> product instanceof Bagel)
                .map(product -> (Bagel) product)
                .sorted(Comparator.comparing(Bagel::getPrice))
                .toList();

        bagels.forEach(bagel -> System.out.println(
                bagel.getVariant() + " - " + bagel.getPrice()));
    }

    public static void prettyPrintAllFillings() {
        List<Filling> fillings = getInventory().stream()
                .filter(product -> product instanceof Filling)
                .map(product -> (Filling) product)
                .sorted(Comparator.comparing(Filling::getPrice))
                .toList();

        fillings.forEach(filling -> System.out.println(
                filling.getVariant() + " - " + filling.getPrice()));
    }

    public static void prettyPrintAllCoffee() {
        List<Coffee> coffees = getInventory().stream()
                .filter(product -> product instanceof Coffee)
                .map(product -> (Coffee) product)
                .sorted(Comparator.comparing(Coffee::getPrice))
                .toList();

        coffees.forEach(coffee -> System.out.println(
                coffee.getVariant() + " - " + coffee.getPrice()));
    }

}
