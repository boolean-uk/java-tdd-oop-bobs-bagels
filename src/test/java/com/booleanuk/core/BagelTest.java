package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagelTest {

    @Test
    public void createBagelTest(){

        Bagel bagel = new Bagel("Onion bagel", 0.49, "BGLO");
        Assertions.assertEquals("Onion bagel", bagel.getName());
        Assertions.assertEquals(0.49, bagel.getPrice());

    }

    @Test
    public void getPriceTest(){

        Bagel bagel = new Bagel("Plain bagel", 0.39, "BGLP");
        Assertions.assertEquals(0.39, bagel.getPrice());

    }

    @Test
    public void addFillingTest() {

        Bagel plainBagel = new Bagel("Plain Bagel", 0.39, "BGLP");
        Filling creamCheese = new Filling("Cream Cheese", 0.12, "FILX");
        Filling bacon = new Filling("Bacon", 0.12, "FILB");

        plainBagel.addFilling(creamCheese);
        plainBagel.addFilling(bacon);

        Assertions.assertEquals(0.63, plainBagel.getPrice());

    }

}