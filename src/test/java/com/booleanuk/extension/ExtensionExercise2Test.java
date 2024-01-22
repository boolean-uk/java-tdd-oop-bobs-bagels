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

        extensionExercise2.addItem(item1, 2);
        extensionExercise2.addItem(item2, 3);

        String receipt = extensionExercise2.returnReceipt();

        //Different way to check the receipt String having the correct values without
        // having to put in a whole new receipt string in the expected value.
        Assertions.assertTrue(receipt.contains("Onion Bagel     2 £0.98"));
        Assertions.assertTrue(receipt.contains("Plain Bagel     3 £1.17"));
        Assertions.assertTrue(receipt.contains("Total                 £2.15"));
    }
}