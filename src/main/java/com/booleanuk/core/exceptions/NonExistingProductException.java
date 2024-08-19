package com.booleanuk.core.exceptions;

public class NonExistingProductException extends Exception {
    public NonExistingProductException(String message) {
        super(message);
    }
}
