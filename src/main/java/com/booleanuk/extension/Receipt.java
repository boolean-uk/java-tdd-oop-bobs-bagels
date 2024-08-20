package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Receipt {
    private HashMap<String, List<Item>> orderedItemsListsMap;
    private ArrayList<String> orderStrings;
    private double totalDiscount;

    public Receipt() {
        this.orderedItemsListsMap = new HashMap<>();
        this.totalDiscount = 0;
    }

    public void resetReceipt() {
        this.orderedItemsListsMap = new HashMap<>();
        this.totalDiscount = 0;
    }

    public void printReceipt() {
        // Format receipt
        this.createOrderStrings();
        System.out.println();
        System.out.println("    ~~~ Bob's Bagels ~~~");
        System.out.println();
        System.out.println(new Date());
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
        for (int i = 0; i < this.orderStrings.size()-1; i++) {
            System.out.println(this.orderStrings.get(i));
        }
        System.out.println();
        System.out.println("----------------------------");
        System.out.println(this.orderStrings.getLast());
        System.out.println();
        if (this.totalDiscount > 0) {
            System.out.println(" You saved a total of £" + this.totalDiscount/10000);
            System.out.println("       on this shop");
            System.out.println();
        }
        System.out.println("        Thank you");
        System.out.println("      for your order!");
        System.out.println();
        System.out.println();
    }

    public void createOrderStrings() {
        //Create Strings to print
        orderStrings = new ArrayList<>();
        double totalSum = 0;
        double totalOriginalSum = 0;
        double sum;
        double originalSum;
        HashMap<String, List<Item>> fillings;
        String currentString;

        // Loop through every variant
        for (String SKU : this.orderedItemsListsMap.keySet()) {
            fillings = new HashMap<>();
            sum = 0;
            originalSum = 0;

            // Pick out and save cost and filling for every item
            for (Item item : this.orderedItemsListsMap.get(SKU)) {
                totalSum += item.getTotal();
                totalOriginalSum += item.getPrice();
                sum += item.getTotal();
                originalSum += item.getPrice();
                if (item.getFillings() != null) {
                    for (Item filling : item.getFillings()) {
                        if (!fillings.containsKey(filling.getVariant())) {
                            List<Item> fillingList = new ArrayList<>();
                            fillings.put(filling.getVariant(), fillingList);
                        }
                        fillings.get(filling.getVariant()).add(filling);
                        totalOriginalSum += filling.getPrice();
                        originalSum += filling.getPrice();
                    }
                }
            }

            currentString = formatString(sum, this.orderedItemsListsMap.get(SKU));
            this.orderStrings.add(currentString);

            if (!fillings.isEmpty()) {
                for (List<Item> list : fillings.values()) {
                    currentString = formatString(-1, list);
                    this.orderStrings.add(currentString);
                }
            }
            if (sum < originalSum) {
                currentString = formatDiscountString(originalSum, sum);
                this.orderStrings.add(currentString);
            }
        }
        currentString = formatString(totalSum, null);
        this.totalDiscount = totalOriginalSum - totalSum;
        this.orderStrings.add(currentString);
    }

    public String formatString(double sum, List<Item> itemList) {
        int stringLength = 29;
        String currentString;

        if (itemList == null) {
            currentString = "Total";
        } else {
            if (!(itemList.getFirst() instanceof Filling)) {
                currentString = itemList.getFirst().getVariant() + " " + itemList.getFirst().getName();
            } else {
                currentString = " +" + itemList.getFirst().getVariant() + " " + itemList.getFirst().getName();
            }

            for (int i = currentString.length(); i < 20; i++) {
                currentString = currentString.concat(" ");
            }

            currentString += itemList.size();
        }

        if (sum != -1) {
            String currentCostString = "£" + (sum / 10000);

            for (int i = currentString.length(); i < stringLength - currentCostString.length(); i++) {
                currentString = currentString.concat(" ");
            }
            currentString += currentCostString;
        }

        return currentString;
    }

    public String formatDiscountString(double originalSum, double sum) {
        int stringLength = 30;
        String discount = "(-£" + (originalSum-sum)/10000 + ")";
        String currentString = " ";
        for (int i = currentString.length(); i < stringLength - discount.length(); i++) {
            currentString = currentString.concat(" ");
        }
        currentString += discount;
        return currentString;
    }

    public void addToOrderedItemsListsMap(Item item) {
        if (!this.orderedItemsListsMap.containsKey(item.getSKU())) {
            List<Item> itemList = new ArrayList<>();
            this.orderedItemsListsMap.put(item.getSKU(), itemList);
        }
        this.orderedItemsListsMap.get(item.getSKU()).add(item);
    }
}
