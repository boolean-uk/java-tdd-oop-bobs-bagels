package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomerTest {

    @Test
    public void testInit() {
        Customer customer = new Customer();
    }


    @Test
    public void testGetTotalCost() {
        Customer customer = new Customer();

        Assertions.assertEquals(0.39*3, customer.getTotalCost(Map.of(new Bagel("Plain"), 3)));


    }

    @Test
    public void testGetTotalCostDiscount6And12(){
        Customer customer = new Customer();


        Assertions.assertEquals(2.49, customer.getTotalCost(Map.of(new Bagel("Plain"), 6)));
        Assertions.assertEquals(3.99, customer.getTotalCost(Map.of(new Bagel("Plain"), 12)));

        Map<Item, Integer> map = Map.of(
                new Bagel("Plain"), 4,
                new Coffee("Black"), 4);


        Map<Item, Integer> map2 = Map.of(
                new Bagel("Plain"), 7,
                new Coffee("Black"), 4);

        Assertions.assertEquals(1.25*4, customer.getTotalCost(map));
        Assertions.assertEquals(2.49 + 1.25+ 0.99*3, customer.getTotalCost(map2));



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

    //As it isnt necessary for the user stories i have commented it out as of now
/*    @Test
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


    }*/

    @Test
    public void testGetCostOfFillings() {
        Customer customer = new Customer();


        Map<String, Double> fillings = Map.of("FILB", 0.12,"FILE", 0.12,"FILC", 0.12,"FILX", 0.12,"FILS", 0.12,"FILH", 0.12);
        Assertions.assertEquals(fillings, customer.getFillingsInInventory());
    }

    @Test
    public void testOrder() {
        Customer customer = new Customer();

        Assertions.assertTrue(customer.order("FILB"));
        Assertions.assertFalse(customer.order("FIIILb"));


    }

    @Test
    public void testDiscounts() {
        Customer customer = new Customer();

        Basket basket = new Basket(5);

        customer.setBasket(basket);

        Map<Item, Integer> map = Map.of(
                new Bagel("Plain"), 4,
                new Coffee("Black"), 4);

        Map<String, ArrayList<Double>> discounts = customer.getDiscounts();

        double finalDiscount = 0.00;
        for(double saving : discounts.values()) {
            finalDiscount += saving;
        }

        Assertions.assertEquals((0.99*4 + 0.39*4) - customer.getTotalCost(map),finalDiscount );

        discounts = customer.getDiscounts();
        finalDiscount = 0.00;
        for(double saving : discounts.values()) {
            finalDiscount += saving;
        }

        Assertions.assertEquals((0.39*12) - 3.99, customer.getTotalCost(Map.of(new Bagel("Plain"), 12)));



    }




}
