package com.booleanuk.extension;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ExtensionTest {

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
        store = new Store(10);
        customer = store.addCustomer("Tom");
    }

    @Test
    public void bagelAndCoffeeComboGivesDiscountTest() {
        customer.getInventory().addItem(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        customer.getInventory().addItem(new Coffee("COFL", 1.29, "Coffee", "Latte"));
        Assertions.assertEquals(1.25, customer.calculateCostBeforeOrder());
    }

    @Test
    public void TwoPlusTwoPlusTwoBagelsGivesNoDiscountTest() {
        customer.getInventory().addItem(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        customer.getInventory().addItem(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        customer.getInventory().addItem(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        customer.getInventory().addItem(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        customer.getInventory().addItem(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        customer.getInventory().addItem(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        Assertions.assertEquals(2.74, customer.calculateCostBeforeOrder());
    }

    @Test
    public void sixBagelsGivesDiscountTest() {
        for(int i = 0; i < 6; i++) {
            customer.getInventory().addItem(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        }
        Assertions.assertEquals(2.49, customer.calculateCostBeforeOrder());
    }

    @Test
    public void twoItemsOfSameSortGivesQuantityTwoInReceipt() {
        Bagel bagel = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        customer.getInventory().addItem(bagel);
        customer.getInventory().addItem(bagel);
        Assertions.assertTrue(customer.getInventory().showInventory().contains("2"));
    }
}
