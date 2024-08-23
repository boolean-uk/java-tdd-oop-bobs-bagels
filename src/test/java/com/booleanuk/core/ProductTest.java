package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.inherited.Bagel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testGetPriceForBagel() {
        Product bagel = new Bagel.BagelBuilder(BagelType.ONION).build();
        Assertions.assertEquals(0.49, bagel.getPrice());
    }
}
