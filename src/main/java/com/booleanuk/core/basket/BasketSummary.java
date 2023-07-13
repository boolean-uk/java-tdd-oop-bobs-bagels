package com.booleanuk.core.basket;

import com.booleanuk.core.products.Product;

import java.math.BigDecimal;
import java.util.HashMap;

public record BasketSummary(
        BigDecimal total, HashMap<Product, BigDecimal> discounts
) {
}
