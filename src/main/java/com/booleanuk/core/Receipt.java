package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Receipt {
    Basket basket;
    ArrayList<String> receiptLines;

    public Receipt(Basket basket){
        this.basket = basket;
        this.receiptLines = new ArrayList<>();
        createReceipt();
    }

    public void printReceipt(){
        for (String s : receiptLines){
            System.out.println(s);
        }
    }

    public void createReceipt(){
        this.receiptLines.add("\t\t\t ~Bob's Bagels~");
        this.receiptLines.add(String.format("%-15s %5s %10s", "Item", "Quantity", "Price"));
        this.receiptLines.add("-----------------------------------");

        Item item;
        int quantity;
        String price = String.format("%.2f", (float)basket.getDiscount() /100);

        for (Map.Entry<Item, Integer> entry : basket.getBasket().entrySet()){
            item = entry.getKey();
            quantity = entry.getValue();

            if (item instanceof Bagel){
                this.receiptLines.add(String.format("%-15s %5s %13s", item.getName(), quantity, price + "$"));
                addFillingToReceipt((Bagel) item);
            }

            else {
                this.receiptLines.add(String.format("%-15s %5s %13s", item.getName(), quantity, price + "$"));
            }
        }

        this.receiptLines.add("-----------------------------------");
        this.receiptLines.add(String.format("%-15s %5s %12s", "Discount", " ", "-" + price + "$"));
        this.receiptLines.add(String.format("%-15s %5s %12s", "Total", " ", basket.calculateBasketCost()+"$"));
        this.receiptLines.add("\n");
        this.receiptLines.add(String.format("%-10s %10s", " ", "Thank you"));
        this.receiptLines.add(String.format("%-7s %16s", " ", "for your order"));
    }

    public void addFillingToReceipt(Bagel bagel) {
        HashMap<String, Integer> listOfFillings = basket.getQuantityOfFillings(bagel);
        listOfFillings.forEach((key, value) -> receiptLines.add(String.format("%-15s %5s", "- " + key, value)));
    }
}
