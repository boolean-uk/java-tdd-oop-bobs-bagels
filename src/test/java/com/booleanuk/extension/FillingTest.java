package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FillingTest {

    @Test
    public void testGetName(){
         Filling bacon = new  Filling("FILB", 0.12, "Bacon");
         Filling egg = new  Filling("FILE", 0.12, "Egg");
         Filling cheese = new  Filling("FILC", 0.12, "Cheese");


        Assertions.assertEquals("Filling", bacon.getName());
        Assertions.assertEquals("Filling", egg.getName());
        Assertions.assertEquals("Filling", cheese.getName());

    }

    @Test
    public void testGetVariant(){
         Filling bacon = new  Filling("FILB", 0.12, "Bacon");
         Filling egg = new  Filling("FILE", 0.12, "Egg");
         Filling cheese = new  Filling("FILC", 0.12, "Cheese");

        Assertions.assertEquals("Bacon", bacon.getVariant());
        Assertions.assertEquals("Egg", egg.getVariant());
        Assertions.assertEquals("Cheese", cheese.getVariant());
    }

    @Test
    public void testGetPrice(){
         Filling bacon = new  Filling("FILB", 0.12, "Bacon");
         Filling egg = new  Filling("FILE", 0.12, "Egg");
         Filling cheese = new Filling("FILC", 0.12, "Cheese");

        Assertions.assertEquals(0.12, bacon.getPrice());
        Assertions.assertEquals(0.12, egg.getPrice());
        Assertions.assertEquals(0.12, cheese.getPrice());
    }
}