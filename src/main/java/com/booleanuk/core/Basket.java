package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Basket {
    Fillings fillings = new Fillings();
    private List<String> items;
    private Map<String, Double> pricedItems;
    private int avSpace = 5;

    public void testMethod(){
        System.out.println(fillings.inventoryList);
    }

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

        if (items.size() < avSpace) {
            items.add(item);
            System.out.println("item has been added");
            return true;
        } else {
            System.out.println("item has not been added(not enough space)");
            return false;
        }

    }

    public void addPrice(String name, double price) {
        pricedItems.put(name, price);
        add(name);

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


    public boolean contains(String item) {
        return items.contains(item);
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