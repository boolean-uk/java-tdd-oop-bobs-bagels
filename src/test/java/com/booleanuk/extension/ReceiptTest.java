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
    public void testCompleteReceipt() {
        Basket basket = new Basket();
        Receipt receipt= new Receipt(basket);
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

        String testReceipt = """
        
           ~~~ Bob's Bagels ~~~

                14.01.2025

        ---------------------------

        Plain Bagel     5     £1.95
        Onion Bagel     5     £2.45
        Black Coffee    1     £0.99
        Cheese Filling  1     £0.12
        Egg Fillings    1     £0.12
        
        ---------------------------
        Total                 £5.63

        Thank you for your order!
        """;
        Assertions.assertEquals(testReceipt, receipt.conStructReceipt(receipt.constructDate(), receipt.constructBody(), receipt.constructTotal()));
    }


}
