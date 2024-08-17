package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
  private List<StandaloneProduct> products = new ArrayList<>();

  public void add(StandaloneProduct product) {
    this.products.add(product);
  }

  public void remove(String sku) throws NotPresentInBasketException {
    int i = 0;
    for (StandaloneProduct product : this.products) {
      if (product.sku().equals(sku)) {
        this.products.remove(i);
        return;
      }
      ++i;
    }

    throw new NotPresentInBasketException(sku);
  }

  public void remove(String sku, int count) throws NotPresentInBasketException {
    for (int i = 0; i < count; ++i)
      this.remove(sku);
  }

  public double price() {
    return this.products.stream().mapToDouble(StandaloneProduct::price).sum();
  }
}
