package com.booleanuk.core;

enum BAGELTYPE {
    NORMAL
}
public class Bagel {
    private double cost;
    private BAGELTYPE type;
    public Filling filling;

    public double getCost() { return cost; }

    public BAGELTYPE getType() { return type; }
}
