package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void testAddBagelToEmptyBasket() {
        Basket test = new Basket();
        SKUConverter converter = new SKUConverter();

        String sKU = converter.getSKU("Plain");

        Bagel plain = new Bagel("Plain", sKU);

        Assertions.assertTrue(test.addItem(plain));
    }

    @Test
    public void testAddBagelToFullBasket() {
        Basket test = new Basket();
        SKUConverter converter = new SKUConverter();

        test.addItem(new Bagel("Plain", converter.getSKU("Plain")));
        test.addItem(new Bagel("Onion", converter.getSKU("Onion")));
        test.addItem(new Bagel("Everything", converter.getSKU("Everything")));
        test.addItem(new Bagel("Sesame", converter.getSKU("Sesame")));
        test.addItem(new Coffee("Black", converter.getSKU("Black")));

        Assertions.assertFalse(test.addItem(new Bagel("Plain", converter.getSKU("Plain"))));
    }

    @Test
    public void testRemoveBagelFromBasket() {
        Basket test = new Basket();
        SKUConverter converter = new SKUConverter();

        Bagel plain = new Bagel("Plain", converter.getSKU("Plain"));
        Bagel onion = new Bagel("Onion", converter.getSKU("Onion"));
        Bagel every = new Bagel("Everything", converter.getSKU("Everything"));
        Bagel sesame = new Bagel("Sesame", converter.getSKU("Sesame"));
        Coffee black = new Coffee("Black", converter.getSKU("Black"));

        test.addItem(plain);
        test.addItem(onion);
        test.addItem(every);
        test.addItem(sesame);
        test.addItem(black);

        Assertions.assertTrue(test.removeItem(plain));
    }
}
