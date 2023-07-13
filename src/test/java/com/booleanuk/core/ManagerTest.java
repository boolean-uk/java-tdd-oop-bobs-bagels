package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class ManagerTest {
    private Manager bob;
    private static final int INITIAL_BASKET_CAPACITY = 15;

    private static final List<Product> inventory = List.of(
            new Bagel("BGLO", 0.49, "Onion", Collections.emptyList()),
            new Bagel("BGLP", 0.39, "Plain", Collections.emptyList()),
            new Bagel("BGLE", 0.49, "Everything", Collections.emptyList()),
            new Bagel("BGLS", 0.49, "Sesame", Collections.emptyList()),
            new Coffee("COFB", 0.99, "Black"),
            new Coffee("COFW", 1.19, "White"),
            new Coffee("COFC", 1.29, "Cappuccino"),
            new Coffee("COFL", 1.29, "Latte"),
            new Filling("FILB", 0.12, "Bacon"),
            new Filling("FILE", 0.12, "Egg"),
            new Filling("FILC", 0.12, "Cheese"),
            new Filling("FILX", 0.12, "Cream Cheese"),
            new Filling("FILS", 0.12, "Smoked Salmon"),
            new Filling("FILH", 0.12, "Ham")
    );

    @BeforeEach
    public void setUp(){
        bob = new Manager(INITIAL_BASKET_CAPACITY);
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
        List<Product> managerInventory = Manager.getInventory();

        // Verify
        Assertions.assertEquals(inventory, managerInventory);
    }

    @Test
    void testGetBagelByVariant(){
        List<Filling> fillings = List.of(
                new Filling("BGLO", 0.49, "Onion")
        );
        Bagel bagel = new Bagel("BGLO", 0.49, "Onion", fillings);

        Assertions.assertEquals(bagel, bob.getBagelByVariant("BGLO"));
    }

    @Test
    void testGetBagelByVariantShouldThrowException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> bob.getBagelByVariant("Nonexistent"));
    }

    @Test
    void testGetFillingByVariant(){
        List<Filling> fillings = List.of(
                new Filling("NO FILLING", 0.12, "Bacon")
        );
        Filling filling = new Filling("BGLO", 0.49, "Onion");

       Assertions.assertEquals(filling, bob.getFillingByVariant("Bacon"));
    }

    @Test
    void testGetFillingByVariantShouldThrowException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> bob.getFillingByVariant("Nonexistent"));
    }

    @Test
    void testGetFillingsByVariants() {
        List<Filling> expected = List.of(
                new Filling("FILB", 0.12, "Bacon"),
                new Filling("FILE", 0.12, "Egg")
        );

        List<Filling> actual = bob.getFillingsByVariants(List.of("Bacon", "Egg"));

        Assertions.assertEquals(expected, actual);
    }

}
