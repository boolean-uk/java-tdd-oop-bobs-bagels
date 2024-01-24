    package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BagelTest {

    @Test
    public void getBasePrice() {
        Bagel bagel = new Bagel("Sesame", 1.29);
        Assertions.assertEquals(1.29, bagel.getBasePrice());
    }

    @Test
    public void setBasePriceTest() {
        Bagel bagel = new Bagel("Sesame", 1.29);
        bagel.setBasePrice(1.19);
        Assertions.assertEquals(1.19, bagel.getBasePrice());
    }

    @Test
    public void getPriceTest() {
        Bagel bagel = new Bagel("Poppy Seed", 1.29);
        Assertions.assertEquals(1.29, bagel.getPrice());
    }

    @Test
    public void setPriceTest() {
        Bagel bagel = new Bagel("Poppy Seed", 1.29);
        bagel.setPrice(0.89);
        Assertions.assertEquals(0.89, bagel.getPrice());
    }

    @Test
    public void getFillingsTest() {
        Bagel bagel = new Bagel("Poppy Seed", 1.29);
        Assertions.assertTrue(bagel.getFillings().isEmpty());
    }

    @Test
    public void addFillingsTest() {
        Bagel bagel = new Bagel("Poppy Seed", 1.29);
        bagel.addFilling(new Filling("Butter", 0.09));
        bagel.addFilling(new Filling("Ham", 0.29));
        bagel.addFilling(new Filling("Cheese", 0.19));
        Filling[] testFillings = {
                new Filling("Butter", 0.09),
                new Filling("Ham", 0.29),
                new Filling("Cheese", 0.19)
        };
        for(int i = 0; i < bagel.getFillings().size(); i++) {
            Assertions.assertEquals(testFillings[i].name, bagel.getFillings().get(i).name);
            Assertions.assertEquals(testFillings[i].price, bagel.getFillings().get(i).getPrice());
        }
        Assertions.assertEquals(1.86, bagel.getPrice());

    }


}
