package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestBasket {

    @Test
    public void testAddBagel(){
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory()) ;

        Basket newBasket = new Basket(10, new Inventory());

        boolean response = newBasket.add(newBagel);
        Assertions.assertTrue(response);
    }

    @Test
    public void testRemoveBagel(){
        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        Bagel newBagel2 = new Bagel("Plain", 0.39, new Inventory());

        Basket newBasket = new Basket(10, new Inventory());
        newBasket.add(newBagel);

        boolean response = newBasket.remove(newBagel);
        Assertions.assertTrue(response);

        boolean response2 = newBasket.remove(newBagel2);
        Assertions.assertFalse(response2);
    }

    @Test
    public void testRemoveBagelWithFillings(){
        ArrayList<Filling> fillings = new ArrayList<>() {
            {
                add(new Filling("Bacon", 0.12));
                add(new Filling("Egg", 0.12));
            }
        };

        Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
        newBagel.addFilling(fillings.get(0));
        newBagel.addFilling(fillings.get(1));

        Basket newBasket = new Basket(10, new Inventory());
        newBasket.add(newBagel);

        boolean response3 = newBasket.remove(newBagel);
        Assertions.assertTrue(response3);
    }

    @Test
    public void testAddCoffee(){
        Coffee newCoffee = new Coffee("White", 1.19) ;

        Basket newBasket = new Basket(10, new Inventory());

        boolean response = newBasket.add(newCoffee);
        Assertions.assertTrue(response);
    }

    @Test
    public void testRemoveCoffee() {
        Coffee newCoffee = new Coffee("White", 1.19) ;
        Coffee newCoffee2 = new Coffee("Capuccino", 0.99) ;
        Coffee newCoffee3 = new Coffee("Flat White", 0.49);

        Basket newBasket = new Basket(10, new Inventory());
        newBasket.add(newCoffee);
        newBasket.add(newCoffee2);

        boolean response = newBasket.remove(newCoffee2);
        Assertions.assertTrue(response);

        boolean response2 = newBasket.remove(newCoffee3);
        Assertions.assertFalse(response2);
    }

  @Test
  public void testUpdateCapacity(){
      Bagel newBagel = new Bagel("Onion", 0.49, new Inventory()) ;
      Bagel newBagel2 = new Bagel("Plain", 0.39, new Inventory()) ;

      Basket newBasket = new Basket(2, new Inventory());
      newBasket.add(newBagel);
      newBasket.add(newBagel2);

      boolean response = newBasket.updateCapacity(3);
      Assertions.assertTrue(response);

      response = newBasket.updateCapacity(1);
      Assertions.assertFalse(response);
  }

  @Test
    public void testCost(){
      Bagel newBagel = new Bagel("Onion", 0.49, new Inventory());
      Bagel newBagel2 = new Bagel("Plain", 0.39, new Inventory());
      Coffee newCoffee = new Coffee("White", 1.19);

      Basket newBasket = new Basket(3, new Inventory());
      newBasket.add(newBagel);
      newBasket.add(newBagel2);
      newBasket.add(newCoffee);

      Assertions.assertEquals(2.07, newBasket.cost());
  }
}
