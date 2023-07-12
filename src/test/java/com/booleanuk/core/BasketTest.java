package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTest {
    Basket basket;
    Bagel bagel;
    Bagel bagel1;
    Bagel bagel2;
    Coffee coffee;
    Filling filling;

    @BeforeEach
    public void setUp(){
        basket = new Basket(2);

        bagel = new Bagel("Onion", 0.48);
        bagel1 = new Bagel("Plain", 0.39);
        bagel2 = new Bagel("Everything", 0.49);
        Bagel bagel3 = new Bagel("Sesame", 0.49);

        Coffee coffee = new Coffee("Black", 0.99);
        Coffee coffee1 = new Coffee("White", 1.19);
        Coffee coffee2 = new Coffee("Capuccino", 1.29);
        Coffee coffee3 = new Coffee("Latte", 1.29);

        Filling filling = new Filling("Bacon", 0.12);
        Filling filling1 = new Filling("Egg", 0.12);
        Filling filling2 = new Filling("Cheese", 0.12);
        Filling filling3 = new Filling("Cream Cheese", 0.12);
        Filling filling4 = new Filling("Smoked Salmon", 0.12);
        Filling filling5 = new Filling("Ham", 0.12);
    }

    @Test
    public void addTest(){
        Assertions.assertTrue(basket.add(bagel));
        Assertions.assertTrue(basket.add(bagel1));
        Assertions.assertFalse(basket.add(bagel2));
    }



}
