package com.booleanuk.extension;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTest {

    private static Checkout CHECKOUT;
    @BeforeAll
    public static void initializeCheckout() {
        Basket basket = new Basket(30);
        basket.add("BGLO", 2);
        basket.add("BGLP", 14);
        basket.add("BGLE", 6);
        basket.add("FILC", 2);
        basket.add("COFB", 2);

        CHECKOUT = new Checkout(basket);
    }

    @Test
    public void getCostsTest() {
        assertEquals(
                5,
                CHECKOUT.getCosts().size()
        );
    }

    @Test
    public void getAmountsTest() {
        assertEquals(
                5,
                CHECKOUT.getAmounts().size()
        );
    }

    @Test
    public void getDiscountsTest() {
        assertEquals(
                3,
                CHECKOUT.getDiscounts().size()
        );
    }

    @Test
    public void getTotalCostTest() {
        assertEquals(
                10.2,
                CHECKOUT.getTotalCost()
        );
    }

    @Test
    public void getTotalDiscountTest() {
        assertTrue(Math.abs(CHECKOUT.getTotalDiscount() - 1.40d) < 0.01);
    }

    @Test
    public void getReceiptTest() {
        assertNotNull(CHECKOUT.getReceipt());
    }

    @Nested
    class CheckoutStaticMethods {

        private static Basket BASKET;
        private static String PLAIN_BAGEL;

        @BeforeAll
        public static void createBasket() {
            PLAIN_BAGEL = "BGLP";

            BASKET = new Basket(30);
            BASKET.add("BGLO", 2);
            BASKET.add(PLAIN_BAGEL, 14);
            BASKET.add("BGLE", 6);
            BASKET.add("FILC", 2);
            BASKET.add("COFB", 2);
        }

        @Test
        public void getCostOfProductsFromInventoryTest() {
            assertEquals(
                    117,
                    Checkout.getProductsCost(
                            PLAIN_BAGEL,
                            3
                    )
            );
        }

        @Test
        public void getCostOfUnknownProductsTest() {
            assertEquals(
                    0,
                    Checkout.getProductsCost(
                            "Plastic",
                            3
                    )
            );
        }

        @Test
        public void countBasketCostWithoutDiscountsTest() {
            assertEquals(
                    11.6,
                    Checkout.countBasketCostWithoutDiscounts(BASKET)
            );
        }

        @Test
        public void countBasketCostWithDiscountsTest() {
            assertEquals(
                    10.2,
                    Checkout.countBasketCostWithDiscounts(BASKET)
            );
        }
    }
}
