package com.booleanuk.core;

enum FILLINGTYPE {
    BACON,
    EGG,
    CHEESE,
    CREAMCHEESE,
    SMOKEDSALMON,
    HAM
}
public class Filling extends Item {
    private FILLINGTYPE type;

    public FILLINGTYPE getType() { return type; }
}
