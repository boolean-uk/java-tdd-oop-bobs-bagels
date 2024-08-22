package com.booleanuk.core;

public class BasketItemExistException extends RuntimeException {
    public BasketItemExistException(String message) {
        super(message);
    }
}
