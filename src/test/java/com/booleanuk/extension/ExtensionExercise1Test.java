package com.booleanuk.extension;

import com.booleanuk.core.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExtensionExercise1Test {

    @Test
    void returnItemsWithDiscount() {
        ExtensionExercise1 extensionExercise1 = new ExtensionExercise1();

        extensionExercise1.getBasketList().clear();

        for(int i = 0; i < 6; i++) {
            extensionExercise1.getBasketList().add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        }

        for(int i = 0; i < 12; i++) {
            extensionExercise1.getBasketList().add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        }

        double result = extensionExercise1.returnItemsWithDiscount();

        double sum = 2.49 + 3.99;
        Assertions.assertEquals(sum, result);

        /*
        extensionExercise1.getBasketList().add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        extensionExercise1.getBasketList().add(new Inventory("BGLE", 0.49, "Bagel", "Everything"));
        extensionExercise1.getBasketList().add(new Inventory("COFB", 0.99, "Coffee", "Black"));
        */
    }
}