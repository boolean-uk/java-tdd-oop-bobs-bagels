package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Product;
import com.booleanuk.extension.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
            double price = entry.getKey().getPrice();

            sbExpected.append(String.format("%-18s %2d   %s%.2f\n", variant + " " + name, quantity, pound, price));
        }
        sbExpected.append("-".repeat(28));
        sbExpected.append("\n");
        sbExpected.append("Total" + " ".repeat(18) + pound + basket.totalCost());
        sbExpected.append("\n");
        sbExpected.append("\n");

        sbExpected.append(" ".repeat(8) + "Thank you" + "\n");
        sbExpected.append(" ".repeat(6) + "for your order!");
        System.out.println(sbExpected);

        Assertions.assertEquals(sbExpected.toString(), receipt.generateReceipt(basket));

    }
}
