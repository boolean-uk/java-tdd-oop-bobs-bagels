package com.booleanuk.core;

public class NotPresentInBasketException extends RuntimeException {
  public NotPresentInBasketException(CoffeeType type) {
    super("Coffee of type " + Coffee.typeToString(type) + " is not in the basket");
  }

  public NotPresentInBasketException(BagelType type) {
    super("Bagel of type " + Bagel.typeToString(type) + " is not in the basket");
  }
}
