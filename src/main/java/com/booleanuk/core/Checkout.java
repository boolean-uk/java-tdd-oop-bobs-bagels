package com.booleanuk.core;

import com.booleanuk.extension.Discounts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Inventory inventory;
    private Discounts discounts;

    public Checkout(Inventory inventory, Discounts discounts) {
        this.inventory = inventory;
        this.discounts = discounts;
    }

    public double totalCost(HashMap<String, Integer> basketMap) {
        double cost = 0;
        for(Map.Entry<String, Integer> entry: basketMap.entrySet()) {
            cost += this.inventory.getProductCost(entry.getKey())*entry.getValue();
        }
        return cost;
    }

    public double totalCostDiscount(HashMap<String, Integer> basketMap) {
        double cost = 0;
        for(Map.Entry<String, Integer> entry: basketMap.entrySet()) {
            cost += (this.inventory.getProductCost(entry.getKey()) * entry.getValue())-this.discounts.calculateDiscount(entry.getKey(), basketMap);
        }
        return Math.round(cost * 100)/100.0;
    }

    public String receiptDiscount(HashMap<String, Integer> basketMap) {
        StringBuilder stringBuilder = new StringBuilder();

        String bbTitle = "~~~ Bob's Bagels ~~~";
        int totalWidth = 30;
        int padding = (totalWidth - bbTitle.length()) / 2;
        stringBuilder.append(String.format("%" + padding + "s%s%" + padding + "s", "", bbTitle, "")).append("\n\n");

        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();

        String date = DateFormat.format(c.getTime());
        padding = (totalWidth - date.length()) / 2;
        stringBuilder.append(String.format("%" + padding + "s%s%" + padding + "s", "", date, "")).append("\n\n");

        stringBuilder.append("-".repeat(30)).append("\n\n");

        double discountVal = 0;
        int productPadding = 0;
        int numberPadding = 0;
        int pricePadding = 0;
        String variantAndName = "";
        double saved = 0;
        double costEntry = 0;

        for(Map.Entry<String, Integer> entry: basketMap.entrySet()) {
            discountVal = this.discounts.calculateDiscount(entry.getKey(), basketMap);
            saved += discountVal;
            costEntry = Math.round(((this.inventory.getProductCost(entry.getKey()) * entry.getValue())-discountVal)*100.0)/100.0;

            variantAndName = inventory.findProduct(entry.getKey()).getVariant()+" "+inventory.findProduct(entry.getKey()).getName();
            productPadding = 20-(variantAndName.length());
            numberPadding = 4-Integer.toString(entry.getValue()).length();
            pricePadding = 5-Double.toString(costEntry).length();

            stringBuilder.append(String.format("%" + "s%s%" + productPadding + "s", "", variantAndName, ""));
            stringBuilder.append(String.format("%" + "s%s%" + numberPadding + "s", "", entry.getValue(), ""));
            stringBuilder.append(String.format("%" + pricePadding + "s%s%" + "s", "", "$"+costEntry, "")).append("\n");
            if (discountVal != 0.0) {
                stringBuilder.append(String.format("%" + (totalWidth-Double.toString(discountVal).length()-4) + "s%s%" + "s", "", "(-$"+discountVal+")", "")).append("\n");
            }
        }
        stringBuilder.append("\n").append("-".repeat(30)).append("\n");

        double totCost = this.totalCostDiscount(basketMap);
        stringBuilder.append("Total").append(String.format("%" + (24-Double.toString(totCost).length()) + "s%s%" + "s", "", "$"+totCost, "")).append("\n\n");
        if (saved != 0) {
            String savedString = "You saved a total of $" + saved;
            stringBuilder.append(String.format("%" + (totalWidth - savedString.length()) / 2 + "s%s%" + (totalWidth - savedString.length()) / 2 + "s", "", savedString, "")).append("\n").append("         on this shop\n");
        }
        stringBuilder.append("          Thank you\n").append("       for your order!");

        return stringBuilder.toString();
    }

    public String orderSummary(HashMap<String, Integer> basketMap) {
        if (basketMap.isEmpty()) return "Order is empty";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" Bob's Bagels \n");


        double discountVal = 0;
        String variantAndName = "";
        double saved = 0;
        double costEntry = 0;
        int numOfItems = 0;

        for(Map.Entry<String, Integer> entry: basketMap.entrySet()) {
            discountVal = this.discounts.calculateDiscount(entry.getKey(), basketMap);
            saved += discountVal;
            numOfItems += entry.getValue();
            costEntry = Math.round(((this.inventory.getProductCost(entry.getKey()) * entry.getValue())-discountVal)*100.0)/100.0;
            variantAndName = inventory.findProduct(entry.getKey()).getVariant()+" "+inventory.findProduct(entry.getKey()).getName();

            stringBuilder.append("\n").append(variantAndName).append(" x ").append(entry.getValue()).append(": $").append(costEntry);
            if (discountVal != 0.0) {
                stringBuilder.append(" (-$").append(discountVal).append(")").append("\n");
            } else {
                stringBuilder.append("\n");
            }
        }

        double totCost = this.totalCostDiscount(basketMap);
        stringBuilder.append("\nTotal: $").append(totCost).append("\n");
        if (saved != 0) {
            stringBuilder.append("You saved a total of $").append(saved).append("\n\n");
        } else {
            stringBuilder.append("\n");
        }

        SimpleDateFormat DateFormat = new SimpleDateFormat("HH:mm");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(c.getTimeInMillis()+((long) numOfItems *60*1000));

        String date = DateFormat.format(c.getTime());

        stringBuilder.append("Your order will arrive: ").append(date);

        return stringBuilder.toString();
    }
}
