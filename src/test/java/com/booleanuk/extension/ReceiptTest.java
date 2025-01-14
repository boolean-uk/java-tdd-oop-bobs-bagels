package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReceiptTest {

    @Test
    public void testDateHeader() {
        Basket basket = new Basket();
        Receipt receipt = new Receipt(basket);
        String date = """
        
           ~~~ Bob's Bagels ~~~

                %s

        ---------------------------
        """;
        String dateNow = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        date = String.format(date, dateNow);
        Assertions.assertEquals(date, receipt.constructDate());
        // Sort of doing the same thing as in the method tested, but date changed every day so hard to write a super different test
    }

    @Test
    public void testBodyConstruction() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item plainBagel = factory.createItem("BGLP");
        Item onionBagel = factory.createItem("BGLO");
        Item blackCoffee = factory.createItem("COFB");
        basket.addItem(plainBagel);
        basket.addItem(onionBagel);
        basket.addItem(blackCoffee);
        Receipt receipt = new Receipt(basket);
        receipt.dataToMap();
        StringBuilder testString1 = new StringBuilder();
        StringBuilder testString2 = new StringBuilder();

        String body = """
        
        Plain Bagel\t\t1\t\t0.39
        Onion Bagel\t\t1\t\t0.49
        Black Coffee\t\t1\t\t0.99
        
        ---------------------------
        """;
        testString1.append(body);
        testString2.append(receipt.constructBody());
        System.out.println(testString1);
        System.out.println(testString2);
        Assertions.assertEquals(0, testString1.compareTo(testString2));
    }

    @Test
    public void testTotalConstruction() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item plainBagel = factory.createItem("BGLP");
        Item onionBagel = factory.createItem("BGLO");
        Item blackCoffee = factory.createItem("COFB");
        basket.addItem(plainBagel);
        basket.addItem(onionBagel);
        basket.addItem(blackCoffee);
        Receipt receipt = new Receipt(basket);
        receipt.dataToMap();
        StringBuilder testString1 = new StringBuilder();
        StringBuilder testString2 = new StringBuilder();

        String testTotal = """
        Total                 1.87

        Thank you for your order!
        """;
        testString1.append(testTotal);
        testString2.append(receipt.constructTotal());
        Assertions.assertEquals(0,testString1.compareTo(testString2));

    }


    @Test
    public void testCompleteReceipt() {
        Basket basket = new Basket();
        ItemFactory factory = new ItemFactory();
        Item plainBagel = factory.createItem("BGLP");
        Item onionBagel = factory.createItem("BGLO");
        Item blackCoffee = factory.createItem("COFB");
        Item cheeseFilling = factory.createItem("FILC");
        Item eggFilling = factory.createItem("FILE");
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel);
        basket.addItem(plainBagel); // 5 plain
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel);
        basket.addItem(onionBagel); // 5 onion
        basket.addItem(blackCoffee);
        basket.addItem(cheeseFilling);
        basket.addItem(eggFilling);
        Receipt receipt= new Receipt(basket);
        receipt.dataToMap();

        String testReceipt = """
        
           ~~~ Bob's Bagels ~~~

                14-01-2025

        ---------------------------

        Plain Bagel\t\t5\t\t1.95
        Onion Bagel\t\t5\t\t2.45
        Black Coffee\t\t1\t\t0.99
        Cheese Filling\t\t1\t\t0.12
        Egg Filling\t\t1\t\t0.12
        
        ---------------------------
        Total                 5.63

        Thank you for your order!
        """;

        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder1.append(testReceipt);
        stringBuilder2.append(receipt.conStructReceipt(receipt.constructDate(), receipt.constructBody(), receipt.constructTotal()));
        System.out.println(testReceipt);
        System.out.println(receipt.conStructReceipt(receipt.constructDate(), receipt.constructBody(), receipt.constructTotal()));
        Assertions.assertEquals(0, stringBuilder1.compareTo(stringBuilder2));


    }


}
