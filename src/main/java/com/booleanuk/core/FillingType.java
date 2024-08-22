package com.booleanuk.core;

public enum FillingType {
  BACON(Sku.FILB),
  EGG(Sku.FILE),
  CHEESE(Sku.FILC),
  CREAM_CHEESE(Sku.FILC),
  SMOKED_SALMON(Sku.FILX),
  HAM(Sku.FILH);

  private final Sku sku;

  private FillingType(Sku sku) {
    this.sku = sku;
  }

  public Sku sku() {
    return this.sku;
  }
}
