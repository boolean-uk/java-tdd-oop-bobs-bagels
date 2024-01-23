package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InventoryTest {

    //User story 9
    @Test
    public void assertPriceOfEveryFilling() {
        Inventory inventory = new Inventory();

        ArrayList<Filling> returnedFillings = inventory.getAllFillings();

        int allTested = 0;

        for(Filling filling : returnedFillings) {
            switch (filling.getName()) {
                case "Bacon":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                case "Egg":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                case "Cheese":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                case "Cream Cheese":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                case "Smoked Salmon":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                case "Ham":
                    Assertions.assertEquals(filling.getPrice(), 0.12);
                    allTested++;
                    break;
                default:
                    Assertions.assertEquals(1, 2);
                    break;
            }
        }
        if(allTested != 6) {
            Assertions.assertEquals(1, 2);
        }
    }
}
