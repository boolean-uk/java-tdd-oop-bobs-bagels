package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public record Coffee(CoffeeType type) implements StandaloneProduct {
  public double fullPrice() {
    return this.basePrice();
  }

  public double basePrice() {
    switch (this.type) {
      case BLACK:
        return 0.99;
      case WHITE:
        return 1.19;
      case CAPUCCINO:
        return 1.29;
      case LATTE:
        return 1.29;
    }

    return 0;
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
