package com.booleanuk.extension;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReceiptTest {

    private static Receipt RECEIPT;
    private static LocalDateTime CREATION_DATE;

    @BeforeAll
    public static void initializeReceipt() {
        Basket basket = new Basket(30);
        basket.add("BGLO", 2);
        basket.add("BGLP", 14);
        basket.add("BGLE", 6);
        basket.add("FILC", 2);
        basket.add("COFB", 2);

        Checkout checkout = new Checkout(basket);
        RECEIPT = checkout.getReceipt();
        CREATION_DATE = LocalDateTime.now();
    }

    @Test
    public void createReceiptTest() {
        assertEquals(5, RECEIPT.getCosts().size());
        assertEquals(5, RECEIPT.getAmounts().size());
        assertEquals(3, RECEIPT.getDiscounts().size());
        assertEquals(10.2d, RECEIPT.getTotalCost());
        assertTrue(Math.abs(RECEIPT.getTotalDiscount() - 1.40d) < 0.01);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd hh:mm:ss");
        assertEquals(
                CREATION_DATE.format(formatter),
                RECEIPT.getCreationDate().format(formatter));
    }

    @Nested
    class SpecificGetters {

        private static Receipt RECEIPT;
        private static String PLAIN_BAGEL;
        @BeforeAll
        public static void initializeReceipt() {
            PLAIN_BAGEL = "BGLP";

            Basket basket = new Basket(30);
            basket.add(PLAIN_BAGEL, 14);

            Checkout checkout = new Checkout(basket);
            RECEIPT = checkout.getReceipt();
        }

        @Test
        public void getCostTest() {
            assertEquals(
                    4.77,
                    RECEIPT.getCost(PLAIN_BAGEL)
            );
        }

        @Test
        public void getDiscountTest() {
            assertEquals(
                    0.69,
                    RECEIPT.getDiscount(PLAIN_BAGEL)
            );
        }

        @Test
        public void getQuantityTest() {
            assertEquals(
                    14,
                    RECEIPT.getQuantity(PLAIN_BAGEL)
            );
        }
    }
}
