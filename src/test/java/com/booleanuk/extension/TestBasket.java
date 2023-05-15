package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBasket {
    @Test
    public void testAdd6Identical() {
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        Bagel newBagel2 = new Bagel("Plain", 0.39, new Inventory());

        Basket b = new Basket(10, new Inventory());
        b.add(newBagel);
        b.add(newBagel);
        b.add(newBagel);
        b.add(newBagel);
        b.add(newBagel);
        b.add(newBagel2);

        // 6 different bagels => cost = 5 * 0.49 + 0.39 = 2.84
        Assertions.assertEquals(2.84, b.discountedCost());

        // 6 identical
        b.add(newBagel);

        // 6 identical bagels plus 1 different => cost = 2.49 + 0.39 = 2.88
        Assertions.assertEquals(2.88, b.discountedCost());
    }

    @Test
    public void testAdd12Identical() {
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        Bagel newBagel2 = new Bagel("Plain", 0.39, new Inventory());

        Basket b = new Basket(10, new Inventory());
        for (int i = 0; i < 11; i++) {
            b.add(newBagel);
        }
        b.add(newBagel2);

        // 12 different bagels => cost = 11 * 0.49 + 0.39 = 5.78
        Assertions.assertEquals(5.78, b.discountedCost());

        // 6 identical
        b.add(newBagel);

        // 12 identical bagels plus 1 different => cost = 3.99 + 0.39 = 4.38
        Assertions.assertEquals(4.38, b.discountedCost());
    }

}
