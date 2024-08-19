package com.booleanuk.core;

import java.util.List;

public class Receipt {
  List<Product> products;

  public Receipt(List<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    String out = "~~~ Bob's Bagels ~~~\n" +
        "----------------------\n";
    for (Product product : this.products)
      out += "1x " + product.sku().toString() + ' ' + product.basePrice() + "\n";

    out += "----------------------";

    return out;
  }
}
