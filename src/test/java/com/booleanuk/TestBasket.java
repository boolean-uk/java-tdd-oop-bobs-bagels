package com.booleanuk;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBasket {
    @Test
    public void testAddBagel() {
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        boolean r = newBagel.addFilling(new Filling("Bacon",0.12));

        Assertions.assertTrue(r);

        Basket b = new Basket(100, new Inventory(), new Receipt());
        r = b.add(newBagel);

        Assertions.assertTrue(r);
    }

    @Test
    public void testAddCoffee() {
        Coffee c = new Coffee("Black", 0.99);

        Basket b = new Basket(100, new Inventory(), new Receipt());
        boolean r = b.add(c);

        Assertions.assertTrue(r);
    }

    @Test
    public void testRemoveBagel() {
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        newBagel.addFilling(new Filling("Bacon",0.12));

        Basket b = new Basket(100, new Inventory(), new Receipt());
        b.add(newBagel);

//        Bagel sameNewBagel = new Bagel("Onion", 0.49, new Inventory());

        boolean r = b.remove(new Bagel("Onion", 0.49, new Inventory()));
        Assertions.assertTrue(r);
    }

    @Test
    public void testRemoveCoffee() {
        Coffee c = new Coffee("Black", 0.99);

        Basket b = new Basket(100, new Inventory(), new Receipt());
        boolean r = b.add(c);

        Assertions.assertTrue(r);

        r = b.remove(c);
        Assertions.assertTrue(r);
    }

    @Test
    public void testUpdateCapacity() {
        Coffee c = new Coffee("Black", 0.99);
        Coffee c2 = new Coffee("White", 1.19);

        Basket b = new Basket(2, new Inventory(), new Receipt());
        b.add(c);
        b.add(c2);

        boolean r = b.updateCapacity(1);
        Assertions.assertFalse(r);

        r = b.updateCapacity(10);
        Assertions.assertTrue(r);
    }

    @Test
    public void testAdd12IdenticalWithCoffees() {
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        Bagel newBagel2 = new Bagel("Plain", 0.39, new Inventory());

        Basket b = new Basket(100, new Inventory(), new Receipt());
        b.add(newBagel);
        for (int i = 0; i < 11; i++) {
            Assertions.assertTrue(b.add(newBagel2));
        }

        Coffee newCoffee = new Coffee("White", 1.19);
        Coffee newCoffee2 = new Coffee("Black", 0.99);
        Coffee newCoffee3 = new Coffee("White", 1.19);
        b.add(newCoffee);
        b.add(newCoffee2);
        b.add(newCoffee3);

        Assertions.assertEquals(7.41, b.discountedCost());

        // 11 bagels onion, 1 bagel plain and one cappucino and one white
        // 6 of the same, 5 of onion bagels, 1 plain
        // 2.49 + 3*1.25 + 2*0.39 + 0.39 = 6.63+0.98 = 7.61 YUHUUUUU YEIII!! 10-10=0 :)
    }
}
