package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FillingTest {

    @Test
    void getPrice() {
        Filling filling = new Filling("Bacon");

        double result = filling.getPrice();

        Assertions.assertEquals(0.12, result);
    }

    @Test
    void setPrice() {
        Filling filling = new Filling("Egg");

        filling.setPrice(0.15);

        double result = filling.getPrice();

        Assertions.assertEquals(0.15, result);
    }

    @Test
    void getVariant() {
        Filling filling = new Filling("Cheese");

        String result = filling.getVariant();

        Assertions.assertEquals("Cheese", result);
    }

    @Test
    void setVariant() {
        Filling filling = new Filling("Cream Cheese");

        filling.setVariant("Ham");

        String result = filling.getVariant();

        Assertions.assertEquals("Ham", result);
    }

    @Test
    void getSku() {
        Filling filling = new Filling("Smoked Salmon");

        String result = filling.getSku();

        Assertions.assertEquals("FILS", result);
    }

    @Test
    void setSku() {
        Filling filling = new Filling("Ham");

        filling.setSku("FILE");

        String result = filling.getSku();

        Assertions.assertEquals("FILE", result);
    }

    @Test
    void getFilling() {
        Filling filling = new Filling("Bacon");

        filling.setFilling("Egg");

        String result = filling.getFilling();

        Assertions.assertEquals("Egg", result);
    }

    @Test
    void setFilling() {
        Filling filling = new Filling("Egg");

        filling.setFilling("Cream Cheese");

        String result = filling.getFilling();

        Assertions.assertEquals("Cream Cheese", result);
    }
}
