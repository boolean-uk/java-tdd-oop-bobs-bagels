package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Receipt implements ReceiptInterface {
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

        for (Item i : basket.getBasket()){
            String price = String.format("%.2f", (((float)i.price * i.quantity) /100));
            if (i instanceof Bagel){
                this.receiptLines.add(String.format("%-15s %5s %13s", i.name + " " + i.variant, i.quantity, price + "$"));
                addFillingToReceipt((Bagel) i);
            }

            else {
                this.receiptLines.add(String.format("%-15s %5s %13s", i.name + " " + i.variant, i.quantity, price + "$"));
            }
        }
        this.receiptLines.add("-----------------------------------");

        int discount = basket.getDiscount();
        String price = String.format("%.2f", (float)discount /100);

        this.receiptLines.add(String.format("%-15s %5s %12s", "Discount", " ", "-" + price + "$"));
        this.receiptLines.add(String.format("%-15s %5s %12s", "Total", " ", basket.calculateBasketCost()+"$"));
        this.receiptLines.add("\n");
        this.receiptLines.add(String.format("%-10s %10s", " ", "Thank you"));
        this.receiptLines.add(String.format("%-7s %16s", " ", "for your order"));
    }

    public void addFillingToReceipt(Bagel bagel) {
        HashMap<String, Integer> listOfFillings = basket.getListOfFillings(bagel);
        listOfFillings.forEach((key, value) -> receiptLines.add(String.format("%-15s %5s", "- " + key, value)));
    }
}
