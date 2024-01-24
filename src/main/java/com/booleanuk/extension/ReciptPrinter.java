package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReciptPrinter {
    private StringBuilder sb;
    private String title = "Bob's Bagels";

    private int reciptWidth = 36;

    public ReciptPrinter() {
        this.sb = new StringBuilder();
    }

    private void buildHeader() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        this.sb.append(String.format("%8s=== %s ===\n","", title));
        this.sb.append(String.format("%s\n",formattedDateTime.indent(9)));
        this.sb.append("-".repeat(reciptWidth) + "\n");

    }

    private void listItem(Product product) {
        this.sb.append(String.format(
                "%-4s %-10s %-10s\t £%5.2f\n",
                product.getSku(),
                product.getName(),
                product.getVariant(),
                product.getPrice()));
    }
    private void listItems(Inventory inventory) {
        ArrayList<Product> itemList = inventory.getInventory();
        for(Product product : itemList) {
            listItem(product);
        }
    }

    private void buildFooter(double sum) {
        this.sb.append("-".repeat(reciptWidth) + "\n");
        this.sb.append(String.format("Total %-22s £%5.2f\n", "", sum));
        this.sb.append(String.format("%-14sThank you\n%-10sfor your order!", "", ""));
    }

    public void printRecipt(Inventory inventory, double sum) {
        this.sb = new StringBuilder();
        buildHeader();
        listItems(inventory);
        buildFooter(sum);
        System.out.println(sb);

    }

}
