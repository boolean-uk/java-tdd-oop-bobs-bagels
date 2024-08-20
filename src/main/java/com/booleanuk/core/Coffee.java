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
    switch (this.type) {
      case BLACK:
        return Sku.COFB;
      case WHITE:
        return Sku.COFW;
      case CAPUCCINO:
        return Sku.COFC;
      case LATTE:
        return Sku.COFL;
    }

    return Sku.UNKNOWN;
  }

  public List<Product> components() {
    List<Product> components = new ArrayList<>();
    components.add(this);
    return components;
  }
}
