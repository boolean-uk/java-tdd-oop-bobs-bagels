package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Receipt {
    private Date date;
    private HashMap<Item, Double> prices;
    private LinkedHashMap<Item, Integer> quantities;
    private HashMap<Item, Double> discounts;
    private double totalCost;
    private double totalDiscount;
    private String storeName;
    private int width;
    private int priceOffSet;
    private String decorativeLine;

    public Receipt(HashMap<Item, Double> prices, LinkedHashMap<Item, Integer> quantities, double totalCost, String storeName, int width) {
        date = new Date();
        this.prices = prices;
        this.quantities = quantities;
        this.totalCost = totalCost;
        this.storeName = storeName;
        this.width = width;
        priceOffSet = 9;
        decorativeLine = "-".repeat(width);
    }

    public Receipt(HashMap<Item, Double> prices, LinkedHashMap<Item, Integer> quantities, HashMap<Item, Double> discounts, double totalCost, double totalDiscount, String storeName, int width) {
        date = new Date();
        this.prices = prices;
        this.quantities = quantities;
        this.discounts = discounts;
        this.totalCost = totalCost;
        this.totalDiscount = (totalDiscount*100)/100;
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
        Item item;
        int quantity;
        String cost;
        String quantityAndCost = "";
        String name;

        for(Map.Entry<Item, Integer> entry: quantities.entrySet()) {
            item = entry.getKey();
            quantity = entry.getValue();
            cost = String.format("%.2f", prices.get(item));
            name = item.getName()+ " " + item.getClass().getSimpleName();
            quantityAndCost = quantity + " ".repeat(priceOffSet - String.valueOf(quantity).length()- String.valueOf(cost).length()-1) + "\u00A3"+cost;
            string += "\n" + name + " ".repeat(width-name.length()-priceOffSet) + quantityAndCost;
            if(discounts != null && discounts.get(item) != 0) {
                String discount = "(-\u00A3" + String.format("%,.2f", discounts.get(item)) + ")";
                string += "\n" + " ".repeat(width-discount.length()) + discount;
            }
        }

        return string;
    }

    private String formatTotalCost() {
        String cost = "\u00A3"+ String.format("%.2f", totalCost);
        return "Total" + " ".repeat(width-("Total"+cost).length())+cost;
    }

    private String formatStoreName() {
        return " ".repeat((width-(storeName).length()-8)/2)+"~~~ " + storeName + " ~~~";
    }


    private String formatSavingsMessage() {
        String savingsMessage = "";
        if(discounts != null) {
            String firstLine = "You saved a total of \u00A3" + String.format("%,.2f", totalDiscount);
            String secondLine = "on this shop";
            savingsMessage += " ".repeat((width - firstLine.length()) / 2) + firstLine;
            savingsMessage += "\n" + " ".repeat((width - secondLine.length()) / 2) + secondLine;
        }
        return savingsMessage;
    }

    private String formatEndMessage() {
        String endMessage = " ".repeat((width-("Thank you").length())/2)+ "Thank you";
        endMessage += "\n" + " ".repeat((width-("for your order!").length())/2)+ "for your order!";
        return endMessage;
    }

    @Override
    public String toString() {
        if (discounts == null) {
            return String.format("%s\n\n%s\n\n%s\n%s\n\n%s\n%s\n\n%s", formatStoreName(), formatDate(), decorativeLine,
                    formatProductData(), decorativeLine, formatTotalCost(), formatEndMessage());
        } else {
            return String.format("%s\n\n%s\n\n%s\n%s\n\n%s\n%s\n\n%s\n\n%s", formatStoreName(), formatDate(), decorativeLine,
                    formatProductData(), decorativeLine, formatTotalCost(), formatSavingsMessage(), formatEndMessage());
        }
    }
}
