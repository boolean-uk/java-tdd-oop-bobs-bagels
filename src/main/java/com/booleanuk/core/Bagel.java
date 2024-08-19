package com.booleanuk.core;

public record Bagel(BagelType type) implements StandaloneProduct {
  public double price() {
    switch (this.type) {
      case ONION:
        return 0.49;
      case PLAIN:
        return 0.39;
      case EVERYTHING:
        return 0.49;
      case SESAME:
        return 0.49;
    }

    // Should be unreachable but we get a warning if we dont do this or add a
    // default in switch. Adding a default in switch could cause bugs if we add
    // another bagel type so default return is better outside switch.
    return 0;
  }

  public Sku sku() {
    switch (this.type) {
      case ONION:
        return Sku.BGLO;
      case PLAIN:
        return Sku.BGLP;
      case EVERYTHING:
        return Sku.BGLE;
      case SESAME:
        return Sku.BGLS;
    }

    return Sku.UNKNOWN;
  }
}
