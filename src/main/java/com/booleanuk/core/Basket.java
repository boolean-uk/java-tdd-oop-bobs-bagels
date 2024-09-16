package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Basket {
    Fillings fillings = new Fillings();
    private int avSpace = 5;
    public List<String> items;
    public Map<String, Double> pricedItems;


    public Basket() {
        this.items = new ArrayList<>();
        this.pricedItems = new HashMap<>();
    }

    public Basket(Fillings fillings) {
        this.items = new ArrayList<>();
        this.fillings = fillings;
        this.pricedItems = new HashMap<>();
    }


    public Basket(int space) {
        this.items = new ArrayList<>();
        this.avSpace = space;
        this.pricedItems = new HashMap<>();
    }


    public boolean add(String item) {

        if (items.size() < avSpace && fillings.inventoryList.containsKey(item)) {
            items.add(item);
            System.out.println("Item has been added");
            return true;
        } else {
            System.out.println("The cart is full");
            return false;
        }

    }

    public void addPrice(String name, double price) {
        if (fillings.inventoryList.containsKey(name)) {
            System.out.println("The bagel you've chosen costs: " + price);
            pricedItems.put(name, price);
            add(name);
        } else {
            System.out.println("Bagel has not been found in our stock");
        }


    }

    public double calculatePrice() {
        double total = 0.00d;
        for (Map.Entry<String, Double> entry : pricedItems.entrySet()) {
            Double value = entry.getValue();
            total += value;
        }
        System.out.println(total);
        System.out.println(fillings.fillingPrice);
        double fillingprices = fillings.getFillingCost();
        total += fillingprices;
        return total;
    }

    public boolean remove(String item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println(item + "has been deleted from the list");
            return true;
        } else {
            System.out.println("This item has not been found");
            return false;
        }
    }

    public void avSpaceSetter(int newVal) {
        avSpace = newVal;
        System.out.println("The new space value is: " + newVal);
    }


}