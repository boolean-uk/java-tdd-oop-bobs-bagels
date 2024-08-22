package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public record Coffee(CoffeeType type) implements StandaloneProduct {
  public double extraPrice() {
    return 0;
  }

  public double basePrice() {
    return this.sku().price();
  }

  public Sku sku() {
    return this.type.sku();
  }

  public List<Product> extras() {
    return new ArrayList<>();
  }
}
