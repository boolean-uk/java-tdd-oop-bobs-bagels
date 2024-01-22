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

        extensionExercise2.getInventoryList().clear();

        extensionExercise2.getInventoryList().add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        extensionExercise2.getInventoryList().add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));

        String receipt = extensionExercise2.returnReceipt();

        Assertions.assertTrue(receipt.contains("Onion Bagel     1 £0.49"));
        Assertions.assertTrue(receipt.contains("Plain Bagel     1 £0.39"));
        Assertions.assertTrue(receipt.contains("Total                 £0.88"));
    }
}