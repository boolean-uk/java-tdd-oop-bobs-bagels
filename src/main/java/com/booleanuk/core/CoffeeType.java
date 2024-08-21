package com.booleanuk.core;

public enum CoffeeType {
  BLACK(Sku.COFB),
  WHITE(Sku.COFW),
  CAPUCCINO(Sku.COFC),
  LATTE(Sku.COFL);

  private final Sku sku;

  private CoffeeType(Sku sku) {
    this.sku = sku;
  }

  public Sku sku() {
    return this.sku;
  }
}
