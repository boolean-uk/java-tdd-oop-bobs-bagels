package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;
import com.booleanuk.core.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    private com.booleanuk.core.Basket basket;
    private Item testItem;
    @Test
    public void addAndRemoveItemTest() {
        basket = new com.booleanuk.core.Basket(10);
        com.booleanuk.core.Inventory inventory = new com.booleanuk.core.Inventory("src/main/java/com/booleanuk/core/inventory.csv");
        basket.addItems(inventory, "BGLO", 2);
        Assertions.assertEquals(0.98, basket.getTotalCost());

        basket.removeItems(inventory, "BGLO", 1);
        Assertions.assertEquals(0.49, basket.getTotalCost());
    }
    @Test
    public void testBasketCapacity(){
        basket = new com.booleanuk.core.Basket(5);
        com.booleanuk.core.Inventory inventory = new com.booleanuk.core.Inventory("src/main/java/com/booleanuk/core/inventory.csv");
        basket.addItems(inventory, "BGLO", 3);

        Assertions.assertFalse(basket.addItems(inventory, "BGLO", 3));
        Assertions.assertTrue(basket.addItems(inventory, "BGLO", 2));
    }
    @Test
    public void changeBasketCapacity(){
        basket = new com.booleanuk.core.Basket(5);
        com.booleanuk.core.Inventory inventory = new com.booleanuk.core.Inventory("src/main/java/com/booleanuk/core/inventory.csv");
        Assertions.assertTrue((basket.changeCapacity(10)));
        basket.addItems(inventory, "BGLO", 10);

        Assertions.assertFalse((basket.changeCapacity(9)));
        Assertions.assertTrue((basket.changeCapacity(20)));
    }

    @Test
    public void showBasketTest(){
        basket = new com.booleanuk.core.Basket(5);
        com.booleanuk.core.Inventory inventory = new com.booleanuk.core.Inventory("src/main/java/com/booleanuk/core/inventory.csv");
        basket.addItems(inventory, "BGLO", 1);
        String showBasket = basket.showBasket();
        Assertions.assertEquals("[BGLO, Bagel, 0.49, Onion]", showBasket);
    }

    @Test
    public void getCoastTest(){
        basket = new Basket(5);
        com.booleanuk.core.Inventory inventory = new Inventory("src/main/java/com/booleanuk/core/inventory.csv");
        basket.addItems(inventory, "BGLO", 1);
        Assertions.assertEquals(0.49, basket.getTotalCost());
    }


}
