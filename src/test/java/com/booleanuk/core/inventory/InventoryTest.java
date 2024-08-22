package com.booleanuk.core.inventory;

import com.booleanuk.core.Coffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class InventoryTest {
    Inventory inventory;

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
}
