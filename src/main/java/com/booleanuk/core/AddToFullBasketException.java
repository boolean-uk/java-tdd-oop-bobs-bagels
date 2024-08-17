package com.booleanuk.core;

public class AddToFullBasketException extends RuntimeException {
  public AddToFullBasketException(int capacity) {
    // TODO: print capacity here
    super("Cannot add product to full basket with capacity of" + capacity);
  }
}
