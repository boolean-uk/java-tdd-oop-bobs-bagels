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
    return this.type.sku();
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
