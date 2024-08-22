package com.booleanuk.core;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class TwilioTest {
  @Test
  @Disabled
  public void testSendMessage() {
    List<Product> inventoryStock = new ArrayList<>();
    inventoryStock.add(new Coffee(CoffeeType.BLACK));
    inventoryStock.add(new Coffee(CoffeeType.WHITE));
    inventoryStock.add(new Bagel(BagelType.EVERYTHING, Optional.empty()));

    Inventory inventory = new Inventory(inventoryStock);
    Basket basket = new Basket();
    basket.add(new Coffee(CoffeeType.BLACK));
    basket.add(new Bagel(BagelType.EVERYTHING, Optional.empty()));
    Receipt receipt = inventory.purchase(basket);

    // INSERT SOME PHONE NUMBER HERE:
    MessageController.notifyUser(receipt.toString(), "<some phone number>");
  }
}
