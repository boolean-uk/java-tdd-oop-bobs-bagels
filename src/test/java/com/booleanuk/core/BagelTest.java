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
    public void addFillingTest() {
        Bagel bagel = new Bagel("Sesame", 1.29);
        bagel.addFilling(new Filling("Ham", 0.19));
        bagel.addFilling(new Filling("Butter", 0.09));

    }

    public void getFillings() {
        Bagel bagel = new Bagel("Sesame", 1.29);

    }

    @Test
    public void getPriceTest() {

    }

}
