package com.booleanuk.core.enums;

public enum ProductName {

    // Resource: https://www.youtube.com/watch?v=wq9SJb8VeyM

    DEFAULT("DEFAULT"),
    COFFEE("Coffee"),
    BAGEL("Bagel"),
    FILLING("Filling");

    private final String string;

    ProductName(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

}