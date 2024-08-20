package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.FillingType;
import com.booleanuk.core.inherited.Bagel;
import com.booleanuk.core.inherited.Filling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BagelTest {
    Bagel bagel;

    @BeforeEach
    public void setUp() {
        bagel = new Bagel().createBagelWithFilling(
                BagelType.ONION,
                FillingType.BACON,
                FillingType.CHEESE
        );
    }

    @Test
    public void testCreateBagelWithFillings() {
        Filling bacon = this.bagel.getFillings().get(0);
        Filling cheese = this.bagel.getFillings().get(1);

        Assertions.assertEquals(bacon.getVariant(), FillingType.BACON);
        Assertions.assertEquals(cheese.getVariant(), FillingType.CHEESE);
    }


    @Test
    public void testPriceOfFilling() {
        Bagel testBagel = new Bagel();
        Double priceForEgg = testBagel.getFillingPrice(FillingType.EGG);
        Double priceForCheese = testBagel.getFillingPrice(FillingType.CHEESE);

        Assertions.assertEquals(priceForEgg, 0.12);
        Assertions.assertEquals(priceForCheese, 0.12);
    }
}
