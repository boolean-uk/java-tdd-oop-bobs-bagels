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

  public double price() {
    double fillingsPrice = fillings.stream().mapToDouble(Filling::price).sum();

    switch (this.type) {
      case ONION:
        return fillingsPrice + 0.49;
      case PLAIN:
        return fillingsPrice + 0.39;
      case EVERYTHING:
        return fillingsPrice + 0.49;
      case SESAME:
        return fillingsPrice + 0.49;
    }

    // Should be unreachable but we get a warning if we dont do this or add a
    // default in switch. Adding a default in switch could cause bugs if we add
    // another bagel type so default return is better outside switch.
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

  public void add(Filling filling) {
    this.fillings.add(filling);
  }
}
