package com.booleanuk.core.inventory;

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
}
