package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private final Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public void printReceipt() {
        System.out.println("\t~~~~ Bobs Bagel ~~~~\n");
        System.out.println("\t" + getFormattedDate() + "\n");
        System.out.println("----------------------------");
    }

    public String getFormattedDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(df);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt(new Order());
        receipt.printReceipt();
    }
}
