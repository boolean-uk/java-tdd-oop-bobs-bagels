package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Product;
import com.booleanuk.extension.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ReceiptTest {
    @Test
    public void generateReceipt() {
        StringBuilder sbExpected = new StringBuilder();
        StringBuilder sbDate = new StringBuilder();
        String pound = "\u00a3";

        //build date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);

        Receipt receipt = new Receipt();
        Basket basket = new Basket(25);
        basket.addProduct("BGLO", 2);
        basket.addProduct("BGLP", 12);
        basket.addProduct("BGLE", 6);
        basket.addProduct("COFB", 3);

        sbExpected.append("    ~~~ Bob's Bagels ~~~");
        sbExpected.append("\n");
        sbExpected.append("\n");
        sbExpected.append("    "+formattedDateTime);
        sbExpected.append("\n");
        sbExpected.append("\n");
        sbExpected.append("-".repeat(28));
        sbExpected.append("\n");
        for(Map.Entry<Product, Integer> entry : basket.getBasketList().entrySet()){

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

            sbExpected.append(String.format("%-18s %2d   %s%.2f\n", variant + " " + name, quantity, pound, totalCost));
        }
        sbExpected.append("-".repeat(28));
        sbExpected.append("\n");
        sbExpected.append("Total" + " ".repeat(18) + pound + basket.totalCost());
        sbExpected.append("\n");
        sbExpected.append("\n");

        sbExpected.append(" ".repeat(8) + "Thank you" + "\n");
        sbExpected.append(" ".repeat(6) + "for your order!");
        System.out.println(sbExpected);

        Assertions.assertEquals(sbExpected.toString(), receipt.generateReceiptExtension2(basket));

    }

    @Test
    void generateReceiptWithDiscounts() {
        StringBuilder sbExpected = new StringBuilder();
        StringBuilder sbDate = new StringBuilder();
        String pound = "\u00a3";

        //build date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);

        Receipt receipt = new Receipt();
        Basket basket = new Basket(25);
        basket.addProduct("BGLO", 2);
        basket.addProduct("BGLP", 12);
        basket.addProduct("BGLE", 6);
        basket.addProduct("COFB", 3);

        sbExpected.append("    ~~~ Bob's Bagels ~~~");
        sbExpected.append("\n");
        sbExpected.append("\n");
        sbExpected.append("    "+formattedDateTime);
        sbExpected.append("\n");
        sbExpected.append("\n");
        sbExpected.append("-".repeat(28));
        sbExpected.append("\n");
        double totalDiscount = 0.00;
        for(Map.Entry<Product, Integer> entry : basket.getBasketList().entrySet()){

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

            sbExpected.append(String.format("%-18s %2d   %s%.2f\n", variant + " " + name, quantity, pound, totalCost));

            if(discount < 0.00){
                sbExpected.append(" ".repeat(22) + "(-"+ pound + Math.abs(Double.parseDouble(twoDForm.format(discount))) + ")\n");
                totalDiscount += Math.abs(Double.parseDouble(twoDForm.format(discount)));
            }
        }
        sbExpected.append("-".repeat(28));
        sbExpected.append("\n");
        sbExpected.append("Total" + " ".repeat(18) + pound + basket.totalCost());
        sbExpected.append("\n");
        sbExpected.append("\n");

        sbExpected.append("  You saved a total of " + pound + totalDiscount +"\n");
        sbExpected.append(" ".repeat(8) + "on this shop\n");
        sbExpected.append("\n");
        sbExpected.append("\n");

        sbExpected.append(" ".repeat(8) + "Thank you" + "\n");
        sbExpected.append(" ".repeat(6) + "for your order!");
        System.out.println(sbExpected);

        Assertions.assertEquals(sbExpected.toString(), receipt.generateReceipt(basket));
    }
}
