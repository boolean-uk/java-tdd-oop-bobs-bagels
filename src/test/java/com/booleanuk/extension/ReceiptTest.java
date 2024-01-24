package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptTest {

    @Test
    public void testPrintReceiptWithItemsInBasket() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Receipt receipt = new Receipt();

        String item1 = "Plain";
        Assertions.assertTrue(inventory.canItemBeOrdered(item1));
        Bagel bagel1 = new Bagel(item1, inventory.getSKU(item1));
        basket.addItem(bagel1);

        String item2 = "White";
        Assertions.assertTrue(inventory.canItemBeOrdered(item2));
        Item coffee1 = new Coffee(item2, inventory.getSKU(item2));
        basket.addItem(coffee1);

        String item3 = "Everything";
        Assertions.assertTrue(inventory.canItemBeOrdered(item3));
        Bagel bagel2 = new Bagel(item3, inventory.getSKU(item3));
        basket.addItem(bagel2);

        String item4 = "Black";
        Assertions.assertTrue(inventory.canItemBeOrdered(item4));
        Item coffee2 = new Coffee(item4, inventory.getSKU(item4));
        basket.addItem(coffee2);

        String item5 = "Bacon";
        Assertions.assertTrue(inventory.canItemBeOrdered(item5));
        basket.addBagelFilling(bagel1, new Filling(item5, inventory.getSKU(item5)));

        String item6 = "Cream Cheese";
        Assertions.assertTrue(inventory.canItemBeOrdered(item5));
        basket.addBagelFilling(bagel2, new Filling(item6, inventory.getSKU(item6)));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();

        String expectedReceipt = "";
        expectedReceipt += "       ~~~ Bob's Bagels ~~~       \n";
        expectedReceipt += "\n";
        expectedReceipt += "        " + dtf.format(dateTime) + "       \n";
        expectedReceipt += "\n";
        expectedReceipt += "-----------------------------------\n";
        expectedReceipt += "\n";
        expectedReceipt += "Plain Bagel               1  £0.39\n";
        expectedReceipt += "with Bacon filling        1  £0.12\n";
        expectedReceipt += "Everything Bagel          1  £0.49\n";
        expectedReceipt += "with Cream Cheese filling 1  £0.12\n";
        expectedReceipt += "White Coffee              1  £1.19\n";
        expectedReceipt += "Black Coffee              1  £0.99\n";
        expectedReceipt += "\n";
        expectedReceipt += "-----------------------------------\n";
        expectedReceipt += "Total                         £3.30\n";
        expectedReceipt += "\n";
        expectedReceipt += "            Thank you             \n";
        expectedReceipt += "         for your order!          \n";

        Assertions.assertTrue(receipt.printReceipt(basket, inventory));

        Assertions.assertEquals(expectedReceipt, outContent.toString());
    }

    @Test
    public void testPrintReceiptWithEmptyBasket() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Receipt receipt = new Receipt();

        String expectedReceipt = "You have no items in your basket, can't print receipt!\n";

        Assertions.assertFalse(receipt.printReceipt(basket, inventory));
        Assertions.assertEquals(expectedReceipt, outContent.toString());
    }

    @Test
    public void testPrintReceiptWithManyOfSameItem() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Receipt receipt = new Receipt();

        basket.changeBasketCapacity(10);

        String itemStringPlain = "Plain";
        Assertions.assertTrue(inventory.canItemBeOrdered(itemStringPlain));
        Bagel plain1 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain1);

        Bagel plain2 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain2);

        Bagel plain3 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain3);

        String itemStringEverything = "Everything";
        Assertions.assertTrue(inventory.canItemBeOrdered(itemStringEverything));
        Bagel everything1 = new Bagel(itemStringEverything, inventory.getSKU(itemStringEverything));
        basket.addItem(everything1);

        Bagel everything2 = new Bagel(itemStringEverything, inventory.getSKU(itemStringEverything));
        basket.addItem(everything2);

        String itemStringBlack = "Black";
        Assertions.assertTrue(inventory.canItemBeOrdered(itemStringBlack));
        Item black1 = new Coffee(itemStringBlack, inventory.getSKU(itemStringBlack));
        basket.addItem(black1);

        Item black2 = new Coffee(itemStringBlack, inventory.getSKU(itemStringBlack));
        basket.addItem(black2);

        String itemStringBacon = "Bacon";
        Assertions.assertTrue(inventory.canItemBeOrdered(itemStringBacon));
        basket.addBagelFilling(plain1, new Filling(itemStringBacon, inventory.getSKU(itemStringBacon)));
        basket.addBagelFilling(plain1, new Filling(itemStringBacon, inventory.getSKU(itemStringBacon)));

        String itemStringCream = "Cream Cheese";
        Assertions.assertTrue(inventory.canItemBeOrdered(itemStringBacon));
        basket.addBagelFilling(everything2, new Filling(itemStringCream, inventory.getSKU(itemStringCream)));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();

        String expectedReceipt = "";
        expectedReceipt += "       ~~~ Bob's Bagels ~~~       \n";
        expectedReceipt += "\n";
        expectedReceipt += "        " + dtf.format(dateTime) + "       \n";
        expectedReceipt += "\n";
        expectedReceipt += "-----------------------------------\n";
        expectedReceipt += "\n";
        expectedReceipt += "Plain Bagel               3  £1.17\n";
        expectedReceipt += "with Bacon filling        2  £0.24\n";
        expectedReceipt += "Everything Bagel          2  £0.98\n";
        expectedReceipt += "with Cream Cheese filling 1  £0.12\n";
        expectedReceipt += "Black Coffee              2  £1.98\n";
        expectedReceipt += "\n";
        expectedReceipt += "-----------------------------------\n";
        expectedReceipt += "Total                         £4.37\n";
        expectedReceipt += "\n";
        expectedReceipt += "            Thank you             \n";
        expectedReceipt += "         for your order!          \n";

        Assertions.assertTrue(receipt.printReceipt(basket, inventory));

        Assertions.assertEquals(expectedReceipt, outContent.toString());
    }

    @Test
    public void testPrintReceiptManyItems() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Receipt receipt = new Receipt();

        basket.changeBasketCapacity(25);

        String itemStringOnion = "Onion";
        Assertions.assertTrue(inventory.canItemBeOrdered(itemStringOnion));
        Bagel onion1 = new Bagel(itemStringOnion, inventory.getSKU(itemStringOnion));
        basket.addItem(onion1);

        String itemStringPlain = "Plain";
        Assertions.assertTrue(inventory.canItemBeOrdered(itemStringPlain));
        Bagel plain1 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain1);

        Bagel plain2 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain2);

        Bagel plain3 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain3);

        Bagel onion2 = new Bagel(itemStringOnion, inventory.getSKU(itemStringOnion));
        basket.addItem(onion2);

        Bagel plain4 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain4);

        Bagel plain5 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain5);

        String itemStringEverything = "Everything";
        Assertions.assertTrue(inventory.canItemBeOrdered(itemStringEverything));
        Bagel everything1 = new Bagel(itemStringEverything, inventory.getSKU(itemStringEverything));
        basket.addItem(everything1);

        Bagel plain6 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain6);

        Bagel plain7 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain7);

        Bagel everything2 = new Bagel(itemStringEverything, inventory.getSKU(itemStringEverything));
        basket.addItem(everything2);

        String itemStringBlack = "Black";
        Assertions.assertTrue(inventory.canItemBeOrdered(itemStringBlack));
        Item black1 = new Coffee(itemStringBlack, inventory.getSKU(itemStringBlack));
        basket.addItem(black1);

        Bagel plain8 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain8);

        Item black2 = new Coffee(itemStringBlack, inventory.getSKU(itemStringBlack));
        basket.addItem(black2);

        Bagel everything3 = new Bagel(itemStringEverything, inventory.getSKU(itemStringEverything));
        basket.addItem(everything3);

        Bagel everything4 = new Bagel(itemStringEverything, inventory.getSKU(itemStringEverything));
        basket.addItem(everything4);

        Bagel everything5 = new Bagel(itemStringEverything, inventory.getSKU(itemStringEverything));
        basket.addItem(everything5);

        Bagel everything6 = new Bagel(itemStringEverything, inventory.getSKU(itemStringEverything));
        basket.addItem(everything6);

        Bagel plain9 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain9);

        Item black3 = new Coffee(itemStringBlack, inventory.getSKU(itemStringBlack));
        basket.addItem(black3);

        Bagel plain10 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain10);

        Bagel plain11 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain11);

        Bagel plain12 = new Bagel(itemStringPlain, inventory.getSKU(itemStringPlain));
        basket.addItem(plain12);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.now();

        String expectedReceipt = "";
        expectedReceipt += "       ~~~ Bob's Bagels ~~~       \n";
        expectedReceipt += "\n";
        expectedReceipt += "        " + dtf.format(dateTime) + "       \n";
        expectedReceipt += "\n";
        expectedReceipt += "-----------------------------------\n";
        expectedReceipt += "\n";
        expectedReceipt += "Onion Bagel               2  £0.98\n";
        expectedReceipt += "Plain Bagel              12  £4.68\n";
        expectedReceipt += "Everything Bagel          6  £2.94\n";
        expectedReceipt += "Black Coffee              3  £2.97\n";
        expectedReceipt += "\n";
        expectedReceipt += "-----------------------------------\n";
        expectedReceipt += "Total                        £11.57\n";
        expectedReceipt += "\n";
        expectedReceipt += "            Thank you             \n";
        expectedReceipt += "         for your order!          \n";

        Assertions.assertTrue(receipt.printReceipt(basket, inventory));

        Assertions.assertEquals(expectedReceipt, outContent.toString());
    }
}
