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
    public void testGetBagelByVariant() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Onion", Collections.emptyList());

        Assertions.assertEquals(bagel, Manager.getBagelByVariant("Onion"));
    }

    @Test
    public void testGetBagelByVariantShouldThrowException(){
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> bob.getBagelByVariant("Nonexistent"));

        Assertions.assertEquals("Bagel with variant Nonexistent " +
                "is not in the inventory!", exception.getMessage());
    }

    @Test
    public void testGetFillingByVariant(){
        Filling filling = new Filling("FILB", 0.12, "Bacon");

        Assertions.assertEquals(filling, bob.getFillingByVariant("Bacon"));
    }

    @Test
    public void testGetFillingByVariantShouldThrowException(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> bob.getFillingByVariant("Nonexistent"));
    }

    @Test
    public void testGetFillingsByVariants() {
        List<Filling> expected = List.of(
                new Filling("FILB", 0.12, "Bacon"),
                new Filling("FILE", 0.12, "Egg")
        );

        List<Filling> actual = bob.getFillingsByVariants(List.of("Bacon", "Egg"));

        Assertions.assertEquals(expected, actual);
    }

}