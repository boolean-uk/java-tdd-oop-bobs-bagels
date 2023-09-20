package com.booleanuk.extension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receipt {
    private ArrayList<ReceiptItem> items;
    private String storeName;
    private Date timestamp;
    private double totalCost;

    public Receipt(String storeName) {
        this.items = new ArrayList<>();
        this.storeName = storeName;
        this.timestamp = new Date();
        this.totalCost = 0.0;
    }

    public void addItem(Product product, int quantity, double cost, double specialOfferCost) {
        this.items.add(new ReceiptItem(product, quantity, cost, specialOfferCost));
        this.totalCost += cost;
    }

    public void printReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("~~~ " + this.storeName + " ~~~");
        System.out.println(dateFormat.format(this.timestamp));
        System.out.println("----------------------------");

        for (ReceiptItem item : items) {
            System.out.printf("%s\t%d\t£%.2f\n", item.getProductName(), item.getQuantity(), item.getCost());
        }

        System.out.println("----------------------------");
        System.out.printf("Total\t\t\t£%.2f\n", this.totalCost);
        System.out.println("\nThank you\nfor your order!");
    }

    public ArrayList<ReceiptItem> getItems() {
        return items;
    }
}
