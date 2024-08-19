package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.SKU;
import com.booleanuk.core.inherited.Bagel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTest {
    private Order order;

    @BeforeEach
    public void setUp() {
        this.order = new Order();
    }

    @Test
    public void testAddProductAddsABagelToTheBasket() {
        Basket basket = this.order.getBasket();
        basket.addProduct(new Bagel("Bagel", 0.49, SKU.BGLP, BagelType.ONION));
        Assertions.assertFalse(basket.getProducts().isEmpty());
    }
}
