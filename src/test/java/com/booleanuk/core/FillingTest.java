package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FillingTest {

    @Test
    public void getPrice() {
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");

        double result = filling.getPrice();

        Assertions.assertEquals(0.12, result);
    }

    @Test
    public void setPrice() {
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");

        filling.setPrice(0.15);

        double result = filling.getPrice();

        Assertions.assertEquals(0.15, result);
    }

    @Test
    public void getVariant() {
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");

        String result = filling.getVariant();

        Assertions.assertEquals("Egg", result);
    }

    @Test
    public void setVariant() {
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");

        filling.setVariant("Ham");

        String result = filling.getVariant();

        Assertions.assertEquals("Ham", result);
    }

    @Test
    public void getSku() {
        Filling filling = new Filling("FILE", 0.12, "Filling", "Egg");

        String result = filling.getSku();

        Assertions.assertEquals("FILE", result);
    }

    @Test
    public void setSku() {
        Filling filling = new Filling("FILC", 0.12, "Filling", "Cheese");

        filling.setSku("FILE");

        String result = filling.getSku();

        Assertions.assertEquals("FILE", result);
    }

    @Test
    public void getName() {
        Filling filling = new Filling("FILC", 0.12, "Filling", "Cheese");

        String result = filling.getVariant();

        Assertions.assertEquals("Cheese", result);
    }

    @Test
    public void setName() {
        Filling filling = new Filling("FILC", 0.12, "Filling", "Cheese");

        filling.setVariant("Cream Cheese");

        String result = filling.getVariant();

        Assertions.assertEquals("Cream Cheese", result);
    }
}
