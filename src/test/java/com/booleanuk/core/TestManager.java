package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestManager {
    public Manager manager;
    public Customer customer;
    public int CAPACITY = 5;

    @BeforeEach
    public void setUp() {
        manager = new Manager();
    }

    @Test
    public void whenChangeBasketCapacity_basketCapacityIsChanged() {
        manager.changeBasketCapacity(CAPACITY);
        customer = new Customer();

        Assertions.assertEquals(CAPACITY,customer.basket.getCapacity());
    }

}
