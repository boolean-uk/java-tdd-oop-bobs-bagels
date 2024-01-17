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

        //Bagel bagel5 = new Bagel();
        //bagel5.setBagel("Raspberry Bagels");

        basket.addBagelTypeToBasket(bagel1);
        basket.addBagelTypeToBasket(bagel2);
        basket.addBagelTypeToBasket(bagel3);
        basket.addBagelTypeToBasket(bagel4);
        //basket.addBagelTypeToBasket(bagel5);

        String result = basket.basketIsFull();

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


        basket.addBagelTypeToBasket(bagel1);
        basket.addBagelTypeToBasket(bagel2);

        String result = basket.basketIsFull();

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

        //Bagel bagel5 = new Bagel();
        //bagel5.setBagel("Raspberry Bagels");

        basket.addBagelTypeToBasket(bagel1);
        basket.addBagelTypeToBasket(bagel2);
        basket.addBagelTypeToBasket(bagel3);
        basket.addBagelTypeToBasket(bagel4);
        //basket.addBagelTypeToBasket(bagel5);

        //If newCapacity > this.bagels.size() then the following should pass the test
        String result = basket.changeBasketCapacity(6);

        Assertions.assertEquals("Basket capacity changed!", result);

    }

    //User Story 4 case 2
    @Test
    public void basketCapacityIsNotChanged() {
        Basket basket = new Basket();

        //4 entries
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

        basket.addBagelTypeToBasket(bagel1);
        basket.addBagelTypeToBasket(bagel2);
        basket.addBagelTypeToBasket(bagel3);
        basket.addBagelTypeToBasket(bagel4);
        //basket.addBagelTypeToBasket(bagel5);

        //This should pass, as theres already 5 bagels in the list and the new capacity is 5
        //Thus the capacity hasnt changed, if new capacity is lower than 5, it should also pass
        //as the capacity can't be lowered than the items already in the list
        String result = basket.changeBasketCapacity(3);

        //It should fail if the new capacity is bigger than 5 as the capacity has then been changed

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

        basket.addBagelTypeToBasket(bagel1);
        basket.addBagelTypeToBasket(bagel2);
        basket.addBagelTypeToBasket(bagel3);
        basket.addBagelTypeToBasket(bagel4);
        //basket.addBagelTypeToBasket(bagel5);

        String result = basket.canRemoveItemInBasket(bagel1);

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

        basket.addBagelTypeToBasket(bagel1);
        basket.addBagelTypeToBasket(bagel2);
        basket.addBagelTypeToBasket(bagel3);
        //basket.addBagelTypeToBasket(bagel4);
        //basket.addBagelTypeToBasket(bagel5);

        String result = basket.canRemoveItemInBasket(bagel4);

        Assertions.assertEquals("Item is not in basket and can't be removed.", result);
    }

    //User Story 6
    @Test
    public void totalCostTest() {

        Basket basket = new Basket();

        basket.addItem("Butter", 10, 2);
        basket.addItem("Milk", 5, 1);
        basket.addItem("Bread", 10, 1);
        basket.addItem("Biscuits", 5, 2);

        double totalScore = basket.totalCostOfItems();

        Assertions.assertEquals(45, totalScore);
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

        boolean result = mustBeInInventory("Bagel");

        Assertions.assertTrue(result);
    }
    //User Story 10 Case 1 - Is in inventory
    @Test
    public void testNotInInventory() {
        Basket basket = new Basket();

        boolean result = mustBeInInventory("Banana");

        Assertions.assertFalse(result);
    }


}
