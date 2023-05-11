package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void testAdd() {
        Basket basket = new Basket();
        Invetory invetory = new Invetory();

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

    //    Bagel bagel2 = invetory.bagels.get(2);
    //        Bagel bagel3 = invetory.bagels.get(3);
    @Test
    void testRemove() {
        Basket basket = new Basket();
        Invetory invetory = new Invetory();
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
        Invetory invetory = new Invetory();
        Bagel bagel0 = invetory.bagels.get(0);
        Bagel bagel1 = invetory.bagels.get(1);
        Assertions.assertEquals(0.0, basket.total);
        basket.add(bagel0);
        Assertions.assertEquals(0.49, basket.total);
        basket.add(bagel0);
        Assertions.assertEquals(0.49 + 0.49, basket.total);
        basket.add(bagel1);
        Assertions.assertEquals(0.49 + 0.49 + 0.39, basket.total);
        basket.remove(bagel1);
        Assertions.assertEquals(0.49 + 0.49, basket.total);
        basket.remove(bagel0);
        Assertions.assertEquals(0.49, basket.total);
        //Check the Feels! Feel bad man...:(
        bagel1.addFillings(new Filling[]{invetory.fillings.get(0)});
        basket.add(bagel1);
        Assertions.assertEquals(0.49+0.12+0.39, basket.total);

    }
    @Test
    void testSetCapacity(){
        Basket basket = new Basket();
        Invetory invetory = new Invetory();
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
