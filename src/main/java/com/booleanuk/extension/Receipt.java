package com.booleanuk.extension;

import com.booleanuk.core.*;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Receipt {
    private LocalDateTime date;
    private String pound = "\u00a3";
    private double totalDiscount;

    public LocalDateTime getDate() {
        return date;
    }

    public String generateReceiptExtension2(Basket basket) {
        StringBuilder sb = new StringBuilder();

        //build date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);

        // Header
        sb.append("    ~~~ Bob's Bagels ~~~");
        sb.append("\n");
        sb.append("\n");
        sb.append("    "+formattedDateTime);
        sb.append("\n");
        sb.append("\n");
        sb.append("-".repeat(28));
        sb.append("\n");

        // Products
        for (Map.Entry<Product, Integer> entry : basket.getBasketList().entrySet()) {
            String variant = entry.getKey().getVariant();
            String name = entry.getKey().getName();
            int quantity = entry.getValue();
            double totalCost = 0.00;
            DecimalFormat twoDForm = new DecimalFormat("#.##");

            if ((entry.getKey().getSku().equals("BGLO") || entry.getKey().getSku().equals("BGLE"))
                    && entry.getValue() >= 6) {
                int quantityOfSpecialPrice = entry.getValue() / 6;
                int rest = entry.getValue() % 6;
                totalCost += quantityOfSpecialPrice * 2.49;
                totalCost += rest * entry.getKey().getPrice();
            } else if (entry.getKey().getSku().equals("BGLP")
                    && entry.getValue() >= 12) {
                int quantityOfSpecialPrice = entry.getValue() / 12;
                int rest = entry.getValue() % 12;
                totalCost += quantityOfSpecialPrice * 3.99;
                totalCost += rest * entry.getKey().getPrice();
            } else totalCost += entry.getValue() * entry.getKey().getPrice();

            totalCost = Double.parseDouble(twoDForm.format(totalCost));

            sb.append(String.format("%-18s %2d   %s%.2f\n", variant + " " + name, quantity, pound, totalCost));
        }

        // Total Cost
        sb.append("-".repeat(28));
        sb.append("\n");
        sb.append("Total" + " ".repeat(18) + pound + basket.totalCost());
        sb.append("\n");
        sb.append("\n");

        sb.append(" ".repeat(8) + "Thank you" + "\n");
        sb.append(" ".repeat(6) + "for your order!");

        return sb.toString();
    }

    public String generateReceipt(Basket basket) {
        StringBuilder sb = new StringBuilder();

        //build date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);

        // Header
        sb.append("    ~~~ Bob's Bagels ~~~");
        sb.append("\n");
        sb.append("\n");
        sb.append("    "+formattedDateTime);
        sb.append("\n");
        sb.append("\n");
        sb.append("-".repeat(28));
        sb.append("\n");

        totalDiscount = 0.00;
        // Products
        for (Map.Entry<Product, Integer> entry : basket.getBasketList().entrySet()) {

            String variant = entry.getKey().getVariant();
            String name = entry.getKey().getName();
            int quantity = entry.getValue();
            double totalCost = 0.00;
            double discount = 0.00;
            DecimalFormat twoDForm = new DecimalFormat("#.##");

            if ((entry.getKey().getSku().equals("BGLO") || entry.getKey().getSku().equals("BGLE"))
                    && entry.getValue() >= 6) {
                int quantityOfSpecialPrice = entry.getValue() / 6;
                int rest = entry.getValue() % 6;
                totalCost += quantityOfSpecialPrice * 2.49;
                totalCost += rest * entry.getKey().getPrice();
                discount = totalCost - entry.getValue() * entry.getKey().getPrice();
            } else if (entry.getKey().getSku().equals("BGLP")
                    && entry.getValue() >= 12) {
                int quantityOfSpecialPrice = entry.getValue() / 12;
                int rest = entry.getValue() % 12;
                totalCost += quantityOfSpecialPrice * 3.99;
                totalCost += rest * entry.getKey().getPrice();
                discount = totalCost - entry.getValue() * entry.getKey().getPrice();
            } else totalCost += entry.getValue() * entry.getKey().getPrice();

            totalCost = Double.parseDouble(twoDForm.format(totalCost));

            sb.append(String.format("%-18s %2d   %s%.2f\n", variant + " " + name, quantity, pound, totalCost));

            if(discount < 0.00){
                sb.append(" ".repeat(22) + "(-"+ pound + Math.abs(Double.parseDouble(twoDForm.format(discount))) + ")\n");
                totalDiscount += Math.abs(Double.parseDouble(twoDForm.format(discount)));
            }
        }

        // Total Cost
        sb.append("-".repeat(28));
        sb.append("\n");
        sb.append("Total" + " ".repeat(18) + pound + basket.totalCost());
        sb.append("\n");
        sb.append("\n");

        sb.append("  You saved a total of " + pound + totalDiscount +"\n");
        sb.append(" ".repeat(8) + "on this shop\n");
        sb.append("\n");
        sb.append("\n");

        sb.append(" ".repeat(8) + "Thank you" + "\n");
        sb.append(" ".repeat(6) + "for your order!");

        return sb.toString();
    }
}
