package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FillingTest {

    @Test
    public void createFillingTest(){
        Filling filling = new Filling("Bacon", 0.12, "FILB");
        Assertions.assertEquals("Bacon", filling.getName());
        Assertions.assertEquals(0.12, filling.getPrice());
    }

    @Test
    public void fillingCostTest(){
        Filling bacon = new Filling("Bacon", 0.12, "FILB");
        Assertions.assertEquals(0.12, bacon.getPrice());
    }

    

}
