package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testGetBalance() {
        Customer customer = new Customer();
        customer.setBalance(100);
        Assertions.assertEquals(100, customer.getBalance());
    }
}
