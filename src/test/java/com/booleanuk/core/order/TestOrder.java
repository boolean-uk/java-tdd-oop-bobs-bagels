//package com.booleanuk.core.order;
//
//import com.booleanuk.core.Bagel;
//import com.booleanuk.core.Coffee;
//import com.booleanuk.core.Filling;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//public class TestOrder {
//
//    @Test
//    public void testAdd() {
//        Order newOrder = new Order();
//
//        Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<>());
//        Bagel newBagel2 = new Bagel("Honey", 0.49, new ArrayList<Filling>());
//        boolean response = newOrder.add(newBagel);
//        Assertions.assertTrue(response);
//        response = newOrder.add(newBagel2);
//        Assertions.assertFalse(response);
//
//
//        Coffee newCoffee = new Coffee("White", 1.19);
//        Coffee newCoffee2 = new Coffee("Latte Macchiato", 1.19);
//        response = newOrder.add(newCoffee);
//        Assertions.assertTrue(response);
//        response = newOrder.add(newCoffee2);
//        Assertions.assertFalse(response);
//
//
//        Filling newFilling = new Filling("Egg", 0.12);
//        Filling newFilling2 = new Filling("Nutella", 0.12);
//        response = newOrder.add(newFilling);
//        Assertions.assertTrue(response);
//        response = newOrder.add(newFilling2);
//        Assertions.assertFalse(response);
//    }
//
//    @Test
//    public void testRemove(){
//        Order newOrder = new Order();
//
//        Bagel newBagel = new Bagel("Onion", 0.49, new ArrayList<>());
//        Bagel newBagel2 = new Bagel("Honey", 0.49, new ArrayList<Filling>());
//        boolean response = newOrder.add(newBagel);
//        Assertions.assertTrue(response);
//        response = newOrder.remove(newBagel2);
//        Assertions.assertFalse(response);
//
//
//        Coffee newCoffee = new Coffee("White", 1.19);
//        Coffee newCoffee2 = new Coffee("Latte Macchiato", 1.19);
//        response = newOrder.add(newCoffee);
//        Assertions.assertTrue(response);
//        response = newOrder.remove(newCoffee2);
//        Assertions.assertFalse(response);
//    }
//
//
//}
