package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    Invetory invetory = new Invetory();

    @Test
    void testAddWithMultiplyQuality(){
        Basket basket = new Basket();
        Bagel bagel0 = invetory.bagels.get(0);
        basket.setCapacity(10);
        Assertions.assertTrue(basket.add(bagel0,4));
        Assertions.assertEquals(4,basket.sizeOfBasket);
        Assertions.assertEquals(1,basket.shoppingBasket.size());
    }
    @Test
    void testTotalWithDiscount(){
        Basket basket = new Basket();
        basket.setCapacity(50);
        basket.add(invetory.bagels.get(1), 16);
        Assertions.assertEquals(5.55,basket.total);
        basket.add(invetory.bagels.get(0));
        Assertions.assertEquals(6.04,basket.total);
        basket.add(invetory.bagels.get(0));
        Assertions.assertEquals(6.53,basket.total);
        basket.add(invetory.bagels.get(0),4);
        Assertions.assertEquals(8.04,basket.total);



    }
    @Test
    void testTotalWithDiscountAndFillings(){
        Basket basket = new Basket();
        basket.setCapacity(50);
        Bagel bagel =invetory.bagels.get(1);
        bagel.addFillings(new Filling[]{invetory.fillings.get(0)});
        basket.add(bagel, 16);
        Assertions.assertEquals(7.47,basket.total);
        basket.add(invetory.bagels.get(0), 1);
        Assertions.assertEquals(7.96,basket.total);


    }
    @Test
    void testRemoveWithMultiplyQuality(){
        Basket basket = new Basket();
        basket.setCapacity(50);

        Bagel bagel1 = invetory.bagels.get(1);
        basket.add(bagel1,16);
        // check if bagel is in HashMap
        Assertions.assertFalse(basket.remove(new Bagel("new", 0, "SKU"),1));
        Assertions.assertFalse(basket.remove(bagel1,17));

        basket.remove(bagel1,4);
        Assertions.assertEquals(12,basket.sizeOfBasket);
    }
    @Test
    void testTotalWithDiscountRemovingBagels(){
        Basket basket = new Basket();
        basket.setCapacity(50);

        Bagel bagel1 = invetory.bagels.get(1);
        basket.add(bagel1,16);
        Assertions.assertEquals(5.55,basket.total);
        basket.remove(bagel1,4);
        Assertions.assertEquals(3.99,basket.total);
        basket.remove(bagel1,1);
        Assertions.assertEquals(4.44,basket.total);
        basket.remove(bagel1,11);
        Assertions.assertEquals(0.0,basket.total);



    }

    @Test
    public void testAddSingleEntry() {
        Basket basket = new Basket();
        //Bagels From  Inventory!
        Bagel bagel0 = invetory.bagels.get(0);
        Bagel bagel1 = invetory.bagels.get(1);

        Assertions.assertTrue(basket.add(bagel0));
        Assertions.assertEquals(1, basket.shoppingBasket.size());
        Assertions.assertEquals(1, basket.sizeOfBasket);
        Assertions.assertTrue(basket.add(bagel1));
        Assertions.assertEquals(2, basket.shoppingBasket.size());
        Assertions.assertEquals(2, basket.sizeOfBasket);
        Assertions.assertTrue(basket.add(bagel0));
        Assertions.assertEquals(2, basket.shoppingBasket.size());
        Assertions.assertEquals(3, basket.sizeOfBasket);
        // Check if size Over Capacity and throw Flag False!
        Assertions.assertFalse(basket.add(bagel0));

    }
    @Test
    void testRemove() {
        Basket basket = new Basket();
        Bagel bagel0 = invetory.bagels.get(0);
        Bagel bagel1 = invetory.bagels.get(1);
        basket.add(bagel0);
        basket.add(bagel0);
        basket.add(bagel1);
        // check if bagel is in HashMap
        Assertions.assertFalse(basket.remove(new Bagel("new", 0, "SKU")));
        Assertions.assertTrue(basket.remove(bagel0));
        Assertions.assertEquals(2, basket.sizeOfBasket);
        Assertions.assertEquals(2, basket.shoppingBasket.size());
        basket.remove(bagel1);
        Assertions.assertEquals(1, basket.shoppingBasket.size());
    }

    @Test
    void testTotal() {
        Basket basket = new Basket();
        Bagel bagel0 = invetory.bagels.get(0);
        Bagel bagel1 = invetory.bagels.get(1);
        Assertions.assertEquals(0.0, basket.total);
        basket.add(bagel0);
        Assertions.assertEquals(0.49, basket.total);
        basket.add(bagel0);
        Assertions.assertEquals(0.98, basket.total);
        basket.remove(bagel0);
        Assertions.assertEquals(0.49, basket.total);



    }
    @Test
    void testSetCapacity(){
        Basket basket = new Basket();
        Bagel bagel0 = invetory.bagels.get(0);
        Bagel bagel1 = invetory.bagels.get(1);
        Bagel bagel2 = invetory.bagels.get(2);
        Assertions.assertFalse(basket.setCapacity(0));
        basket.add(bagel0);
        basket.add(bagel1);
        basket.add(bagel2);
        Assertions.assertFalse(basket.setCapacity(2));
        Assertions.assertTrue(basket.setCapacity(5));


    }

}
