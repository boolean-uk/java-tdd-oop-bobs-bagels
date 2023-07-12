package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.UUID;

public class Item {
    private UUID id;
    private BigDecimal price;
    private SKU sku;

    public Item(SKU sku) {
        this.id = UUID.randomUUID();
        this.sku = sku;
    }

    public UUID getId() {
        return id;
    }
}
