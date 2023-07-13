package com.booleanuk.extension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class Basket {

    private List<Item> items;
    private List<Item> coffeeList;
    private List<Item> bagelList;
    private int capacity;
    private Inventory inventory;

    int countBagelOnion = 0;
    int countBagelEverything = 0;
    int countBagelPlain = 0;
    double sum = 0;

    public Basket(int capacity) {
        items = new ArrayList<>();
        this.capacity = capacity;
        inventory = new Inventory();
        coffeeList = new ArrayList<>();
        bagelList = new ArrayList<>();
    }

    public boolean add(Item item) {
        if (items.size() < capacity) {
            items.add(item);
            if (item.getVariant().equals("Black")) {
                coffeeList.add(item);
            }
            if (item.getName().equals("Bagel")) {
                bagelList.add(item);
            }

            if (item.getVariant().equals("Onion")) {
                countBagelOnion++;
            } else if (item.getVariant().equals("Everything")) {
                ++countBagelEverything;
            } else if (item.getVariant().equals("Plain")) {
                ++countBagelPlain;
            }

            if (countBagelOnion == 6) {
                while (countBagelOnion > 0) {
                    for (Item item1 : items) {
                        if (item1.getVariant().equals("Onion")) {
                            item1.setPrice(0);
                            countBagelOnion--;
                        }
                    }
                }
                sum = sum + 2.49;
            }
            if (countBagelEverything == 6) {
                while (countBagelEverything > 0) {
                    for (Item item1 : items) {
                        if (item1.getVariant().equals("Everything")) {
                            item1.setPrice(0);
                            countBagelEverything--;
                        }
                    }
                }
                sum = sum + 2.49;
            }

            if (countBagelPlain == 12) {
                while (countBagelPlain > 0) {
                    for (Item item1 : items) {
                        if (item1.getVariant().equals("Plain")) {
                            item1.setPrice(0);
                            countBagelPlain--;
                        }
                    }
                }
                sum = sum + 3.99;
            }
            return true;
        }
        return false;
    }

    public void changeCapacity(int newCapacity) {
        if (capacity > newCapacity)
            throw new RuntimeException("New capacity cannot be smaller than the old one");
        capacity = newCapacity;

    }

    public double totalCost() {
        int pairs = 0;
        if (coffeeList.size() > bagelList.size()) {
            pairs = bagelList.size();
            for (int i = 0; i < bagelList.size(); i++) {
                coffeeList.get(i).setPrice(0);
            }
            for (Item i: bagelList) {
                i.setPrice(0);
            }
            sum += 1.25*pairs;
        } else {
            pairs = coffeeList.size();
            for (int i = 0; i < coffeeList.size(); i++) {
                bagelList.get(i).setPrice(0);
            }
            for (Item i: coffeeList) {
                i.setPrice(0);
            }

            sum += 1.25*pairs;
        }

        sum += items.stream()
                .map(Item::getPrice)
                .reduce(Double::sum)
                .orElse(0.0);
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedValue = df.format(sum);
        return Double.parseDouble(formattedValue);
    }
}
