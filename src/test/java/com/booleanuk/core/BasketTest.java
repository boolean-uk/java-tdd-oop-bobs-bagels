package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BasketTest {
    @Test
    public void testAddBagelToEmptyBasket() {
        Basket testBasket = new Basket();
        SKUConverter converter = new SKUConverter();

        String sKU = converter.getSKU("Plain");

        Bagel plain = new Bagel("Plain", sKU);

        Assertions.assertTrue(testBasket.addItem(plain));
    }

    @Test
    public void testAddBagelToFullBasket() {
        Basket testBasket = new Basket();
        SKUConverter converter = new SKUConverter();

        testBasket.addItem(new Bagel("Plain", converter.getSKU("Plain")));
        testBasket.addItem(new Bagel("Onion", converter.getSKU("Onion")));
        testBasket.addItem(new Bagel("Everything", converter.getSKU("Everything")));
        testBasket.addItem(new Bagel("Sesame", converter.getSKU("Sesame")));
        testBasket.addItem(new Coffee("Black", converter.getSKU("Black")));

        Assertions.assertFalse(testBasket.addItem(new Bagel("Plain", converter.getSKU("Plain"))));
    }

    @Test
    public void testRemoveBagelFromBasket() {
        Basket testBasket = new Basket();
        SKUConverter converter = new SKUConverter();

        ArrayList<Item> expected = new ArrayList<>();

        Bagel plain = new Bagel("Plain", converter.getSKU("Plain"));
        Bagel onion = new Bagel("Onion", converter.getSKU("Onion"));
        Bagel every = new Bagel("Everything", converter.getSKU("Everything"));
        Bagel sesame = new Bagel("Sesame", converter.getSKU("Sesame"));
        Coffee black = new Coffee("Black", converter.getSKU("Black"));

        testBasket.addItem(plain);
        testBasket.addItem(onion);
        testBasket.addItem(every);
        testBasket.addItem(sesame);
        testBasket.addItem(black);

        expected.add(onion);
        expected.add(every);
        expected.add(sesame);
        expected.add(black);

        Assertions.assertTrue(testBasket.removeItem(plain));
        Assertions.assertEquals(expected, testBasket.getBasket());
    }

    @Test
    public void testRemoveBagelFromEmptyBasket() {
        Basket testBasket = new Basket();
        SKUConverter converter = new SKUConverter();

        ArrayList<Item> expected = new ArrayList<>();

        Bagel plain = new Bagel("Plain", converter.getSKU("Plain"));

        Assertions.assertFalse(testBasket.removeItem(plain));
        Assertions.assertEquals(expected, testBasket.getBasket());
    }
}
