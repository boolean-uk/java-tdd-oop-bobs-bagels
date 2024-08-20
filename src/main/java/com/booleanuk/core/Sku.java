package com.booleanuk.core;

public enum Sku {
  BGLO("Onion bagel", 0.49),
  BGLP("Plain bagel", 0.39),
  BGLE("Everything bagel", 0.49),
  BGLS("Sesame bagel", 0.49),
  COFB("Black coffee", 0.99),
  COFW("White coffee", 1.19),
  COFC("Capuccino", 1.29),
  COFL("Latte", 1.29),
  FILB("Bacon filling", 0.12),
  FILE("Egg filling", 0.12),
  FILC("Cheese filling", 0.12),
  FILX("Cream cheese filling", 0.12),
  FILS("Smoked salmon filling", 0.12),
  FILH("Ham filling", 0.12),

  UNKNOWN("<Unknown product>", 0);

  private final String name;
  private final double price;

  private Sku(String name, double price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String toString() {
    return this.name;
  }

  public double price() {
    return this.price;
  }

  public boolean isBagel() {
    return this == BGLO || this == BGLP || this == BGLE || this == BGLS;
  }
}
