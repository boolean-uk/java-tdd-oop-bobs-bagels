package com.booleanuk.core.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductsTest {

    @Test
    public void shouldCreateBagelProperly() {
        Bagel bagel = new Bagel("SKU1", 0.44);
        Assertions.assertEquals("SKU1", bagel.getSKU());
        Assertions.assertEquals(0.44, bagel.getPrice());
    }

    @Test
    public void shouldCreateCoffeeProperly() {
        Coffee coffee = new Coffee("SKU2", 0.45);
        Assertions.assertEquals("SKU2", coffee.getSKU());
        Assertions.assertEquals(0.45, coffee.getPrice());
    }

    @Test
    public void shouldCreateFillingProperly() {
        Filling filling = new Filling("SKU3", 0.46);
        Assertions.assertEquals("SKU3", filling.getSKU());
        Assertions.assertEquals(0.46, filling.getPrice());
    }

    @Test
    public void ShouldEvaluateThePriceWithFillingProperly() {
        Filling filling = new Filling("SKU3", 0.46);
        Bagel bagel = new Bagel("SKU1", 0.44);
        bagel.getFillings().add(filling);
        Assertions.assertEquals(0.90, bagel.getPriceWithFilling());
    }


}
