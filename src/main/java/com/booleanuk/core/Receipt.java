package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receipt {
  private static final double twelveBagelsPrice = 3.99;
  private static final double sixBagelsPrice = 2.49;
  private static final double coffeeAndBagelPrice = 1.25;
  private List<Product> products;
  private String asString;
  private double price;

  public Receipt(List<Product> products) {
    this.products = products;
  }

  private int numBagels() {
    int n = 0;
    for (Product product : this.products)
      if (product.sku().isBagel())
        ++n;
    return n;
  }

  private int numCoffees() {
    int n = 0;
    for (Product product : this.products)
      if (product.sku().isCoffee())
        ++n;
    return n;
  }

  public static Receipt makeReceipt(List<Product> products) {
    Receipt receipt = new Receipt(products);
    receipt.asString = "~~~ Bob's Bagels ~~~\n\n" +
        LocalDateTime.now() +
        "\n\n----------------------\n\n";
    // All fillings and extras cost money and cannot be discounted
    receipt.price = 0;

    int numBagels = receipt.numBagels();
    int numCoffees = receipt.numCoffees();

    if (numBagels >= 12) {
      int nDiscounts = 0;
      while (numBagels >= 12) {
        numBagels -= 12;
        receipt.price += twelveBagelsPrice;
        ++nDiscounts;
      }
      receipt.asString += nDiscounts + "x Twelve bagel deal " + twelveBagelsPrice * nDiscounts;
    }

    if (numBagels >= 6) {
      int nDiscounts = 0;
      while (numBagels >= 6) {
        numBagels -= 6;
        receipt.price += sixBagelsPrice;
        ++nDiscounts;
      }
      receipt.asString += nDiscounts + "x Six bagel deal " + sixBagelsPrice * nDiscounts;
    }

    if (numBagels >= 1 && numCoffees >= 1) {
      int nDiscounts = 0;
      while (numBagels >= 1 && numCoffees >= 1) {
        --numCoffees;
        --numBagels;
        receipt.price += coffeeAndBagelPrice;
        ++nDiscounts;
      }
      receipt.asString += nDiscounts + "x Coffee & bagel deal " + coffeeAndBagelPrice * nDiscounts;
    }

    Map<Sku, Integer> productCounts = new HashMap<>();

    for (Product product : receipt.products) {
      if (product.sku().isBagel() && numBagels > 0) {
        --numBagels;
        receipt.price += product.sku().price();
        // Increment productCount by 1
        productCounts.merge(product.sku(), 1, Integer::sum);
      } else if (product.sku().isCoffee() && numCoffees > 0) {
        --numCoffees;
        receipt.price += product.sku().price();
        productCounts.merge(product.sku(), 1, Integer::sum);
      }
    }

    for (Map.Entry<Sku, Integer> entry : productCounts.entrySet()) {
      Sku sku = entry.getKey();
      int count = entry.getValue();
      receipt.asString += String.format("%dx %s %.2f", count, sku.toString(), sku.price() * count);
    }

    receipt.asString += "\n\n----------------------\n\n";
    receipt.asString += String.format("Total: %.2f", receipt.price);

    return receipt;
  }

  @Override
  public String toString() {
    return this.asString;
  }

  public double price() {
    return this.price;
  }
}
