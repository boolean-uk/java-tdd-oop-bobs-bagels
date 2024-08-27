package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Item> basket;
    private final Inventory inventory;
    private int basketCapacity;


    public Basket(Inventory inventory) {
        this.basket = new ArrayList<>();
        this.inventory = inventory;
        this.basketCapacity = 5;
    }

    public boolean addItem(Item item) {
        if (!this.inventory.isInInventory(item.getsKU())) {
            System.out.print("This item does not exist at our store!");
            return false;
        }
        if (this.basket.size() == this.basketCapacity) {
            System.out.print("Your basket is at its capacity, can't add item!");
            return false;
        }
        this.basket.add(item);
        return true;
    }

    public String removeItem(Item item) {
        if (this.basket.remove(item)) {
            return "Removed " + item.getName() + "from basket.";
        }
        if (this.basket.isEmpty()) {
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
        double totalCost = 0;
        for (Item item : this.basket) {
            totalCost += costOfItem(item.getName());
        }
        return totalCost;
    }

    public double costOfItem(String name) {
        return this.inventory.getPrice(name);
    }

    public String getBagelPrices() {
        String output = "Bagels:\n";
        for (String name : this.inventory.getBagelPrices().keySet()) {
            output += name + " costs £" + this.inventory.getBagelPrices().get(name) + "\n";
        }
        return output;
    }

    public String getCoffeePrices() {
        String output = "Coffees:\n";
        for (String name : this.inventory.getCoffeePrices().keySet()) {
            output += name + " costs £" + this.inventory.getCoffeePrices().get(name) + "\n";
        }
        return output;
    }

    public String getFillingPrices() {
        String output = "Fillings:\n";
        for (String name : this.inventory.getFillingPrices().keySet()) {
            output += name + " costs £" + this.inventory.getFillingPrices().get(name) + "\n";
        }
        return output;
    }

    public boolean addBagelFilling(Bagel bagel, Filling filling) {
        if (this.basket.contains(bagel) && this.inventory.isInInventory(filling.getsKU())) {
            bagel.addFilling(filling.getName());
            return true;
        }
        return false;
    }

    public int getAmountOfItemInBasket(String name) {
        int counter = 0;
        for (Item basketItem : this.basket) {
            if (name.equals(basketItem.getName())) {
                counter++;
            }
        }
        return counter;
    }

    public ArrayList<Item> getBasket() {
        return this.basket;
    }

    public int getBasketCapacity() {
        return this.basketCapacity;
    }

}
