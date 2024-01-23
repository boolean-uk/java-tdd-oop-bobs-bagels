package com.booleanuk.extension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Basket {
    private int capacity;
    private ArrayList<Item> items;
    private int quantity;

    private double totalPrice;

    public Basket(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void clearItems() {
        items.clear();
    }

    public Boolean changeCapacity(int newCapacity) {
        if (newCapacity >= items.size()) {
            this.capacity = newCapacity;
            return true;
        }
        return false;
    }

    public boolean addItems(Inventory inventory, String sku, int quantity) {
        Item itemToAdd = inventory.getItemBySKU(sku);
        if (itemToAdd == null) {
            System.out.println("Item not found");
            return false;
        }
        if (items.size() + quantity > capacity) {
            System.out.println("Basket capacity is reached. Current basket: " + items.size() + ". Capacity: " + capacity);
            return false;
        }

        for (int i = 0; i < quantity; i++) {
            items.add(itemToAdd);
        }
        return true;
    }

    public boolean removeItems(Inventory inventory, String skuToRemove, int quantityToRemove) {
        Item itemToRemove = inventory.getItemBySKU(skuToRemove);
        if (itemToRemove != null && items.contains(itemToRemove)) {
            for (int i = 0; i < quantityToRemove; i++) {
                items.remove(itemToRemove);
            }
            return true;
        }
        System.out.println("Item was not found");
        return false;
    }

    public String showBasket() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%3s %-1s", "", "~~~ Bob's Bagels ~~~\n"));
        DateTimeFormatter timeNow = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        result.append(String.format("%3s %-1s", "", LocalDateTime.now().format(timeNow)));
        result.append("\n--------------------------------\n");
        getProductPrice(result);
        result.append("--------------------------------\n");
        result.append(String.format("%-26s", "Total Price ") + getTotalCost());
        result.append("\n--------------------------------\n");
        result.append(String.format("%5s %-1s", "", "Have a good day!"));

        return result.toString();
    }

    private String getTotalCost() {
        return String.format("£%.2f", this.totalPrice);
    }

    private StringBuilder getProductPrice(StringBuilder result) {
        double discountedPrice;
        double discounted;
        this.totalPrice = 0;
        Set<Item> uniqueItems = new HashSet<>(items);

        for (Item uniqueItem : uniqueItems) {
            String itemName = uniqueItem.getType() + " " + uniqueItem.getVariant();
            int quantity = Collections.frequency(items, uniqueItem);

            if (uniqueItem.getType().equals("Bagel")){
                discountedPrice = calculateBagelOffer(uniqueItem, quantity);
                discounted = uniqueItem.getPrice() * quantity;
                discounted = discounted - discountedPrice;
                this.totalPrice += discountedPrice;
                if (discounted > 0){
                    result.append(String.format("%-20s %-4d £%.2f\n", itemName, quantity, discountedPrice));
                    String discountedString = String.format("(£%.2f)\n", discounted);
                    result.append(String.format("%-26s", " ") + discountedString);
                } else {
                    result.append(String.format("%-20s %-4d £%.2f\n", itemName, quantity, discountedPrice));
                }
            }

            else {
                discountedPrice = calculateCoffeeOffer(uniqueItem, quantity);
                this.totalPrice += discountedPrice;
                result.append(String.format("%-20s %-4d £%.2f\n", itemName, quantity, discountedPrice));
            }
        }
        return result;
    }
    private double calculateBagelOffer(Item item, int quantity) {
        double discountedPrice = 0.0;
        int remainingBagels;

        int deal12Quantity = quantity / 12;
        discountedPrice += deal12Quantity * 3.99;
        remainingBagels = quantity % 12;

        int deal6Quantity = remainingBagels / 6;
        discountedPrice += deal6Quantity * 2.49;
        remainingBagels %= 6;

        discountedPrice += remainingBagels * item.getPrice();
        return discountedPrice;
    }

    private double calculateCoffeeOffer(Item item, int quantity){
        double discountedPrice = 0.0;

        if (item.getType().equals("Coffee")) {
            discountedPrice += item.getPrice() * quantity;
        } else {
            discountedPrice += item.getPrice() * quantity;
        }
        return discountedPrice;
    }

}