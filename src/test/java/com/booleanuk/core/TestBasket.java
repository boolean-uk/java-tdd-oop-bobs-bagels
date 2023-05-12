package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestBasket {

    @Test
    public void testAddBagel(){
        Bagel newBagel = new Bagel("Onion", 0.49) ;
        Basket newBasket = new Basket(10);
        boolean response = newBasket.add(newBagel);
        Assertions.assertTrue(response);
    }

    @Test
    public void testRemoveBagel(){
        Bagel newBagel = new Bagel("Onion", 0.49) ;
        Bagel newBagel2 = new Bagel("Plain", 0.39) ;
        Basket newBasket = new Basket(10);
        boolean response = newBasket.add(newBagel);
        response = newBasket.add(newBagel2);

        response = newBasket.remove(newBagel2);
        Assertions.assertTrue(response);
        Bagel newBagel3 = new Bagel("Honey", 0.49);
        response = newBasket.remove(newBagel3);
        Assertions.assertFalse(response);

    }

    @Test
    public void testAddCoffee(){
        Coffee newCoffee = new Coffee("White", 1.19) ;
        Basket newBasket = new Basket(new ArrayList<Bagel>(), new ArrayList<Coffee>(), 10);
        boolean response = newBasket.add(newCoffee);
        Assertions.assertTrue(response);
    }

    @Test
    public void testRemoveCoffee(){
        Coffee newCoffee = new Coffee("White", 1.19) ;
        Coffee newCoffee2 = new Coffee("Capuccino", 0.99) ;
        Basket newBasket = new Basket(new ArrayList<Bagel>(), new ArrayList<Coffee>(), 10);
        boolean response = newBasket.add(newCoffee);
        response = newBasket.add(newCoffee2);

        response = newBasket.remove(newCoffee2);
        Assertions.assertTrue(response);
        Coffee newCoffee3= new Coffee("Flat White", 0.49);
        response = newBasket.remove(newCoffee3);
        Assertions.assertFalse(response);

    }

  @Test
  public void testUpdateCapacity(){
      Basket newBasket = new Basket(new ArrayList<Bagel>(), new ArrayList<Coffee>(), 2);
      Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<Filling>()) ;
      Bagel newBagel2 = new Bagel("Plain", 0.39, new ArrayList<Filling>()) ;
      boolean response = newBasket.add(newBagel);
      response = newBasket.add(newBagel2);
      response = newBasket.updateCapacity(3);
      Assertions.assertTrue(response);
      response = newBasket.updateCapacity(1);
      Assertions.assertFalse(response);

  }

  @Test
    public void testCost(){
      Basket newBasket = new Basket(new ArrayList<Bagel>(), new ArrayList<Coffee>(), 2);
      Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<Filling>()) ;
      Bagel newBagel2 = new Bagel("Plain", 0.39, new ArrayList<Filling>()) ;
      boolean response = newBasket.add(newBagel);
      response = newBasket.add(newBagel2);
      Assertions.assertEquals(0.88, newBasket.cost());
  }

  @Test
    public void testCostBagel(){
      Basket newBasket = new Basket(new ArrayList<Bagel>(), new ArrayList<Coffee>(), 2);
      Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<Filling>()) ;
      Bagel newBagel2 = new Bagel("Plain", 0.39, new ArrayList<Filling>()) ;
      boolean response = newBasket.add(newBagel);
      response = newBasket.add(newBagel2);
      Assertions.assertEquals(0.39, newBasket.costBagel(newBagel));
  }


}
