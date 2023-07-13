package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCustomer {

    public Customer customer;
    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void whenAddToBasketExistingBagelType_bagelIsAddedToBasket()  {
        //Setup
        String bagel = "BGLO";

        //Execute
        customer.addToBasket(bagel);

        Assertions.assertEquals(List.of(bagel), customer.getBasket().getListOfItemsInBasket());
    }

    @Test
    public void whenCheckBasketCalled_everythingInBasketIsReturned()  {
        //Setup
        String coffee = "COFB";
        customer.addToBasket(coffee);
        String bagel = "BGLO";
        customer.addToBasket(bagel);

        String expected = "0 " + Inventory.getItemBySku(coffee) + "1 " + Inventory.getItemBySku(bagel);

        Assertions.assertEquals(expected, customer.checkBasket());
    }

}
