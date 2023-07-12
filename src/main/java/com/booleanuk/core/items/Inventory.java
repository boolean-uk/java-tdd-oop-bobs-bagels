package com.booleanuk.core.items;

import java.util.List;

public interface Inventory {
    boolean contains(Item item);
    void expand(List<Item> items);
}
