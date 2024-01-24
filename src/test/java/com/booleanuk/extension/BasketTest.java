package com.booleanuk.extension;

import com.booleanuk.extension.Basket;
import com.booleanuk.extension.Inventory;
import com.booleanuk.extension.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasketTest {

    private Basket basket;
    private Item testItem;
    @Test
    public void addAndRemoveItemTest() {
        basket = new Basket(10);
        Inventory inventory = new Inventory("src/main/java/com/booleanuk/core/inventory.csv");
        Assertions.assertTrue(basket.addItems(inventory, "BGLO", 2));
        Assertions.assertTrue(basket.removeItems(inventory, "BGLO", 1));

        Assertions.assertFalse(basket.addItems(inventory, "BGLO", 20));
        Assertions.assertFalse(basket.removeItems(inventory, "BGLE", 2));

    }
    @Test
    public void changeBasketCapacity(){
        basket = new Basket(5);
        Inventory inventory = new Inventory("src/main/java/com/booleanuk/core/inventory.csv");
        Assertions.assertTrue((basket.changeCapacity(10)));
        basket.addItems(inventory, "BGLO", 10);

        Assertions.assertFalse((basket.changeCapacity(9)));
        Assertions.assertTrue((basket.changeCapacity(20)));
    }

    @Test
    public void bagelOfferTest(){
        basket = new Basket(5);
        Inventory inventory = new Inventory("src/main/java/com/booleanuk/core/inventory.csv");
        basket.addItems(inventory, "BGLO", 6);
        // Should always reset
        Assertions.assertEquals("£0.00", basket.getTotalCost());
    }


}
