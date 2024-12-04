package com.booleanuk.extension.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public enum Coffee implements Product {
    COFB("Black", BigDecimal.valueOf(.99)),
    COFW("White", BigDecimal.valueOf(1.19)),
    COFC("Cappuccino", BigDecimal.valueOf(1.29)),
    COFL("Latte", BigDecimal.valueOf(1.29));

    private final Product.Type productType = Product.Type.Coffee;
    private final String variant;
    private final BigDecimal price;
}
