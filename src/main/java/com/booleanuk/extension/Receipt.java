package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Receipt {
    private Basket basket;
    private String time;

    public Receipt(Basket basket, LocalDateTime dateTime) {
        this.basket = basket;

        // format time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        time = dateTime.format(formatter);
    }

    String getReceipt() {
        StringBuilder sb = new StringBuilder();
        sb.append("    ~~~ Bob's Bagels ~~~\n");
        sb.append("\n");
        sb.append("    " + time + "\n");
        sb.append("\n");
        sb.append("----------------------------\n");

        // count occurences for each item
        HashMap<Item, Integer> itemMap = new HashMap<>();
        for (Item item : basket.getItems()) {
            boolean itemExists = false;

            // check if this item exists in map
            for (Item key : itemMap.keySet()) {
                if (key.getSku() == item.getSku()) {
                    itemExists = true;
                    itemMap.put(key, itemMap.get(key) + 1);
                }
            }

            // if this is a new item
            if (!itemExists) {
                itemMap.put(item, 1);
            }
        }

        // add items to receipt
        itemMap.forEach(
                (item, count) -> sb.append(
                        item.toString() + "\t" + Integer.toString(count) + "\t$" + String.valueOf(item.getPrice())
                                + "\n"));

        sb.append("\n");
        sb.append("----------------------------\n");
        sb.append("Total            " + "$" + basket.getTotalCost() + "\n");
        sb.append("\n");
        sb.append("        Thank you\n");
        sb.append("      for your order!");

        return sb.toString();
    }

    void printReceipt() {
        System.out.println(getReceipt());
    }
}
