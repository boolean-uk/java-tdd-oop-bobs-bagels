package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @BeforeEach
    public void initialiseProducts(){
        Product product = new Product("BGLO","Bagel",0.49,"Onion");
        Product product1 = new Product("BGLP","Bagel",0.39,"Plain");
        Product product2 = new Product("BGLE","Bagel",0.49,"Everything");


    }

    @Test
    public void testGetProductCost(){

        Product product = new Product("BGLO","Bagel",0.49,"Onion");
        Assertions.assertEquals(0.49,product.getProductCost());

    }
}
