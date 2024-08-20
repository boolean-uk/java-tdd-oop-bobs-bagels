

package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOrderManager {

    @Test
    public void testOrderManagerConstr(){
        OrderManager om = new OrderManager();
    }

    @Test
    public void testaddItem(){
        OrderManager om = new OrderManager();
        String result = om.addItem(BagelType.Onion);
        Assertions.assertEquals("Onion: 1", result);


        result = om.addItem(CoffeeType.Cappuccino);
        Assertions.assertEquals("Cappuccino: 1", result);


        result = om.addItem(CoffeeType.Cappuccino);
        Assertions.assertEquals("Cappuccino: 2", result);

        for (int i = 0; i < OrderManager.getMaxFillings(); i++) {
            result = om.addItem(FillingType.Bacon);
            Assertions.assertEquals("Bacon: " + (i+1), result);
        }

        result = om.addItem(FillingType.Bacon);
        Assertions.assertEquals("Item not in stock.", result);
    }

    @Test
    public void testGetPrice(){ // core
        OrderManager om = new OrderManager();
        om.addItem(BagelType.Onion);
        om.addItem(BagelType.Onion);
        om.addItem(BagelType.Onion);

        double pricePerOnion = 0.49;
        double expectedPrice = 3* pricePerOnion;
        Assertions.assertEquals(expectedPrice, om.getPrice());

        om.addItem(CoffeeType.Cappuccino);
        double pricePerCappuccino = 1.29;
        expectedPrice += pricePerCappuccino;
        Assertions.assertEquals(expectedPrice, om.getPrice());

        om.addItem(CoffeeType.Cappuccino);
        om.addItem(CoffeeType.Cappuccino);
        expectedPrice += pricePerCappuccino*2;
        Assertions.assertEquals(expectedPrice, om.getPrice());
    }

    @Test
    public void testRemoveItem(){
        OrderManager om = new OrderManager();
        String result;
        result = om.removeItem(BagelType.Onion);
        Assertions.assertEquals("Onion is not in cart.", result);

        Assertions.assertEquals(20, OrderManager.getMaxBagels());
        om.addItem(BagelType.Onion);
        result = om.removeItem(BagelType.Onion);
        Assertions.assertEquals("Removed Onion from cart.", result);



    }

}
