package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductTest {
    private static Inventory inventory;

    @BeforeAll
    static void setup() {
        inventory = new Inventory();
        inventory.addProduct("BGLO", 0.49F, "Bagel", "Onion");
        inventory.addProduct("BGLP", 0.39F, "Bagel", "Plain");
        inventory.addProduct("BGLE", 0.49F, "Bagel", "Everything");
        inventory.addProduct("BGLS", 0.49F, "Bagel", "Sesame");

        inventory.addProduct("COFB", 0.99F, "Coffee", "Black");
        inventory.addProduct("COFW", 1.19F, "Coffee", "White");
        inventory.addProduct("COFC", 1.29F, "Coffee", "Cappuccino");
        inventory.addProduct("COFL", 1.29F, "Coffee", "Latte");

        inventory.addProduct("FILB", 0.12F, "Filling", "Bacon");
        inventory.addProduct("FILE", 0.12F, "Filling", "Egg");
        inventory.addProduct("FILC", 0.12F, "Filling", "Cheese");
        inventory.addProduct("FILX", 0.12F, "Filling", "Cream Cheese");
        inventory.addProduct("FILS", 0.12F, "Filling", "Smoked Salmon");
        inventory.addProduct("FILH", 0.12F, "Filling", "Ham");
        inventory.addProduct("FILNOT", 0.12F, "NotFilling", "Feeling");
    }
    @Test
    public void testItemValidation_WhenSkuIsValid_ShouldNotThrowException() throws Exception {
        Assertions.assertDoesNotThrow(() -> new Product("BGLO", inventory));
    }

    @Test
    public void testItemValidation_WhenSkuIsNotValid_ShouldThrowWithProperMessage() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> new Product("BGLX", inventory));
        Assertions.assertEquals(exception.getMessage(), "Product is not in inventory");
    }
}
