package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Coffee;
import com.booleanuk.core.models.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BasketTest {

    // Models Tests run first!!


    @Test
    void addBagelTest() {
        Basket basket = new Basket();
        Bagel bagel1 = basket.invetory.getBagels().get(0);
        Bagel bagelError = new Bagel("Anything", 0.0, "ERROR");

        Assertions.assertFalse(basket.add(bagelError,1));
        Assertions.assertTrue(basket.add(bagel1,1));
        Assertions.assertEquals(1 ,basket.sizeOfBasket);
        Assertions.assertEquals(1, basket.bagelQuantity.get(0));
        Assertions.assertEquals(bagel1,basket.bagels.get(0));

        Bagel bagel2 = basket.invetory.getBagels().get(0);
        Filling fill =  new Filling("Bacon",0.12, "FILB");
        bagel2.setFillings(new ArrayList<>(Arrays.asList(fill)), basket.invetory);
        Assertions.assertTrue(basket.add(bagel2,1));
        Assertions.assertEquals(2, basket.sizeOfBasket);
        Assertions.assertEquals(2, basket.bagelQuantity.size());
        Assertions.assertEquals(bagel2,basket.bagels.get(1));

        Bagel bagel3 = new Bagel("Onion", 0.49, "BGLO");
        Assertions.assertTrue(basket.add(bagel2,1));
        Assertions.assertEquals(3 ,basket.sizeOfBasket);
        Assertions.assertEquals(2, basket.bagelQuantity.get(0));
    }

    @Test
    void addCoffeeTest() {
        Basket basket = new Basket();
        Coffee coffee1 = new Coffee("Black", 0.99, "COFB");
        Coffee coffeeError = new Coffee("Anything", 0.0, "ERROR");

        Assertions.assertFalse(basket.add(coffeeError,1));
        Assertions.assertTrue(basket.add(coffee1,1));
        Assertions.assertEquals(1 ,basket.sizeOfBasket);
        Assertions.assertEquals(1, basket.coffeeQuantity.get(0));
        Assertions.assertEquals(coffee1,basket.coffees.get(0));
    }
}
