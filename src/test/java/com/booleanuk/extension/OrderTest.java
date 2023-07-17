package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OrderTest {

    @Test
    public void shouldReturnBasketWithProducts() {
        Basket basket = new Basket(10);
        basket.add(new Bagel("BGL1", BigDecimal.ONE, "Bagel 1"));
        basket.add(new Bagel("BGL2", BigDecimal.TEN, "Bagel 2"));

        Order order = new Order(basket);
        Assertions.assertEquals(2, order.getBasket().getProducts().size());
    }


}
