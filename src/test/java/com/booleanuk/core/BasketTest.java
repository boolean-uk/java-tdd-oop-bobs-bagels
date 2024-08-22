package com.booleanuk.core;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {
  @Test
  public void testAddProduct() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.ONION, Optional.empty()));
    Assertions.assertEquals(0.49, basket.price());

    basket.add(new Coffee(CoffeeType.BLACK));
    // Bagel + coffee is discounted to 1.25
    Assertions.assertEquals(1.25, basket.price());
  }

  @Test
  public void testAddMultipleProducts() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.ONION, Optional.empty()), 4);
    Assertions.assertEquals(0.49 * 4, basket.price());

    basket.add(new Coffee(CoffeeType.BLACK), 2);
    Assertions.assertEquals((1.25 * 2) + (0.49 * 2), basket.price(), 0.0001);
  }

  @Test
  public void testRemoveProduct() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.ONION, Optional.empty()));
    basket.add(new Bagel(BagelType.ONION, Optional.empty()));
    basket.add(new Bagel(BagelType.PLAIN, Optional.empty()));
    basket.add(new Coffee(CoffeeType.BLACK));

    Assertions.assertDoesNotThrow(() -> basket.remove(Sku.BGLO));
    Assertions.assertDoesNotThrow(() -> basket.remove(Sku.BGLO));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(Sku.BGLO));
    Assertions.assertDoesNotThrow(() -> basket.remove(Sku.BGLP));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(Sku.BGLO));
    Assertions.assertDoesNotThrow(() -> basket.remove(Sku.COFB));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(Sku.BGLO));
  }

  @Test
  public void testRemoveMultipleProducts() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.ONION, Optional.empty()));
    basket.add(new Bagel(BagelType.ONION, Optional.empty()));
    basket.add(new Bagel(BagelType.PLAIN, Optional.empty()));
    basket.add(new Coffee(CoffeeType.BLACK));

    Assertions.assertDoesNotThrow(() -> basket.remove(Sku.BGLO, 2));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(Sku.BGLO, 1));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(Sku.COFB, 2));
  }

  @Test
  public void testBasketCapacity() {
    Basket basket = new Basket(5);

    Assertions.assertDoesNotThrow(() -> basket.add(new Bagel(BagelType.ONION, Optional.empty())));
    Assertions.assertDoesNotThrow(() -> basket.add(new Bagel(BagelType.PLAIN, Optional.empty())));
    Assertions.assertDoesNotThrow(() -> basket.add(new Coffee(CoffeeType.BLACK)));
    Assertions.assertDoesNotThrow(() -> basket.add(new Coffee(CoffeeType.CAPUCCINO)));
    Assertions.assertDoesNotThrow(() -> basket.add(new Coffee(CoffeeType.WHITE)));

    Assertions.assertThrows(AddToFullBasketException.class,
        () -> basket.add(new Bagel(BagelType.EVERYTHING, Optional.empty())));
    basket.setCapacity(10);
    Assertions.assertDoesNotThrow(() -> basket.add(new Bagel(BagelType.EVERYTHING, Optional.empty())));
  }

  @Test
  public void testTwelveBagelDiscount() {
    Basket twelveBagelBasket = new Basket(12);
    twelveBagelBasket.add(new Bagel(BagelType.EVERYTHING, Optional.empty()), 12);
    Assertions.assertEquals(3.99, twelveBagelBasket.price());
  }

  @Test
  public void testSixBagelDiscount() {
    Basket sixBagelBasket = new Basket();
    sixBagelBasket.add(new Bagel(BagelType.ONION, Optional.empty()), 6);
    Assertions.assertEquals(2.49, sixBagelBasket.price());
  }

  @Test
  public void testCoffeeAndBagelDiscount() {
    Basket coffeeAndBagelBasket = new Basket();
    coffeeAndBagelBasket.add(new Bagel(BagelType.PLAIN, Optional.empty()));
    coffeeAndBagelBasket.add(new Coffee(CoffeeType.BLACK));
    Assertions.assertEquals(1.25, coffeeAndBagelBasket.price());
  }

  @Test
  public void testManyDiscounts() {
    Basket basket = new Basket(30);
    basket.add(new Bagel(BagelType.ONION, Optional.empty()), 2);
    basket.add(new Bagel(BagelType.PLAIN, Optional.empty()), 12);
    basket.add(new Bagel(BagelType.EVERYTHING, Optional.empty()), 6);
    basket.add(new Coffee(CoffeeType.BLACK), 3);

    Assertions.assertEquals(9.97, basket.price());
  }
}
