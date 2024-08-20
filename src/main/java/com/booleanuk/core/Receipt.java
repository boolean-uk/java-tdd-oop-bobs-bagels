package com.booleanuk.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receipt {
  private List<Product> products;

  public Receipt(List<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    String out = "~~~ Bob's Bagels ~~~\n" +
        "----------------------\n";
    Map<Sku, Integer> productCounts = new HashMap<>();
    for (Product product : this.products)
      productCounts.merge(product.sku(), 1, Integer::sum);

    for (Map.Entry<Sku, Integer> entry : productCounts.entrySet())
      out += entry.getValue() + "x " + entry.getKey() + ' ' + "\n";

    out += "----------------------";

    return out;
  }
}
