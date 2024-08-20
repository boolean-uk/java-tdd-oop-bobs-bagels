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

  public double extraPrice() {
    return fillings.stream().mapToDouble(Filling::basePrice).sum();
  }

  public double basePrice() {
    return this.sku().price();
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
