package com.booleanuk.core;

import com.booleanuk.extension.Discounts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private HashMap<String, Integer> basketMap;
    private Inventory inventory;
    private int capacity;
    private Discounts discounts;

    public Basket(Inventory inventory) {
        this.basketMap = new HashMap<>();
        this.inventory = inventory;
        this.setCapacity(5);
    }

    public Basket(Inventory inventory, Discounts discounts) {
        this.basketMap = new HashMap<>();
        this.inventory = inventory;
        this.discounts = discounts;
        this.setCapacity(5);
    }

    public HashMap<String, Integer> getBasketMap() {
        return basketMap;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getCapacity() {
        return capacity;
    }

    public Discounts getDiscounts() {
        return discounts;
    }

    public boolean setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            return true;
        }
        return false;
    }

    public int getNumberOfItems() {
        return this.basketMap.values().stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public String add(String sku) {
        if (this.getNumberOfItems() >= this.capacity) {
            return "Basket is full";
        }
        if (this.basketMap.containsKey(sku)) {
            this.basketMap.put(sku, this.basketMap.get(sku)+1);
            return "Product added to basket";
        } else {
            for (Product product : inventory.getProducts()) {
                if (sku.equals(product.getSku())) {
                    this.basketMap.put(sku, 1);
                    return "Product added to basket";
                }
            }
        }
        return "Product not found";
    }

    public String remove(String sku) {
        if (this.basketMap.containsKey(sku)) {
            if (this.basketMap.get(sku) == 1) {
                this.basketMap.remove(sku);
            } else {
                this.basketMap.put(sku, this.basketMap.get(sku)-1);
            }
            return "Product removed from basket";
        }
        return "Product is not in basket";
    }

    public double totalCost() {
        double cost = 0;
        for(Map.Entry<String, Integer> entry: this.basketMap.entrySet()) {
                    cost += this.inventory.getProductCost(entry.getKey())*entry.getValue();
        }
        return cost;
    }

    public String addFilling(String sku) {
        if (Collections.disjoint(this.basketMap.keySet(), this.inventory.getProducts().stream().filter(x -> x.getName().equals("Bagel")).map(Product::getSku).toList())) {
            return "You need to add a bagel to your basket";
        }
        for(Product product: this.inventory.getProducts()) {
            if(sku.equals(product.getSku())) {
                if (product.getName().equals("Filling")) {
                    String addMessage = this.add(sku);
                    if(addMessage.equals("Product added to basket")) {
                        return "Filling added";
                    } else {
                        return addMessage;
                    }
                } else {
                    return "Product needs to be a filling";
                }
            }
        }
        return "Filling was not found";
    }

    public double totalCostDiscount() {
        double cost = 0;
        for(Map.Entry<String, Integer> entry: this.basketMap.entrySet()) {
            cost += (this.inventory.getProductCost(entry.getKey()) * entry.getValue())-this.discounts.calculateBulkDiscount(entry.getKey(), entry.getValue());
        }
        return Math.round(cost * 100)/100.0;
    }

    public String receiptDiscount() {
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

        for(Map.Entry<String, Integer> entry: this.basketMap.entrySet()) {
            discountVal = this.discounts.calculateBulkDiscount(entry.getKey(), entry.getValue());
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

        double totCost = this.totalCostDiscount();
        stringBuilder.append("Total").append(String.format("%" + (24-Double.toString(totCost).length()) + "s%s%" + "s", "", "$"+totCost, "")).append("\n\n");
        if (saved != 0) {
            String savedString = "You saved a total of $" + saved;
            stringBuilder.append(String.format("%" + (totalWidth - savedString.length()) / 2 + "s%s%" + (totalWidth - savedString.length()) / 2 + "s", "", savedString, "")).append("\n").append("         on this shop\n");
        }
        stringBuilder.append("          Thank you\n").append("       for your order!");

        return stringBuilder.toString();
    }
}
