package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestManager {
    public Basket basket;
    public Manager manager;
    @BeforeEach
    public void setUp() {
        basket = new Basket();
        manager = new Manager();
    }


    @Test
    public void whenChangeBasketCapacity_basketCapacityIsChanged() throws Exception {
        manager.changeBasketCapacity(3);

        Assertions.assertEquals(3,basket.getCapacity());
    }

}
