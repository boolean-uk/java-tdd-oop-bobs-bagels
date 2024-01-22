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

    public Basket(int capacity){
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    public void clearItems(){
        items.clear();
    }

    public Boolean changeCapacity(int newCapacity){
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
        Set<Item> uniqueItems = new HashSet<>(items);
        StringBuilder result = new StringBuilder();
        result.append(String.format("%3s %-1s", "", "~~~ Bob's Bagels ~~~\n"));
        DateTimeFormatter timeNow = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        result.append(String.format("%3s %-1s", "",LocalDateTime.now().format(timeNow)));
        result.append("\n--------------------------------\n");

        for (Item uniqueItem : uniqueItems) {
            String itemName = uniqueItem.getType() + " " + uniqueItem.getVariant();
            int quantity = Collections.frequency(items, uniqueItem);
            double totalCost = uniqueItem.getPrice() * quantity;

            result.append(String.format("%-20s %-4d £%.2f\n", itemName, quantity, totalCost));
        }

        result.append("--------------------------------\n");
        result.append(String.format("%-26s", "Total Price ") + getTotalCost());
        result.append("\n--------------------------------\n");
        result.append(String.format("%5s %-1s", "", "Have a good day!"));


        return result.toString();
    }
    public String getTotalCost() {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getTotalCost();
        }
        return String.format("£%.2f", totalCost);
    }

}
