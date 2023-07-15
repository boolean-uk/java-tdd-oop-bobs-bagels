package com.booleanuk.extension;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class Receipt {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private List<ReceiptItem> items;
    private double total;
    private double totalSavings;
    private Date date;

    public Receipt() {
        items = new ArrayList<>();
        total = 0;
        totalSavings = 0;
        date = new Date();
    }

    public void addItem(String name, int quantity, double price, double savings) {
        ReceiptItem item = new ReceiptItem(name, quantity, price, savings);
        items.add(item);
        total += price ;
        totalSavings += savings ;
    }

    public void printReceipt() {
        System.out.println("~~~ Bob's Bagels ~~~");
        System.out.println();
        System.out.println(DATE_FORMAT.format(date));
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();

        for (ReceiptItem item : items) {
            System.out.printf("%-18s %2d   $%s%n", item.getName(), item.getQuantity(), DECIMAL_FORMAT.format(item.getPrice()));
            if (item.getSavings() > 0) {
                System.out.printf("%24s (-$%s)%n", "", DECIMAL_FORMAT.format(item.getSavings()));
            }
        }

        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Total                 $" + DECIMAL_FORMAT.format(total));
        System.out.println();
        System.out.println("You saved a total of $" + DECIMAL_FORMAT.format(totalSavings));
        System.out.println("      on this shop");
        System.out.println();
        System.out.println("        Thank you");
        System.out.println("      for your order!");
        System.out.println();
        System.out.println("~~~ Bob's Bagels ~~~");
        System.out.println();
        System.out.println(DATE_FORMAT.format(date));
        System.out.println();
        System.out.println("----------------------------");
        System.out.println();
    }
}

class ReceiptItem {
    private String name;
    private int quantity;
    private double price;
    private double savings;

    public ReceiptItem(String name, int quantity, double price, double savings) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.savings = savings;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getSavings() {
        return savings;
    }
}
