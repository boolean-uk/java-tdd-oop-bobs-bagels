package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerTest {

    @Test
    public void testInit() {
        Customer customer = new Customer();
    }


    @Test
    public void testGetTotalCost() {
        Customer customer = new Customer();

        Bagel bagel1 = new Bagel("Plain");
        Bagel bagel2 = new Bagel("Plain");
        Bagel bagel3 = new Bagel("Plain");


        Assertions.assertEquals(0.39*3, customer.getTotalCost(new ArrayList<Item>(Arrays.asList(bagel1, bagel2, bagel3))));
    }

    @Test
    public void testGetCostOfItem() {
        Customer customer = new Customer();

        Assertions.assertEquals(0.39, customer.getCostOfItem(new Bagel("plain")));
        Assertions.assertEquals(0.49, customer.getCostOfItem(new Bagel("onion")));
        Assertions.assertEquals(0.12, customer.getCostOfItem(new Filling("Bacon")));
        Assertions.assertEquals(0.99, customer.getCostOfItem(new Coffee("Black")));
        Assertions.assertEquals(1.29, customer.getCostOfItem(new Coffee("Capuccino")));


    }

    @Test
    public void testGetCostOfFillingsInBasket() {
        Customer customer = new Customer();
        Basket basket = new Basket(5);

        Assertions.assertTrue(customer.setBasket(basket));

        Assertions.assertEquals(basket, customer.getBasket());

        basket.addItemToBasket(new Filling("Bacon"));
        basket.addItemToBasket(new Filling("Egg"));
        basket.addItemToBasket(new Filling("Cheese"));
        basket.addItemToBasket(new Bagel("Plain"));

        Assertions.assertEquals(0.12*3, customer.getCostOfFillingsInBasket(basket.getItemList()));


    }

    @Test
    public void testGetCostOfFillingsAfterA() {
        Customer customer = new Customer();
        Basket basket = new Basket(5);



    }




}
