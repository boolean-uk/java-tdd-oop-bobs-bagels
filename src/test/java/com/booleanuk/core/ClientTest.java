package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClientTest {
    private Client client;

    private static final List<Filling> exampleFillings = List.of(
            new Filling("FILB", 0.12, "Bacon"),
            new Filling("FILC", 0.12, "Cheese")
    );
    private static final Bagel exampleBagel = new Bagel("BGLO", 0.49, "Onion", exampleFillings);

    @BeforeAll
    public static void setUpAll() {
        Basket.setCapacity(10);
    }

    @BeforeEach
    public void setUp() {
        client = new Client();
    }

    @Test
    public void testOrderBagelShouldSucceed() {
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));

        Assertions.assertTrue(client.getBasketContents().contains(exampleBagel));
    }

    @Test
    public void testOrderBagelShouldThrowException1() {
        String variant = "VARIANT X";
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> client.orderBagel(variant, List.of("Bacon", "Cheese")));

        Assertions.assertEquals("Bagel with variant " + variant +
                " is not in the inventory!", exception.getMessage());
    }

    @Test
    public void testOrderBagelShouldThrowException2() {
        String fillingVariant = "FILLING X";
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> client.orderBagel("Onion", List.of(fillingVariant, "Cheese")));

        Assertions.assertEquals("Filling with variant " + fillingVariant +
                " is not in the inventory!", exception.getMessage());
    }

    @Test
    public void testOrderBagelWithFullBasketShouldThrowException() {
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
    public void getBagelIfPresentShouldReturnBagel() {
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));

        Bagel bagel = client.getBagelIfPresent("Onion", List.of("Bacon", "Cheese"));

        Assertions.assertNotNull(bagel);
    }

    @Test
    public void getBagelIfPresentShouldReturnNull() {
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));

        Bagel bagel = client.getBagelIfPresent("Onion", List.of("Bacon", "Cheese", "Cheese"));

        Assertions.assertNull(bagel);
    }

    @Test
    public void cancelOrderShouldSucceed(){
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));
        client.cancelOrder(client.getBagelIfPresent("Onion", List.of("Bacon", "Cheese")));
        Assertions.assertEquals(0, client.getBasketContents().size());
    }

    @Test
    public void testCancelOrderShouldThrowException(){
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));
        Bagel bagel = new Bagel("BGLP", 0.39, "Plain", exampleFillings);

        Exception exception = Assertions.assertThrows(Exception.class, () ->
                client.cancelOrder(bagel));

        Assertions.assertEquals("Bagel is not in the basket!", exception.getMessage());
    }

    @Test
    public void testGetTotalBasketCost() {
        client.orderBagel("Onion", List.of("Bacon", "Cheese"));
        client.orderBagel("Plain", List.of("Ham", "Smoked Salmon"));

        Assertions.assertEquals(1.36, client.getTotalBasketCost());
    }

    @Test
    public void testGetFillingPriceShouldSucceed() {
        Double baconPrice = Assertions.assertDoesNotThrow(() -> client.getFillingPrice("Bacon"));
        Double cheesePrice = Assertions.assertDoesNotThrow(() -> client.getFillingPrice("Cheese"));

        Assertions.assertEquals(0.12, baconPrice);
        Assertions.assertEquals(0.12, cheesePrice);
    }

    @Test
    public void testGetFillingPriceShouldThrowException() {
        Exception exception = Assertions.assertThrows(Exception.class, () ->
                client.getFillingPrice("Filling X"));

        Assertions.assertEquals("Filling with variant Filling X is " +
                "not in the inventory!", exception.getMessage());
    }

    @Test
    public void testGetBagelPriceShouldSucceed(){
        Double onionPrice = Assertions.assertDoesNotThrow(() -> client.getBagelPrice("Onion"));
        Double plainPrice = Assertions.assertDoesNotThrow(() -> client.getBagelPrice("Plain"));

        Assertions.assertEquals(0.49, onionPrice);
        Assertions.assertEquals(0.39, plainPrice);
    }

    @Test
    public void testGetBagelPriceShouldThrowException(){
        Exception exception = Assertions.assertThrows(Exception.class, () ->
                client.getBagelPrice("Bagel X"));

        Assertions.assertEquals("Bagel with variant Bagel " +
                "X is not in the inventory!", exception.getMessage());
    }


}
