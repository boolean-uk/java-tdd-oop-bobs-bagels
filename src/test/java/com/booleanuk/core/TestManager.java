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
    public void whenChangeBasketCapacity_basketCapacityIsChanged() throws Exception {
        manager.changeBasketCapacity(3);
        customer = new Customer();

        Assertions.assertEquals(3,customer.basket.getCapacity());
    }

}
