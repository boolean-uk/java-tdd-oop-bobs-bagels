package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasketTest {
    private Basket basket;

    public BasketTest() {
        basket = new Basket(16);
    }

    @Test
    public void addToBasketTest() {
        Assertions.assertEquals(0,basket.getItems().size());
        List<String> fillings = new ArrayList<>();
        fillings.add("FILB");
        fillings.add("FILE");

        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");


        basket.addItem("BGLO",fillings);
        basket.addItem("fake",fillings);
        basket.addItem("wrong item",fillings);
        Assertions.assertEquals(3,basket.getItems().size());

        basket.addItem("FILB",fillings);
        Assertions.assertEquals(3,basket.getItems().size());
        basket.addItem("COFL", fillings);
        Assertions.assertEquals(4,basket.getItems().size());
        basket.addItem("BGLS",fillings2);
        Assertions.assertEquals(8,basket.getItems().size());
    }
    @Test
    public void calculateTotalFillingsCostTest() {
        Basket basket = new Basket(10);
        Inventory inventory = new Inventory();

        basket.addItem("BGLO", Arrays.asList("FILB", "FILC"));
        basket.addItem("BGLP", Arrays.asList("FILC", "FILX"));
        basket.addItem("COFB", null);

        double totalCost = basket.calculateTotalFillingsCost();

        Assertions.assertEquals(0.48, totalCost, 0.01);
    }






    @Test
    public void checkIfWeCanAddToBasketOverTheSizeOfCapacityTest() {
        List<String> filling = new ArrayList<>();
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");


        basket.addItem("BGLO",filling);
        basket.addItem("BGLO",filling);
        basket.addItem("FILB",filling);
        basket.addItem("FILB",filling);
        Assertions.assertEquals(2,basket.getItems().size());
        basket.addItem("BGLO",fillings2);
        Assertions.assertEquals(10,basket.getItems().size());
        basket.addItem("BGLP",fillings2);
        Assertions.assertEquals(10,basket.getItems().size());
    }
/*
    @Test
    public void removeFromBasketTest() {
        basket.addItem("BGLO");
        basket.addItem("FILB");
        Assertions.assertEquals(2,basket.getItems().size());

        basket.removeItem("BGLOOOO");
        Assertions.assertEquals(2,basket.getItems().size());

        basket.removeItem("FILB");
        Assertions.assertEquals(1,basket.getItems().size());

        basket.removeItem("FILB");
        Assertions.assertEquals(1,basket.getItems().size());

        basket.removeItem("BGLO");
        Assertions.assertEquals(0,basket.getItems().size());

        basket.removeItem("BGLO");
        Assertions.assertEquals(0,basket.getItems().size());
    }
*/
    @Test
    public void isBasketFullTest() {
        List<String> filling = new ArrayList<>();
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");
        Assertions.assertTrue(basket.addItem("BGLO",fillings2));
        Assertions.assertFalse(basket.addItem("FILB",fillings2));
        Assertions.assertTrue(basket.addItem("BGLO",fillings2));

        Assertions.assertFalse(basket.addItem("FILB",filling));
    }


    @Test
    public void changingCapacityTest() {
        List<String> filling = new ArrayList<>();
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");
        basket.addItem("BGLO",fillings2);
        basket.addItem("FILB",fillings2);
        basket.addItem("BGLO",filling);
        basket.addItem("FILB",filling);
        Assertions.assertEquals(9,basket.getItems().size());

        basket.changeCapacity(10);
        basket.addItem("COFC",filling);
        basket.addItem("COFC",filling);
        basket.addItem("COFC",filling);
        basket.addItem("COFC",filling);
        Assertions.assertEquals(10,basket.getItems().size());
        basket.changeCapacity(6);

        basket.addItem("BGLO",fillings2);

        Assertions.assertEquals(10,basket.getItems().size());
    }
/*
    @Test
    public void doesItemExistInBasketSoItCanBeRemoveFromItTest() {
        basket.addItem("BGLO");
        basket.addItem("FILB");

        Assertions.assertTrue(basket.removeItem("BGLO"));
        Assertions.assertFalse(basket.removeItem("BGLO"));
        Assertions.assertTrue(basket.removeItem("FILB"));
        Assertions.assertFalse(basket.removeItem("FILB"));
        Assertions.assertFalse(basket.removeItem("strange item"));
    }

*/
    @Test
    public void getTotalPriceOfItemsInBasketTest() {
        Assertions.assertEquals(0.00, basket.calculateTotalPrice());

        List<String> filling = new ArrayList<>();
        filling.add("FILB");
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");

        basket.addItem("BGLO",filling);

        Assertions.assertEquals(0.61, basket.calculateTotalPrice());

        basket.addItem("COFL",fillings2);
        Assertions.assertEquals(1.90, basket.calculateTotalPrice());
        basket.addItem("COFW",fillings2);
        Assertions.assertEquals(3.09, basket.calculateTotalPrice());

        basket.addItem("BGLO",fillings2);
        Assertions.assertEquals(4.42, basket.calculateTotalPrice());

    }

    @Test
    public void changingCapacityOfBasketWithNegativeNumber() {
        List<String> filling = new ArrayList<>();
        filling.add("FILB");


        basket.addItem("BGLO",filling);

        basket.addItem("BGLO",filling);

        Assertions.assertEquals(4,basket.getItems().size());

        basket.changeCapacity(-10);
        basket.addItem("BGLO",filling);

        Assertions.assertEquals(6,basket.getItems().size());
    }


    @Test
    public void changingCapacityOfBasketWithItemsAlreadyInBasketExceedingNewCapacityGivenByUser() {
        List<String> filling = new ArrayList<>();
        filling.add("FILB");
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");
        basket.addItem("BGLO",fillings2);

        Assertions.assertEquals(8,basket.getItems().size());
        basket.changeCapacity(2);
        Assertions.assertEquals(8,basket.getItems().size());
        basket.addItem("BGLO",filling);
        basket.addItem("BGLO",filling);
        Assertions.assertEquals(8,basket.getItems().size());

    }



}
