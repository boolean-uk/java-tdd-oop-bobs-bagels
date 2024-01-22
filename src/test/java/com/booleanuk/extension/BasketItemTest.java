package com.booleanuk.extension;

import com.booleanuk.core.BasketItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketItemTest {

    @Test
    public void testBasketItem() {
        BasketItem basketItem1 = new BasketItem("scissors", "hand",2, 1.28);
        BasketItem basketItem2 = new BasketItem("battery", "lithium",1, 3.5);

        Assertions.assertEquals("scissors", basketItem1.getName());
        Assertions.assertEquals(3.5, basketItem2.getPrice());
        Assertions.assertEquals(2, basketItem1.getQuantity());

        basketItem2.setQuantity(5);
        Assertions.assertEquals(5, basketItem2.getQuantity());
    }


}
