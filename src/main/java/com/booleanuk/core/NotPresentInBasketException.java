package com.booleanuk.core;

public class NotPresentInBasketException extends RuntimeException {
  public NotPresentInBasketException(Sku sku) {
    super("Product '" + sku + "' is not present in the basket");
  }

  public NotPresentInBasketException(String message) {
    super(message);
  }
}
