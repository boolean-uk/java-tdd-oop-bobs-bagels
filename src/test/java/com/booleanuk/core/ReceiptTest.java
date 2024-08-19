package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReceiptTest {
  @Test
  public void testSimpleReceipt() {
    List<Product> inventoryStock = new ArrayList<>();
    inventoryStock.add(new Coffee(CoffeeType.BLACK));
    inventoryStock.add(new Coffee(CoffeeType.WHITE));
    inventoryStock.add(new Bagel(BagelType.ONION));
    Inventory inventory = new Inventory(inventoryStock);

    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.ONION));
    basket.add(new Coffee(CoffeeType.BLACK));

    // Receipt receipt = inventory.purchase(basket);
    String expected = "~~~ Bob's Bagels ~~~" +
        "---------------------------------" +
        "Onion bagel | 1 | " +
        "---------------------------------";
  }
}
