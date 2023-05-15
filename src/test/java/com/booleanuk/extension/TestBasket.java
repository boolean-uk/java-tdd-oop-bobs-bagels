package com.booleanuk.extension;

import com.booleanuk.extension.Bagel;
import com.booleanuk.extension.Basket;
import com.booleanuk.extension.Coffee;
import com.booleanuk.extension.Filling;
import com.booleanuk.extension.Inventory;

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

}
