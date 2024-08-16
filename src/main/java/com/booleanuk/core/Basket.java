package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
  private List<StandaloneProduct> products = new ArrayList<>();

  public void add(StandaloneProduct product) {
    this.products.add(product);
  }

  public void remove(BagelType type) throws NotPresentInBasketException {
    int i = 0;
    for (StandaloneProduct product : this.products) {
      if (product instanceof Bagel) {
        Bagel bagel = (Bagel) product;
        if (bagel.is(type)) {
          this.products.remove(i);
          return;
        }
      }
      ++i;
    }

    throw new NotPresentInBasketException(type);
  }

  public void remove(BagelType type, int count) throws NotPresentInBasketException {
    for (int i = 0; i < count; ++i)
      this.remove(type);
  }

  public void remove(CoffeeType type) throws NotPresentInBasketException {
    int i = 0;
    for (StandaloneProduct product : this.products) {
      if (product instanceof Coffee) {
        Coffee coffee = (Coffee) product;
        if (coffee.is(type)) {
          this.products.remove(i);
          return;
        }
      }
      ++i;
    }

    throw new NotPresentInBasketException(type);
  }

  public void remove(CoffeeType type, int count) {
    for (int i = 0; i < count; ++i)
      this.remove(type);
  }

  public double price() {
    return this.products.stream().mapToDouble(StandaloneProduct::price).sum();
  }
}
