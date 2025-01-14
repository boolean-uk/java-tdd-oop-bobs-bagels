package com.booleanuk.extension;

import java.time.Month;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestReceipt {
    @Test
    void TestGetRecipet() {
        Inventory inventory = new Inventory();

        inventory.addStock(SKU.BGLO, 2);
        inventory.addStock(SKU.COFB, 1);

        Basket basket = new Basket(inventory, 5);
        basket.addItem(new Bagel(SKU.BGLO));
        basket.addItem(new Bagel(SKU.BGLO));
        basket.addItem(new Coffee(SKU.COFB));

        LocalDateTime time = LocalDateTime.of(2021, Month.MARCH, 16, 21, 38, 44);
        Receipt receipt = new Receipt(basket, time);

        String expected = "    ~~~ Bob's Bagels ~~~\n"
                + "\n"
                + "    2021-03-16 21:38:44\n"
                + "\n"
                + "----------------------------\n"
                + "Black Coffee 1   $0.99\n"
                + "Onion Bagel  2   $0.98\n"
                + "\n"
                + "----------------------------\n"
                + "Total            $1.74\n"
                + "\n"
                + "        Thank you\n"
                + "      for your order!";

        expected = expected.replaceAll("\\s", "");

        String result = receipt.getReceipt().replaceAll("\\s", "");

        Assertions.assertEquals(expected, result);

    }
}
