package com.booleanuk.core.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductsTest {

    @Test
    public void shouldCreateBagelProperly() {
        Bagel bagel = new Bagel("SKU1", BigDecimal.valueOf(0.44));
        Assertions.assertEquals("SKU1", bagel.getSKU());
        Assertions.assertEquals(BigDecimal.valueOf(0.44), bagel.getPrice());
    }

    @Test
    public void shouldCreateCoffeeProperly() {
        Coffee coffee = new Coffee("SKU2", BigDecimal.valueOf(0.45));
        Assertions.assertEquals("SKU2", coffee.getSKU());
        Assertions.assertEquals(BigDecimal.valueOf(0.45), coffee.getPrice());
    }

    @Test
    public void shouldCreateFillingProperly() {
        Filling filling = new Filling("SKU3", BigDecimal.valueOf(0.46), FillingVariant.Bacon);
        Assertions.assertEquals("SKU3", filling.getSKU());
        Assertions.assertEquals(BigDecimal.valueOf(0.46), filling.getPrice());
    }

    @Test
    public void ShouldEvaluateThePriceWithFillingProperly() {
        Filling filling = new Filling("SKU3", BigDecimal.valueOf(0.46), FillingVariant.Egg);
        Bagel bagel = new Bagel("SKU1", BigDecimal.valueOf(0.44));
        bagel.getFillings().add(filling);
        Assertions.assertEquals(BigDecimal.valueOf(0.90).doubleValue(), bagel.getPriceWithFilling().doubleValue());
    }
}
