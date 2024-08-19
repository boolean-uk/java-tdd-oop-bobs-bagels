package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
  private List<StandaloneProduct> products = new ArrayList<>();
  private int capacity;

  public Basket() {
    this.capacity = 10;
  }

  public Basket(int capacity) {
    this.capacity = capacity;
  }

  public void add(StandaloneProduct product) throws AddToFullBasketException {
    if (this.products.size() < this.capacity)
      this.products.add(product);
    else
      throw new AddToFullBasketException(this.capacity);
  }

  public void remove(Sku sku) throws NotPresentInBasketException {
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

  public void remove(Sku sku, int count) throws NotPresentInBasketException {
    for (int i = 0; i < count; ++i)
      this.remove(sku);
  }

  public double price() {
    return this.products.stream().mapToDouble(StandaloneProduct::price).sum();
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}
