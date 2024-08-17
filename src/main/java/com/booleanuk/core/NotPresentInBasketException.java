package com.booleanuk.core;

public class NotPresentInBasketException extends RuntimeException {
  public NotPresentInBasketException(String sku) {
    super("Product with SKU '" + sku + "' is not present in the basket");
  }
}
