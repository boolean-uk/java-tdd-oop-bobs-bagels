package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BasketTest {
    @Test /* User story 1 */
    public void testAddBagelToEmptyBasket() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        String sKU = testInventory.getSKU("Plain");

        Bagel plain = new Bagel("Plain", sKU);

        Assertions.assertTrue(testBasket.addItem(plain));
    }

    @Test /* User story 3 and 10*/
    public void testAddBagelToFullBasket() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        testBasket.addItem(new Bagel("Plain", testInventory.getSKU("Plain")));
        testBasket.addItem(new Bagel("Onion", testInventory.getSKU("Onion")));
        testBasket.addItem(new Bagel("Everything", testInventory.getSKU("Everything")));
        testBasket.addItem(new Bagel("Sesame", testInventory.getSKU("Sesame")));
        testBasket.addItem(new Coffee("Black", testInventory.getSKU("Black")));

        Assertions.assertFalse(testBasket.addItem(new Bagel("Plain", testInventory.getSKU("Plain"))));
    }

    @Test /* User story 2 */
    public void testRemoveBagelFromBasket() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        ArrayList<Item> expected = new ArrayList<>();

        Bagel plain = new Bagel("Plain", testInventory.getSKU("Plain"));
        Bagel onion = new Bagel("Onion", testInventory.getSKU("Onion"));
        Bagel every = new Bagel("Everything", testInventory.getSKU("Everything"));
        Bagel sesame = new Bagel("Sesame", testInventory.getSKU("Sesame"));
        Coffee black = new Coffee("Black", testInventory.getSKU("Black"));

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

    @Test /* User story 2 */
    public void testRemoveBagelFromEmptyBasket() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        ArrayList<Item> expected = new ArrayList<>();

        Bagel plain = new Bagel("Plain", testInventory.getSKU("Plain"));

        String expectedString = "Basket is empty, can't remove items.";

        Assertions.assertEquals(expectedString, testBasket.removeItem(plain));
        Assertions.assertEquals(expected, testBasket.getBasket());
    }

    @Test /* User story 5 */
    public void testRemoveBagelThatIsNotInBasket() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        ArrayList<Item> expected = new ArrayList<>();

        Bagel plain = new Bagel("Plain", testInventory.getSKU("Plain"));
        Bagel onion = new Bagel("Onion", testInventory.getSKU("Onion"));
        Coffee white = new Coffee("White", testInventory.getSKU("White"));
        Bagel sesame = new Bagel("Sesame", testInventory.getSKU("Sesame"));
        Coffee black = new Coffee("Black", testInventory.getSKU("Black"));

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

        Bagel everything = new Bagel("Everything", testInventory.getSKU("Everything"));

        String expectedString = "Can't remove " + everything.getName() + ", item not in basket.";

        Assertions.assertEquals(expectedString, testBasket.removeItem(everything));
        Assertions.assertEquals(expected, testBasket.getBasket());
    }

    @Test /* User story 4 */
    public void testChangeToBiggerCapacityAndAddItemsAfter() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        Bagel plain = new Bagel("Plain", testInventory.getSKU("Plain"));
        Bagel onion = new Bagel("Onion", testInventory.getSKU("Onion"));
        Coffee white = new Coffee("White", testInventory.getSKU("White"));
        Bagel sesame = new Bagel("Sesame", testInventory.getSKU("Sesame"));
        Coffee black = new Coffee("Black", testInventory.getSKU("Black"));
        testBasket.addItem(plain);
        testBasket.addItem(onion);
        testBasket.addItem(white);
        testBasket.addItem(sesame);
        testBasket.addItem(black);

        Assertions.assertTrue(testBasket.changeBasketCapacity(10));
        Assertions.assertEquals(10, testBasket.getBasketCapacity());

        Bagel plain2 = new Bagel("Plain", testInventory.getSKU("Plain"));
        Bagel everything = new Bagel("Everything", testInventory.getSKU("Everything"));
        Coffee cappu = new Coffee("Cappuccino", testInventory.getSKU("Cappuccino"));
        Coffee latte = new Coffee("Latte", testInventory.getSKU("Latte"));
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

    @Test /* User story 4 */
    public void testChangeToSmallerCapacity() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        Bagel plain = new Bagel("Plain", testInventory.getSKU("Plain"));
        Bagel onion = new Bagel("Onion", testInventory.getSKU("Onion"));
        Coffee white = new Coffee("White", testInventory.getSKU("White"));
        Bagel sesame = new Bagel("Sesame", testInventory.getSKU("Sesame"));
        Coffee black = new Coffee("Black", testInventory.getSKU("Black"));
        testBasket.addItem(plain);
        testBasket.addItem(onion);
        testBasket.addItem(white);
        testBasket.addItem(sesame);
        testBasket.addItem(black);

        Assertions.assertFalse(testBasket.changeBasketCapacity(3));
        Assertions.assertEquals(5, testBasket.getBasketCapacity());
    }

    @Test /* User story 6 */
    public void testShowCostOfAllItemsInBasket() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        Bagel plain = new Bagel("Plain", testInventory.getSKU("Plain"));
        Bagel onion = new Bagel("Onion", testInventory.getSKU("Onion"));
        Coffee white = new Coffee("White", testInventory.getSKU("White"));
        Bagel sesame = new Bagel("Sesame", testInventory.getSKU("Sesame"));
        Coffee black = new Coffee("Black", testInventory.getSKU("Black"));
        testBasket.addItem(plain);
        testBasket.addItem(onion);
        testBasket.addItem(white);
        testBasket.addItem(sesame);
        testBasket.addItem(black);

        double expectedPrice = 0.39 + 0.49 + 1.19 + 0.49 + 0.99;

        Assertions.assertEquals(expectedPrice, testBasket.showTotalCostInBasket(), 0.01);
    }

    @Test /* User story 7 and 9 */
    public void testShowCostOfAllItemsInInventory() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        String expectedBagelOutput = "Bagels:\n";

        expectedBagelOutput += "Onion costs £" + 0.49 + "\n";
        expectedBagelOutput += "Plain costs £" + 0.39 + "\n";
        expectedBagelOutput += "Everything costs £" + 0.49 + "\n";
        expectedBagelOutput += "Sesame costs £" + 0.49 + "\n";

        Assertions.assertEquals(expectedBagelOutput, testBasket.getBagelPrices());

        String expectedCoffeeOutput = "Coffees:\n";
        expectedCoffeeOutput += "Black costs £" + 0.99 + "\n";
        expectedCoffeeOutput += "White costs £" + 1.19 + "\n";
        expectedCoffeeOutput += "Cappuccino costs £" + 1.29 + "\n";
        expectedCoffeeOutput += "Latte costs £" + 1.29 + "\n";

        Assertions.assertEquals(expectedCoffeeOutput, testBasket.getCoffeePrices());

        String expectedFillingOutput = "Fillings:\n";
        expectedFillingOutput += "Bacon costs £" + 0.12 + "\n";
        expectedFillingOutput += "Egg costs £" + 0.12 + "\n";
        expectedFillingOutput += "Cheese costs £" + 0.12 + "\n";
        expectedFillingOutput += "Cream Cheese costs £" + 0.12 + "\n";
        expectedFillingOutput += "Smoked Salmon costs £" + 0.12 + "\n";
        expectedFillingOutput += "Ham costs £" + 0.12 + "\n";

        Assertions.assertEquals(expectedFillingOutput, testBasket.getFillingPrices());
    }

    @Test /* User story 8 and 10*/
    public void testAddFillingToOneBagel() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        Bagel plain = new Bagel("Plain", testInventory.getSKU("Plain"));
        Filling bacon = new Filling("Bacon", testInventory.getSKU("Bacon"));

        Assertions.assertFalse(testBasket.addBagelFilling(plain, bacon));

        testBasket.addItem(plain);
        Assertions.assertTrue(testBasket.addBagelFilling(plain, bacon));

        Set<String> expectedFillingsInBagel = new HashSet<>();
        expectedFillingsInBagel.add(bacon.getName());

        Assertions.assertEquals(expectedFillingsInBagel, plain.getFillings());

        ArrayList<Item> expected = new ArrayList<>();
        expected.add(plain);

        Assertions.assertEquals(expected, testBasket.getBasket());
    }

    @Test
    public void testAddMultipleFillings() {
        Inventory testInventory = new Inventory();
        Basket testBasket = new Basket(testInventory);

        Bagel plain = new Bagel("Plain", testInventory.getSKU("Plain"));
        testBasket.addItem(plain);
        Filling bacon = new Filling("Bacon", testInventory.getSKU("Bacon"));
        testBasket.addBagelFilling(plain, bacon);
        Filling cheese = new Filling("Cheese", testInventory.getSKU("Cheese"));

        Assertions.assertTrue(testBasket.addBagelFilling(plain, cheese));

        Set<String> expectedFillingsInPlainBagel = new HashSet<>();
        expectedFillingsInPlainBagel.add(bacon.getName());
        expectedFillingsInPlainBagel.add(cheese.getName());

        Assertions.assertEquals(expectedFillingsInPlainBagel, plain.getFillings());
    }

    @Test
    public void testIfValidCustomerOrder() {
        Inventory testInventory = new Inventory();

        String customerOrder = "Chocolate";
        Assertions.assertFalse(testInventory.canItemBeOrdered(customerOrder));

        customerOrder = "Plain";
        Assertions.assertTrue(testInventory.canItemBeOrdered(customerOrder));
    }
}
