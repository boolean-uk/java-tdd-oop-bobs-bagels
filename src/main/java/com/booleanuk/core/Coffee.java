package com.booleanuk.core;

public record Coffee(CoffeeType type) implements StandaloneProduct {
  public double price() {
    switch (this.type) {
      case Black:
        return 0.99;
      case White:
        return 1.19;
      case Capuccino:
        return 1.29;
      case Latte:
        return 1.29;
    }

    return 0;
  }

  public String sku() {
    switch (this.type) {
      case Black:
        return "COFB";
      case White:
        return "COFW";
      case Capuccino:
        return "COFC";
      case Latte:
        return "COFL";
    }

    return "";
  }
}
