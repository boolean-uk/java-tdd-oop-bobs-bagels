package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.HashMap;
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

  private void calculateBagelDiscounts(int neededForDiscount, double discountedPrice, String dealMessage) {
    int numBagels = this.numBagels();

    if (numBagels < neededForDiscount)
      return;

    int nDiscounts = 0;
    double fullPrice = 0;
    while (numBagels >= neededForDiscount) {
      for (int i = 0; i < neededForDiscount; ++i) {
        StandaloneProduct bagel = this.basket.removeBagel();
        fullPrice += bagel.sku().price();

        for (Product extra : bagel.extras()) {
          Sku extraSku = extra.sku();
          this.stringBuilder.append(String.format("1x %s %.2f\n", extraSku.toString(), extraSku.price()));
        }
      }
      numBagels -= neededForDiscount;
      this.price += discountedPrice;
      ++nDiscounts;
    }

    double discountedPriceFull = discountedPrice * nDiscounts;
    this.stringBuilder.append(String.format("%dx %s %.2f\n", nDiscounts, dealMessage, discountedPriceFull));
    this.stringBuilder.append(String.format("(-%.2f)\n", fullPrice - discountedPriceFull));
  }

  private void calculateCoffeeAndBagelDiscounts() {
    int numBagels = this.numBagels();
    int numCoffees = this.numCoffees();

    if (numBagels < 1 && numCoffees < 1)
      return;

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

      for (Product extra : bagel.extras()) {
        Sku extraSku = extra.sku();
        this.stringBuilder.append(String.format("1x%s%.2f\n", extraSku.toString(), extraSku.price()));
      }
      ++nDiscounts;
    }

    double discountedPrice = coffeeAndBagelPrice * nDiscounts;
    this.stringBuilder.append(String.format("%dx Coffee & bagel deal %.2f\n", nDiscounts, discountedPrice));
    this.stringBuilder.append(String.format("(-%.2f)\n", fullPrice - discountedPrice));
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

        for (Product extra : product.extras()) {
          Sku componentSku = extra.sku();
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

    receipt.calculateBagelDiscounts(12, twelveBagelsPrice, "Twelve bagel deal");
    receipt.calculateBagelDiscounts(6, sixBagelsPrice, "Six bagel deal");
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
