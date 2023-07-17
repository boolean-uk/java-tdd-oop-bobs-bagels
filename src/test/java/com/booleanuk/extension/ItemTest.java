package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.booleanuk.extension.SKU.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    @Test
    public void testCreatingListOfItemSubclasses() {
        List<Item> items = new ArrayList<>();
        items.add(new Bagel(BGLP));
        items.add(new Coffee(COFB));
        items.add(new Filling(FILB));

        assertEquals(3, items.size());
    }
}
