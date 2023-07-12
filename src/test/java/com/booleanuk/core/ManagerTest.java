package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ManagerTest {
    private Manager bob;
    private static final int INITIAL_BASKET_CAPACITY = 15;
    private final List<Product> initialInventory = List.of(
            // new Product(...),
            // new Product(...)
    );

    public ManagerTest() {
    }

    @BeforeEach
    public void setUp(){
        bob = new Manager(INITIAL_BASKET_CAPACITY,
                initialInventory);
    }

    @Test
    public void testChangeBasketCapacity(){
        Assertions.assertDoesNotThrow(() -> bob.changeBasketsCapacity(INITIAL_BASKET_CAPACITY));
        Assertions.assertEquals(INITIAL_BASKET_CAPACITY, bob.getBasketCapacity());
        Assertions.assertThrows(IllegalArgumentException.class, () -> bob.changeBasketsCapacity(5));
    }

    @Test
    public void testGetInventory() {
        // Execute
        List<Product> inventory = bob.getInventory();

        // Verify
        Assertions.assertEquals(initialInventory, inventory);

    }
}
