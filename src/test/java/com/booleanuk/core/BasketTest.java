package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasketTest {
  @Test
  public void testAddProduct() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.ONION));
    Assertions.assertEquals(0.49, basket.price());

    basket.add(new Coffee(CoffeeType.BLACK));
    Assertions.assertEquals(0.49 + 0.99, basket.price());
  }

  @Test
  public void testAddMultipleProducts() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.ONION), 4);
    Assertions.assertEquals(0.49 * 4, basket.price());

    basket.add(new Coffee(CoffeeType.BLACK), 2);
    Assertions.assertEquals((0.49 * 4) + (0.99 * 2), basket.price());
  }

  @Test
  public void testRemoveProduct() {
    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.ONION));
    basket.add(new Bagel(BagelType.ONION));
    basket.add(new Bagel(BagelType.PLAIN));
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
    basket.add(new Bagel(BagelType.ONION));
    basket.add(new Bagel(BagelType.ONION));
    basket.add(new Bagel(BagelType.PLAIN));
    basket.add(new Coffee(CoffeeType.BLACK));

    Assertions.assertDoesNotThrow(() -> basket.remove(Sku.BGLO, 2));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(Sku.BGLO, 1));
    Assertions.assertThrows(NotPresentInBasketException.class, () -> basket.remove(Sku.COFB, 2));
  }

  @Test
  public void testBasketCapacity() {
    Basket basket = new Basket(5);

    Assertions.assertDoesNotThrow(() -> basket.add(new Bagel(BagelType.ONION)));
    Assertions.assertDoesNotThrow(() -> basket.add(new Bagel(BagelType.PLAIN)));
    Assertions.assertDoesNotThrow(() -> basket.add(new Coffee(CoffeeType.BLACK)));
    Assertions.assertDoesNotThrow(() -> basket.add(new Coffee(CoffeeType.CAPUCCINO)));
    Assertions.assertDoesNotThrow(() -> basket.add(new Coffee(CoffeeType.WHITE)));

    Assertions.assertThrows(AddToFullBasketException.class, () -> basket.add(new Bagel(BagelType.EVERYTHING)));
    basket.setCapacity(10);
    Assertions.assertDoesNotThrow(() -> basket.add(new Bagel(BagelType.EVERYTHING)));
  }

  @Test
  public void testDiscounts() {
    Basket sixBagelBasket = new Basket();
    sixBagelBasket.add(new Bagel(BagelType.ONION), 6);
    Assertions.assertEquals(2.49, sixBagelBasket.price());

    Basket twelveBagelBasket = new Basket();
    twelveBagelBasket.add(new Bagel(BagelType.PLAIN), 12);
    Assertions.assertEquals(3.99, sixBagelBasket.price());

    Basket coffeeAndBagelBasket = new Basket();
    twelveBagelBasket.add(new Bagel(BagelType.PLAIN));
    twelveBagelBasket.add(new Coffee(CoffeeType.BLACK));
    Assertions.assertEquals(1.25, coffeeAndBagelBasket.price());
  }
}
