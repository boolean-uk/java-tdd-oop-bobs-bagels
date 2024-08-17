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

  @Test
  public void testBasketCapacity() {
    Basket basket = new Basket(5);

    Assertions.assertDoesNotThrow(() -> basket.add(new Bagel(BagelType.Onion)));
    Assertions.assertDoesNotThrow(() -> basket.add(new Bagel(BagelType.Plain)));
    Assertions.assertDoesNotThrow(() -> basket.add(new Coffee(CoffeeType.Black)));
    Assertions.assertDoesNotThrow(() -> basket.add(new Coffee(CoffeeType.Capuccino)));
    Assertions.assertDoesNotThrow(() -> basket.add(new Coffee(CoffeeType.White)));

    Assertions.assertThrows(AddToFullBasketException.class, () -> basket.add(new Bagel(BagelType.Everything)));
    basket.setCapacity(10);
    Assertions.assertDoesNotThrow(() -> basket.add(new Bagel(BagelType.Everything)));
  }
}
