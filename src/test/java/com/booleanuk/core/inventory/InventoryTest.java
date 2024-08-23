package com.booleanuk.core.inventory;

import com.booleanuk.core.BasketItem;
import com.booleanuk.core.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class InventoryTest {
    Inventory inventory;

    // Print exception method function
    public void printExceptionMessageToConsole(Exception e) {
        System.out.println("\nException message:");
        System.out.println("\t" + e.getMessage() + "\n");
    }

    @Test
    public void checkInventoryInitialization() {
        inventory = new Inventory();
        Map<String, InventoryItem> items = inventory.getAllItems();

        for (InventoryItem i : items.values()) {
            System.out.println(
                    i.getSKU()+", "
                    + i.getPrice()+", "
                    + i.getName()+", "
                    + i.getVariant()+", "
            );
        }
    }

    @Test
    public void getItemBasedOnSKU() {
        inventory = new Inventory();
        Assertions.assertEquals("BAGE", inventory.getItem("BAGE").getSKU());
    }

    // User story #10: Can't add something that are not in the inventory / in stock
    // TODO: This inventory don't keep track on number of items in stock, so it is infinite
    @Test
    public void throwExceptionWhenItemIsNotInInventory() {
        inventory = new Inventory();

        // Try to invoke exception
        InventoryItemException e = Assertions.assertThrows(
                InventoryItemException.class,
                () -> { inventory.getItem("HELLO"); }
        );
        Assertions.assertEquals("SKU 'HELLO' does not exist.", e.getMessage());
        printExceptionMessageToConsole(e);
    }

    // User story #7: Get price of bagel
    @Test
    public void getPriceOfBagel() {
        inventory = new Inventory();
        BagelItem bagel = (BagelItem) inventory.getItem("BAGE");
        Assertions.assertEquals(0.49, bagel.getPrice());
    }

    // User story #9: Get price of filling
    @Test
    public void getPriceOfFilling() {
        inventory = new Inventory();
        FillingItem filling = (FillingItem) inventory.getItem("FILB");
        Assertions.assertEquals(0.12, filling.getPrice());
    }

    @Test
    public void printInventoryMenu() {
        inventory = new Inventory();
        inventory.printMenu();
    }
}
