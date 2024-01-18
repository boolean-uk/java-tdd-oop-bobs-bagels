package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    private static final int EMPTY = 0;

    private ArrayList<Item> basket;
    private int bagelsInBasket;
    private int fillingsInBasket;
    private int coffeesInBasket;
    private Inventory inventory;
    private int basketCapacity;


    public Basket() {
        this.basket = new ArrayList<>();
        this.bagelsInBasket = EMPTY;
        this.fillingsInBasket = EMPTY;
        this.coffeesInBasket = EMPTY;
        this.inventory = new Inventory();
        this.basketCapacity = 5;
    }

    public boolean addItem(Item item) {
        if (!this.inventory.isInInventory(item.getsKU())) {
            System.out.print("This item does not exist at our store!");
            return false;
        }
        if (basket.size() == this.basketCapacity) {
            System.out.print("Your basket is at its capacity, can't add item!");
            return false;
        }
        this.basket.add(item);
        return true;
    }

    public String removeItem(Item item) {
        if (basket.remove(item)) {
            return "Removed " + item.getName() + "from basket.";
        }
        if (basket.isEmpty()) {
            return "Basket is empty, can't remove items.";
        }
        return "Can't remove " + item.getName() + ", item not in basket.";
    }

    public boolean changeBasketCapacity(int newCapacity) {
        if (newCapacity < this.basketCapacity) {
            return false;
        }
        this.basketCapacity = newCapacity;
        return true;
    }

    public double showTotalCostInBasket() {
        return -1.0;
    }

    public void addBagelFilling(Bagel bagel, Filling filling) {

    }

    public void showCostOfBagel(String name) {

    }

    public void showCostOfFillings() {

    }

    public ArrayList<Item> getBasket() {
        return this.basket;
    }

    public int getBasketCapacity() {
        return this.basketCapacity;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public static void main(String[] args) {
        Basket test = new Basket();
        SKUConverter converter = new SKUConverter();

        String sKU = converter.getSKU("Plain");
        System.out.println(sKU);
        Bagel plain = new Bagel("Plain", sKU);

    }
}
