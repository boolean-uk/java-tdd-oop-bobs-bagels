package com.booleanuk.core;

public record Filling(FillingType type) implements Product {
  public double extraPrice() {
    return 0;
  }

  public double basePrice() {
    return this.sku().price();
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
