package com.booleanuk.core;

public record Filling(FillingType type) implements Product {
  public double extraPrice() {
    return 0;
  }

  public double basePrice() {
    switch (this.type) {
      case BACON:
        return 0.12;
      case CHEESE:
        return 0.12;
      case CREAM_CHEESE:
        return 0.12;
      case EGG:
        return 0.12;
      case HAM:
        return 0.12;
      case SMOKED_SALMON:
        return 0.12;
    }

    return 0.12;
  }

  public Sku sku() {
    switch (this.type) {
      case BACON:
        return Sku.FILB;
      case CHEESE:
        return Sku.FILC;
      case CREAM_CHEESE:
        return Sku.FILX;
      case EGG:
        return Sku.FILE;
      case HAM:
        return Sku.FILH;
      case SMOKED_SALMON:
        return Sku.FILS;
    }

    return Sku.UNKNOWN;
  }
}
