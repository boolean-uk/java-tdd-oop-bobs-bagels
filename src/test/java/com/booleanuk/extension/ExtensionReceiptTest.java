package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ExtensionReceiptTest {
    private HashMap<Item, Integer> itemsThatArePurchased = new HashMap<>(){{
        // Adding the bagels
        Item onionBagel = new OnionBagel(0.49, "BGLO", "Onion", "Bagel") {};
        put(onionBagel, 2);

        Item plainBagel = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
        put(plainBagel, 12);

        Item everythingBagel = new EverythingBagel(0.49, "BGLE", "Everything", "Bagel") {};
        put(everythingBagel, 6);

        Item blackCoffee = new BlackCoffee(0.99, "COFB", "Black", "Coffee"){};
        put(blackCoffee, 3);
    }};

    @Test
    public void correctReceiptIsPrinted(){
        ExtensionReceipt receipt = new ExtensionReceipt(itemsThatArePurchased);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateOfPurchase = sdf.format(new Date());

        String desiredOutput = "~~~ Bob's Bagels ~~~ \n\n" +
                                    dateOfPurchase +
                               "\n----------------------------\n" +
                               "Onion Bagel        2   £0.98" +
                               "Plain Bagel        12  £3.99" +
                               "Everything Bagel   6   £2.49" +
                               "Coffee             3   £2.97\n" +
                               "\n----------------------------\n" +
                               "Total                 £10.43\n" +
                               "Thank you\n" +
                               "for your order!";


        Assertions.assertEquals(desiredOutput, receipt.printReceipt());
    }
}
