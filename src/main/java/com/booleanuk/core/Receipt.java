package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.List;

public class Receipt {
  private List<Product> products;

  public Receipt(List<Product> products) {
    this.products = products;
  }

  private int numBagels() {
    int n = 0;
    for (Product product : this.products)
      if (product instanceof Bagel)
        ++n;
    return n;
  }

  private int numCoffees() {
    int n = 0;
    for (Product product : this.products)
      if (product instanceof Coffee)
        ++n;
    return n;
  }

  @Override
  public String toString() {
    String out = "~~~ Bob's Bagels ~~~\n\n" +
        LocalDateTime.now() +
        "\n\n----------------------\n\n";
    double totalPrice = 0;

    int numBagels = this.numBagels();
    int numCoffees = this.numCoffees();

    for (Sku sku : Sku.values()) {
      long productCount = this.products
          .stream()
          .filter((product) -> product.sku() == sku)
          .count();
      if (productCount == 0)
        continue;

      double productPrice = 0;
      if (sku.isBagel()) {
        if (productCount >= 12) {
          // Twelve bagel discount
          productPrice = 4.99;
          out += String.format("Discount: %.2f\n", productPrice - (sku.price() * productCount));
        } else if (productCount >= 6) {
          // Six bagel discount
          productPrice = 2.49;
          out += String.format("Discount: %.2f\n", productPrice - (sku.price() * productCount));
        } else {
          if (numCoffees > 0) {
            // Coffee and bagel discount
            while (Math.min(numBagels, numCoffees) > 0) {
              productPrice += 1.25;
              --numBagels;
              --numCoffees;
            }
            totalPrice += productPrice;
            out += String.format("%dx Coffee + bagel deal %.2f\n", productCount, productPrice);
            continue;
          } else {
            productPrice = sku.price() * productCount;
          }
        }
        numBagels -= productCount;
      } else {
        // Already applied as bagel + coffee discount
        if (numCoffees <= 0)
          continue;
        // No discount
        productPrice = sku.price() * productCount;
        numCoffees -= productCount;
      }
      totalPrice += productPrice;

      out += String.format("%dx %s %.2f\n", productCount, sku, productPrice);
    }

    out += "\n----------------------\n";
    out += String.format("Total %.2f", totalPrice);

    return out;
  }
}
