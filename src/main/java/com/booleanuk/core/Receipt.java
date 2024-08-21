package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receipt {
  private static final double twelveBagelsPrice = 3.99;
  private static final double sixBagelsPrice = 2.49;
  private static final double coffeeAndBagelPrice = 1.25;
  private Basket basket;
  private String asString;
  private double price;

  public Receipt(Basket basket) {
    this.basket = basket;
  }

  private int numBagels() {
    int n = 0;
    for (Product product : this.basket.products())
      if (product.sku().isBagel())
        ++n;
    return n;
  }

  private int numCoffees() {
    int n = 0;
    for (Product product : this.basket.products())
      if (product.sku().isCoffee())
        ++n;
    return n;
  }

  public static Receipt makeReceipt(Basket basket) {
    Receipt receipt = new Receipt(basket);
    receipt.asString = "~~~ Bob's Bagels ~~~\n\n" +
        LocalDateTime.now() +
        "\n\n-------------------------\n\n";
    receipt.price = 0;

    int numBagels = receipt.numBagels();
    int numCoffees = receipt.numCoffees();

    if (numBagels >= 12) {
      int nDiscounts = 0;
      double fullPrice = 0;
      while (numBagels >= 12) {
        for (int i = 0; i < 12; ++i) {
          StandaloneProduct bagel = receipt.basket.removeBagel();
          fullPrice += bagel.sku().price();
          List<Product> components = bagel.components();
          // Calculate any fillings for that bagel
          for (int j = 1, size = components.size(); j < size; ++j) {
            Sku componentSku = components.get(j).sku();
            double componentPrice = componentSku.price();
            receipt.asString += String.format("1x %s %.2f\n", componentSku.toString(), componentPrice);
          }
        }
        numBagels -= 12;
        receipt.price += twelveBagelsPrice;
        ++nDiscounts;
      }

      double discountedPrice = twelveBagelsPrice * nDiscounts;
      receipt.asString += String.format("%dx Twelve bagel deal %.2f\n", nDiscounts, discountedPrice);
      receipt.asString += String.format("                   (-%.2f)\n", fullPrice - discountedPrice);
    }

    if (numBagels >= 6) {
      int nDiscounts = 0;
      double fullPrice = 0;
      while (numBagels >= 6) {
        for (int i = 0; i < 6; ++i) {
          StandaloneProduct bagel = receipt.basket.removeBagel();
          fullPrice += bagel.sku().price();
          List<Product> components = bagel.components();
          // Calculate any fillings for that bagel
          for (int j = 1, size = components.size(); j < size; ++j) {
            Sku componentSku = components.get(j).sku();
            double componentPrice = componentSku.price();
            receipt.asString += String.format("1x %s %.2f\n", componentSku.toString(), componentPrice);
          }
        }
        numBagels -= 6;
        receipt.price += sixBagelsPrice;
        ++nDiscounts;
      }

      double discountedPrice = sixBagelsPrice * nDiscounts;
      receipt.asString += String.format("%dx Six bagel deal %.2f\n", nDiscounts, discountedPrice);
      receipt.asString += String.format("                (-%.2f)\n", fullPrice - discountedPrice);
    }

    if (numBagels >= 1 && numCoffees >= 1) {
      int nDiscounts = 0;
      double fullPrice = 0;
      while (numBagels >= 1 && numCoffees >= 1) {
        --numCoffees;
        --numBagels;
        receipt.price += coffeeAndBagelPrice;
        StandaloneProduct bagel = receipt.basket.removeBagel();
        StandaloneProduct coffee = receipt.basket.removeCoffee();
        fullPrice += bagel.sku().price();
        fullPrice += coffee.sku().price();
        List<Product> components = bagel.components();
        for (int j = 1, size = components.size(); j < size; ++j) {
          Sku componentSku = components.get(j).sku();
          double componentPrice = componentSku.price();
          receipt.asString += String.format("1x %s %.2f\n", componentSku.toString(), componentPrice);
        }
        ++nDiscounts;
      }
      double discountedPrice = coffeeAndBagelPrice * nDiscounts;
      receipt.asString += String.format("%dx Coffee & bagel deal %.2f\n", nDiscounts, coffeeAndBagelPrice * nDiscounts);
      receipt.asString += String.format("                     (-%.2f)\n", fullPrice - discountedPrice);
    }

    Map<Sku, Integer> productCounts = new HashMap<>();

    for (StandaloneProduct product : receipt.basket.products()) {
      Sku sku = product.sku();
      if (sku.isBagel()) {
        if (numBagels > 0) {
          --numBagels;
          receipt.price += sku.price();
          // Increment product count by 1
          productCounts.merge(sku, 1, Integer::sum);
        }

        List<Product> components = product.components();
        // Add all extras (fillings) even if we've already payed for the bagel itself, i
        // = 1 since first part of components is the product itself
        for (int i = 1, size = components.size(); i < size; ++i) {
          Sku componentSku = components.get(i).sku();
          receipt.price += componentSku.price();
          receipt.asString += String.format("1x %s %.2f\n", componentSku.toString(),
              componentSku.price());
        }
      } else if (sku.isCoffee() && numCoffees > 0) {
        --numCoffees;
        receipt.price += sku.price();
        productCounts.merge(sku, 1, Integer::sum);
      }
    }

    for (Map.Entry<Sku, Integer> entry : productCounts.entrySet()) {
      Sku sku = entry.getKey();
      int count = entry.getValue();
      receipt.asString += String.format("%dx %s %.2f", count, sku.toString(), sku.price() * count);
    }

    receipt.asString += "\n\n-------------------------\n\n";
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
