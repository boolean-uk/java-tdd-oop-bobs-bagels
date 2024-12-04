package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testGetProductCost(){
        Product product = new Product("BGLO","Bagel",0.49,"Onion");
        Assertions.assertEquals(0.49,product.getProductCost());
    }
}
