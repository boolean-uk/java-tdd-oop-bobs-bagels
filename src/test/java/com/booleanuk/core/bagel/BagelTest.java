package com.booleanuk.core.bagel;

import com.booleanuk.extension.bagel.Bagel;
import com.booleanuk.extension.bagel.BagelType;
import com.booleanuk.extension.bagel.Filling;
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
