package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static java.time.format.DateTimeFormatter.*;

public class NormalReceipt implements Receipt{
    private ArrayList<String> receiptLines;
    private LocalDateTime dateTime;
    private float totalSum;
    private ArrayList<String> finalReceipt;


    public NormalReceipt(){
        this.receiptLines = new ArrayList<>();
        this.finalReceipt = new ArrayList<>();
        this.totalSum = 0;
    }

    public ArrayList<String> getFinalReceipt() {
        return finalReceipt;
    }


    public void addReceiptLine(String itemName, int quantity, float price) {
        this.receiptLines.add(String.format("%-18s %3s %8s", itemName, +quantity, "$"+price));
    }


    public void getDiscountedSum(float sum) {
        this.totalSum = sum;
    }

    public void createFinalReceipt() {
        dateTime = LocalDateTime.now();
        this.finalReceipt.add(String.format("%-8s %10s", " ", "~Bob's Bagels~"));
        this.finalReceipt.add(String.format("%-5s %10s", " ", dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        this.finalReceipt.add("-------------------------------");
        this.finalReceipt.add(" ");
        this.finalReceipt.addAll(receiptLines);
        this.finalReceipt.add(" ");
        this.finalReceipt.add("-------------------------------");
        this.finalReceipt.add(String.format("%-15s %2s %12s", "Total", " ", "$"+totalSum));
        this.finalReceipt.add(" ");
        this.finalReceipt.add(String.format("%-10s %10s", " ", "Thank you"));
        this.finalReceipt.add(String.format("%-7s %16s", " ", "for your order!"));

    }

    public void printReceipt(){
        for (String s : finalReceipt){
            System.out.println(s);
        }
    }
}
