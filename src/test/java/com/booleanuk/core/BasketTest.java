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

    Assertions.assertDoesNotThrow(() -> basket.remove(BagelType.Onion));
    Assertions.assertDoesNotThrow(() -> basket.remove(BagelType.Onion));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(BagelType.Onion));
    Assertions.assertDoesNotThrow(() -> basket.remove(BagelType.Plain));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(BagelType.Plain));
    Assertions.assertDoesNotThrow(() -> basket.remove(CoffeeType.Black));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(CoffeeType.Black));
  }

  @Test
  public void testRemoveMultipleProducts() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.Onion));
    basket.add(new Bagel(BagelType.Onion));
    basket.add(new Bagel(BagelType.Plain));
    basket.add(new Coffee(CoffeeType.Black));

    Assertions.assertDoesNotThrow(() -> basket.remove(BagelType.Onion, 2));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(BagelType.Onion, 1));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(CoffeeType.Black, 2));
  }
}
