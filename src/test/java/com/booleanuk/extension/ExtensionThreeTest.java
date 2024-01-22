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
    public void createReceiptForOneProductTest() {
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
                        "\n You saved a total of \u00A30.0"+
                        "\n        on this shop"+
                        "\n" +
                        "\n         Thank you" +
                        "\n      for your order!";

        Assertions.assertEquals(expected, receipt.toString());
    }
}
