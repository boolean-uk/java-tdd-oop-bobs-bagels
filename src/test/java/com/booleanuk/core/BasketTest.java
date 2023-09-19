package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    @Test
    public void theTestToAdd() {
        Basket basket = new Basket();
        String name = "le onion";
        basket.add(name);
        Assertions.assertTrue(basket.contains(name));
    }




}