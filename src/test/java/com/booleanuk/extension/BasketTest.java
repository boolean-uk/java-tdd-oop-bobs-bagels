package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class BasketTest {
    private Basket basket;

    private static final List<Filling> FILLINGS = List.of(
            new Filling("FILB", 0.12, "Bacon"),
            new Filling("FILC", 0.12, "Cheese")
    );

    private static final List<Bagel> BAGELS = List.of(
            new Bagel("BGLO", 0.49, "Onion", FILLINGS),
            new Bagel("BGLP", 0.39, "Plain", FILLINGS),
            new Bagel("BGLE", 0.49, "Everything", FILLINGS),
            new Bagel("BGLS", 0.49, "Sesame", FILLINGS)
    );
    private static final int INITIAL_CAPACITY = 4;

    @BeforeEach
    public void setUp() {
        Basket.setCapacity(INITIAL_CAPACITY);
        basket = new Basket();
    }

    @Test
    public void testAddToBasketShouldSucceed(){
        for (Bagel bagel : BAGELS) {
            Assertions.assertDoesNotThrow(() -> basket.addToBasket(bagel));
        }

        Assertions.assertEquals(BAGELS, basket.getContents());
    }

    @Test
    public void testAddToBasketShouldThrowException() {
        Bagel bagel = new Bagel("NO BAGEL", 0.49, "Onion", Collections.emptyList());

        Exception exception = Assertions.assertThrows(Exception.class, () -> basket.addToBasket(bagel));
        Assertions.assertEquals("Bagel " + bagel + " is not in the manager's inventory!", exception.getMessage());
    }

    @Test
    public void testAddToBasketShouldThrowException2() {
        List<Filling> fillings = List.of(
                new Filling("NO FILLING", 0.12, "Bacon")
        );
        Bagel bagel = new Bagel("BGLO", 0.49, "Onion", fillings);

        Exception exception = Assertions.assertThrows(Exception.class, () -> basket.addToBasket(bagel));

        Assertions.assertEquals("Bagel does not have the correct filling!", exception.getMessage());
    }

    @Test
    public void testRemoveFromBasketShouldSucceed() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Onion", Collections.emptyList());
        basket.addToBasket(bagel);
        basket.removeFromBasket(bagel);

        Assertions.assertFalse(basket.getContents().contains(bagel));
    }

    @Test
    public void testRemoveFromBasketShouldThrowException() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Onion", Collections.emptyList());

        Exception exception = Assertions.assertThrows(Exception.class, () -> basket.removeFromBasket(bagel));
        Assertions.assertEquals("Bagel is not in the basket!", exception.getMessage());
    }

    @Test
    public void testIsBasketFullShouldSucceed() {
        for(Bagel bagel: BAGELS){
            basket.addToBasket(bagel);
        }

        Assertions.assertTrue(basket.isBasketFull());
    }

    @Test
    public void testGetTotalCost() {
        for(Bagel bagel: BAGELS){
            basket.addToBasket(bagel);
        }

        Double expectedSum = BAGELS.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        Double actualSum = basket.getContents().stream()
                .mapToDouble(Product::getPrice)
                .sum();
        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testChangeBasketCapacityShouldSucceed() {
        Basket.setCapacity(2);
        basket.addToBasket(BAGELS.get(0));
        basket.addToBasket(BAGELS.get(1));

        Assertions.assertTrue(basket.isBasketFull());
    }

}
