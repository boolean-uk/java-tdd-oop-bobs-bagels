package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Receipt {
    private Date date;
    private HashMap<String, Double> prices;
    private LinkedHashMap<String, Integer> quantities;
    private double totalCost;
    private String storeName;
    private int width;
    private int priceOffSet;
    private String decorativeLine;

    public Receipt(HashMap<String, Double> prices, LinkedHashMap<String, Integer> quantities, double totalCost, String storeName, int width) {
        date = new Date();
        this.prices = prices;
        this.quantities = quantities;
        this.totalCost = totalCost;
        this.storeName = storeName;
        this.width = width;
        priceOffSet = 9;
        decorativeLine = "-".repeat(width);
    }

    private String formatDate() {
        String dateFormatted = new SimpleDateFormat("dd-MM-yyyy").format(date) + " " + new SimpleDateFormat("H:mm:ss").format(date);
        return " ".repeat((width-dateFormatted.length())/2)+dateFormatted;
    }


    private String formatProductData() {
        String string = "";
        String name;
        int quantity;
        String cost;
        String quantityAndCost = "";

        for(Map.Entry<String, Integer> entry: quantities.entrySet()) {
            name = entry.getKey();
            quantity = entry.getValue();
            cost = String.format("%.2f", prices.get(name));
            quantityAndCost = quantity + " ".repeat(priceOffSet - String.valueOf(quantity).length()-String.valueOf(cost).length()-1) + "\u00A3"+cost;
            string += "\n" + name.toUpperCase() + " ".repeat(width-name.length()-priceOffSet) + quantityAndCost;
        }

        return string;
    }

    private String formatTotalCost() {
        String cost = "\u00A3"+String.format("%.2f", totalCost);
        return "Total" + " ".repeat(width-("Total"+cost).length())+cost;
    }

    private String formatStoreName() {
        return " ".repeat((width-(storeName).length()-8)/2)+"~~~ " + storeName + " ~~~";
    }

    private String newLines(int n) {
        return "\n".repeat(n);
    }

    private String formatEndMessage() {
        String endMessage = " ".repeat((width-("Thank you").length())/2)+ "Thank you";
        endMessage += "\n" + " ".repeat((width-("for your order!").length())/2)+ "for your order!";
        return endMessage;
    }

    @Override
    public String toString() {
        return String.format("%s\n\n%s\n\n%s\n%s\n\n%s\n%s\n\n%s", formatStoreName(), formatDate(), decorativeLine,
                formatProductData(), decorativeLine, formatTotalCost(), formatEndMessage());
    }
}
