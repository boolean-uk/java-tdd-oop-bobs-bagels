package com.booleanuk.core;

public enum BagelType {
  ONION(Sku.BGLO),
  PLAIN(Sku.BGLP),
  EVERYTHING(Sku.BGLE),
  SESAME(Sku.BGLS);

  private final Sku sku;

  private BagelType(Sku sku) {
    this.sku = sku;
  }

  public Sku sku() {
    return this.sku;
  }
}
