package com.booleanuk.core;

import com.booleanuk.extension.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

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
    public void testDiscounts() throws InterruptedException {
        Customer customer = new Customer();

        Basket basket = new Basket(10);

        customer.setBasket(basket);

        Map<Item, Integer> map = Map.of(
                new Bagel("Plain"), 4,
                new Coffee("Black"), 4);

        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));

        basket.addItemToBasket(new Coffee("Black"));
        basket.addItemToBasket(new Coffee("Black"));
        basket.addItemToBasket(new Coffee("Black"));
        basket.addItemToBasket(new Coffee("Black"));



        Map<String, ArrayList<Double>> discounts = customer.getDiscounts();


        //As of now, totalCost has to be ran before getting discount, this does seem wrong as i test discount without getting total cost.
        //However i would need to change alot of my code and logic of getting discounts to make this work othere way. Or make discount run
        //like how total cost is ran without the cost getting calculated.

        double totalCost = customer.getTotalCost(basket.getItemList());
        double finalDiscount = 0.00;
        for(ArrayList<Double> saving : customer.getDiscounts().values()) {

            for(double dob : saving) {
                finalDiscount += dob;
            }
        }

        System.out.println(customer.getTotalCost(map));

        Assertions.assertEquals(((0.99*4 + 0.39*4) - 1.25*4),finalDiscount );






        Customer customer2 = new Customer();
        Basket basket2 = new Basket(10);



        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));
        basket2.addItemToBasket(new Bagel("Plain"));

        customer2.setBasket(basket2);

        double finalDiscount2 = 0.00;

        //As of now, totalCost has to be ran before getting discount, this does seem wrong as i test discount without getting total cost.
        //However i would need to change alot of my code and logic of getting discounts to make this work othere way. Or make discount run
        //like how total cost is ran without the cost getting calculated.

        double totalCost2 = customer2.getTotalCost(basket2.getItemList());

        for(ArrayList<Double> saving : customer2.getDiscounts().values()) {

            for(double dob : saving) {
                finalDiscount2 += dob;
            }
        }





        double expectedPrice = (0.39*12) - 3.99;
        Assertions.assertEquals(expectedPrice, finalDiscount2);



    }


    @Test
    public void testTotalCostAfterDiscounts() {
        Customer customer = new Customer();

        Basket basket = new Basket(15);

        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Bagel("Plain"));
        basket.addItemToBasket(new Filling("Bacon"));
        basket.addItemToBasket(new Coffee("White"));
        basket.addItemToBasket(new Coffee("White"));
        basket.addItemToBasket(new Coffee("White"));
        basket.addItemToBasket(new Bagel("Plain"));


        customer.setBasket(basket);
        Receipt receipt = new Receipt(customer);

        double totalCost = customer.getTotalCost(basket.getItemList());
        System.out.println(receipt.printBasket());

        Assertions.assertEquals(6.3, totalCost);

    }




}
