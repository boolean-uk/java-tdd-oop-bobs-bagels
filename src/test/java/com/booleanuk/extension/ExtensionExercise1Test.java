package com.booleanuk.extension;

import com.booleanuk.core.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExtensionExercise1Test {

    @Test
    void returnItemsWithDiscount() {
        ExtensionExercise1 extensionExercise1 = new ExtensionExercise1();

        extensionExercise1.getBasketList().clear();

        for(int i = 0; i < 6; i++) { // = 2.49 (Onion Bagel Discount)
            extensionExercise1.getBasketList().add(new Inventory("BGLO", 0.49, "Bagel", "Onion"));
        }
        for(int i = 0; i < 12; i++) { // = 3.99 (Plain Bagel Discount)
            extensionExercise1.getBasketList().add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));
        }
        for(int i = 0; i < 6; i++) { // = 2.49 (Everything Bagel Discount)
            extensionExercise1.getBasketList().add(new Inventory("BGLE", 0.49, "Bagel", "Everything"));
        }
        for(int i = 0; i < 1; i++) { // = 1.25 (Coffee + Bagel Discount)
            extensionExercise1.getBasketList().add(new Inventory("BGLE", 0.49, "Bagel", "Everything"));
            extensionExercise1.getBasketList().add(new Inventory("COFB", 0.99, "Coffee", "Black"));
        }

        //1 extra individual plain bagel = 0.49
        //extensionExercise1.getBasketList().add(new Inventory("BGLP", 0.39, "Bagel", "Plain"));

        double result = extensionExercise1.returnItemsWithDiscount();

        /*
        double onionBagelDiscountPrice = 2.49;
        double plainBagelDiscountPrice = 3.99;
        double everythingBagelDiscountPrice = 2.49;
        double coffeeAndBagelDiscountPrice = 1.25;
        double individualOnionAndEverythingBagelPrice = 0.49;
        double IndividualPlainBagelPrice = 0.39;
        double individualCoffeePrice = 0.99;
         */

        double expectedSum = 2.49 + 3.99 + 2.49 + 1.25;
        Assertions.assertEquals(expectedSum, result);
    }
}