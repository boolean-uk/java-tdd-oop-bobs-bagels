package com.booleanuk.core.items;

public interface FillableItem<T> extends Item {
    void add(T filling);
}
