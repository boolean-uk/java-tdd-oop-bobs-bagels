package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        store = new Store(5, new ArrayList<Customer>(), itemsInStock);
        customer = store.addCustomer(new Customer("Tom"));
    }
    @Test
    public void orderCoffeeInEmptyBasketTest() {
        Assertions.assertTrue(customer.order("COFB"));
    }

    @Test
    public void orderCoffeeInBasketWithElementsTest() {
        customer.getBasket().addItem(store.getItemsInStock().get(5));
        Assertions.assertTrue(customer.order("COFW"));
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
        customer.getBasket().addAll(fillItems);
        Assertions.assertFalse(customer.order("COFL"));
    }

    @Test
    public void orderCoffeeInBasketWithSameBagelTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Coffee("COFW", 0.99, "Coffee", "White"));
            add(new Coffee("COFC", 1.29, "Coffee", "Cappuccino"));
        }};
        customer.getBasket().addAll(fillItems);
        Assertions.assertTrue(customer.order("COFW"));
    }

    @Test
    public void deleteCoffeeInBasketTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Coffee("COFW", 0.99, "Coffee", "White"));
        }};
        customer.getBasket.addAll(fillItems);
        Assertions.assertEquals("Coffee White has been deleted", customer.deleteItem("COFW"));
    }

    @Test
    public void deleteMissingBagelInBasketTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        }};
        customer.getBasket.addAll(fillItems);
        Assertions.assertEquals("Bagel Plain was not found", customer.deleteItem("BGLP"));
    }

    @Test
    public void deleteOneBagelWhenDuplicateBagelsInBasketTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Coffee("COFB", 0.99, "Coffee", "Black"));
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        }};
        customer.getBasket.addAll(fillItems);
        Assertions.assertEquals("Bagel Onion has been deleted", customer.deleteItem("BGLO"));
        Assertions.assertEquals("Vanilla", customer.getBasket().get(customer.getBasket().size()-1).getSKU());
    }

    @Test
    public void ChangeCapacityTest() {
        Assertions.assertEquals(5, Store.BASKETCAPACITY);
        store.setCapacity(7);
        Assertions.assertEquals(7, Store.BASKETCAPACITY);
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
        customer.getBasket.addAll(fillItems);
        store.setCapacity(6);
        Assertions.assertTrue(customer.order("COFW"));
    }

    @Test
    public void ReduceCapacityForFullBasketTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Coffee("COFB", 0.99, "Coffee", "Black"));
        }};
        customer.getBasket.addAll(fillItems);

        store.setCapacity(1);
        Assertions.assertEquals(1, basket.bagels.size());
        Assertions.assertEquals("BGLO", customer.getBasket().get(0).getSKU());
        Assertions.assertFalse(customer.getBasket().getAll().contains("COFB"));
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
        customer.getBasket.addAll(fillItems);
        store.setCapacity(3);
        Assertions.assertEquals(3, customer.getBasket().size());
        Assertions.assertEquals(3, Store.BASKETCAPACITY);
        Assertions.assertEquals("Plain", customer.getBasket().get(basket.bagels.size()-1).getSKU());
    }

    @Test
    public void calculateTotalCostOfTwoItemsTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Coffee("COFB", 0.99, "Coffee", "Black"));
        }};
        customer.getBasket().addAll(fillItems);
        Assertions.assertEquals(1.48, customer.getBasket().calculateTotalCost());
    }

    @Test
    public void calculateCostOfThreeItemsFromCustomerTest() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
            add(new Coffee("COFB", 0.99, "Coffee", "Black"));
            add(new Filling("FILB", 0.12, "Filling", "Bacon"));
        }};
        customer.getBasket().addAll(fillItems);
        Assertions.assertEquals(1.60, customer.calculateCostBeforeOrder());
    }

    @Test
    public void addFillingWhenStringMatchesSkuFromInput() {
        ArrayList<Item> fillItems = new ArrayList<Item>() {{
            add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        }};
        customer.getBasket().addAll(fillItems);
        Assertions.assertEquals("Bacon", customer.chooseFilling("FILB").get(0).getVariant());
    }

    @Test
    public void wrongInputInOrderGivesFalse() {
        Assertions.AssertFalse(customer.order("Hi there"));
    }
}

