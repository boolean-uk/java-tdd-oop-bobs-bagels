package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FillingTest {

    @Test
    void getPrice() {
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");

        double result = filling.getPrice();

        Assertions.assertEquals(0.12, result);
    }

    @Test
    void setPrice() {
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");

        filling.setPrice(0.15);

        double result = filling.getPrice();

        Assertions.assertEquals(0.15, result);
    }

    @Test
    void getVariant() {
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");

        String result = filling.getVariant();

        Assertions.assertEquals("Egg", result);
    }

    @Test
    void setVariant() {
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");

        filling.setVariant("Ham");

        String result = filling.getVariant();

        Assertions.assertEquals("Ham", result);
    }

    @Test
    void getSku() {
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");

        String result = filling.getSku();

        Assertions.assertEquals("FILE", result);
    }

    @Test
    void setSku() {
        Filling filling = new Filling("FILC", 0.12, "Filling", "Cheese");

        filling.setSku("FILE");

        String result = filling.getSku();

        Assertions.assertEquals("FILE", result);
    }

    @Test
    void getName() {
        Filling filling = new Filling("FILC", 0.12, "Filling", "Cheese");

        String result = filling.getVariant();

        Assertions.assertEquals("Cheese", result);
    }

    @Test
    void setName() {
        Filling filling = new Filling("FILC", 0.12, "Filling", "Cheese");

        filling.setVariant("Cream Cheese");

        String result = filling.getVariant();

        Assertions.assertEquals("Cream Cheese", result);
    }
}
