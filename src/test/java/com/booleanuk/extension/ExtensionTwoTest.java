package com.booleanuk.extension;

import com.booleanuk.core.Store;
import com.booleanuk.core.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionTwoTest {

    @Test
    public void createReceiptForOneProductTest() {
        Store store = new Store();
        int basketId = store.createBasket();
        store.addBagelToBasket("Plain", basketId);
        Receipt receipt = store.createReceipt(basketId);

        String expected =
                        "    ~~~ Bob's Bagels ~~~   " +
                        "\n" +
                        "\n   2021-03-16 21:38:44 " +
                        "\n" +
                        "\n----------------------------" +
                        "\n" +
                        "\nPlain Bagel         1  \u00A30.39" +
                        "\n" +
                        "\n----------------------------" +
                        "\nTotal                  \u00A30.39" +
                        "\n" +
                        "\n        Thank you" +
                        "\n     for your order!";

        System.out.println(expected);
        Assertions.assertEquals(expected, receipt.toString());

    }
}
