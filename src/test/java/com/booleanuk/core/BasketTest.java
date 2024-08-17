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

  @Test
  public void testRemoveProduct() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.Onion));
    basket.add(new Bagel(BagelType.Onion));
    basket.add(new Bagel(BagelType.Plain));
    basket.add(new Coffee(CoffeeType.Black));

    Assertions.assertDoesNotThrow(() -> basket.remove("BGLO"));
    Assertions.assertDoesNotThrow(() -> basket.remove("BGLO"));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove("BGLO"));
    Assertions.assertDoesNotThrow(() -> basket.remove("BGLP"));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove("BGLO"));
    Assertions.assertDoesNotThrow(() -> basket.remove("COFB"));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove("BGLO"));
  }

  @Test
  public void testRemoveMultipleProducts() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.Onion));
    basket.add(new Bagel(BagelType.Onion));
    basket.add(new Bagel(BagelType.Plain));
    basket.add(new Coffee(CoffeeType.Black));

    Assertions.assertDoesNotThrow(() -> basket.remove("BGLO", 2));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove("BGLO", 1));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove("COFB", 2));
  }
}
