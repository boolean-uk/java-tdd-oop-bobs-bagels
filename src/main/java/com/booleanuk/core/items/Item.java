package com.booleanuk.core.items;

public interface Item {
    boolean isType(Category type);
    String variant();
    double cost();
}
