

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
    }

}
