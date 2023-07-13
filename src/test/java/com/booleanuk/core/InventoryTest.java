package com.booleanuk.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
        @Test
        public void testAddBagel() {
            Inventory inventory = new Inventory();
            Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
            inventory.addBagel(bagel);
            assertTrue(inventory.checkItemExists("BGLO"));
        }

        @Test
        public void testRemoveBagel() {
            Inventory inventory = new Inventory();
            Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
            inventory.addBagel(bagel);
            inventory.removeBagel(bagel);
            assertFalse(inventory.checkItemExists("BGLO"));
        }

        @Test
        public void testAddFilling() {
            Inventory inventory = new Inventory();
            Filling filling = new Filling("FILB", 0.12, "Bacon");
            inventory.addFilling(filling);
            assertTrue(inventory.checkItemExists("FILB"));
        }

        @Test
        public void testRemoveFilling() {
            Inventory inventory = new Inventory();
            Filling filling = new Filling("FILB", 0.12, "Bacon");
            inventory.addFilling(filling);
            inventory.removeFilling(filling);
            assertFalse(inventory.checkItemExists("FILB"));
        }
}
