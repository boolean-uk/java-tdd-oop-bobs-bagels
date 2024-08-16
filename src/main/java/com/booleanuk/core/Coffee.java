package com.booleanuk.core;

public class Coffee implements StandaloneProduct {
  private CoffeeType type;

  public Coffee(CoffeeType type) {
    this.type = type;
  }

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

  public boolean is(CoffeeType type) {
    return this.type == type;
  }

  public static String typeToString(CoffeeType type) {
    switch (type) {
      case Black:
        return "Black";
      case White:
        return "Black";
      case Capuccino:
        return "Capuccino";
      case Latte:
        return "Latte";
    }

    return "";
  }
}
