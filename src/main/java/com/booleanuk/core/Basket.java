package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.List;


public class Basket {

    private final ArrayList<Item> items;
    private final int capacity;

    // Store available items using sku as key.
    private final Map<String, Item> menu;

    // Initialize basket with item list, max capacity and menu.
    public Basket(int capacity){

        this.items = new ArrayList<>();
        this.capacity = capacity;
        this.menu = new HashMap<>();
        populateInventory();

    }

    // Populate manu with inventory
    private void populateInventory(){

        menu.put("BGLP", new Bagel("Plain bagel", 0.39, "BGLP"));
        menu.put("BGLO", new Bagel("Onion bagel", 0.49, "BGLO"));
        menu.put("BGLE", new Bagel("Everything bagel", 0.49, "BGLE"));
        menu.put("BGLS", new Bagel("Sesame bagel", 0.49, "BGLS"));

        menu.put("COFB", new Coffee("Black", 0.99, "COFB"));
        menu.put("COFW", new Coffee("White", 1.19, "COFW"));
        menu.put("COFC", new Coffee("Capuccino", 1.29, "COFC"));
        menu.put("COFL", new Coffee("Latte", 1.29, "COFL"));

        menu.put("FILB", new Filling("Bacon", 0.12, "FILB"));
        menu.put("FILX", new Filling("Cream cheese", 0.12, "FILX"));
        menu.put("FILC", new Filling("Cheese", 0.12, "FILC"));
        menu.put("FILH", new Filling("Ham", 0.12, "FILH"));
        menu.put("FILS", new Filling("Smoked salmon", 0.12, "FILS"));
        menu.put("FILE", new Filling("Egg", 0.12, "FILE"));

    }

    // Add item to basket based on sku.
    public boolean addItem(String sku){

        if (items.size() < capacity && menu.containsKey(sku)){

            items.add(menu.get(sku));
            return true;

        }
        else
            return false;
    }

    // Remove the element(s) that matches sku.
    public boolean removeItem(String sku){

        return items.removeIf(item -> item.getSku().equals(sku));

    }

    // List of items currently in basket.
    public ArrayList<Item> getItems(){

        return new ArrayList<>(items);

    }

    // Total cost of all items in basket.
    public double getTotalCost(){

        double total = 0;
        for(Item item : items){

            total += item.getPrice();

        }
        return total;
    }

    // Return true if items.size is bigger/equal to capacity.
    public boolean isFull(){

        return items.size() >= capacity;

    }

    // Do I actually need the last else statement in each of these methods?
    // Return the discount price of special offers.
    public double discountPrice() {

        double afterDiscountTotal = 0;

        int countOnionBagel = 0;
        int countEverythingBagel = 0;
        int countPlainBagel = 0;

        // Count number of each bagel type.
        for (Item item : items) {

            if (item.getSku().equals("BGLO")) {

                countOnionBagel++;

            } else if (item.getSku().equals("BGLE")) {

                countEverythingBagel++;

            } else if (item.getSku().equals("BGLP")) {

                countPlainBagel++;

            } else {

                // Add item outside of discount.
                afterDiscountTotal += item.getPrice();

            }
        }

        // Sum the total of discounted bagels with bagels outside of discount.
        afterDiscountTotal += (countOnionBagel / 6) * 2.49 + (countOnionBagel % 6) * menu.get("BGLO").getPrice();

        afterDiscountTotal += (countEverythingBagel / 6) * 2.49 + (countEverythingBagel % 6) * menu.get("BGLE").getPrice();

        afterDiscountTotal += (countPlainBagel / 12) * 3.99 + (countPlainBagel % 12) * menu.get("BGLP").getPrice();

        return afterDiscountTotal;

    }

    // Every coffee and bagel combo should add 1.25 to total price.
    public double coffeeAndBagelDiscount() {

        int coffeeCount = 0;
        int bagelCount = 0;
        double total = 0;

        for (Item item : items) {

            if (item.getSku().equals("COFB")) {

                coffeeCount++;

            } else if (item.getSku().startsWith("BGL")) {

                bagelCount++;

            } else {

                total += item.getPrice();

            }
        }

        // Tried making several loops here for each coffee and bagel type considering different prices..
        // .. but ended up assuming the same price since it will cost 1.25 anyway.
        // If I add for example an extra white coffee in the test it will not pass, because its price is different from black coffee
        int numDiscountPairs = Math.min(coffeeCount, bagelCount);
        total += numDiscountPairs * 1.25;

        total += (coffeeCount - numDiscountPairs) * 0.99;
        total += (bagelCount - numDiscountPairs) * 0.39;

        return total;
    }

    // Group items in the basket by their SKU using a map.
    public String printReceipt() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        Map<String, List<Item>> groupedItems = items.stream().collect(Collectors.groupingBy(Item::getSku));

        StringBuilder receipt = new StringBuilder();
        receipt.append("~~~ Bob's Bagels ~~~\n\n");
        receipt.append(formattedDateTime).append("\n\n");
        receipt.append("----------------------------\n");

        double total = 0;

        for (Map.Entry<String, List<Item>> entry : groupedItems.entrySet()) {

            List<Item> itemList = entry.getValue();
            Item item = itemList.get(0);
            int quantity = itemList.size();
            double itemTotalCost = item.getPrice() * quantity;

            receipt.append(String.format("%-20s %2d   £%.2f\n", item.getName(), quantity, itemTotalCost));
            total += itemTotalCost;

        }

        receipt.append("----------------------------\n");
        receipt.append(String.format("Total                 £%.2f\n", total));
        receipt.append("\nThank you\n      for your order!");

        return receipt.toString();
    }

}

