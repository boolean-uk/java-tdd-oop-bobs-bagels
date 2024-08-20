package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Receipt {
    private HashMap<String, List<Item>> orderedItemsList;
    private ArrayList<String> orderStrings;

    public Receipt() {
        this.orderedItemsList = new HashMap<>();
    }

    public void resetReceipt() {
        this.orderedItemsList = new HashMap<>();
    }

    public void printReceipt() {
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
        System.out.println("        Thank you");
        System.out.println("      for your order!");
        System.out.println();
        System.out.println();
    }

    public void createOrderStrings() {
        orderStrings = new ArrayList<>();
        double totalSum = 0;
        double sum;
        HashMap<String, List<Filling>> fillings;
        int stringLength = 29;
        String currentCostString;
        String currentString;

        for (String SKU : this.orderedItemsList.keySet()) {

            fillings = new HashMap<>();
            sum = 0;
            for (Item item : this.orderedItemsList.get(SKU)) {
                totalSum += item.getTotal();
                sum += item.getTotal();
                if (item.getFillings() != null) {
                    for (Filling filling : item.getFillings()) {
                        if (!fillings.containsKey(filling.getVariant())) {
                            List<Filling> fillingList = new ArrayList<>();
                            fillings.put(filling.getVariant(), fillingList);
                        }
                        fillings.get(filling.getVariant()).add(filling);
                    }
                }
            }
            currentString = this.orderedItemsList.get(SKU).getFirst().getVariant() + " " + this.orderedItemsList.get(SKU).getFirst().getName();
            for (int i = currentString.length(); i < 20; i++) {
                currentString = currentString.concat(" ");
            }

            currentString += this.orderedItemsList.get(SKU).size();
            currentCostString = "£" + (sum/10000);

            for (int i = currentString.length(); i < stringLength-currentCostString.length(); i++) {
                currentString = currentString.concat(" ");
            }
            currentString += currentCostString;
            this.orderStrings.add(currentString);

            if (!fillings.isEmpty()) {
                for (List<Filling> list : fillings.values()) {
                    currentString = " +" + list.getFirst().getVariant() + " " + list.getFirst().getName();
                    for (int i = currentString.length(); i < 20; i++) {
                        currentString = currentString.concat(" ");
                    }
                    currentString += list.size();
                    this.orderStrings.add(currentString);
                }
            }
        }
        currentString = "Total";
        currentCostString = "£" + (totalSum/10000);
        for (int i = currentString.length(); i < stringLength-currentCostString.length(); i++) {
            currentString = currentString.concat(" ");
        }
        currentString += currentCostString;
        this.orderStrings.add(currentString);

    }

    public void addToOrderedItemsList(Item item) {
        if (!this.orderedItemsList.containsKey(item.getSKU())) {
            List<Item> itemList = new ArrayList<>();
            this.orderedItemsList.put(item.getSKU(), itemList);
        }
        this.orderedItemsList.get(item.getSKU()).add(item);
    }
}
