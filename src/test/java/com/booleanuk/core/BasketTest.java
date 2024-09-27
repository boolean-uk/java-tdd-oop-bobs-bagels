package com.booleanuk.core;


import com.booleanuk.core.Basket;
import com.booleanuk.core.InventoryItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

        private Basket basket;

        @BeforeEach
        void setUp() {
            basket = new Basket(10);  // Set an initial capacity of 10 for testing
        }

        @Test
        void addBagelWithFillings() {
            // Test adding a bagel with fillings
            InventoryItem bagel = new InventoryItem("BGLO", 0.49, "Bagel", "Onion", 10);

            List<InventoryItem> fillings = new ArrayList<>();
            fillings.add(new InventoryItem("FILB", 0.12, "Filling", "Bacon", 50));

            assertTrue(basket.addBagelWithFillings(bagel, fillings));
        }

        @Test
        void removeBagel() {

            InventoryItem bagel = new InventoryItem("BGLP", 0.39, "Bagel", "Plain", 20);

            basket.addBagelWithFillings(bagel, new ArrayList<>());
            assertEquals(1, basket.getBagels().get(bagel));

            basket.removeBagel(bagel);
            assertEquals(0, basket.getBagels().getOrDefault(bagel, -1));
        }

        @Test
        void basketFull() {

            assertFalse(basket.basketFull());  // Basket should not be full initially


            for (InventoryItem item : basket.getBagels().keySet()) {
                basket.addBagelWithFillings(item, new ArrayList<>());
            }

            assertTrue(basket.basketFull());
        }

        @Test
        void calculateTotalCost() {

            InventoryItem bagel1 = new InventoryItem("BGLO", 0.49, "Bagel", "Onion", 10);
            InventoryItem bagel2 = new InventoryItem("BGLP", 0.39, "Bagel", "Plain", 20);

            basket.addBagelWithFillings(bagel1, new ArrayList<>());
            basket.addBagelWithFillings(bagel2, new ArrayList<>());

            double expectedTotalCost = bagel1.getPrice() + bagel2.getPrice();

            assertEquals(expectedTotalCost, basket.calculateTotalCost());
        }

        @Test
        void calculateBagelCost() {
            InventoryItem bagel = new InventoryItem("BGLE", 0.49, "Bagel", "Everything", 15);

            double expectedBagelCost = bagel.getPrice();

            assertEquals(expectedBagelCost, basket.calculateBagelCost(bagel));
        }

        @Test
        void isBagelAvailableInInventory() {
            InventoryItem bagel = new InventoryItem("BGLS", 0.49, "Bagel", "Sesame", 25);

            assertTrue(basket.isBagelAvailableInInventory(bagel));
        }
    }

