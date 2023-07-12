package com.booleanuk.core;

import java.util.UUID;

public class Item {
    private UUID id;

    public Item() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
