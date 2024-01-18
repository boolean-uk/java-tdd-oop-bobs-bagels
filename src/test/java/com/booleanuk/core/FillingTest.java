package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FillingTest {

    @Test
    public void testGetName(){
        Filling bacon = new Filling("FILB");
        Filling egg = new Filling("FILE");
        Filling cheese = new Filling("FILC");


        Assertions.assertEquals("Filling", bacon.getName());
        Assertions.assertEquals("Filling", egg.getName());
        Assertions.assertEquals("Filling", cheese.getName());

    }

    @Test
    public void testGetVariant(){
        Filling bacon = new Filling("FILB");
        Filling egg = new Filling("FILE");
        Filling cheese = new Filling("FILC");

        Assertions.assertEquals("Bacon", bacon.getVariant());
        Assertions.assertEquals("Egg", egg.getVariant());
        Assertions.assertEquals("Cheese", cheese.getVariant());
    }

    @Test
    public void testGetPrice(){
        Filling bacon = new Filling("FILB");
        Filling egg = new Filling("FILE");
        Filling cheese = new Filling("FILC");

        Assertions.assertEquals(0.12, bacon.getPrice());
        Assertions.assertEquals(0.12, egg.getPrice());
        Assertions.assertEquals(0.12, cheese.getPrice());
    }
}