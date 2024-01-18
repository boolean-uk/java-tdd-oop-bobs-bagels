package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BagelTest {
    /* Test use case 1 */
    @Test
    public void testAddingItemToBasket(){
        Basket basket = new Basket(15);
        Assertions.assertTrue(basket.addItem("COFB", 10));


    }

    /*  Test use case 2*/
    @Test
    public void testRemovingItemFromBasket(){
        Basket basket = new Basket(15);
        basket.addItem("COFB", 1);
        Assertions.assertTrue(basket.removeItem("COFB"));
    }

    /* Test use case 3 */
    @Test
    public void testAddingOverMaxCapacity(){
        Basket basket = new Basket(2);
        basket.addItem("COFB", 1);
        basket.addItem("FILB", 1);
        Assertions.assertFalse(basket.addItem("BGLO", 1));
    }

    /* Test use case 4 */
    @Test
    public void testChangingBasketCapacity(){
        Shop shop = new Shop();
        shop.createBasket();
        shop.getAllBaskets().get(0).addItem("COFB", 5);
        Assertions.assertFalse(shop.changeMaxCapacity(2));


    }
    /* Test use case 5 */
    @Test
    public void testRemovingItemFromBasketThatDoesNotExist(){
        Basket basket = new Basket(20);
        Assertions.assertFalse(basket.removeItem("COFB"));
    }

    /* Test use case 6 */
    @Test
    public void testGetTotalCostOfBasket(){
        Basket basket = new Basket(20);
        basket.addItem("COFB", 3);
        basket.addItem("BGLO", 3);
        Assertions.assertEquals(4.44, basket.getTotalCost());
    }
    /* Test use case 7 */
    @Test
    public void testGetPriceOfSpecificItem(){
        Assertions.assertEquals("0.99", Inventory.getInstance().getPriceInfo("COFB"));
    }

    /* Test use case 8 */
    @Test
    public void testAddFillingsToBagel(){
        Basket basket = new Basket(3);
        ArrayList<String> fillingsTest = new ArrayList<>();
        fillingsTest.add("FILB");
        fillingsTest.add("FILC");
        Assertions.assertTrue(basket.addFillingWithBagel("BGLO", fillingsTest));
    }

}
