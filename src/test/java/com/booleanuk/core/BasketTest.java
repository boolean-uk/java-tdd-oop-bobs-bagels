package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasketTest {

    public void addTenItemsToBasket(Basket basket) {
        Bagel b1 = ItemFactory.bagelFactory("BGLO");
        Bagel b2 = ItemFactory.bagelFactory("BGLO");
        Bagel b3 = ItemFactory.bagelFactory("BGLO");
        Bagel b4 = ItemFactory.bagelFactory("BGLO");
        Bagel b5 = ItemFactory.bagelFactory("BGLO");
        Bagel b6 = ItemFactory.bagelFactory("BGLO");
        Bagel b7 = ItemFactory.bagelFactory("BGLO");
        Bagel b8 = ItemFactory.bagelFactory("BGLO");
        Bagel b9 = ItemFactory.bagelFactory("BGLO");
        Bagel b10 = ItemFactory.bagelFactory("BGLO");
        basket.addItemToBasket(b1);
        basket.addItemToBasket(b2);
        basket.addItemToBasket(b3);
        basket.addItemToBasket(b4);
        basket.addItemToBasket(b5);
        basket.addItemToBasket(b6);
        basket.addItemToBasket(b7);
        basket.addItemToBasket(b8);
        basket.addItemToBasket(b9);
        basket.addItemToBasket(b10);
    }

    @Test
    public void createBasketTest() {
        Basket basket = new Basket();

        Assertions.assertEquals(0, basket.countTotalItems());
    }

    @Test
    public void addBagelAndCoffeeAndFillingToBasketTest() {
        Basket basket = new Basket();
        Bagel bagel = ItemFactory.bagelFactory("BGLO");
        Bagel bagel2 =ItemFactory.bagelFactory("BGLO");
        Coffee coffee = ItemFactory.coffeeFactory("COFB");
        Filling filling = ItemFactory.fillingFactory("FILH");
        basket.addItemToBasket(bagel);
        basket.addItemToBasket(coffee);
        basket.addItemToBasket(filling);


        //Populate a reference list
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(bagel);
        itemList.add(coffee);
        itemList.add(filling);

        for (int i = 0; i < basket.countTotalItems(); i++) {
            Assertions.assertEquals(1, basket.checkAllItems().get(itemList.get(i).getSKU()));
        }
    }

    @Test
    public void addMultipleBagelsTest() {
        Basket basket = new Basket();
        Bagel bagel = ItemFactory.bagelFactory("BGLO");
        Bagel bagel2 = ItemFactory.bagelFactory("BGLO");
        basket.addItemToBasket(bagel);
        basket.addItemToBasket(bagel2);


        //Populate a reference list
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(bagel);
        itemList.add(bagel2);

        for (int i = 0; i < basket.countTotalItems(); i++) {
            Assertions.assertEquals(2, basket.checkAllItems().get(itemList.get(i).getSKU()));
        }
    }

    @Test
    public void addFillingToBagelTest() {
        Basket basket = new Basket();
        Bagel bagel = ItemFactory.bagelFactory("BGLO");
        Filling filling = ItemFactory.fillingFactory("FILX");

        bagel.addFilling(filling);
        basket.addItemToBasket(bagel);

        Assertions.assertEquals(2, basket.countTotalItems());

        Assertions.assertEquals(1, basket.getItemQuantityFromSKU(bagel.getSKU()));

    }

    @Test
    public void calculateTotalValueOfBasketTest() {
        Basket basket = new Basket();
        Bagel bagel = ItemFactory.bagelFactory("BGLO");
        Filling filling = ItemFactory.fillingFactory("FILX");
        Bagel bagel2 = ItemFactory.bagelFactory("BGLP");

        bagel.addFilling(filling);
        basket.addItemToBasket(bagel);

        Assertions.assertEquals(2, basket.countTotalItems());

        Assertions.assertEquals(0.61, basket.countTotalValueOfItems());

        basket.addItemToBasket(bagel2);

        Assertions.assertEquals(1.0, basket.countTotalValueOfItems());
    }

    @Test
    public void removeItemFromBasketTest() {
        Basket basket = new Basket();
        Bagel bagel = ItemFactory.bagelFactory("BGLO");
        Filling filling = ItemFactory.fillingFactory("FILX");
        Bagel bagel2 = ItemFactory.bagelFactory("BGLP");
        bagel.addFilling(filling);
        basket.addItemToBasket(bagel);
        basket.addItemToBasket(bagel2);

        Assertions.assertEquals(3, basket.countTotalItems());

        basket.removeItemFromBasket(bagel);
        basket.removeItemFromBasket(bagel2);

        Assertions.assertEquals(0, basket.countTotalItems());
    }

    @Test
    public void removeOneOfTwoBagelsTest() {
        Basket basket = new Basket();

        Bagel bagel = ItemFactory.bagelFactory("BGLO");
        Filling filling = ItemFactory.fillingFactory("FILX");
        Bagel bagel2 = ItemFactory.bagelFactory("BGLO");
        Filling filling2 = ItemFactory.fillingFactory("FILH");

        basket.addItemToBasket(bagel, filling);
        basket.addItemToBasket(bagel2, filling2);

        Assertions.assertEquals(4, basket.countTotalItems());

        Assertions.assertEquals("Bagel with filling " + bagel.getFilling().getName() + " is removed.", basket.removeItemFromBasket(bagel));

        Assertions.assertEquals(2, basket.countTotalItems());
    }

    @Test
    public void addMoreThanCapacity() {
        Basket basket = new Basket();
        addTenItemsToBasket(basket);
        Bagel b1 = ItemFactory.bagelFactory("BGLO");
        Filling f1 = ItemFactory.fillingFactory("FILX");


        Assertions.assertEquals(10, basket.countTotalItems());

        Assertions.assertEquals( "Basket is full.", basket.addItemToBasket(b1, f1));

        Assertions.assertEquals(10, basket.countTotalItems());
    }

    @Test
    public void addBagelWithFillingWithNineItemsInBasketTest() {
        Basket basket = new Basket();
        Bagel b1 = ItemFactory.bagelFactory("BGLO");
        Bagel b2 = ItemFactory.bagelFactory("BGLO");
        Bagel b3 = ItemFactory.bagelFactory("BGLO");
        Bagel b4 = ItemFactory.bagelFactory("BGLO");
        Bagel b5 = ItemFactory.bagelFactory("BGLO");
        Filling f1 = ItemFactory.fillingFactory("FILX");
        Filling f2 = ItemFactory.fillingFactory("FILX");
        Filling f3 = ItemFactory.fillingFactory("FILX");
        Filling f4 = ItemFactory.fillingFactory("FILX");
        
        basket.addItemToBasket(b1, f1);
        basket.addItemToBasket(b2, f2);
        basket.addItemToBasket(b3, f3);
        basket.addItemToBasket(b4, f4);
        basket.addItemToBasket(b5);

        Assertions.assertEquals(9, basket.countTotalItems());

        basket.printOutHashMap();

        Assertions.assertEquals( "Basket is full.", basket.addItemToBasket(b1, f1));
    }

    @Test
    public void increaseTheBasketCapacityTest() {
        Basket basket = new Basket();
        addTenItemsToBasket(basket);
        Bagel b11 = ItemFactory.bagelFactory("BGLE");
        Assertions.assertEquals("Basket is full.", basket.addItemToBasket(b11));

        basket.increaseBasketSize(2);

        Assertions.assertEquals(12, basket.getMaxCapacity());

        basket.addItemToBasket(ItemFactory.bagelFactory("BGLE"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLE"));

        Assertions.assertEquals(12, basket.countTotalItems());
    }

    @Test
    public void tryToRemoveNonExistingItemFromBasket() {
        Basket basket = new Basket();
        addTenItemsToBasket(basket);

        Assertions.assertFalse(basket.removeItemFromBasket("EEEE"));
        Assertions.assertTrue(basket.removeItemFromBasket("BGLO"));
    }

    @Test
    public void checkThePriceOfABagelTest() {
        Basket basket = new Basket();
        Bagel bagel = ItemFactory.bagelFactory("BGLO");

        Assertions.assertEquals(0.49, bagel.getPrice());
    }

    @Test
    public void checkEveryFillingPrice() {
        Basket basket = new Basket();
        HashMap<String, Double> referenceList = new HashMap<>();
        referenceList.put("FILB", 0.12);
        referenceList.put("FILE", 0.12);
        referenceList.put("FILC", 0.12);
        referenceList.put("FILX", 0.12);
        referenceList.put("FILS", 0.12);
        referenceList.put("FILH", 0.12);

        Assertions.assertEquals(referenceList, basket.getFillingPriceList());

        for (Map.Entry<String, Double> entry : basket.getFillingPriceList().entrySet()) {
            Assertions.assertEquals(referenceList.get(entry.getKey()), entry.getValue());
        }
    }

    @Test
    public void tryToAddItemThatDoesNotExistTest() {
        Basket basket = new Basket();

        Bagel bagel = ItemFactory.bagelFactory("EEEE");

        Assertions.assertEquals("This item does not exist.", basket.addItemToBasket(bagel));

        Bagel bagel1 = ItemFactory.bagelWithFillingFactory("EEEE", "KKKK");

        Assertions.assertEquals("This item does not exist.", basket.addItemToBasket(bagel1));
    }

    @Test
    public void tryToAddBagelWithFilling() {
        Basket basket = new Basket();

        Bagel bagelWithFilling = ItemFactory.bagelWithFillingFactory("BGLE", "FILE");

        basket.addItemToBasket(bagelWithFilling);

        Assertions.assertEquals(2, basket.countTotalItems());

        Bagel bagelWithFilling2 = ItemFactory.bagelWithFillingFactory("BGLP", "FILS");

        basket.addItemToBasket(bagelWithFilling2);

        Assertions.assertEquals(4, basket.countTotalItems());
    }


    @Test
    public void tryToAddCoffeeAsFillingForBagelTest() {
        Basket basket = new Basket();

        Bagel bagelWithFilling = ItemFactory.bagelWithFillingFactory("BGLE", "COFB");

        basket.addItemToBasket(bagelWithFilling);

        Assertions.assertEquals(0, basket.countTotalItems());
    }
}
