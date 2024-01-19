package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BasketTest {

    //User Story 1
    @Test
    public void bagelAddedToBasketReturnTrue() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion");

        basket.addBagelVariantToBasket(bagel);

        boolean bagelAdded = true;

        Assertions.assertTrue(bagelAdded);
    }

    //User Story 2
    @Test
    public void removeBagelFromBasketReturnTrue() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion");

        basket.addBagelVariantToBasket(bagel);
        basket.removeBagelVariantFromBasket(bagel);

        boolean bagelRemoved = true;

        Assertions.assertTrue(bagelRemoved);
    }

    //User Story 3 Case 1 - Basket is full
    @Test
    public void testReturnBasketIsFull() {
        Basket basket = new Basket();

        basket.addBagelVariantToBasket(new Bagel("Onion"));
        basket.addBagelVariantToBasket(new Bagel("Plain"));
        basket.addBagelVariantToBasket(new Bagel("Everything"));
        basket.addBagelVariantToBasket(new Bagel("Sesame"));
        basket.addBagelVariantToBasket(new Bagel("Onion"));

        String result = basket.bagelBasketIsFull();

        Assertions.assertEquals("Basket is full!", result);
    }

    //User Story 3 Case 2 - Basket is not full
    @Test
    public void testReturnBasketIsNotFull() {
        Basket basket = new Basket();

        basket.addBagelVariantToBasket(new Bagel("Onion"));
        basket.addBagelVariantToBasket(new Bagel("Plain"));
        basket.addBagelVariantToBasket(new Bagel("Everything"));
        basket.addBagelVariantToBasket(new Bagel("Sesame"));

        String result = basket.bagelBasketIsFull();

        Assertions.assertEquals("Basket is not full!", result);
    }

    //User Story 4 Case 1 - Basket capacity is changed
    @Test
    public void basketCapacityIsChanged() {
        Basket basket = new Basket();

        String result = basket.changeBasketCapacity(8);

        Assertions.assertEquals("Basket capacity is changed.", result);
    }

    //User Story 4 Case 2 - Basket capacity is not changed
    @Test
    public void basketCapacityIsNotChanged() {
        Basket basket = new Basket();

        String result = basket.changeBasketCapacity(4);

        Assertions.assertEquals("Basket capacity is not changed.", result);
    }

    //User Story 5 Case 1 - Can remove item
    @Test
    public void canRemoveItemFromBasket() {
        Basket basket = new Basket();

        basket.addBagelVariantToBasket(new Bagel("Onion"));
        basket.addBagelVariantToBasket(new Bagel("Plain"));
        basket.addBagelVariantToBasket(new Bagel("Everything"));
        basket.addBagelVariantToBasket(new Bagel("Sesame"));

        String result = basket.canRemoveItemInBasket("Plain");

        Assertions.assertEquals("Item is in basket and can be removed.", result);
    }

    //User Story 5 Case 2 - Can not remove item
    @Test
    public void canNotRemoveItemFromBasket() {
        Basket basket = new Basket();

        basket.addBagelVariantToBasket(new Bagel("Onion"));
        basket.addBagelVariantToBasket(new Bagel("Plain"));
        basket.addBagelVariantToBasket(new Bagel("Everything"));

        String result = basket.canRemoveItemInBasket("Sesame");

        Assertions.assertEquals("Item is not in basket and can't be removed.", result);
    }

    //User Story 6
    @Test
    void testTotalCostOfItems() {
        Basket basket = new Basket();

        basket.getBasketList().add(new Inventory("BGLO", 0.49, "Bagel", "Onion")); // Price: 0.49
        basket.getBasketList().add(new Inventory("BGLP", 0.39, "Bagel", "Plain")); // Price: 0.39
        basket.getBasketList().add(new Inventory("BGLE", 0.49, "Bagel", "Everything")); // Price: 0.49

        double expectedTotal = 0.49 + 0.39 + 0.49;

        double totalCost = basket.totalCostOfItems();

        Assertions.assertEquals(expectedTotal, totalCost);
    }

    // User Story 7
    @Test
    public void returnCostOfBagel() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion");

        double cost = basket.returnCostOfBagel(bagel);

        Assertions.assertEquals(0.49, cost);
    }

    // User Story 8
    @Test
    public void chooseBagelFilling() {
        Basket basket = new Basket();
        Filling filling = new Filling("Egg");

        String fillingVariant = basket.chooseBagelFilling(filling);

        Assertions.assertEquals("Egg", fillingVariant);
    }

    // User Story 9
    @Test
    public void costOfEachFilling() {
        Basket basket = new Basket();
        Filling filling = new Filling("Egg");

        double fillingCost = basket.costOfEachFilling(filling);

        Assertions.assertEquals(0.12, fillingCost);
    }

    // User Story 10 Case 1 - Is in inventory
    @Test
    public void mustBeInInventory() {
        Basket basket = new Basket();

        boolean isInInventory = basket.mustBeInInventory("BGLO");

        Assertions.assertTrue(isInInventory);
    }

    // User Story 10 Case 2 - Is not in inventory
    @Test
    public void mustNotBeInInventory() {
        Basket basket = new Basket();

        boolean isInInventory = basket.mustBeInInventory("BAGX");

        Assertions.assertFalse(isInInventory);
    }

    @Test
    void getBasketList() {
        Basket basket = new Basket();
        ArrayList<Inventory> basketListItems = new ArrayList<>();
        basketListItems.add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));

        basket.setBasketList(basketListItems);

        String result = String.valueOf(basket.getBasketList());

        Assertions.assertEquals("[Inventory{sku='BGLO', price=0.49, name='Bagel', variant='Onion'}]", result);
    }

    @Test
    void setBasketList() {
        Basket basket = new Basket();
        ArrayList<Inventory> basketListItems = new ArrayList<>();
        basketListItems.add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));

        basket.setBasketList(basketListItems);

        String result = basket.getBasketList().toString();

        Assertions.assertEquals("[Inventory{sku='BGLO', price=0.49, name='Bagel', variant='Onion'}]", result);
    }

    @Test
    void getInventoryList() {
        Basket basket = new Basket();

        ArrayList<Inventory> items = new ArrayList<>();

        items.add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));

        basket.setInventoryList(items);

        String result = String.valueOf(basket.getInventoryList());

        Assertions.assertEquals("[Inventory{sku='BGLO', price=0.49, name='Bagel', variant='Onion'}]", result);
    }

    @Test
    void setInventoryList() {
        Basket basket = new Basket();

        ArrayList<Inventory> items = new ArrayList<>();

        items.add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));

        basket.setInventoryList(items);

        String result = basket.getInventoryList().toString();

        Assertions.assertEquals("[Inventory{sku='BGLO', price=0.49, name='Bagel', variant='Onion'}]", result);
    }


    @Test
    void getBasketSize() {
        Basket basket = new Basket();

        basket.setBasketSize(10);

        int result = basket.getBasketSize();

        Assertions.assertEquals(10, result);
    }

    @Test
    void setBasketSize() {
        Basket basket = new Basket();

        basket.setBasketSize(10);

        basket.setBasketSize(5);

        int result = basket.getBasketSize();

        Assertions.assertEquals(5, result);
    }
}
