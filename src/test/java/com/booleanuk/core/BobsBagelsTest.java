package com.booleanuk.core;

import com.booleanuk.extension.Discounts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BobsBagelsTest {

    @Test
    public void testSetBasketCapacity() {
        BobsBagels bb = new BobsBagels();
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket b = new Basket(inventory, checkout);
        b.add("BGLO");
        b.add("BGLO");
        bb.getBaskets().add(b);
        Assertions.assertEquals("Capacity set to 1. There are customers with more than 1 product in basket", bb.setBasketCapacity(1));
    }

    @Test
    public void testSetBasketCapacityToBelowThreshold() {
        BobsBagels bb = new BobsBagels();
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket b = new Basket(inventory, checkout);
        Assertions.assertEquals("Minimum capacity for baskets are 1", bb.setBasketCapacity(-1));
    }

    @Test
    public void testSetBasketCapacitySuccessfully() {
        BobsBagels bb = new BobsBagels();
        Inventory inventory = new Inventory();
        Discounts discounts = new Discounts(inventory);
        Checkout checkout = new Checkout(inventory, discounts);
        Basket b = new Basket(inventory, checkout);
        Assertions.assertEquals("Capacity set to 3", bb.setBasketCapacity(3));
    }

}