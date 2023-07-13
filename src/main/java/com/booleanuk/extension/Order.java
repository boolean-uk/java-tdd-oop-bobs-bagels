package com.booleanuk.extension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    private UUID id;
    private LocalDateTime orderDate;
    private final Basket basket;

    public Order(Basket basket) {
        id = UUID.randomUUID();
        orderDate = LocalDateTime.now();
        this.basket = basket;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getTotalPrice() {
        return basket.getTotalPrice();
    }
}
