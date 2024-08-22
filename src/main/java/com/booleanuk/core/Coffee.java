package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public record Coffee(CoffeeType type) implements StandaloneProduct {
  public Sku sku() {
    return this.type.sku();
  }

  public List<Product> extras() {
    return new ArrayList<>();
  }
}
