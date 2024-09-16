package com.booleanuk.core.Products;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
public class FillingTest {
    @Test
    public void testFilling() {
        Filling bacon = new Filling("FILB", new BigDecimal("0.12"), "Filling", FillingType.Bacon);
        Filling egg = new Filling("FILE", new BigDecimal("0.12"), "Filling", FillingType.Egg);

        assertEquals("FILB", bacon.getSku());
        assertEquals(BigDecimal.valueOf(0.12), bacon.getPrice());
        assertEquals("Filling", bacon.getName());
        assertEquals(FillingType.Bacon, bacon.getVariant());

        assertEquals("FILE", egg.getSku());
        assertEquals(BigDecimal.valueOf(0.12), egg.getPrice());
        assertEquals("Filling", egg.getName());
        assertEquals(FillingType.Egg, egg.getVariant());
    }

    @Test
    public void testSetAndGetVariant() {
        Filling cheese = new Filling("FILC", new BigDecimal("0.12"), "Filling", FillingType.Cheese);
        Filling creamCheese = new Filling("FILX", new BigDecimal("0.12"), "Filling", FillingType.CreamCheese);

        cheese.setVariant(FillingType.Cheese);
        assertEquals(FillingType.Cheese, cheese.getVariant());
        cheese.setVariant(FillingType.Ham);
        assertEquals(FillingType.Ham, cheese.getVariant());
        creamCheese.setVariant(FillingType.CreamCheese);
        assertEquals(FillingType.CreamCheese, creamCheese.getVariant());
    }

    @Test
    public void testToString() {
        Filling smokedSalmon = new Filling("FILS", new BigDecimal("0.12"), "Filling", FillingType.SmokedSalmon);
        Filling ham = new Filling("FILH", new BigDecimal("0.12"), "Filling", FillingType.Ham);

        assertEquals("SmokedSalmon Filling", smokedSalmon.toString());
        assertEquals("Ham Filling", ham.toString());
    }
}
