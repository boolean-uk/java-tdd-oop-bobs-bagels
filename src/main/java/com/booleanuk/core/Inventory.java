package com.booleanuk.core;

import java.util.List;

public class Inventory {
  private List<Product> stock;

  public Inventory(List<Product> stock) {
    this.stock = stock;
  }

  // Not sure what to name - method removes all products in the basket from the
  // inventory
  void remove(Basket basket) throws NotInStockException {
    for (StandaloneProduct product : basket.products())
      for (Product component : product.components())
        this.stock.remove(this.find(component.sku()));
  }

  private int find(Sku sku) throws NotInStockException {
    int i = 0;
    for (Product product : this.stock) {
      if (product.sku() == sku)
        return i;
      ++i;
    }

    throw new NotInStockException(sku);
  }
}
