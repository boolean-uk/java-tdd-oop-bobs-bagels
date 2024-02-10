package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagelTest {
   @Test
    public void testGetSku(){
       Bagel bagel = new Bagel("BGLO", 0.49, "Bagel", "Onion");
       assertEquals("BGLO", bagel.getSku());
   }
}
