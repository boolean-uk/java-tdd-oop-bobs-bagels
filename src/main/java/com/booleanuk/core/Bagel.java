package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel implements StandaloneProduct {
  private BagelType type;
  private List<Filling> fillings;

  public Bagel(BagelType type) {
    this.type = type;
    this.fillings = new ArrayList<>();
  }

  public double fullPrice() {
    return this.basePrice() + fillings.stream().mapToDouble(Filling::fullPrice).sum();
  }

  public double basePrice() {
    switch (this.type) {
      case ONION:
        return 0.49;
      case PLAIN:
        return 0.39;
      case EVERYTHING:
        return 0.49;
      case SESAME:
        return 0.49;
    }

    return 0;
  }

  public Sku sku() {
    switch (this.type) {
      case ONION:
        return Sku.BGLO;
      case PLAIN:
        return Sku.BGLP;
      case EVERYTHING:
        return Sku.BGLE;
      case SESAME:
        return Sku.BGLS;
    }

    return Sku.UNKNOWN;
  }

  public List<Product> components() {
    List<Product> components = new ArrayList<>(this.fillings);
    components.add(this);
    return components;
  }

  public void add(Filling filling) {
    this.fillings.add(filling);
  }
}
