package com.booleanuk.core;

public class Bagel implements StandaloneProduct {
  private BagelType type;

  public Bagel(BagelType type) {
    this.type = type;
  }

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

  public boolean is(BagelType type) {
    return this.type == type;
  }

  public static String typeToString(BagelType type) {
    switch (type) {
      case Onion:
        return "Onion";
      case Plain:
        return "Plain";
      case Everything:
        return "Everything";
      case Sesame:
        return "Sesame";
    }

    return "";
  }
}
