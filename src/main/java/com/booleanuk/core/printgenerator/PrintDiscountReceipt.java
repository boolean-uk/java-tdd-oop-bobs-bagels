package com.booleanuk.core.printgenerator;

import com.booleanuk.core.basket.BasketItemFormatted;
import com.booleanuk.core.calculators.DiscountObjectMultiPrice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PrintDiscountReceipt extends PrintGenerator{

    private String dateCreated;
    private ArrayList<BasketItemFormatted> pritableItemsList;
    private double totalCost;

    public PrintDiscountReceipt(ArrayList<BasketItemFormatted> pritableItemsList, double totalCost) {
        this.dateCreated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.pritableItemsList = pritableItemsList;
        this.totalCost = totalCost;
    }

    @Override
    public void print() {

        // TODO: not good to let a print function calculate, should be refactored
        double totalDiscount = 0;

        // Variables for e.g. "%-15s %-15s %n", keep blank space
        String leftAlignSmall = "%7s ";
        String leftAlign = "%-23s ";
        String newLine = "%n";
        String divider = "----------------------------------------";
        int totalwidth = 40;

        System.out.println();
        printCenterTitle("~~~Bob's Bagels ~~~", totalwidth);
        System.out.println();
        printCenterTitle(dateCreated.toString(), totalwidth);
        System.out.println();
        System.out.println(divider);
        System.out.println();

        double total = 0.0;
        for (BasketItemFormatted item : pritableItemsList) {
            total += item.getDiscount(); // TODO: Should not calculate here, should refactor

            System.out.printf(
                    leftAlign + leftAlignSmall + leftAlignSmall +  newLine,
                    item.getName(), item.getAmount(),  "£"+item.getPrice()
            );

            if (item.getDiscount() != 0.0) {
                System.out.printf(
                        leftAlign + leftAlignSmall + leftAlignSmall +  newLine,
                        "", "",  "(-£"+item.getDiscount()+")"
                );
            }
        }

        System.out.println("\n"+divider);
        System.out.printf(
                "%s %26s" + newLine,
                "Total cost: ", "£"+totalCost
        );

        System.out.println();
        printCenterTitle("You saved a total of £"+total, totalwidth);
        printCenterTitle("on this shop!", totalwidth);
        System.out.println();

        System.out.println();
        printCenterTitle("Thank you", totalwidth);
        printCenterTitle("for your order!", totalwidth);
        System.out.println();
    }
}
