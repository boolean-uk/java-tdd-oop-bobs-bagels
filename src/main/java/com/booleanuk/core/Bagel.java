package com.booleanuk.core;

public record Bagel(BagelType type) implements StandaloneProduct {
  public double price() {
    switch (this.type) {
      case Onion:
        return 0.49;
      case Plain:
        return 0.39;
      case Everything:
        return 0.49;
      case Sesame:
        return 0.49;
    }

    // Should be unreachable but we get a warning if we dont do this or add a
    // default in switch. Adding a default in switch could cause bugs if we add
    // another bagel type so default return is better outside switch.
    return 0;
  }

  public String sku() {
    switch (this.type) {
      case Onion:
        return "BGLO";
      case Plain:
        return "BGLP";
      case Everything:
        return "BGLE";
      case Sesame:
        return "BGLS";
    }

    return "";
  }
}
