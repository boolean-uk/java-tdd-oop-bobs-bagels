package com.booleanuk.extension;

import java.math.BigDecimal;

public record Discount(String SKU, BigDecimal price, int quantity) {
}
