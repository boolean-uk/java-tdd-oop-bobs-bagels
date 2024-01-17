package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {

    //User Story 1
    @Test
    public void bagelAddedToBasketReturnTrue() {
        Basket basket = new Basket();

        Bagel bagel = new Bagel("Onion");

        basket.addBagelTypeToBasket(bagel);

        boolean bagelAdded = basket.bagels.contains(bagel);

        Assertions.assertTrue(bagelAdded);
    }

    //User Story 2
    @Test
    public void removeBagelFromBasketReturnTrue() {
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion");
        //bagel.setBagel("Chocolate Bagels");

        basket.addBagelTypeToBasket(bagel);
        basket.removeBagelTypeFromBasket(bagel);

        boolean bagelRemoved = !basket.bagels.contains(bagel);

        Assertions.assertTrue(bagelRemoved);
    }

    //User Story 3 case 1
    @Test
    public void testReturnBasketIsFull() {

        Basket basket = new Basket();

        Bagel bagel1 = new Bagel("Onion");
        //bagel1.setBagel("Chocolate Bagels");

        Bagel bagel2 = new Bagel("Plain");
        //bagel2.setBagel("Vanilla Bagels");

        Bagel bagel3 = new Bagel("Everything");
        //bagel3.setBagel("Strawberry Bagels");

        Bagel bagel4 = new Bagel("Sesame");
        //bagel4.setBagel("Blueberry Bagels");

        Bagel bagel5 = new Bagel("Onion");
        //bagel5.setBagel("Raspberry Bagels");

        basket.addBagelTypeToBasket(bagel1);
        basket.addBagelTypeToBasket(bagel2);
        basket.addBagelTypeToBasket(bagel3);
        basket.addBagelTypeToBasket(bagel4);
        basket.addBagelTypeToBasket(bagel5);

        String result = basket.bagelBasketIsFull();

        Assertions.assertEquals("Basket is full!", result);
    }

    //User Story 3 case 2
    @Test
    public void testReturnBasketIsNotFull() {

        Basket basket = new Basket();

        Bagel bagel1 = new Bagel("Onion");
        //bagel1.setBagel("Chocolate Bagels");

        Bagel bagel2 = new Bagel("Plain");
        //bagel2.setBagel("Vanilla Bagels");

        Bagel bagel3 = new Bagel("Everything");
        //bagel3.setBagel("Strawberry Bagels");

        Bagel bagel4 = new Bagel("Sesame");
        //bagel4.setBagel("Blueberry Bagels");

        basket.addBagelTypeToBasket(bagel1);
        basket.addBagelTypeToBasket(bagel2);
        basket.addBagelTypeToBasket(bagel3);
        basket.addBagelTypeToBasket(bagel4);

        String result = basket.bagelBasketIsFull();

        Assertions.assertEquals("Basket is not full!", result);
    }

    //User Story 4 case 1
    @Test
    public void basketCapacityIsChanged() {
        Basket basket = new Basket();

        Bagel bagel1 = new Bagel("Onion");
        //bagel1.setBagel("Chocolate Bagels");

        Bagel bagel2 = new Bagel("Plain");
        //bagel2.setBagel("Vanilla Bagels");

        Bagel bagel3 = new Bagel("Everything");
        //bagel3.setBagel("Strawberry Bagels");

        Bagel bagel4 = new Bagel("Sesame");
        //bagel4.setBagel("Blueberry Bagels");

        Bagel bagel5 = new Bagel("Onion");
        //bagel5.setBagel("Raspberry Bagels");
        Filling filling1 = new Filling("Egg");
        Filling filling2 = new Filling("Cheese");

        basket.itemsMap.put(bagel1.getBagel(), 0.49);
        basket.itemsMap.put(bagel2.getBagel(), 0.39);
        basket.itemsMap.put(bagel3.getBagel(), 0.49);
        basket.itemsMap.put(bagel4.getBagel(), 0.49);
        basket.itemsMap.put(filling1.getFillingType(), 0.12);
        basket.itemsMap.put(filling2.getFillingType(), 0.12);
        //basket.addBagelTypeToBasket(bagel5);

        //If newCapacity > this.items.size() then the following should pass the test
        String result = basket.changeBasketCapacity(8);

        Assertions.assertEquals("Basket capacity is changed.", result);

    }

    //User Story 4 case 2
    @Test
    public void basketCapacityIsNotChanged() {
        Basket basket = new Basket();

        Bagel bagel1 = new Bagel("Onion");
        //bagel1.setBagel("Chocolate Bagels");

        Bagel bagel2 = new Bagel("Plain");
        //bagel2.setBagel("Vanilla Bagels");

        Bagel bagel3 = new Bagel("Everything");
        //bagel3.setBagel("Strawberry Bagels");

        Bagel bagel4 = new Bagel("Sesame");
        //bagel4.setBagel("Blueberry Bagels");

        Bagel bagel5 = new Bagel("Onion");
        //bagel5.setBagel("Raspberry Bagels");
        Filling filling1 = new Filling("Egg");
        Filling filling2 = new Filling("Cheese");

        basket.itemsMap.put(bagel1.getBagel(), 0.49);
        basket.itemsMap.put(bagel2.getBagel(), 0.39);
        basket.itemsMap.put(bagel3.getBagel(), 0.49);
        basket.itemsMap.put(bagel4.getBagel(), 0.49);
        basket.itemsMap.put(filling1.getFillingType(), 0.12);
        basket.itemsMap.put(filling2.getFillingType(), 0.12);
        //basket.addBagelTypeToBasket(bagel5);

        //If newCapacity > this.items.size() then the following should pass the test
        String result = basket.changeBasketCapacity(4);

        Assertions.assertEquals("Basket capacity is not changed.", result);
    }

    //User Story 5 case 1
    @Test
    public void canRemoveItemFromBasket() {
        Basket basket = new Basket();

        Bagel bagel1 = new Bagel("Onion");
        //bagel1.setBagel("Chocolate Bagels");

        Bagel bagel2 = new Bagel("Plain");
        //bagel2.setBagel("Vanilla Bagels");

        Bagel bagel3 = new Bagel("Everything");
        //bagel3.setBagel("Strawberry Bagels");

        Bagel bagel4 = new Bagel("Sesame");
        //bagel4.setBagel("Blueberry Bagels");

        //Bagel bagel5 = new Bagel();
        //bagel5.setBagel("Raspberry Bagels");

        basket.itemsList.add(bagel1.getVariant());
        basket.itemsList.add(bagel2.getVariant());
        basket.itemsList.add(bagel3.getVariant());
        basket.itemsList.add(bagel4.getVariant());
        //basket.addBagelTypeToBasket(bagel5);

        String result = basket.canRemoveItemInBasket(bagel2.getVariant());

        Assertions.assertEquals("Item is in basket and can be removed.", result);
    }

    //User Story 5 case 2
    @Test
    public void canNotRemoveItemFromBasket() {

        Basket basket = new Basket();

        Bagel bagel1 = new Bagel("Onion");
        //bagel1.setBagel("Chocolate Bagels");

        Bagel bagel2 = new Bagel("Plain");
        //bagel2.setBagel("Vanilla Bagels");

        Bagel bagel3 = new Bagel("Everything");
        //bagel3.setBagel("Strawberry Bagels");

        Bagel bagel4 = new Bagel("Sesame");
        //bagel4.setBagel("Blueberry Bagels");

        //Bagel bagel5 = new Bagel();
        //bagel5.setBagel("Raspberry Bagels");

        basket.itemsList.add(bagel1.getVariant());
        basket.itemsList.add(bagel2.getVariant());
        basket.itemsList.add(bagel3.getVariant());
        //basket.items.put(bagel4.getBagel(), 0.49);
        //basket.addBagelTypeToBasket(bagel4);
        //basket.addBagelTypeToBasket(bagel5);

       String result = basket.canRemoveItemInBasket(bagel4.getVariant());

        Assertions.assertEquals("Item is not in basket and can't be removed.", result);
    }

    //User Story 6
    @Test
    public void totalCostTest() {

        Basket basket = new Basket();

        Bagel bagel1 = new Bagel("Onion");

        Bagel bagel2 = new Bagel("Sesame");

        Filling filling1 = new Filling("Cheese");

        Filling filling2 = new Filling("Egg");

        basket.addItem(bagel1.getVariant(), 1, bagel1.getPrice());
        basket.addItem(bagel2.getVariant(), 2, bagel2.getPrice());
        basket.addItem(filling1.getVariant(), 1, filling1.getPrice());
        basket.addItem(filling2.getVariant(), 2, filling2.getPrice());

        double totalScore = basket.totalCostOfItems();

        Assertions.assertEquals(1.83, totalScore);
    }

    //User Story 7
    @Test
    public void testReturnCostOfBagel() {
        Basket basket = new Basket();

        Bagel bagel = new Bagel("Everything");

        bagel.setBagel(bagel.getBagel());

        double result = basket.returnCostOfBagel(bagel);

        Assertions.assertEquals(0.49, result);
    }

    //User Story 8
    @Test
    public void testChooseFillingOfBagel() {
        Basket basket = new Basket();

        Filling filling = new Filling("Egg");

        String result = basket.chooseBagelFilling(filling);
        Assertions.assertEquals("Egg", result);
    }

    //User Story 9
    @Test
    public void testReturnPriceOfEachFilling() {
        Basket basket = new Basket();

        Filling filling = new Filling("Egg");

        double result = basket.costOfEachFilling(filling);

        Assertions.assertEquals(0.12, result);
    }

    //User Story 10 Case 1 - Is in inventory
    @Test
    public void testIsInInventory() {
        Basket basket = new Basket();

        boolean result = basket.mustBeInInventory("BGLO");

        Assertions.assertTrue(result);
    }
    //User Story 10 Case 1 - Is in inventory
    @Test
    public void testNotInInventory() {
        Basket basket = new Basket();

        boolean result = basket.mustBeInInventory("FILZ");

        Assertions.assertFalse(result);
    }


}
