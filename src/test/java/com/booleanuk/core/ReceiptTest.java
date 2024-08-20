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
    String actual = receipt.toString();
    Assertions.assertTrue(actual.contains("1x Black coffee " + String.format("%.2f", Sku.COFB.price())));
    Assertions.assertTrue(actual.contains("1x White coffee " + String.format("%.2f", Sku.COFW.price())));
    Assertions.assertTrue(actual.contains("1x Onion bagel " + String.format("%.2f", Sku.BGLO.price())));
    Assertions.assertTrue(
        actual.contains("Total " + String.format("%.2f", Sku.COFB.price() + Sku.COFW.price() + Sku.BGLO.price())));
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
    String actual = receipt.toString();
    Assertions.assertTrue(actual.contains("3x Black coffee " + String.format("%.2f", Sku.COFB.price() * 3)));
    Assertions.assertTrue(
        actual.contains("Total " + String.format("%.2f", Sku.COFB.price() * 3)));
  }

  @Test
  public void testReceiptWithDiscount() {
    List<Product> inventoryStock = new ArrayList<>();
    inventoryStock.add(new Coffee(CoffeeType.BLACK));
    inventoryStock.add(new Bagel(BagelType.ONION));
    Inventory inventory = new Inventory(inventoryStock);

    Basket basket = new Basket();
    basket.add(new Bagel(BagelType.ONION));
    basket.add(new Coffee(CoffeeType.BLACK));
    Receipt receipt = inventory.purchase(basket);
    String actual = receipt.toString();
    Assertions.assertEquals("", actual); // temporary to see full output
    Assertions.assertTrue(actual.contains("1x Black coffee " + String.format("%.2f", Sku.COFB.price())));
    Assertions.assertTrue(actual.contains("1x Onion bagel " + String.format("%.2f", Sku.BGLO.price())));
    Assertions.assertTrue(actual.contains("Total 1.25"));

  }
}
