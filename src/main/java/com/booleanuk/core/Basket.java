package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Basket {

    private ArrayList<InventoryItem> list;
    private ArrayList<InventoryItem> basket = new ArrayList<>();

    private InventoryItem item;
    private int capacity;

    public Basket(InventoryItem inventoryItem) {
        this.list = new ArrayList<>();
        this.capacity = 4;
        this.item = inventoryItem;
    }

    public boolean addBagel(String variant, double price) {
        fillList();
        Iterator<InventoryItem> iterator = list.iterator();

        if (price != 0 && basket.size() < capacity) {
            boolean added = true;

            while (iterator.hasNext()) {
                item = iterator.next();
                if (item.getVariant().equals(variant) && item.getName().equals("Bagel")) {
                    added = false;
                }
            }
            if (!added) {
                System.out.println("this " + variant + "item already exist");
            } else {
                String sku = "BGL" + variant.substring(0, 1).toUpperCase();
                basket.add(new InventoryItem(sku, price, "Bagel", variant));
                System.out.println("this " + variant + "item added successfully");
            }
            return added;
        }
        return false;
    }

    public boolean removeBagel(String variant) {
        Iterator<InventoryItem> iterator = basket.iterator();
        boolean removed = false;

        if (!variant.equals("")) {
            while (iterator.hasNext()) {
                item = iterator.next();
                if (item.getVariant().equals(variant) && item.getName().equals("Bagel")) {
                    iterator.remove();
                    removed = true;
                }
            }
        }

        if (!removed) {
            System.out.println("item doesn't exist");
        } else {
            System.out.println("item removed successfully");
        }
        return removed;
    }

    public boolean setCapacity(int newCapacity) {
        if (basket.size() != 0) {
            return false;
        } else {
            if (capacity == newCapacity) {
                return false;
            } else {
                this.capacity = newCapacity;
                return true;
            }
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public double totalCost() {
        Iterator<InventoryItem> iterator = basket.iterator();
        double sum = 0;

        while (iterator.hasNext()) {
            item = iterator.next();
            sum += item.getPrice();
        }
        return sum;
    }

    public double showBagelCost(String variant) {
        fillList();

        for (InventoryItem item : list) {
            if (item.getVariant().equals(variant) && item.getName().equals("Bagel")) {
                return item.getPrice();
            }
        }
        return 0;
    }

    public boolean addFilling(String variant, double price) {
        fillList();
        Iterator<InventoryItem> iterator = list.iterator();

        if (price != 0 && basket.size() < capacity) {
            boolean added = true;

            while (iterator.hasNext()) {
                item = iterator.next();
                if (item.getVariant().equals(variant) && item.getName().equals("Filling")) {
                    added = false;
                }
            }
            if (!added) {
                System.out.println("this " + variant + "item already exist");
            } else {
                String sku = "FIL" + variant.substring(0, 1).toUpperCase();
                basket.add(new InventoryItem(sku, price, "Filling", variant));
                System.out.println("this " + variant + "item added successfully");
            }
            return added;
        }
        return false;
    }

    public double showFillingCost(String variant) {
        fillList();

        for (InventoryItem item : list) {
            if (item.getVariant().equals(variant) && item.getName().equals("Filling")) {
                return item.getPrice();
            }
        }
        return 0;
    }

    public double discounts(String item, int times) {
        fillList();
        String[] thisItem = item.split(",");
        double totalDiscount = 0;
        double cb = 1.25;
        boolean isCoffee = false;

        while (times > 0) {
            if (times >= 12) {
                times -= 12;
                totalDiscount += 3.99;
            } else if (times >= 6) {
                times -= 6;
                totalDiscount += 2.49;
            } else {
                break;
            }
        }

        if (thisItem.length == 1) {
            for (InventoryItem it : list) {
                if (it.getVariant().equals(item)) {
                    totalDiscount += it.getPrice() * times;
                    break;
                }
            }
        } else {
            for (String str : thisItem) {
                for (InventoryItem it : list) {
                    if (it.getVariant().equals(str)) {
                        if (it.getName().equals("Coffee")) {
                            isCoffee = true;
                        }
                    }
                }
            }
        }

        if (isCoffee) {
            totalDiscount = cb * times;
        }

        return totalDiscount;
    }


    public void fillList() {
        list.add(new InventoryItem("BGLO", 0.49, "Bagel", "Onion"));
        list.add(new InventoryItem("BGLP", 0.39, "Bagel", "Plain"));
        list.add(new InventoryItem("BGLE", 0.49, "Bagel", "Everything"));
        list.add(new InventoryItem("BGLS", 0.49, "Bagel", "Sesame"));
        list.add(new InventoryItem("COFB", 0.99, "Coffee", "Black"));
        list.add(new InventoryItem("COFW", 1.19, "Coffee", "White"));
        list.add(new InventoryItem("COFC", 1.29, "Coffee", "Capuccino"));
        list.add(new InventoryItem("COFL", 1.29, "Coffee", "Latte"));
        list.add(new InventoryItem("FILB", 0.12, "Filling", "Bacon"));
        list.add(new InventoryItem("FILE", 0.12, "Filling", "Egg"));
        list.add(new InventoryItem("FILC", 0.12, "Filling", "Cheese"));
        list.add(new InventoryItem("FILX", 0.12, "Filling", "Cream Cheese"));
        list.add(new InventoryItem("FILS", 0.12, "Filling", "Smoked Salmon"));
        list.add(new InventoryItem("FILH", 0.12, "Filling", "Ham"));
    }
}
