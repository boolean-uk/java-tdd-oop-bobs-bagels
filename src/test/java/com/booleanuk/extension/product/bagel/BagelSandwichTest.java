package com.booleanuk.extension.product.bagel;

import com.booleanuk.extension.product.BagelSandwich;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagelSandwichTest {
    @Test
    public void price_shouldCorrectlyCalculatePrice() {
        var bagel = new BagelSandwich(BagelSandwich.Bagel.BGLO, BagelSandwich.Filling.values());
        var expectedPrice = BagelSandwich.Bagel.BGLO.getPrice();
        for (var f : BagelSandwich.Filling.values()) {
            expectedPrice = expectedPrice.add(f.getPrice());
        }

        assertEquals(expectedPrice, bagel.getPrice());
    }
}
