package com.booleanuk.core;

public record Filling(FillingType type) implements Product {
  public double basePrice() {
    return this.sku().price();
  }

  public Sku sku() {
    return this.type.sku();
  }
}
