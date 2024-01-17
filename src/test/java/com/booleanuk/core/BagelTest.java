package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {
    /* Test use case 1 */
    @Test
    public void testAddingItemToBasket(){
        Basket basket = new Basket(15);
        Assertions.assertTrue(basket.addItem("Coffee", "Black", 10));


    }

    /*  Test use case 2*/
    @Test
    public void testRemovingItemFromBasket(){
        Basket basket = new Basket(15);
        basket.addItem("Coffee", "Black", 1);
        Assertions.assertTrue(basket.removeItem("Coffee", "Black"));
    }

    /* Test use case 3 */
    @Test
    public void testAddingOverMaxCapacity(){
        Basket basket = new Basket(2);
        basket.addItem("Coffee", "Black", 1);
        basket.addItem("Filling", "Bacon", 1);
        Assertions.assertFalse(basket.addItem("Bagel", "Onion", 1));
    }

    /* Test use case 4 */
    @Test
    public void testChangingBasketCapacity(){
        Shop shop = new Shop();
        shop.createBasket();
        shop.getAllBaskets().get(0).addItem("Coffee", "Black", 5);
        Assertions.assertFalse(shop.changeMaxCapacity(2));


    }
}
