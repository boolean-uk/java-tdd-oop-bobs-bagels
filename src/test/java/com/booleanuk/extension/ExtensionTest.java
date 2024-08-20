package com.booleanuk.extension;

import com.booleanuk.extension.extension.Basket;
import com.booleanuk.extension.extension.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionTest {

    @Test
    public void testTotalCostWithoutDiscounts() {
        Inventory inventory = new Inventory();
        Basket basket = new Basket(20, inventory);
        basket.addItem(inventory.getItem("BGLO"));
        basket.addItem(inventory.getItem("BGLP"));
        basket.addItem(inventory.getItem("BGLE"));

        double totalcost = basket.getTotalCost();
        Assertions.assertEquals(1.37, totalcost, 0.01);

    }
}
