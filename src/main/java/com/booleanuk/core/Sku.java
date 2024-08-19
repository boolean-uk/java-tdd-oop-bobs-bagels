package com.booleanuk.core;

public enum Sku {
  BGLO("Onion bagel"),
  BGLP("Plain bagel"),
  BGLE("Everything bagel"),
  BGLS("Sesame bagel"),
  COFB("Black coffee"),
  COFW("White coffee"),
  COFC("Capuccino"),
  COFL("Latte"),
  FILB("Bacon filling"),
  FILE("Egg filling"),
  FILC("Cheese filling"),
  FILX("Cream cheese filling"),
  FILS("Smoked salmon filling"),
  FILH("Ham filling"),

  UNKNOWN("<Unknown product>");

  private final String name;

  private Sku(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;

  }
}
