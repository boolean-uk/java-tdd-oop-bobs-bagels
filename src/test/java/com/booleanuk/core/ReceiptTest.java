package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
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
    basket.add(new Coffee(CoffeeType.BLACK));
    basket.add(new Coffee(CoffeeType.WHITE));
    basket.add(new Bagel(BagelType.ONION));

    Receipt receipt = inventory.purchase(basket);
    String expected = "~~~ Bob's Bagels ~~~\n" +
        "----------------------\n" +
        "1x Black coffee 0.99\n" +
        "1x White coffee 1.19\n" +
        "1x Onion bagel 0.49\n" +
        "----------------------";
    Assertions.assertEquals(expected, receipt.toString());
  }

  @Test
  public void testReceiptWithSameItems() {
    List<Product> inventoryStock = new ArrayList<>();
    inventoryStock.add(new Coffee(CoffeeType.BLACK));
    inventoryStock.add(new Coffee(CoffeeType.BLACK));
    inventoryStock.add(new Coffee(CoffeeType.BLACK));
    Inventory inventory = new Inventory(inventoryStock);

    Basket basket = new Basket();
    basket.add(new Coffee(CoffeeType.BLACK));
    basket.add(new Coffee(CoffeeType.BLACK));
    basket.add(new Coffee(CoffeeType.BLACK));

    Receipt receipt = inventory.purchase(basket);
    String expected = "~~~ Bob's Bagels ~~~\n" +
        "----------------------\n" +
        "3x Black coffee 2.97\n" +
        "----------------------";
    Assertions.assertEquals(expected, receipt.toString());
  }
}
