package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CheckoutTest {

    private ArrayList<Product> productsStock;
    private ArrayList<Product> productsBasket;
    private Checkout checkout;
    private Stock stock;
    private Basket basket;

    @BeforeEach
    public void makeDummyData() {

        productsStock = new ArrayList<>();
        productsStock.add(new Product("Debris", "Twig",0.03));
        productsStock.add(new Bagel("Poppy Seed", 1.39));
        productsStock.add(new Coffee("Cappucino", 2.29));
        productsStock.add(new Filling("Bacon", 0.19));
        productsStock.add(new Filling("Fried Egg", 0.49));

        stock = new Stock();
        for(Product product : productsStock) {
            stock.addProduct(product);
        }
        checkout = new Checkout(stock);
        basket = new Basket(10);
    }

    @Test
    public void sumPriceTest() {
        Bagel bagel = new Bagel("Poppy Seed", 1.39);
        Filling filling = new Filling("Bacon", 0.19);
        Coffee coffee = new Coffee("Cappucino", 2.29);
        basket.addProduct(new Product("Debris", "Twig",0.03));
        basket.addProduct(bagel);
        basket.addProduct(filling);
        basket.addProduct(coffee);
        Assertions.assertEquals(3.9, checkout.sumPrice(basket));
    }
    @Test
    public void orderValidTest() {
        basket.addProduct(new Product("Debris", "Twig",0.03));
        Bagel bagel = new Bagel("Poppy Seed", 1.39);
        Filling filling = new Filling("Bacon", 0.19);
        Coffee coffee = new Coffee("Cappucino", 2.29);
        bagel.addFilling(filling);
        basket.addProduct(bagel);
        basket.addProduct(coffee);

        Assertions.assertTrue(checkout.order(basket));

    }

    @Test
    public void orderInvalidTest() {

    }

}
