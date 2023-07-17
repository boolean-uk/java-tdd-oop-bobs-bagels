package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCustomer {

    public Customer customer;
    public Bagel ONION_BAGEL = (new Bagel("BGLO",49,"Bagel","Onion"));
    public Coffee BLACK_COFFEE = (new Coffee("COFB",99,"Coffee","Black"));

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

        String expected = "0 " + BLACK_COFFEE.toString() + "1 " + ONION_BAGEL.toString();

        Assertions.assertEquals(expected, customer.checkBasket());
    }

}
