package com.booleanuk.extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReceiptItemTest {
    @Test
    public void testGetters() {
        // Arrange
        String name = "Bagel";
        int quantity = 2;
        double price = 0.98;
        double savings = 0.25;

        // Act
        ReceiptItem item = new ReceiptItem(name, quantity, price, savings);

        // Assert
        Assertions.assertEquals(name, item.getName());
        Assertions.assertEquals(quantity, item.getQuantity());
        Assertions.assertEquals(price, item.getPrice());
        Assertions.assertEquals(savings, item.getSavings());
    }
}