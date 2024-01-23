package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderTest {


    @Test
    public void isBagelInventory() {
        Order basket1 = new Order();

        boolean result = basket1.add("BGLO", "Bagel", "Onion", 0.49);
        Assertions.assertTrue(result);
    }

    @Test
    public void isBagelNotInventory() {
        Order basket1 = new Order();

        boolean result = basket1.add("RATT", "ggg", "ddd", 0.3);
        Assertions.assertFalse(result);

    }

    @Test
    public void isItemRemovable() {
        Order basket1 = new Order();


        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        boolean result = basket1.remove("BGLO", "Bagel", "Onion", 0.49);
        Assertions.assertTrue(result);
    }

    @Test
    public void isItemNotRemovable() {
        Order basket1 = new Order();

        boolean result = basket1.remove("RATT", "ggg", "ddd", 0.3);
        Assertions.assertFalse(result);

    }

    @Test
    public void basketIsFull() {
        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        boolean result = basket1.isBasketFull();
        Assertions.assertTrue(result);

    }


    @Test
    public void basketIsNotFull() {
        Order basket1 = new Order();

        boolean result = basket1.isBasketFull();
        Assertions.assertFalse(result);

    }

    @Test
    public void hasListBeenUpdated() {
        Order basket1 = new Order();

        int result = basket1.updateBasket(30);
        Assertions.assertEquals(30, result);
    }

    @Test
    public void testItemCanBeRemoved() {
        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        String result = basket1.canItemBeRemoved("Onion");
        Assertions.assertEquals("The item can be removed.", result);
    }

    @Test
    public void testItemCannotBeRemoved() {
        Order basket1 = new Order();

        String result = basket1.canItemBeRemoved("Fried");
        Assertions.assertEquals("The item is not in the basket!", result);

    }

    @Test
    public void testTotalCostCorrect() {
        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLP", "Bagel", "Plain", 0.39);
        double result = basket1.totalCost();
        Assertions.assertEquals(0.88, result);
    }

    @Test
    public void testTotalCostWrong() {
        Order basket1 = new Order();

        double result = basket1.totalCost();
        Assertions.assertEquals(0, result);

    }

    @Test
    public void testGetCost() {
        Order basket1 = new Order();

        double result = basket1.getCost("Onion");
        double result2 = basket1.getCost("Plain");
        double result3 = basket1.getCost("Everything");
        Assertions.assertEquals(0.49, result);
        Assertions.assertEquals(0.39, result2);
        Assertions.assertEquals(0.49, result3);

    }

    @Test
    public void isFillingInventory() {
        Order basket1 = new Order();

        boolean result1 = basket1.chooseFilling("FILB", "Filling", "Bacon", 0.12);
        boolean result2 = basket1.chooseFilling("FILE", "Filling", "Egg", 0.12);
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
    }

    @Test
    public void isFillingNotInventory() {
        Order basket1 = new Order();

        boolean result1 = basket1.chooseFilling("RATT", "ggg", "ddd", 0.3);
        boolean result2 = basket1.chooseFilling("RATP", "ggg", "ddd", 0.3);
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);

    }

    @Test
    public void testGetCostFilling() {
        Order basket1 = new Order();

        double result = basket1.getFillingCost("Bacon");
        double result2 = basket1.getFillingCost("Egg");
        double result3 = basket1.getFillingCost("Ham");
        Assertions.assertEquals(0.12, result);
        Assertions.assertEquals(0.12, result2);
        Assertions.assertEquals(0.12, result3);

    }

    @Test
    public void testGetReceipt() {
        Order basket1 = new Order();


        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLP", "Bagel", "Plain", 0.39);
        basket1.add("COFW", "Coffee", "White", 1.19);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILX", "Filling", "Cream Cheese", 0.12);
        String result = basket1.receipt();
        Assertions.assertEquals("~~~ Bob's Bagels ~~~\n" +
                "\n" +
                "2024-01-22 12:23:52\n" +
                "\n" +
                "----------------------------\n" +
                "Bagel     Onion          1   £0.49\n" +
                "Bagel     Plain          1   £0.39\n" +
                "Coffee    White          1   £1.19\n" +
                "Filling   Egg            1   £0.12\n" +
                "Filling   Cream Cheese   1   £0.12\n" +
                "----------------------------\n" +
                "Total:              £1.88\n" +
                "\n" +
                "        Thank you\n" +
                "      for your order!", result);



    }

    @Test
    public void testGetReceiptWithInvalidItems() {
        Order basket1 = new Order();


        basket1.add("rr", "rr", "rr", 0.49);
        basket1.add("rr", "rr", "rr", 0.39);
        basket1.add("COFW", "Coffee", "White", 1.19);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILX", "Filling", "Cream Cheese", 0.12);
        String result = basket1.receipt();
        Assertions.assertEquals("~~~ Bob's Bagels ~~~\n" +
                "\n" +
                "2024-01-22 12:23:52\n" +
                "\n" +
                "----------------------------\n" +
                "Coffee    White          1   £1.19\n" +
                "Filling   Egg            1   £0.12\n" +
                "Filling   Cream Cheese   1   £0.12\n" +
                "----------------------------\n" +
                "Total:              £1.43\n" +
                "\n" +
                "        Thank you\n" +
                "      for your order!", result);



    }

    @Test
    public void testGetReceiptWithMultipleItems() throws ParseException {
        String fixedDate = "2024-01-22 12:23:52";
        Date fixedDateObj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fixedDate);

        Order basket1 = new Order();

        basket1.add("COFW", "Coffee", "White", 1.19);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILX", "Filling", "Cream Cheese", 0.12);
        String result = basket1.receipt();

        Assertions.assertEquals("~~~ Bob's Bagels ~~~\n" +
                "\n" +
                "2024-01-22 12:23:52\n" +
                "\n" +
                "----------------------------\n" +
                "Coffee    White          1   £1.19\n" +
                "Filling   Egg            5   £0.60\n" +
                "Filling   Cream Cheese   1   £0.12\n" +
                "----------------------------\n" +
                "Total:              £1.91\n" +
                "\n" +
                "        Thank you\n" +
                "      for your order!", result);
    }


    @Test
    public void testGetReceiptWithNoItems() throws ParseException {


        Order basket1 = new Order();
        String result = basket1.receipt();

        Assertions.assertEquals("Nothing added.", result);
    }

    @Test
    public void testGetDiscountSixBagels() throws ParseException {





        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);

        double result = basket1.totalCost();

        System.out.println(result);
        //System.out.println(basket1.check());
        System.out.println(basket1.discount());


        Assertions.assertEquals(2.49, result);
    }

    @Test
    public void testGetDiscountTwelveBagels() throws ParseException {





        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);

        double result = basket1.totalCost();



        Assertions.assertEquals(3.990000000000002, result);
    }

    @Test
    public void testGetDiscountCoffeeBagel() throws ParseException {





        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("COFW", "Coffee", "White", 1.19);

        double result = basket1.totalCost();



        Assertions.assertEquals(1.25, result);
    }
    @Test
    public void testGetDiscountCoffeeBagelAndSixBagels() throws ParseException {





        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("COFW", "Coffee", "White", 1.19);

        double result = basket1.totalCost();



        Assertions.assertEquals(3.250000000000001, result);
    }

    @Test
    public void testGetDiscountCoffeeBagelAndTwelveBagels() throws ParseException {





        Order basket1 = new Order();

        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("BGLO", "Bagel", "Onion", 0.49);
        basket1.add("COFW", "Coffee", "White", 1.19);

        double result = basket1.totalCost();



        Assertions.assertEquals(4.750000000000002, result);
    }


    @Test
    public void testGetReceiptWithDiscount() throws ParseException {

        String fixedDate = "2024-01-22 12:23:52";
        Date fixedDateObj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fixedDate);

        Order basket1 = new Order();

        basket1.add("COFW", "Coffee", "White", 1.19);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILE", "Filling", "Egg", 0.12);
        basket1.add("FILX", "Filling", "Cream Cheese", 0.12);
        String result = basket1.receipt();


        Assertions.assertEquals("~~~ Bob's Bagels ~~~\n" +
                "\n" +
                "2024-01-22 12:23:52\n" +
                "\n" +
                "----------------------------\n" +
                "Coffee    White          1   £1.19\n" +
                "Filling   Egg            5   £0.60\n" +
                "Filling   Cream Cheese   1   £0.12\n" +
                "----------------------------\n" +
                "Total:              £1.91\n" +
                "\n" +
                "        Thank you\n" +
                "      for your order!", result);
    }



}
