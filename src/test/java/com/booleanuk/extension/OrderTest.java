package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static com.booleanuk.extension.SKU.BGLO;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @Test
    public void testGettingTotalPriceOfOrder() {
        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);
        basket.addItem(new Bagel(BGLO));
        basket.addItem(new Bagel(BGLO));

        UUID id = store.placeOrder(basket);
        Order order = store.getOrder(id);

        assertEquals(BigDecimal.valueOf(0.98), order.getTotalPrice());
    }
}
