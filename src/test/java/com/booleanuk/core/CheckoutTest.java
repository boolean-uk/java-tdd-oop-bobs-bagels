package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CheckoutTest {
    @Test
    void printReceiptShouldBeItems() {
        Inventory.reset();
        Basket.setCapacity(2);

        Inventory.add(new Item("BGLO"));
        Inventory.add(new Item("COFB"));
        Basket basket = new Basket();
        basket.add(new Item("BGLO"));
        basket.add(new Item("COFB"));

        Checkout.printReceipt(basket);
    }

    @Test
    void printReceiptShouldBePackage() {
        Inventory.reset();

        Inventory.add(new Item("BGLO"));
        Inventory.add(new Item("COFB"));

        ArrayList<Item> items = new ArrayList<>() {{
            add(new Item("BGLO"));
            add(new Item("COFB"));
        }};
        Package pack = new Package(items, 1.25, -0.23);

        Basket basket = new Basket();
        basket.add(pack);

        Checkout.printReceipt(basket);
    }

    @Test
    void printReceiptShouldBeBoth() {
        Inventory.reset();
        Basket.setCapacity(3);

        Inventory.add(new Item("BGLO"));
        Inventory.add(new Item("COFB"));

        ArrayList<Item> items = new ArrayList<>() {{
            add(new Item("BGLO"));
            add(new Item("COFB"));
        }};
        Package pack = new Package(items, 1.25, -0.23);

        Basket basket = new Basket();
        basket.add(new Item("BGLO"));
        basket.add(new Item("COFB"));
        basket.add(pack);

        Checkout.printReceipt(basket);
    }
}
