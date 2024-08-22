package com.booleanuk.core;

public class NotInStockException extends RuntimeException {
  public NotInStockException(Sku sku) {
    super("Cannot get '" + sku + "' from inventory since it's not in stock");
  }
}
