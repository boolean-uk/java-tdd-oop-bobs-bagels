package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCustomer {

    public Customer customer;
    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void whenAddToBasketExistingBagelType_bagelIsAddedToBasket() throws Exception {
        //Setup
        String typeOfBagel = "BGLO";
        Bagel bagel = new Bagel(typeOfBagel);
        //Execute
        customer.addBagelToBasket(bagel);

        Assertions.assertEquals(List.of(bagel), customer.getBasket().getBagelList());
    }

    @Test
    public void whenAddToBasketExistingCoffeeType_coffeeIsAddedToBasket() throws Exception {
        //Setup
        String typeOfCoffee = "COFB";

        //Execute
        customer.addCoffeeToBasket(typeOfCoffee);

        Assertions.assertEquals(List.of(typeOfCoffee), customer.getBasket().getCoffeeList());
    }

    @Test
    public void whenCheckBasketCalled_everythingInBasketIsReturned() throws Exception {
        //Setup
        String typeOfCoffee = "COFB";
        customer.addCoffeeToBasket(typeOfCoffee);
        List<String> coffees = new ArrayList<>();
        coffees.add(typeOfCoffee);
        String typeOfBagel = "BGLO";
        Bagel bagel = new Bagel(typeOfBagel);
        customer.addBagelToBasket(bagel);
        List<Bagel> bagels = new ArrayList<>();
        bagels.add(bagel);

        Assertions.assertEquals(List.of(coffees, bagels), customer.checkBasket());
    }

}
