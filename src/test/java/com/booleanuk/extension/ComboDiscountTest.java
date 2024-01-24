package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComboDiscountTest {

    @Test
    public void testComboDiscountConstructor() {
        ComboDiscount comboDiscount = new ComboDiscount("SKU", "NAME", 0.49);
        Assertions.assertEquals("SKU",comboDiscount.getSku());
        Assertions.assertEquals("NAME",comboDiscount.getName());
        Assertions.assertEquals(0.49,comboDiscount.getPrice());
    }

}