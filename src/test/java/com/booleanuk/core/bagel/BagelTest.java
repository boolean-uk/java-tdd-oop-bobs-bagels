package com.booleanuk.core.bagel;

import com.booleanuk.extension.product.BagelSandwich;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagelTest {
    @Test
    public void price_shouldCorrectlyCalculatePrice() {
        var bagel = new BagelSandwich(BagelSandwich.Bagel.BGLO, BagelSandwich.Filling.values());
        var expectedPrice = BagelType.BGLO.getPrice();
        for (var f : Filling.values()) {
            expectedPrice = expectedPrice.add(f.getPrice());
        }

        assertEquals(expectedPrice, bagel.getPrice());
    }
}
