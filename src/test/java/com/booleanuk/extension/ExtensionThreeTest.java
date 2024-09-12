package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;

public class ExtensionThreeTest {

    @Test
    public void createReceiptForOneProductWithDiscountTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addItemToBasket(new Bagel("plain"), basketId);
        Receipt receipt = store.createReceiptWithDiscountData(basketId);
        Date date = new Date();
        int width = 28;
        String dateFormatted = new SimpleDateFormat("dd-MM-yyyy").format(date) + " " + new SimpleDateFormat("H:mm:ss").format(date);
        dateFormatted = " ".repeat((width-dateFormatted.length())/2)+dateFormatted;
        String expected =
                " ".repeat(4)+"~~~ Bob's Bagels ~~~" +
                        "\n\n" +
                        dateFormatted+
                        "\n" +
                        "\n----------------------------" +
                        "\n" +
                        "\nPlain Bagel        1   \u00A30.39" +
                        "\n" +
                        "\n----------------------------" +
                        "\nTotal                  \u00A30.39" +
                        "\n" +
                        "\n You saved a total of \u00A30.00"+
                        "\n        on this shop"+
                        "\n" +
                        "\n         Thank you" +
                        "\n      for your order!";

        Assertions.assertEquals(expected, receipt.toString());
    }

    @Test
    public void createReceiptForSeveralProductsWithDiscountsTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.updateBasketCapacity(16);
        for(int i=0; i < 16; i++) {
            store.addItemToBasket(new Bagel("plain"), basketId);
        }
        Receipt receipt = store.createReceiptWithDiscountData(basketId);
        Date date = new Date();
        int width = 28;
        String dateFormatted = new SimpleDateFormat("dd-MM-yyyy").format(date) + " " + new SimpleDateFormat("H:mm:ss").format(date);
        dateFormatted = " ".repeat((width-dateFormatted.length())/2)+dateFormatted;
        String expected =
                " ".repeat(4)+"~~~ Bob's Bagels ~~~" +
                        "\n\n" +
                        dateFormatted+
                        "\n" +
                        "\n----------------------------" +
                        "\n" +
                        "\nPlain Bagel        16  \u00A35.55" +
                        "\n                    (-\u00A30.69)" +
                        "\n" +
                        "\n----------------------------" +
                        "\nTotal                  \u00A35.55" +
                        "\n" +
                        "\n You saved a total of \u00A30.69"+
                        "\n        on this shop"+
                        "\n" +
                        "\n         Thank you" +
                        "\n      for your order!";

        Assertions.assertEquals(expected, receipt.toString());
    }

    @Test
    public void createReceiptForSeveralProductsOfDifferentKindsWithDiscountsTest() {

        Store store = new Store();
        store.updateBasketCapacity(100);
        int basketId = store.createBasket();

        for(int i=0; i < 2; i++) {
            store.addItemToBasket(new Bagel("onion"), basketId);
        }
        for(int i=0; i < 12; i++) {
            store.addItemToBasket(new Bagel("plain"), basketId);
        }
        for(int i=0; i < 6; i++) {
            store.addItemToBasket(new Bagel("everything"), basketId);
        }
        for(int i=0; i < 3; i++) {
            store.addItemToBasket(new Coffee("blaCk"), basketId);
        }

        Receipt receipt = store.createReceiptWithDiscountData(basketId);
        Date date = new Date();
        int width = 28;
        String dateFormatted = new SimpleDateFormat("dd-MM-yyyy").format(date) + " " + new SimpleDateFormat("H:mm:ss").format(date);
        dateFormatted = " ".repeat((width-dateFormatted.length())/2)+dateFormatted;
        String expected =
                " ".repeat(4)+"~~~ Bob's Bagels ~~~" +
                        "\n\n" +
                        dateFormatted+
                        "\n" +
                        "\n----------------------------" +
                        "\n" +
                        "\nPlain Bagel        12  \u00A33.99" +
                        "\n                    (-\u00A30.69)" +
                        "\nEverything Bagel   6   \u00A32.49" +
                        "\n                    (-\u00A30.45)" +
                        "\nBlack Coffee       3   \u00A33.49" +
                        "\nOnion Bagel        2   \u00A30.00" +
                        "\n                    (-\u00A30.46)" +
                        "\n" +
                        "\n----------------------------" +
                        "\nTotal                  \u00A3" + store.getCostOfBasket(basketId)+
                        "\n" +
                        "\n You saved a total of \u00A31.60"+
                        "\n        on this shop"+
                        "\n" +
                        "\n         Thank you" +
                        "\n      for your order!";

        Assertions.assertEquals(expected, receipt.toString());

    }

    @Test
    public void createReceiptForSeveralProductsOfDifferentKindsWithFillingsAndWithDiscountsTest() {

        Store store = new Store();
        store.updateBasketCapacity(100);
        int basketId = store.createBasket();

        for(int i=0; i < 2; i++) {
            store.addItemToBasket(new Bagel("ONION", new ArrayList<>(Arrays.asList(new Filling("ham"), new Filling("egg")))), basketId);
        }
        for(int i=0; i < 12; i++) {
            store.addItemToBasket(new Bagel("plain"), basketId);
        }
        for(int i=0; i < 6; i++) {
            store.addItemToBasket(new Bagel("everything"), basketId);
        }
        for(int i=0; i < 3; i++) {
            store.addItemToBasket(new Coffee("blaCk"), basketId);
        }

        Receipt receipt = store.createReceiptWithDiscountData(basketId);
        Date date = new Date();
        int width = 28;
        String dateFormatted = new SimpleDateFormat("dd-MM-yyyy").format(date) + " " + new SimpleDateFormat("H:mm:ss").format(date);
        dateFormatted = " ".repeat((width-dateFormatted.length())/2)+dateFormatted;
        String expected =
                " ".repeat(4)+"~~~ Bob's Bagels ~~~" +
                        "\n\n" +
                        dateFormatted+
                        "\n" +
                        "\n----------------------------" +
                        "\n" +
                        "\nHam Filling        2   \u00A30.24" +
                        "\nEgg Filling        2   \u00A30.24" +
                        "\nPlain Bagel        12  \u00A33.99" +
                        "\n                    (-\u00A30.69)" +
                        "\nEverything Bagel   6   \u00A32.49" +
                        "\n                    (-\u00A30.45)" +
                        "\nBlack Coffee       3   \u00A33.49" +
                        "\nOnion Bagel        2   \u00A30.00" +
                        "\n                    (-\u00A30.46)" +
                        "\n" +
                        "\n----------------------------" +
                        "\nTotal                 \u00A3" + (store.getCostOfBasket(basketId)*100)/100+
                        "\n" +
                        "\n You saved a total of \u00A31.60"+
                        "\n        on this shop"+
                        "\n" +
                        "\n         Thank you" +
                        "\n      for your order!";

        Assertions.assertEquals(expected, receipt.toString());

    }

    @Test
    public void createReceiptForSeveralProductsOfDifferentKindsWithFillingsAndWithoutDiscountsTest() {

        Store store = new Store();
        store.updateBasketCapacity(100);
        int basketId = store.createBasket();

        for(int i=0; i < 2; i++) {
            store.addItemToBasket(new Bagel("ONION", new ArrayList<>(Arrays.asList(new Filling("ham"), new Filling("egg")))), basketId);
        }
        for(int i=0; i < 4; i++) {
            store.addItemToBasket(new Bagel("plain"), basketId);
        }
        for(int i=0; i < 5; i++) {
            store.addItemToBasket(new Bagel("everything"), basketId);
        }


        Receipt receipt = store.createReceiptWithDiscountData(basketId);
        Date date = new Date();
        int width = 28;
        String dateFormatted = new SimpleDateFormat("dd-MM-yyyy").format(date) + " " + new SimpleDateFormat("H:mm:ss").format(date);
        dateFormatted = " ".repeat((width-dateFormatted.length())/2)+dateFormatted;
        String expected =
                " ".repeat(4)+"~~~ Bob's Bagels ~~~" +
                        "\n\n" +
                        dateFormatted+
                        "\n" +
                        "\n----------------------------" +
                        "\n" +
                        "\nHam Filling        2   \u00A30.24" +
                        "\nEgg Filling        2   \u00A30.24" +
                        "\nOnion Bagel        2   \u00A30.98" +
                        "\nPlain Bagel        4   \u00A31.56" +
                        "\nEverything Bagel   5   \u00A32.45" +
                        "\n" +
                        "\n----------------------------" +
                        "\nTotal                  \u00A3" + (store.getCostOfBasket(basketId)*100)/100+
                        "\n" +
                        "\n You saved a total of \u00A30.00"+
                        "\n        on this shop"+
                        "\n" +
                        "\n         Thank you" +
                        "\n      for your order!";

        Assertions.assertEquals(expected, receipt.toString());

    }

    @Test
    public void createReceiptForSeveralProductsOfDifferentKindsWithFillingsAndWithMoreDiscountsTest() {

        Store store = new Store();
        store.updateBasketCapacity(100);
        int basketId = store.createBasket();

        for(int i=0; i < 2; i++) {
            store.addItemToBasket(new Bagel("ONION", new ArrayList<>(Arrays.asList(new Filling("ham"), new Filling("egg")))), basketId);
        }
        for(int i=0; i < 30; i++) {
            store.addItemToBasket(new Bagel("plain"), basketId);
        }
        for(int i=0; i < 6; i++) {
            store.addItemToBasket(new Bagel("everything"), basketId);
        }
        for(int i=0; i < 3; i++) {
            store.addItemToBasket(new Coffee("blaCk"), basketId);
        }

        Receipt receipt = store.createReceiptWithDiscountData(basketId);
        Date date = new Date();
        int width = 28;
        String dateFormatted = new SimpleDateFormat("dd-MM-yyyy").format(date) + " " + new SimpleDateFormat("H:mm:ss").format(date);
        dateFormatted = " ".repeat((width-dateFormatted.length())/2)+dateFormatted;
        String expected =
                " ".repeat(4)+"~~~ Bob's Bagels ~~~" +
                        "\n\n" +
                        dateFormatted+
                        "\n" +
                        "\n----------------------------" +
                        "\n" +
                        "\nHam Filling        2   \u00A30.24" +
                        "\nEgg Filling        2   \u00A30.24" +
                        "\nPlain Bagel        30 \u00A3" + (3.99*2+2.49)+
                        "\n                    (-\u00A31.23)" +
                        "\nEverything Bagel   6   \u00A32.49" +
                        "\n                    (-\u00A30.45)" +
                        "\nBlack Coffee       3   \u00A33.49" +
                        "\nOnion Bagel        2   \u00A30.00" +
                        "\n                    (-\u00A30.46)" +
                        "\n" +
                        "\n----------------------------" +
                        "\nTotal                 \u00A3" + (store.getCostOfBasket(basketId)*100)/100+
                        "\n" +
                        "\n You saved a total of \u00A32.14"+
                        "\n        on this shop"+
                        "\n" +
                        "\n         Thank you" +
                        "\n      for your order!";

        Assertions.assertEquals(expected, receipt.toString());
    }
}
