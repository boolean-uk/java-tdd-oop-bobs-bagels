package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

class CoreTest {
    private ArrayList<Item> itemsInStock;
    private Store store;
    private Customer customer;
    @BeforeEach
    public void init() {
        itemsInStock = new ArrayList<>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
            add(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
            add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
            add(new Coffee("COFB", 0.99, "Coffee", "Black"));
            add(new Coffee("COFW", 1.19, "Coffee", "White"));
            add(new Coffee("COFC", 1.29, "Coffee", "Cappuccino"));
            add(new Coffee("COFL", 1.29, "Coffee", "Latte"));
            add(new Filling("FILB", 0.12, "Filling", "Bacon"));
            add(new Filling("FILE", 0.12, "Filling", "Egg"));
            add(new Filling("FILC", 0.12, "Filling", "Cheese"));
            add(new Filling("FILX", 0.12, "Filling", "Cream Cheese"));
            add(new Filling("FILS", 0.12, "Filling", "Smoked Salmon"));
            add(new Filling("FILH", 0.12, "Filling", "Ham"));
        }};
        store = new Store(5);
        customer = store.addCustomer("Tom");
    }
    @Test
    public void orderCoffeeInEmptyBasketTest() {
        Assertions.assertEquals(customer.getInventory(), customer.order("COFB"));
    }

    @Test
    public void orderCoffeeInBasketWithElementsTest() {
        customer.getInventory().addItem(store.getItemsInStock().get(5));
        Assertions.assertEquals(customer.getInventory(), customer.order("COFW"));
    }

    @Test
    public void orderCoffeeInFullBasketTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Coffee("COFW", 0.99, "Coffee", "White"));
            add(new Coffee("COFC", 1.29, "Coffee", "Cappuccino"));
            add(new Coffee("COFL", 1.29, "Coffee", "Latte"));
            add(new Filling("FILB", 0.12, "Filling", "Bacon"));
            add(new Filling("FILE", 0.12, "Filling", "Egg"));
        }};
        customer.getInventory().getItems().addAll(fillItems);
        Assertions.assertEquals(customer.getInventory().getItems().size(), customer.order("COFL").getItems().size());
    }

    @Test
    public void orderCoffeeInBasketWithSameBagelTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Coffee("COFW", 0.99, "Coffee", "White"));
            add(new Coffee("COFC", 1.29, "Coffee", "Cappuccino"));
        }};
        customer.getInventory().getItems().addAll(fillItems);
        Assertions.assertEquals(customer.getInventory(), customer.order("COFW"));
    }

    @Test
    public void deleteCoffeeInBasketTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Coffee("COFW", 0.99, "Coffee", "White"));
        }};
        customer.getInventory().getItems().addAll(fillItems);
        Assertions.assertEquals("Coffee White was deleted", customer.deleteItems("COFW"));
    }

    @Test
    public void deleteMissingBagelInBasketTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        }};
        customer.getInventory().getItems().addAll(fillItems);
        Assertions.assertEquals("The item was not found, and could not be deleted", customer.deleteItems("BGLP"));
    }

    @Test
    public void deleteOneBagelWhenDuplicateBagelsInBasketTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Coffee("COFB", 0.99, "Coffee", "Black"));
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        }};
        customer.getInventory().getItems().addAll(fillItems);
        Assertions.assertEquals("Bagel Onion was deleted", customer.deleteItems("BGLO"));
        Assertions.assertEquals("BGLO", customer.getInventory().getItems().get(customer.getInventory().getItems().size()-1).getSKU());
    }

    @Test
    public void ChangeCapacityTest() {
        Assertions.assertEquals(5, store.getCapacity());
        store.setCapacity(7);
        Assertions.assertEquals(7, store.getCapacity());
    }

    @Test
    public void addBagelAfterChangeCapacityFromFullCapacityTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Coffee("COFB", 0.99, "Coffee", "Black"));
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Filling("FILB", 0.12, "Filling", "Bacon"));
            add(new Filling("FILX", 0.12, "Filling", "Cream Cheese"));
        }};
        customer.getInventory().getItems().addAll(fillItems);
        store.setCapacity(6);
        Assertions.assertEquals(customer.getInventory(), customer.order("COFW"));
    }

    @Test
    public void ReduceCapacityForFullBasketTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Coffee("COFB", 0.99, "Coffee", "Black"));
        }};
        customer.getInventory().getItems().addAll(fillItems);

        store.setCapacity(1);
        Assertions.assertEquals(1, customer.getInventory().getItems().size());
        Assertions.assertEquals("BGLO", customer.getInventory().getItems().get(0).getSKU());
        Assertions.assertFalse(customer.getInventory().getItems().contains("COFB"));
    }

    @Test
    public void ReduceCapacityFurtherForFullBasketTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Coffee("COFB", 0.99, "Coffee", "Black"));
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Filling("FILB", 0.12, "Filling", "Bacon"));
            add(new Filling("FILX", 0.12, "Filling", "Cream Cheese"));
        }};
        customer.getInventory().getItems().addAll(fillItems);
        store.setCapacity(3);
        Assertions.assertEquals(3, customer.getInventory().getItems().size());
        Assertions.assertEquals(3, store.getCapacity());
        Assertions.assertEquals("BGLO", customer.getInventory().getItems().get(customer.getInventory().getItems().size()-1).getSKU());
    }

    @Test
    public void calculateTotalCostOfTwoItemsTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Coffee("FILX", 0.12, "Filling", "Cream Cheese"));
        }};
        customer.getInventory().getItems().addAll(fillItems);
        Assertions.assertEquals(0.61, customer.getInventory().calculateTotalCost());
    }

    @Test
    public void calculateCostOfThreeItemsFromCustomerTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("COFW", 1.19, "Coffee", "White"));
            add(new Coffee("COFC", 1.29, "Coffee", "Capuccino"));
            add(new Filling("FILB", 0.12, "Filling", "Bacon"));
        }};
        customer.getInventory().getItems().addAll(fillItems);
        Assertions.assertEquals(2.60, customer.calculateCostBeforeOrder());
    }

    @Test
    public void addFillingWhenStringMatchesSkuFromInput() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        }};
        customer.getInventory().getItems().addAll(fillItems);
        String userInput = "FILB";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        Scanner scanner = new Scanner(inputStream);
        Basket basket = customer.chooseFilling(scanner);
        Assertions.assertEquals("FILB", basket.getItems().get(basket.getItems().size()-1).getSKU());
    }

    @Test
    public void wrongInputInOrderGivesFalse() {
        Assertions.assertEquals(customer.getInventory(), customer.order("Hello there"));
    }
}

