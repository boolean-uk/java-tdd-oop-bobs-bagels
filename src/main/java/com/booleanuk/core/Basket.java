package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
  private final double twelveBagelsPrice = 3.99;
  private final double sixBagelsPrice = 2.49;
  private final double coffeeAndBagelPrice = 1.25;

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

  public void add(StandaloneProduct product, int count) throws AddToFullBasketException {
    for (int i = 0; i < count; ++i)
      this.add(product);
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

  private int numBagels() {
    int n = 0;
    for (Product product : this.products)
      if (product.sku().isBagel())
        ++n;
    return n;
  }

  private int numCoffees() {
    int n = 0;
    for (Product product : this.products)
      if (product.sku().isCoffee())
        ++n;
    return n;
  }

  public double price() {
    // All fillings and extras cost money and cannot be discounted
    double price = this.products
        .stream()
        .mapToDouble((product) -> product.extraPrice())
        .sum();

    int numBagels = this.numBagels();
    int numCoffees = this.numCoffees();

    while (numBagels >= 12) {
      numBagels -= 12;
      price += twelveBagelsPrice;
    }

    while (numBagels >= 6) {
      numBagels -= 6;
      price += sixBagelsPrice;
    }

    while (numBagels >= 1 && numCoffees >= 1) {
      --numCoffees;
      --numBagels;
      price += coffeeAndBagelPrice;
    }

    for (Product product : this.products) {
      if (product.sku().isBagel() && numBagels > 0) {
        --numBagels;
        price += product.basePrice();
      } else if (product.sku().isCoffee() && numCoffees > 0) {
        --numCoffees;
        price += product.basePrice();
      }
    }

    return price;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public List<StandaloneProduct> products() {
    return this.products;
  }
}
