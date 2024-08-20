package com.booleanuk.core;

import java.util.List;

public class Receipt {
  private List<Product> products;

  public Receipt(List<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    String out = "~~~ Bob's Bagels ~~~\n" + "----------------------\n";
    double totalPrice = 0;

    for (Sku sku : Sku.values()) {
      long productCount = this.products
          .stream()
          .filter((product) -> product.sku() == sku)
          .count();
      if (productCount == 0)
        continue;

      double productPrice = sku.price() * productCount;
      totalPrice += productPrice;

      out += String.format("%dx %s %.2f\n", productCount, sku, productPrice);
    }

    out += "----------------------\n";
    out += String.format("Total %.2f", totalPrice);

    return out;
  }
}
