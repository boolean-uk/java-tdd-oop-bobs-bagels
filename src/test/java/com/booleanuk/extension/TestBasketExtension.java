package com.booleanuk.extension;

import com.booleanuk.core.Manager;
import com.booleanuk.core.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBasketExtension {
    @Test
    public void testCheckout(){
        BasketExtension basket = new BasketExtension();
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

    @Test
    public void testCannotCheckoutEmptyBasket(){
        BasketExtension basket = new BasketExtension(new User());

        Assertions.assertFalse(basket.checkout());

        basket.add("BGLE");

        Assertions.assertTrue(basket.checkout());
    }

    @Test
    public void testExampleReceipt(){
        BasketExtension basket = new BasketExtension(new Manager());
        basket.updateCapacity(35);
        basket.add("BGLO");
        basket.add("BGLO");
        for (int i = 0; i < 12; i++){
            basket.add("BGLP");
        }
        for (int i = 0; i < 6; i++){
            basket.add("BGLE");
        }
        basket.add("COFB");
        basket.add("COFB");
        basket.add("COFB");
        basket.checkout();
    }

    @Test
    public void testDiscount(){
        BasketExtension basket = new BasketExtension(new Manager());
        basket.updateCapacity(35);

        for (int i = 0; i < 12; i++){
            basket.add("BGLS");
        }
        for (int i = 0; i < 6; i++){
            basket.add("BGLO");
        }

        Assertions.assertTrue(basket.applyDiscount());
    }
}
