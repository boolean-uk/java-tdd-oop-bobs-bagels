package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

        HashMap<Item, Integer> itemMap = basket.getItemCounts();
        ArrayList<String> itemLines = new ArrayList<>();

        // add items to itemLines
        itemMap.forEach(
                (item, count) -> itemLines.add(
                        item.toString() + "\t" + Integer.toString(count) + "\t$" + String.valueOf(item.getPrice())
                                + "\n"));

        // sort itemLines
        itemLines.sort(String::compareTo);

        // add itemLines to receipt
        for (String s : itemLines) {
            sb.append(s);
        }

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
