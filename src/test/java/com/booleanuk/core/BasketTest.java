package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BasketTest {
    private Basket basket;
    private static final List<Bagel> BAGELS = List.of(
            new Bagel("BGLO", 0.49, "Onion", Collections.emptyList()),
            new Bagel("BGLP", 0.39, "Plain", Collections.emptyList()),
            new Bagel("BGLE", 0.49, "Everything", Collections.emptyList()),
            new Bagel("BGLS", 0.49, "Sesame", Collections.emptyList())
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
    public void testAddToBasketShouldThrowException() throws Exception {
        Bagel bagel = new Bagel("NO BAGEL", 0.49, "Onion", Collections.emptyList());

        Exception exception = Assertions.assertThrows(Exception.class, () -> basket.addToBasket(bagel));
        System.out.println(basket.getContents());
        Assertions.assertEquals("Bagel " + bagel + " is not in the manager's inventory!", exception.getMessage());
    }

    @Test
    public void testRemoveFromBasketShouldSucceed() throws Exception {
        Bagel bagel = new Bagel("BGLO", 0.49, "Onion", Collections.emptyList());
        basket.addToBasket(bagel);
        basket.removeFromBasket(bagel);

        Assertions.assertFalse(basket.getContents().contains(bagel));
    }

    @Test
    public void testRemoveFromBasketShouldThrowException() {
        Bagel bagel = new Bagel("BGLO", 0.49, "Onion", Collections.emptyList());

        Exception exception = Assertions.assertThrows(Exception.class, () -> basket.removeFromBasket(bagel));
        Assertions.assertEquals("Bagel " + bagel + " is not in the basket!", exception.getMessage());
    }

    @Test
    public void testIsBasketFullShouldSucceed() throws Exception {
        for(Bagel bagel: BAGELS){
            basket.addToBasket(bagel);
        }

        Assertions.assertTrue(basket.isBasketFull());
    }

    @Test
    public void testGetTotalCost() throws Exception {
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


}
