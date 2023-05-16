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

        Basket b = new Basket(100, new Inventory());
        for (int i = 0; i < 11; i++) {
            b.add(newBagel);
        }
        b.add(newBagel2);

        // 12 different bagels => cost = 5 * 0.49 + 2.49 = 5.78
        Assertions.assertEquals(5.33, b.discountedCost());

        // 6 identical
        b.add(newBagel);

        // 12 identical bagels plus 1 different => cost = 3.99 + 0.39 = 4.38
        Assertions.assertEquals(4.38, b.discountedCost());
    }

    @Test
    public void testAdd12IdenticalWithCoffees() {
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        Bagel newBagel2 = new Bagel("Plain", 0.39, new Inventory());

        Basket b = new Basket(100, new Inventory());
        for (int i = 0; i < 11; i++) {
            b.add(newBagel2);
        }
        b.add(newBagel);

        Coffee newCoffee = new Coffee("White", 1.19) ;
        Coffee newCoffee2 = new Coffee("Capuccino", 0.99) ;
        Coffee newCoffee3 = new Coffee("White", 1.19) ;
        b.add(newCoffee);
        b.add(newCoffee2);
        b.add(newCoffee3);

        Assertions.assertEquals(7.41, b.discountedCost());


        // 11 bagels onion, 1 bagel plain and one cappucino and one white
        // 6 of the same, 5 of onion bagels, 1 plain
        // 2.49 + 3*1.25 + 2*0.39 + 0.39 = 6.63+0.98 = 7.61 YUHUUUUU YEIII!! 10-10=0 :)





    }

}
