package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class BasketTest {

    //User Story 1
    @Test
    public void bagelAddedToBasketReturnTrue() {
        Basket basket = new Basket();

        Bagel bagel = new Bagel("Onion");

        basket.addBagelTypeToBasket(bagel);

        boolean bagelAdded = basket.getBagels().contains(bagel);

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

        boolean bagelRemoved = !basket.getBagels().contains(bagel);

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

        basket.getItemsMap().put(bagel1.getBagel(), 0.49);
        basket.getItemsMap().put(bagel2.getBagel(), 0.39);
        basket.getItemsMap().put(bagel3.getBagel(), 0.49);
        basket.getItemsMap().put(bagel4.getBagel(), 0.49);
        basket.getItemsMap().put(filling1.getFilling(), 0.12);
        basket.getItemsMap().put(filling2.getFilling(), 0.12);
        //basket.addBagelTypeToBasket(bagel5);

        //If newCapacity > this.itemsMap.size() then the following should pass the test
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

        basket.getItemsMap().put(bagel1.getBagel(), 0.49);
        basket.getItemsMap().put(bagel2.getBagel(), 0.39);
        basket.getItemsMap().put(bagel3.getBagel(), 0.49);
        basket.getItemsMap().put(bagel4.getBagel(), 0.49);
        basket.getItemsMap().put(filling1.getFilling(), 0.12);
        basket.getItemsMap().put(filling2.getFilling(), 0.12);
        //basket.addBagelTypeToBasket(bagel5);

        //If newCapacity > this.itemsMap.size() then the following should pass the test
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

        basket.getItemsList().add(bagel1.getVariant());
        basket.getItemsList().add(bagel2.getVariant());
        basket.getItemsList().add(bagel3.getVariant());
        basket.getItemsList().add(bagel4.getVariant());
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

        basket.getItemsList().add(bagel1.getVariant());
        basket.getItemsList().add(bagel2.getVariant());
        basket.getItemsList().add(bagel3.getVariant());
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


    @Test
    void getBagels() {
        Basket basket = new Basket();

        Bagel bagel = new Bagel("Onion");

        ArrayList<Bagel> bagelList = new ArrayList<>();

        bagelList.add(bagel);

        basket.setBagels(bagelList);

        String result = basket.getBagels().toString();

        Assertions.assertEquals("[Onion]", result);
    }

    @Test
    void setBagels() {

        Basket basket = new Basket();

        Bagel bagel = new Bagel("Onion");

        ArrayList<Bagel> bagelList = new ArrayList<>();

        bagelList.add(bagel);

        basket.setBagels(bagelList);

        String result = String.valueOf(bagelList.toString());

        Assertions.assertEquals("[Onion]", result);
    }

    @Test
    void getItemsList() {
        Basket basket = new Basket();

        ArrayList<String> itemsList = new ArrayList<>();

        String testItem1 = "Coffee";
        String testItem2 = "Bagel";
        String testItem3 = "Filling";

        itemsList.add(testItem1);
        itemsList.add(testItem2);
        itemsList.add(testItem3);

        basket.setItemsList(itemsList);

        String result = basket.getItemsList().toString();

        Assertions.assertEquals("[Coffee, Bagel, Filling]", result);
    }

    @Test
    void setItemsList() {
        Basket basket = new Basket();

        ArrayList<String> itemsList = new ArrayList<>();

        String testItem1 = "Coffee";
        String testItem2 = "Bagel";
        String testItem3 = "Coffee";

        itemsList.add(testItem1);
        itemsList.add(testItem2);
        itemsList.add(testItem3);

        basket.setItemsList(itemsList);

        String result = itemsList.toString();

        Assertions.assertEquals("[Coffee, Bagel, Coffee]", result);
    }

    @Test
    void getItemsMap() {

        Basket basket = new Basket();

        HashMap<String, Double> testMap = new HashMap<>();

        testMap.put("Bagel", 0.49);
        testMap.put("Coffee", 1.29);
        testMap.put("Filling", 0.12);

        basket.setItemsMap(testMap);

        String result = basket.getItemsMap().toString();

        Assertions.assertEquals("{Bagel=0.49, Filling=0.12, Coffee=1.29}", result);
    }

    @Test
    void setItemsMap() {

        Basket basket = new Basket();

        HashMap<String, Double> testMap = new HashMap<>();

        testMap.put("Bagel", 0.49);
        testMap.put("Coffee", 1.29);
        testMap.put("Filling", 0.12);

        basket.setItemsMap(testMap);

        String result = testMap.toString();

        Assertions.assertEquals("{Bagel=0.49, Filling=0.12, Coffee=1.29}", result);
    }

    @Test
    void getItemsFullyDetailed() {

        Basket basket = new Basket();

        HashMap<String, Inventory> testMap = new HashMap<>();

        testMap.put("BGLO", new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        testMap.put("COFB", new Inventory("COFB", 0.99, "Coffee", "Black"));
        testMap.put("FILC", new Inventory("FILC", 0.12, "Filling", "Cheese"));

        basket.setItemsFullyDetailed(testMap);

        String result = basket.getItemsFullyDetailed().toString();

        Assertions.assertEquals("{BGLO=Inventory{sku='BGLO', price=0.49, name='Bagel', variant='Onion'}," +
                " COFB=Inventory{sku='COFB', price=0.99, name='Coffee', variant='Black'}," +
                " FILC=Inventory{sku='FILC', price=0.12, name='Filling', variant='Cheese'}}", result);
    }

    @Test
    void setItemsFullyDetailed() {

        Basket basket = new Basket();

        HashMap<String, Inventory> testMap = new HashMap<>();

        testMap.put("BGLO", new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        testMap.put("COFB", new Inventory("COFB", 0.99, "Coffee", "Black"));
        testMap.put("FILC", new Inventory("FILC", 0.12, "Filling", "Cheese"));

        basket.setItemsFullyDetailed(testMap);

        String result = testMap.toString();

        Assertions.assertEquals("{BGLO=Inventory{sku='BGLO', price=0.49, name='Bagel', variant='Onion'}," +
                " COFB=Inventory{sku='COFB', price=0.99, name='Coffee', variant='Black'}," +
                " FILC=Inventory{sku='FILC', price=0.12, name='Filling', variant='Cheese'}}", result);
    }

    @Test
    void getItemsWithQuantity() {
        Basket basket = new Basket();
        HashMap<String, Double[]> testMap = new HashMap<>();
        testMap.put("Bagel", new Double[]{1.0, 0.49});
        testMap.put("Filling", new Double[]{3.0, 0.12});

        basket.setItemsWithQuantity(testMap);

        HashMap<String, Double[]> retrievedMap = basket.getItemsWithQuantity();

        Assertions.assertEquals(testMap, retrievedMap);
    }

    @Test
    void setItemsWithQuantity() {
        Basket basket = new Basket();

        HashMap<String, Double[]> testMap = new HashMap<>();
        testMap.put("Bagel", new Double[]{1.0, 0.49});
        testMap.put("Filling", new Double[]{3.0, 0.12});

        basket.setItemsWithQuantity(testMap);

        HashMap<String, Double[]> retrievedMap = basket.getItemsWithQuantity();

        Assertions.assertEquals(testMap, retrievedMap);
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
