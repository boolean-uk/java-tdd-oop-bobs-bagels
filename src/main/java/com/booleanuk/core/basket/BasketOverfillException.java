package com.booleanuk.core.basket;

public class BasketOverfillException extends RuntimeException {
    public BasketOverfillException(String error) {
        super(error);
    }
}
