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

    // testing total cost once again since I had to adjust it when using a HashMap instead of arraylist
    @Test
    public void discountsAreRecieved(){
        ExtensionReceipt receipt = new ExtensionReceipt(itemsThatArePurchased);

        Assertions.assertEquals(10.43, receipt.totalCostWithDiscounts());
    }

    // testing total cost once again since I had to adjust it when using a HashMap instead of arraylist
    @Test
    public void discountsAreNotRecieved(){
        HashMap<Item, Integer> listOfItems = new HashMap<>(){{
            Item plainBagel = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
            put(plainBagel, 5);
        }};

        ExtensionReceipt receipt = new ExtensionReceipt(listOfItems);

        Assertions.assertEquals(1.95, receipt.totalCostWithDiscounts());
    }

    // testing total cost once again since I had to adjust it when using a HashMap instead of arraylist
    @Test
    public void coffeeAndBagelDiscountAreRecieved(){
        HashMap<Item, Integer> listOfItems = new HashMap<>(){{
            Item plainBagel = new PlainBagel(0.39, "BGLP", "Plain", "Bagel") {};
            put(plainBagel, 1);
            Item blackCoffee = new BlackCoffee(0.99, "COFB", "Black", "Coffee"){};
            put(blackCoffee, 1);
        }};

        ExtensionReceipt receipt = new ExtensionReceipt(listOfItems);

        Assertions.assertEquals(1.25, receipt.totalCostWithDiscounts());
    }


// EXTENSION 2
    @Test
    public void correctReceiptIsPrinted(){
        ExtensionReceipt receipt = new ExtensionReceipt(itemsThatArePurchased);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateOfPurchase = sdf.format(new Date());

        String desiredOutput = "~~~ Bob's Bagels ~~~ \n\n" +
                                    dateOfPurchase +
                               "\n----------------------------\n" +
                               "Onion Bagel        2   £0.98\n" +
                               "Plain Bagel        12  £3.99\n" +
                               "Everything Bagel   6   £2.49\n" +
                               "Coffee             3   £2.97\n" +
                               "\n----------------------------\n" +
                               "Total                 £10.43\n" +
                               "Thank you\n" +
                               "for your order!";


        Assertions.assertEquals(desiredOutput, receipt.printReceipt());
    }

}
