package com.booleanuk.extension;

import com.booleanuk.core.Item;

import java.math.BigDecimal;

public class ReceiptLine {
    private final Item item;
    private final BigDecimal quantity;
    private final BigDecimal price;
    private final boolean bagelCoffeeSpecial;

    public ReceiptLine(Item item, BigDecimal quantity, BigDecimal price, boolean bagelCoffeeSpecial) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.bagelCoffeeSpecial = bagelCoffeeSpecial;
    }

    public Item getItem() {
        return item;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isBagelCoffeeSpecial() {
        return bagelCoffeeSpecial;
    }
}
