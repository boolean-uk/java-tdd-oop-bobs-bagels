package com.booleanuk.extension;

import com.booleanuk.core.BasketItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketItemExTest {

    @Test
    public void testBasketItem() {
        BasketItemEx basketItem1 = new BasketItemEx("scissors",2, 1.28);
        BasketItemEx basketItem2 = new BasketItemEx("battery",1, 3.5);

        Assertions.assertEquals("scissors", basketItem1.getItem());
        Assertions.assertEquals(3.5, basketItem2.getPrice());
        Assertions.assertEquals(2, basketItem1.getQuantity());

        basketItem2.setQuantity(5);
        Assertions.assertEquals(5, basketItem2.getQuantity());
    }


}
