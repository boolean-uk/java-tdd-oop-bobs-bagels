package com.booleanuk.extension;

import com.booleanuk.core.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class Receipt {
    private final Basket basket;
    private StringBuilder sb;

    public Receipt(Basket basket, Store store) {
        this.basket = basket;
    }

    public StringBuilder generateReceipt() {
        SimpleDateFormat dateAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Item> items = basket.getItems();

        StringBuilder receipt = new StringBuilder();
        receipt.append("\t~~~ Bob's Bagels ~~~\n\n\t").
                append(dateAndTime.format(new Date())).append("\n\n").
                append("----------------------------\n\n");

        Map<String, Double> itemCost = new HashMap<>();
        Map<String, Integer> itemQuantity = new HashMap<>();

        for (Item item : items) {
            String key = (item.getVariant().equals("N/A") ? "" : item.getVariant() + " ") + item.getItemName();
            double cost = itemCost.getOrDefault(key, 0.0) + item.getPrice();
            int quantity = itemQuantity.getOrDefault(key, 0) + 1;

            itemCost.put(key, cost);
            itemQuantity.put(key, quantity);
        }

        for (Map.Entry<String, Double> entry : itemCost.entrySet()) {
            String itemName = entry.getKey();
            int quantity = itemQuantity.get(itemName);
            double totalCost = entry.getValue();

            receipt.append(String.format("%-20s %-2d £%.2f\n", itemName, quantity, totalCost));
        }

        receipt.append("\n----------------------------\n");
        receipt.append("Total\t").append(String.format("\t\t\t\t£%.2f", basket.totalCost()));
        receipt.append("\n\n\t\tThank you\n").append("\t for your order!");

        return receipt;
    }
}