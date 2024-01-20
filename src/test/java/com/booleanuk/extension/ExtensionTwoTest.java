package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Store;
import com.booleanuk.core.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtensionTwoTest {

    @Test
    public void createReceiptForOneProductTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addItemToBasket(new Bagel("plain"), basketId);
        Receipt receipt = store.createReceipt(basketId);
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
                        "\nPLAIN BAGEL        1   \u00A30.39" +
                        "\n" +
                        "\n----------------------------" +
                        "\nTotal                  \u00A30.39" +
                        "\n" +
                        "\n         Thank you" +
                        "\n      for your order!";

        Assertions.assertEquals(expected, receipt.toString());
    }

    @Test
    public void createReceiptForSeveralProductsTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.updateBasketCapacity(16);
        for(int i=0; i < 16; i++) {
            store.addItemToBasket(new Bagel("plain"), basketId);
        }
        Receipt receipt = store.createReceipt(basketId);
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
                        "\nPLAIN BAGEL        16  \u00A35.55" +
                        "\n" +
                        "\n----------------------------" +
                        "\nTotal                  \u00A35.55" +
                        "\n" +
                        "\n         Thank you" +
                        "\n      for your order!";

        Assertions.assertEquals(expected, receipt.toString());

    }

    @Test
    public void createReceiptForSeveralProductsOfDifferentKindsTest() {
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

        Receipt receipt = store.createReceipt(basketId);
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
                        "\nONION BAGEL        2   \u00A30.98" +
                        "\nPLAIN BAGEL        12  \u00A33.99" +
                        "\nEVERYTHING BAGEL   6   \u00A32.49" +
                        "\nBLACK COFFEE       3   \u00A32.97" +
                        "\n" +
                        "\n----------------------------" +
                        "\nTotal                 \u00A310.43" +
                        "\n" +
                        "\n         Thank you" +
                        "\n      for your order!";

        Assertions.assertEquals(expected, receipt.toString());

    }


    //TODO: add test with fillings
}
