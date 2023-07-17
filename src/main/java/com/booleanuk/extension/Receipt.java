package com.booleanuk.extension;

import com.booleanuk.core.*;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
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
        Map<Product, Integer> tmp = new HashMap<>(basket.getBasketList());
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        double totalCost = 0.00;
        double discountCoffeeAndBagelPlain = 0.00;
        boolean isPromotion = false;

        for(Map.Entry<Product, Integer> entry : basket.getBasketList().entrySet()){

            String variant = entry.getKey().getVariant();
            String name = entry.getKey().getName();
            int quantity = entry.getValue();
            double discount = 0.00;
            totalCost = 0.00;

            if ((entry.getKey().getSku().equals("BGLO") || entry.getKey().getSku().equals("BGLE"))) {
                if(entry.getValue() >= 6){
                    isPromotion =true;
                    int quantityOfSpecialPrice = entry.getValue() / 6;
                    int rest = entry.getValue() % 6;
                    totalCost += quantityOfSpecialPrice * 2.49;
                    tmp.replace(entry.getKey(), rest);
                    totalCost += rest * entry.getKey().getPrice();
                    discount = totalCost - entry.getValue() * entry.getKey().getPrice();
                }else {
                    totalCost += entry.getValue() * entry.getKey().getPrice();
                    sb.append(String.format("%-18s %2d   %s%.2f\n", variant + " " + name, quantity, pound, totalCost));
                }
            } else if (entry.getKey().getSku().equals("BGLP")
                    && entry.getValue() >= 12) {
                isPromotion = true;
                int quantityOfSpecialPrice = entry.getValue() / 12;
                int rest = entry.getValue() % 12;
                totalCost += quantityOfSpecialPrice * 3.99;
                quantity = quantityOfSpecialPrice * 12;
                tmp.replace(entry.getKey(), rest);
                discount = totalCost - quantity * entry.getKey().getPrice();
            } else if (entry.getKey().getName().equals("Coffee") && !entry.getKey().getVariant().equals("Black")){
                totalCost += entry.getValue() * entry.getKey().getPrice();
                sb.append(String.format("%-18s %2d   %s%.2f\n", variant + " " + name, quantity, pound, totalCost));
            }

            if(isPromotion){
                totalCost = Double.parseDouble(twoDForm.format(totalCost));

                sb.append(String.format("%-18s %2d   %s%.2f\n", variant + " " + name, quantity, pound, totalCost));

                if(discount < 0.00){
                    sb.append(" ".repeat(22) + "(-"+ pound + Math.abs(Double.parseDouble(twoDForm.format(discount))) + ")\n");
                    totalDiscount += Math.abs(Double.parseDouble(twoDForm.format(discount)));
                }
                isPromotion = false;
            }

        }

        int plainBagelsCount = 0;
        int coffeeCount = 0;
        if(tmp.entrySet().stream().anyMatch(e -> e.getKey().getSku().equals("BGLP"))){
            plainBagelsCount = tmp.entrySet().stream().filter(e -> e.getKey().getSku().equals("BGLP")).findAny().get().getValue();
        }
        if(tmp.entrySet().stream().anyMatch(e -> e.getKey().getSku().equals("COFB"))){
            coffeeCount = tmp.entrySet().stream().filter(e -> e.getKey().getSku().equals("COFB")).findAny().get().getValue();
        }
        boolean coffeeIsMin = coffeeCount <= plainBagelsCount;

        int minElements = Math.min(plainBagelsCount, coffeeCount);
        int maxElements = Math.max(plainBagelsCount, coffeeCount);

        totalCost = 0.00;
        totalCost += minElements * 1.25;

        //discount for coffee and bagel
        discountCoffeeAndBagelPlain = minElements * 1.25 - (minElements * 0.99 + minElements * 0.39);

        totalCost = Double.parseDouble(twoDForm.format(totalCost));

        if(minElements > 0){
            sb.append(String.format("%-18s %2d   %s%.2f\n", "Coffee & Bagel P.", minElements, pound, totalCost));

            if(discountCoffeeAndBagelPlain < 0.00){
                sb.append(" ".repeat(22) + "(-"+ pound + Math.abs(Double.parseDouble(twoDForm.format(discountCoffeeAndBagelPlain))) + ")\n");
                totalDiscount += Math.abs(Double.parseDouble(twoDForm.format(discountCoffeeAndBagelPlain)));
            }
        }

        maxElements -= minElements;
        totalCost = 0.00;
        for(int i = 0; i < maxElements; i++){
            if(coffeeIsMin) totalCost += 0.39;
            else totalCost += 0.99;
        }

        if(coffeeIsMin){
            sb.append(String.format("%-18s %2d   %s%.2f\n","Plain" + " " + "Bagel", maxElements, pound, totalCost));
        } else sb.append(String.format("%-18s %2d   %s%.2f\n","Black" + " " + "Coffee", maxElements, pound, totalCost));

        // Total Cost
        sb.append("-".repeat(28));
        sb.append("\n");
        sb.append("Total" + " ".repeat(18) + pound + basket.totalCost());
        sb.append("\n");
        sb.append("\n");

        totalDiscount = Double.parseDouble(twoDForm.format(totalDiscount));
        sb.append("  You saved a total of " + pound + totalDiscount +"\n");
        sb.append(" ".repeat(8) + "on this shop\n");
        sb.append("\n");
        sb.append("\n");

        sb.append(" ".repeat(8) + "Thank you" + "\n");
        sb.append(" ".repeat(6) + "for your order!");

        return sb.toString();
    }
}
