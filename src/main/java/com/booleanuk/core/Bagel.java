package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record Bagel(BagelType type, Optional<List<Filling>> fillings) implements StandaloneProduct {
  public double extraPrice() {
    if (this.fillings.isPresent())
      return fillings.get().stream().mapToDouble(Filling::basePrice).sum();
    else
      return 0;
  }

  public double basePrice() {
    return this.type.sku().price();
  }

  public Sku sku() {
    return this.type.sku();
  }

  public List<Product> extras() {
    if (this.fillings.isPresent())
      return new ArrayList<>(this.fillings.get());

    return new ArrayList<>();
  }
}
