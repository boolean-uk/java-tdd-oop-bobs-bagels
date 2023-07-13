package com.booleanuk.core;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

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

    @Test
    public void testGetBagelBySku_ExistingBagel() {
        Inventory inventory = new Inventory();
        Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        inventory.addBagel(bagel);
        Bagel retrievedBagel = inventory.getBagelBySku("BGLO");
        assertEquals(bagel, retrievedBagel);
    }

    @Test
    public void testGetBagelBySku_NonExistingBagel() {
        Inventory inventory = new Inventory();
        Bagel retrievedBagel = inventory.getBagelBySku("BGLP");
        assertNull(retrievedBagel);
    }

    @Test
    public void testGetFillingBySku_ExistingFilling() {
        Inventory inventory = new Inventory();
        Filling filling = new Filling("FILB", 0.12, "Bacon");
        inventory.addFilling(filling);
        Filling retrievedFilling = inventory.getFillingBySku("FILB");
        assertEquals(filling, retrievedFilling);
    }

    @Test
    public void testGetFillingBySku_NonExistingFilling() {
        Inventory inventory = new Inventory();
        Filling retrievedFilling = inventory.getFillingBySku("FILC");
        assertNull(retrievedFilling);
    }
}
