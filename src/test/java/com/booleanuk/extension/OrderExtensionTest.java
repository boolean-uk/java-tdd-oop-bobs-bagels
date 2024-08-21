package com.booleanuk.extension;

import com.booleanuk.core.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderExtensionTest {

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
