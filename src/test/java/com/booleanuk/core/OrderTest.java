package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.exceptions.FullBasketException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {
    public Order order;

    @BeforeEach
    public void setUp() {
        this.order = new Order();
    }

    @Test
    public void testGetTotalReturnsDiscountOnSixBagels() throws FullBasketException {
        Basket basket = this.order.getBasket();
        basket.changeCapacity(6);

        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);
        basket.addProduct(BagelType.ONION);

        Double total = this.order.getTotalCost();
        Assertions.assertEquals(total, 2.49);
    }
}
