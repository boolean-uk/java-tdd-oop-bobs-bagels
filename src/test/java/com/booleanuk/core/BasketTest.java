package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void ShouldShowProduct(){
        Bagel myBagel = new Bagel("BGLO",	0.49, "Bagel",	"Onion");

        Assertions.assertNotEquals("BGLO 0.49 Bagel Onion", myBagel.showProduct());
        myBagel.showProduct();
    }


}


