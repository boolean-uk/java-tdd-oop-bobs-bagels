package com.booleanuk.core;

import com.booleanuk.core.product.bagel.Bagel;
import com.booleanuk.core.product.bagel.BagelType;
import com.booleanuk.core.product.bagel.Filling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagelTest {
    @Test
    public void price_shouldCorrectlyCalculatePrice() {
        var bagel = Bagel.builder()
                .type(BagelType.BGLO)
                .fillings(Filling.values())
                .build();
        var expectedPrice = BagelType.BGLO.getPrice();
        for (var f : Filling.values()) {
            expectedPrice = expectedPrice.add(f.getPrice());
        }

        assertEquals(expectedPrice, bagel.getPrice());
    }
}
