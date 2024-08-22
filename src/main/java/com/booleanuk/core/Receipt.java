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
  private StringBuilder stringBuilder;
  private double price;

  public Receipt(Basket basket) {
    this.basket = basket;
    this.price = 0;
    this.stringBuilder = new StringBuilder();
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

  private void calculateTwelveBagelDiscounts() {
    int numBagels = this.numBagels();

    if (numBagels >= 12) {
      int nDiscounts = 0;
      double fullPrice = 0;
      while (numBagels >= 12) {
        for (int i = 0; i < 12; ++i) {
          StandaloneProduct bagel = this.basket.removeBagel();
          fullPrice += bagel.sku().price();
          List<Product> components = bagel.components();
          // Calculate any fillings for that bagel
          for (int j = 1, size = components.size(); j < size; ++j) {
            Sku componentSku = components.get(j).sku();
            double componentPrice = componentSku.price();
            this.stringBuilder.append(String.format("1x %s %.2f\n", componentSku.toString(), componentPrice));
          }
        }
        numBagels -= 12;
        this.price += twelveBagelsPrice;
        ++nDiscounts;
      }

      double discountedPrice = twelveBagelsPrice * nDiscounts;
      this.stringBuilder.append(String.format("%dx Twelve bagel deal %.2f\n", nDiscounts, discountedPrice));
      this.stringBuilder.append(String.format("(-%.2f)\n", fullPrice - discountedPrice));
    }
  }

  private void calculateSixBagelDiscounts() {
    int numBagels = this.numBagels();

    if (numBagels >= 6) {
      int nDiscounts = 0;
      double fullPrice = 0;
      while (numBagels >= 6) {
        for (int i = 0; i < 6; ++i) {
          StandaloneProduct bagel = this.basket.removeBagel();
          fullPrice += bagel.sku().price();
          List<Product> components = bagel.components();
          // Calculate any fillings for that bagel
          for (int j = 1, size = components.size(); j < size; ++j) {
            Sku componentSku = components.get(j).sku();
            double componentPrice = componentSku.price();
            this.stringBuilder.append(String.format("1x %s %.2f\n", componentSku.toString(), componentPrice));
          }
        }
        numBagels -= 6;
        this.price += sixBagelsPrice;
        ++nDiscounts;
      }

      double discountedPrice = sixBagelsPrice * nDiscounts;
      this.stringBuilder.append(String.format("%dx Six bagel deal %.2f\n", nDiscounts, discountedPrice));
      this.stringBuilder.append(String.format("(-%.2f)\n", fullPrice - discountedPrice));
    }
  }

  private void calculateCoffeeAndBagelDiscounts() {
    int numBagels = this.numBagels();
    int numCoffees = this.numCoffees();

    if (numBagels >= 1 && numCoffees >= 1) {
      int nDiscounts = 0;
      double fullPrice = 0;
      while (numBagels >= 1 && numCoffees >= 1) {
        --numCoffees;
        --numBagels;
        this.price += coffeeAndBagelPrice;
        StandaloneProduct bagel = this.basket.removeBagel();
        StandaloneProduct coffee = this.basket.removeCoffee();
        fullPrice += bagel.sku().price();
        fullPrice += coffee.sku().price();
        List<Product> components = bagel.components();
        for (int j = 1, size = components.size(); j < size; ++j) {
          Sku componentSku = components.get(j).sku();
          double componentPrice = componentSku.price();
          this.stringBuilder.append(String.format("1x%s%.2f\n", componentSku.toString(), componentPrice));
        }
        ++nDiscounts;
      }

      double discountedPrice = coffeeAndBagelPrice * nDiscounts;
      this.stringBuilder.append(String.format("%dx Coffee & bagel deal %.2f\n", nDiscounts, discountedPrice));
      this.stringBuilder.append(String.format("(-%.2f)\n", fullPrice - discountedPrice));
    }
  }

  private void calculateRemainingProducts() {
    Map<Sku, Integer> productCounts = new HashMap<>();

    int numBagels = this.numBagels();
    int numCoffees = this.numCoffees();

    for (StandaloneProduct product : this.basket.products()) {
      Sku sku = product.sku();
      if (sku.isBagel()) {
        if (numBagels > 0) {
          --numBagels;
          this.price += sku.price();
          // Increment product count by 1
          productCounts.merge(sku, 1, Integer::sum);
        }

        List<Product> components = product.components();
        // Add all extras (fillings) even if we've already payed for the bagel itself, i
        // = 1 since first part of components is the product itself
        for (int i = 1, size = components.size(); i < size; ++i) {
          Sku componentSku = components.get(i).sku();
          this.price += componentSku.price();
          this.stringBuilder.append(String.format("1x %s %.2f\n", componentSku.toString(),
              componentSku.price()));
        }
      } else if (sku.isCoffee() && numCoffees > 0) {
        --numCoffees;
        this.price += sku.price();
        productCounts.merge(sku, 1, Integer::sum);
      }
    }

    for (Map.Entry<Sku, Integer> entry : productCounts.entrySet()) {
      Sku sku = entry.getKey();
      int count = entry.getValue();
      this.stringBuilder.append(String.format("%dx %s %.2f", count, sku.toString(), sku.price() * count));
    }
  }

  public static Receipt makeReceipt(Basket basket) {
    Receipt receipt = new Receipt(basket);
    receipt.stringBuilder.append(String.format("~~~ Bob's Bagels ~~~\n\n%s\n\n-----------------------------\n\n",
        LocalDateTime.now().toString()));

    receipt.calculateTwelveBagelDiscounts();
    receipt.calculateSixBagelDiscounts();
    receipt.calculateCoffeeAndBagelDiscounts();
    receipt.calculateRemainingProducts();

    receipt.stringBuilder.append("\n\n-----------------------------\n\n");
    receipt.stringBuilder.append(String.format("Total: %.2f", receipt.price));

    return receipt;
  }

  @Override
  public String toString() {
    return this.stringBuilder.toString();
  }

  public double price() {
    return this.price;
  }
}
