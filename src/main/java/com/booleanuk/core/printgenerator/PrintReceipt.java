package com.booleanuk.core.printgenerator;

import com.booleanuk.core.basket.BasketItemFormatted;
import com.booleanuk.core.calculators.DiscountObjectCombination;
import com.booleanuk.core.calculators.DiscountObjectMultiPrice;
import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.inventory.InventoryItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PrintReceipt extends PrintGenerator{

    private String dateCreated;
    private ArrayList<BasketItemFormatted> pritableItemsList;
    private double totalCost;

    public PrintReceipt(ArrayList<BasketItemFormatted> pritableItemsList, double totalCost) {
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
        String leftAlign = "%-17s ";
        String newLine = "%n";
        String divider = "---------------------------------";
        int totalwidth = 33;

        System.out.println();
        printCenterTitle("~~~Bob's Bagels ~~~", totalwidth);
        System.out.println();
        printCenterTitle(dateCreated.toString(), totalwidth);
        System.out.println();
        System.out.println(divider);
        System.out.println();

        for (BasketItemFormatted item : pritableItemsList) {

            System.out.printf(
                    leftAlign + leftAlignSmall + leftAlignSmall +  newLine,
                    item.getName(), item.getAmount(),  "£"+item.getPrice()
            );
        }

        System.out.println("\n"+divider);
        System.out.printf(
                "%s %20s" + newLine,
                "Total cost: ", "£"+totalCost
        );
        System.out.println();

    }
}
