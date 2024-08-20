package com.booleanuk.core;

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

  // @Override
  // public String toString() {
  // String out = "~~~ Bob's Bagels ~~~\n----------------------\n";
  // // All fillings and extras cost money and cannot be discounted
  // double price = this.products
  // .stream()
  // .mapToDouble((product) -> product.extraPrice())
  // .sum();
  //
  // int numBagels = numBagels();
  // int numCoffees = numCoffees();
  //
  // while (numBagels >= 12) {
  // numBagels -= 12;
  // price += 4.99;
  // }
  //
  // while (numBagels >= 6) {
  // numBagels -= 6;
  // price += 2.49;
  // }
  //
  // while (numBagels >= 1 && numCoffees >= 1) {
  // --numCoffees;
  // --numBagels;
  // price += 1.25;
  // }
  //
  // for (Product product : this.products) {
  // if (product instanceof Bagel && numBagels > 0) {
  // --numBagels;
  // price += product.basePrice();
  // } else if (product instanceof Coffee && numCoffees > 0) {
  // --numCoffees;
  // price += product.basePrice();
  // }
  // }
  //
  // out += "----------------------\n";
  // out += String.format("Total %.2f", price);
  //
  // return out;
  // }

  @Override
  public String toString() {
    String out = "~~~ Bob's Bagels ~~~\n----------------------\n";
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

    out += "----------------------\n";
    out += String.format("Total %.2f", totalPrice);

    return out;
  }
}
