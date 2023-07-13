package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestManager {
    public Manager manager;
    public Customer customer;
    @BeforeEach
    public void setUp() {
        manager = new Manager();
    }


    @Test
    public void whenChangeBasketCapacity_basketCapacityIsChanged() {
        manager.changeBasketCapacity(5);
        customer = new Customer();

        Assertions.assertEquals(5,customer.basket.getCapacity());
    }

}
