package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReceiptHandler {

    public static final String header =     "\t~~~ Bob's Bagels ~~~ ";
    public static final String separator =  "---------------------------\n";
    public static final String footer =     "\tThank you for ordering \n\t   at Bob's Bagels!";

    Basket basket;
    StringBuilder sb;
    LocalDateTime dt;

    public ReceiptHandler(Basket basket){
        this.basket = basket;
        this.sb = new StringBuilder();
        this.dt = LocalDateTime.now();
    }

    public String getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.dt.format(formatter);
    }

    public String print(){
        // Header
        this.sb.append(header).append("\n").append("\n\t");
        // Date
        this.sb.append(this.getDate()).append("\n\n").append(separator);

        // Products
        double cost = 0.0;
        for (Product product : basket.getBasket()) {
            cost += product.getPrice();
        }
        double discounted = cost - basket.calculateTotal();

        Map<String, Double> productCost = new HashMap<>();
        Map<String, Integer> productQuantity = new HashMap<>();

        for (Product product : basket.getBasket()) {
            String key = (product.getVariant() + " ") + product.getItemName();
            double price = productCost.getOrDefault(key, 0.0) + product.getPrice();
            int quantity = productQuantity.getOrDefault(key, 0) + 1;

            productCost.put(key, price);
            productQuantity.put(key, quantity);
        }

        for (Map.Entry<String, Double> entry : productCost.entrySet()) {
            String itemName = entry.getKey();
            int quantity = productQuantity.get(itemName);
            double totalCost = entry.getValue();
            sb.append(String.format("%-20s %-2d £%.2f\n", itemName, quantity, totalCost));
        }
        sb.append(separator);
        sb.append("Price:\t").append("\t\t\t\t").append(String.format("£%.2f\n", cost));
        sb.append("Discount:\t").append("\t\t\t").append(String.format("£%.2f\n",discounted));
        sb.append(separator);
        sb.append("Total paid:\t").append("\t\t\t").append(String.format("£%.2f\n",basket.calculateTotal()));
        sb.append("\n").append(footer);


        return sb.toString();
    }
}
