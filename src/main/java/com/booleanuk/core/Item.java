package com.booleanuk.core;

public abstract class Item {
    protected String SKU = "";
    protected double cost = -1.0;

    public double getCost() { return cost; }

    public abstract boolean getAvailable();
}
