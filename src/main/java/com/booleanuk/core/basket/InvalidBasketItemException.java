package com.booleanuk.core.basket;

public class InvalidBasketItemException extends RuntimeException {
    public InvalidBasketItemException(String message) {
        super(message);
    }
}
