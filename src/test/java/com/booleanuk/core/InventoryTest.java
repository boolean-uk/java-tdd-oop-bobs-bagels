package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InventoryTest {
  @Test
  public void testInventoryRemoveBasket() {
    List<Product> inventoryStock = new ArrayList<>();
    inventoryStock.add(new Coffee(CoffeeType.BLACK));
    inventoryStock.add(new Coffee(CoffeeType.WHITE));
    inventoryStock.add(new Bagel(BagelType.EVERYTHING));

    Inventory inventory = new Inventory(inventoryStock);

    Basket basket = new Basket();
    basket.add(new Coffee(CoffeeType.BLACK));
    basket.add(new Bagel(BagelType.EVERYTHING));
    Assertions.assertDoesNotThrow(() -> inventory.remove(basket));
  }

  @Test
  public void testInventoryRemoveOverfilledBasket() {
    List<Product> inventoryStock = new ArrayList<>();
    inventoryStock.add(new Coffee(CoffeeType.BLACK));

    Inventory inventory = new Inventory(inventoryStock);

    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.EVERYTHING));
    Assertions.assertThrows(NotInStockException.class, () -> inventory.remove(basket));
  }
}
