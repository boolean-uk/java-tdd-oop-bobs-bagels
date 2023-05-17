package com.booleanuk.extension;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestReceipt {

    @Test
    public void TestData(){
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        Bagel newBagel2 = new Bagel("Plain", 0.39, new Inventory());

        Receipt receipt = new Receipt();
        receipt.add(newBagel);
        receipt.add(newBagel);
        receipt.add(newBagel2);
        receipt.add(newBagel2);
        receipt.add(newBagel2);
        receipt.add(newBagel2);

        Assertions.assertEquals(2, receipt.bagels.get(newBagel));
        System.out.println(receipt.bagels);

    }

    @Test
    public void TestRemove(){
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        Bagel newBagel2 = new Bagel("Plain", 0.39, new Inventory());
        Bagel newBagel3 = new Bagel("Cheese", 0.39, new Inventory());

        Receipt receipt = new Receipt();
        receipt.add(newBagel);
        receipt.add(newBagel);
        receipt.add(newBagel2);
        receipt.add(newBagel2);
        receipt.add(newBagel2);
        receipt.add(newBagel2);

        receipt.remove(newBagel2);
        receipt.remove(newBagel2);
        receipt.remove(newBagel2);
        receipt.remove(newBagel3);
        Assertions.assertEquals(1, receipt.bagels.get(newBagel2));

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
    public void testAdd12IdenticalWithLessCoffeesThanBagels() {
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
        //should be 7.41 with coffees


        // 11 bagels onion, 1 bagel plain and one cappucino and one white
        // 6 of the same, 5 of onion bagels, 1 plain
        // 2.49 + 3*1.25 + 2*0.39 + 0.39 = 6.63+0.98 = 7.61 YUHUUUUU YEIII!! 10-10=0 :)
    }

    @Test
    public void testAdd12IdenticalWithMoreCoffeesThanBagels() {
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        Bagel newBagel2 = new Bagel("Plain", 0.39, new Inventory());

        Basket b = new Basket(100, new Inventory());
        for (int i = 0; i < 7; i++) { //-> 7
            b.add(newBagel2);
        }
        b.add(newBagel); // -> 8

        Coffee newCoffee = new Coffee("White", 1.19);
        Coffee newCoffee2 = new Coffee("Capuccino", 0.99);
        Coffee newCoffee3 = new Coffee("White", 1.19);
        b.add(newCoffee);
        b.add(newCoffee2);
        b.add(newCoffee3);

        // 2.49 + 2.5 + 0.99
        Assertions.assertEquals(5.98, b.discountedCost());
    }

}
