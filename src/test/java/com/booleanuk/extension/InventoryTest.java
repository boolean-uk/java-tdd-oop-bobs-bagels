package com.booleanuk.extension;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    public void getProductsTest() {
        var products = Inventory.getProducts();
        assertEquals(14, products.size());
    }

    @Test
    public void getCombinationBargainsTest() {
        var combinationBargains = Inventory.getCombinationBargains();
        assertEquals(4, combinationBargains.size());
    }

    @Nested
    public class ProductNotInInventory {
        private static String PLAIN_BAGEL;

        @BeforeAll
        public static void initializeProducts() {
            PLAIN_BAGEL = "BGLP";
        }

        @Test
        public void productsNotInInventoryTest() {
            assertTrue(Inventory.productNotInInventory("Plastic"));
        }

        @Test
        public void productInInventoryTest() {
            assertFalse(Inventory.productNotInInventory(PLAIN_BAGEL));
        }
    }

    @Nested
    public class GetBargains {
        private static String PLAIN_BAGEL;
        private static String EGG_FILLING;

        @BeforeAll
        public static void initializeProducts() {
            PLAIN_BAGEL = "BGLP";
            EGG_FILLING = "FILE";
        }

        @Test
        public void getBargainsForProductOnSale() {
            var bargains = Inventory.getBargains(PLAIN_BAGEL);

            assertEquals(2, bargains.size());
        }

        @Test
        public void getBargainsForProductWhichIsNotOnSale() {
            var bargains = Inventory.getBargains(EGG_FILLING);

            assertTrue(bargains.isEmpty());
        }
    }

    @Nested
    public class CheckCostOfTheProduct {
        private static String PLAIN_BAGEL;

        @BeforeAll
        public static void initializeProducts() {
            PLAIN_BAGEL = "BGLP";
        }

        @Test
        public void checkCostOfTheProductFromInventoryTest() {
            int cost = Inventory.checkCostOfTheProduct(PLAIN_BAGEL);
            assertEquals(39, cost);
        }

        @Test
        public void checkCostOfTheProductNotFromInventoryTest() {
            int cost = Inventory.checkCostOfTheProduct("Plastic");
            assertEquals(0, cost);
        }
    }

    @Nested
    public class GetProduct {
        private static String PLAIN_BAGEL;

        @BeforeAll
        public static void initializeProducts() {
            PLAIN_BAGEL = "BGLP";
        }

        @Test
        public void getProductFromInventoryTest() {
            Product product = Inventory.getProduct(PLAIN_BAGEL);

            assertEquals(
                    "Bagel",
                    product.name()
            );
            assertEquals(
                    "Plain",
                    product.variant()
            );
            assertEquals(
                    39,
                    product.price()
            );
        }

        @Test
        public void getProductNotFromInventoryTest() {
            assertNull(Inventory.getProduct("Plasic"));
        }
    }

    @Nested
    public class GetProductDescription {
        private static String PLAIN_BAGEL;

        @BeforeAll
        public static void initializeProductsTest() {
            PLAIN_BAGEL = "BGLP";
        }

        @Test
        public void getDescriptionOfTheProductFromInventoryTest() {
            assertEquals(
                    "Plain Bagel",
                    Inventory.getProductDescription(PLAIN_BAGEL)
            );
        }

        @Test
        public void getDescriptionOfTheProductNotFromInventoryTest() {
            assertEquals(
                    "CoffeePlusBagel",
                    Inventory.getProductDescription("CoffeePlusBagel")
            );
        }
    }
}
