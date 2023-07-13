package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCustomer {

    public Customer customer;
    public String ONION_BAGEL = "BGLO";
    public String BLACK_COFFEE = "COFB";

    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void whenAddToBasketExistingBagelType_bagelIsAddedToBasket()  {
        //Execute
        customer.addToBasket(ONION_BAGEL);

        Assertions.assertEquals(List.of(ONION_BAGEL), customer.getBasket().getListOfItemsInBasket());
    }

    @Test
    public void whenCheckBasketCalled_everythingInBasketIsReturned()  {
        //Setup
        customer.addToBasket(BLACK_COFFEE);
        customer.addToBasket(ONION_BAGEL);

        String expected = "0 " + Inventory.getItemBySku(BLACK_COFFEE) + "1 " + Inventory.getItemBySku(ONION_BAGEL);

        Assertions.assertEquals(expected, customer.checkBasket());
    }

}
