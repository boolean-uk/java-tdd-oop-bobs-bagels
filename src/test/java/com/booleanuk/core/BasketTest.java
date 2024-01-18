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

        String expectedString = "Removed " + plain.getName() + "from basket.";

        Assertions.assertEquals(expectedString, testBasket.removeItem(plain));
        Assertions.assertEquals(expected, testBasket.getBasket());
    }

    @Test
    public void testRemoveBagelFromEmptyBasket() {
        Basket testBasket = new Basket();
        SKUConverter converter = new SKUConverter();

        ArrayList<Item> expected = new ArrayList<>();

        Bagel plain = new Bagel("Plain", converter.getSKU("Plain"));

        String expectedString = "Basket is empty, can't remove items.";

        Assertions.assertEquals(expectedString, testBasket.removeItem(plain));
        Assertions.assertEquals(expected, testBasket.getBasket());
    }

    @Test
    public void testRemoveBagelThatIsNotInBasket() {
        Basket testBasket = new Basket();
        SKUConverter converter = new SKUConverter();

        ArrayList<Item> expected = new ArrayList<>();

        Bagel plain = new Bagel("Plain", converter.getSKU("Plain"));
        Bagel onion = new Bagel("Onion", converter.getSKU("Onion"));
        Coffee white = new Coffee("White", converter.getSKU("White"));
        Bagel sesame = new Bagel("Sesame", converter.getSKU("Sesame"));
        Coffee black = new Coffee("Black", converter.getSKU("Black"));

        testBasket.addItem(plain);
        testBasket.addItem(onion);
        testBasket.addItem(white);
        testBasket.addItem(sesame);
        testBasket.addItem(black);

        expected.add(plain);
        expected.add(onion);
        expected.add(white);
        expected.add(sesame);
        expected.add(black);

        Bagel everything = new Bagel("Everything", converter.getSKU("Everything"));

        String expectedString = "Can't remove " + everything.getName() + ", item not in basket.";

        Assertions.assertEquals(expectedString, testBasket.removeItem(everything));
        Assertions.assertEquals(expected, testBasket.getBasket());
    }

    @Test
    public void testChangeToBiggerCapacityAndAddItemsAfter() {
        Basket testBasket = new Basket();
        SKUConverter converter = new SKUConverter();

        Bagel plain = new Bagel("Plain", converter.getSKU("Plain"));
        Bagel onion = new Bagel("Onion", converter.getSKU("Onion"));
        Coffee white = new Coffee("White", converter.getSKU("White"));
        Bagel sesame = new Bagel("Sesame", converter.getSKU("Sesame"));
        Coffee black = new Coffee("Black", converter.getSKU("Black"));
        testBasket.addItem(plain);
        testBasket.addItem(onion);
        testBasket.addItem(white);
        testBasket.addItem(sesame);
        testBasket.addItem(black);

        Assertions.assertTrue(testBasket.changeBasketCapacity(10));
        Assertions.assertEquals(10, testBasket.getBasketCapacity());

        Bagel plain2 = new Bagel("Plain", converter.getSKU("Plain"));
        Bagel everything = new Bagel("Everything", converter.getSKU("Everything"));
        Coffee cappu = new Coffee("Cappuccino", converter.getSKU("Cappuccino"));
        Coffee latte = new Coffee("Latte", converter.getSKU("Latte"));
        testBasket.addItem(plain2);
        testBasket.addItem(everything);
        testBasket.addItem(cappu);
        testBasket.addItem(latte);

        ArrayList<Item> expected = new ArrayList<>();
        expected.add(plain);
        expected.add(onion);
        expected.add(white);
        expected.add(sesame);
        expected.add(black);
        expected.add(plain2);
        expected.add(everything);
        expected.add(cappu);
        expected.add(latte);

        Assertions.assertEquals(expected, testBasket.getBasket());
    }

    @Test
    public void testChangeToSmallerCapacity() {
        Basket testBasket = new Basket();
        SKUConverter converter = new SKUConverter();

        Bagel plain = new Bagel("Plain", converter.getSKU("Plain"));
        Bagel onion = new Bagel("Onion", converter.getSKU("Onion"));
        Coffee white = new Coffee("White", converter.getSKU("White"));
        Bagel sesame = new Bagel("Sesame", converter.getSKU("Sesame"));
        Coffee black = new Coffee("Black", converter.getSKU("Black"));
        testBasket.addItem(plain);
        testBasket.addItem(onion);
        testBasket.addItem(white);
        testBasket.addItem(sesame);
        testBasket.addItem(black);

        Assertions.assertFalse(testBasket.changeBasketCapacity(3));
        Assertions.assertEquals(5, testBasket.getBasketCapacity());
    }
}
