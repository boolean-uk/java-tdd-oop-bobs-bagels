package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class ClientTest {
    private Client client;

    private static final List<Filling> exampleFillings = List.of(
            new Filling("FILB", 0.12, "Bacon"),
            new Filling("FILC", 0.12, "Cheese")
    );
    private static final Bagel exampleBagel = new Bagel("BGLO", 0.49, "Onion", exampleFillings);

    @BeforeEach
    void setUp() {
        client = new Client();
    }

    @Test
    void testOrderBagelShouldSucceed() {
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));

        Assertions.assertTrue(client.getBasketContents().contains(exampleBagel));
    }

    @Test
    void testOrderBagelShouldThrowException1() {
        String variant = "VARIANT X";
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> client.orderBagel(variant, List.of("Bacon", "Cheese")));

        Assertions.assertEquals("Bagel with variant " + variant +
                " is not in the inventory!", exception.getMessage());
    }

    @Test
    void testOrderBagelShouldThrowException2() {
        String fillingVariant = "FILLING X";
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> client.orderBagel("Onion", List.of(fillingVariant, "Cheese")));

        Assertions.assertEquals("Filling with variant " + fillingVariant +
                " is not in the inventory!", exception.getMessage());
    }

    @Test
    void testOrderBagelWithFullBasketShouldThrowException() {
        String variant = "Onion";
        while(!client.isBasketFull()) {
            Assertions.assertDoesNotThrow(() -> {
                client.orderBagel(variant, List.of("Bacon", "Cheese"));
            });
        }

        Exception exception = Assertions.assertThrows(Exception.class, () ->
                client.orderBagel(variant, List.of("Bacon", "Cheese")));

        Assertions.assertEquals("Basket is full!", exception.getMessage());
    }


    @Test
    void getBagelIfPresentShouldReturnBagel() {
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));

        Bagel bagel = client.getBagelIfPresent("Onion", List.of("Bacon", "Cheese"));

        Assertions.assertNotNull(bagel);
    }

    @Test
    void getBagelIfPresentShouldReturnNull() {
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));

        Bagel bagel = client.getBagelIfPresent("Onion", List.of("Bacon", "Cheese", "Cheese"));

        Assertions.assertNull(bagel);
    }

    @Test
    void cancelOrderShouldSucceed(){
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));
        client.cancelOrder(client.getBagelIfPresent("Onion", List.of("Bacon", "Cheese")));
        Assertions.assertEquals(0, client.getBasketContents().size());
    }

    @Test
    void testCancelOrderShouldThrowException(){
        client.orderBagel("Onion", List.of("Bacon", "Cheese"))

        Exception exception = Assertions.assertThrows(Exception.class, () ->
                client.cancelOrder("Plain", List.of("Ham", "Smoked Salmon")));

        Assertions.assertEquals("The bagel is not present in the basket!", exception.getMessage());
    }

    @Test
    void testGetTotalBasketCost() {
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));
        client.orderBagel("Plain", List.of("Ham", "Smoked Salmon"));

        Assertions.assertEquals(1.36, client.getTotalBasketCost());
    }

    @Test
    void testGetFillingPriceShouldSucceed() {
        Double baconPrice = Assertions.assertDoesNotThrow(() -> client.getFillingPrice("Bacon"));
        Double cheesePrice = Assertions.assertDoesNotThrow(() -> client.getFillingPrice("Cheese"));

        Assertions.assertEquals(0.12, baconPrice);
        Assertions.assertEquals(0.12, cheesePrice);
    }

    @Test
    void testGetFillingPriceShouldThrowException() {
        Exception exception = Assertions.assertThrows(Exception.class, () ->
                client.getFillingPrice("Filling X"));

        Assertions.assertEquals("Filling with variant Filling X is " +
                "not in the inventory!", exception.getMessage());
    }



}
