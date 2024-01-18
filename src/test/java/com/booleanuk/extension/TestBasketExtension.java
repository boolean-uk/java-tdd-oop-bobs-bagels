package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBasketExtension {
    @Test
    public void testCheckout(){
        BasketExtension basket = new BasketExtension(new User());
        basket.add("COFB");
        basket.add("COFB");
        basket.add("BGLS");
        basket.add("BGLS");
        basket.add("BGLS");
        basket.add("BGLP");
        basket.add("FILX");
        basket.add("FILS");
        basket.checkout();

        Assertions.assertTrue(basket.getProducts().isEmpty());
        Assertions.assertEquals(0, basket.getItems());
    }
}
