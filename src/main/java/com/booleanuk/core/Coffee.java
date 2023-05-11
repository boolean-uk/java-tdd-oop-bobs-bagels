package com.booleanuk.core;

enum COFFEETYPE {
    BLACK,
    WHITE,
    CAPPUCCINO,
    LATTE
}
public class Coffee extends Item {
    private COFFEETYPE type = COFFEETYPE.BLACK;

    public COFFEETYPE getType() { return type; }
}
