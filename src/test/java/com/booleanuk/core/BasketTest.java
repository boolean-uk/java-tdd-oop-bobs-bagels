package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {
  @Test
  public void testAddProduct() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.Onion));
    Assertions.assertEquals(0.49, basket.price());

    basket.add(new Coffee(CoffeeType.Black));
    Assertions.assertEquals(0.49 + 0.99, basket.price());
  }
}
