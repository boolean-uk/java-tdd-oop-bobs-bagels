package com.booleanuk.core;

enum FILLINGTYPE {
    NORMAL
}
public class Filling {
    private double cost;
    private FILLINGTYPE type;

    public double getCost() { return cost; }

    public FILLINGTYPE getType() { return type; }
}
