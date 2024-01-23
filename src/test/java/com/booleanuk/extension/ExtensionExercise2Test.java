package com.booleanuk.extension;

import com.booleanuk.core.Inventory;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class ExtensionExercise2Test {

    @Test
    void returnReceipt() {

        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String expectedDate = dateFormat.format(new Date());


        ExtensionExercise2 extensionExercise2 = new ExtensionExercise2();

        Inventory item1 = new Inventory("BGLO", 0.49, "Bagel", "Onion");
        Inventory item2 = new Inventory("BGLP", 0.39, "Bagel", "Plain");
        Inventory item3 = new Inventory("BGLE", 0.49, "Bagel", "Everything");

        extensionExercise2.addItem(item1, 2);
        extensionExercise2.addItem(item2, 3);
        extensionExercise2.addItem(item3, 1);

        String returnedReceipt = extensionExercise2.returnReceipt();

        String expectedReceipt = "\n"
                + "    ~~~ Bob's Bagels ~~~    \n\n"
                + "    2024-01-23 08:50:13   \n\n"
                + "----------------------------\n\n"
                + String.format("%-" + 30 + "s", String.format("%-19s", item1.getVariant() + " " +item1.getName()) + String.format("%3d £%.2f", 2, 0.98)) + "\n"
                + String.format("%-" + 30 + "s", String.format("%-19s", item2.getVariant() + " " +item2.getName()) + String.format("%3d £%.2f", 3, 1.17)) + "\n"
                + String.format("%-" + 30 + "s", String.format("%-19s", item3.getVariant() + " " +item3.getName()) + String.format("%3d £%.2f", 1, 0.49)) + "\n"
                + "                            \n"
                + "----------------------------\n"
                + "Total                  £2.64" + "\n\n"
                + "         Thank you\n"
                + "      for your order!       \n\n";



        //Different way to check the receipt String having the correct values without
        // having to put in a whole new receipt string in the expected value.
        Assertions.assertEquals(expectedReceipt, returnedReceipt);
        System.out.println(expectedReceipt);
    }
}