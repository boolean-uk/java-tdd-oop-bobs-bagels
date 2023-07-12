package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBasket {

    @Test
    public void testGetTotalPrice(){
        //Testing the correct calculation of discounts
        Basket basket = new Basket(3);
        Bagel bagel = new Bagel(Sku.BGLO,0.49,2,"Bagel","Onion");
        Bagel bagel2 = new Bagel(Sku.BGLP,0.39,12,"Bagel","Plain");
        Coffee coffee = new Coffee(Sku.COFC,1.29,1,"Coffee","Capuccino");
        bagel.getFillings().add(new Filling(Sku.FILB,0.12,1,"Filling","Bacon"));
        basket.addItem(bagel);
        basket.addItem(bagel2);
        basket.addItem(coffee); // it complains by printing a message
        Assertions.assertEquals(5.85,basket.getTotalPrice(),0.001); //3.99 + 1.25 + 0.49 + 0.12 for the filling
    }
    @Test
    public void testPrintReceipt(){
        Basket basket = new Basket();
        Bagel bagel = new Bagel(Sku.BGLO,0.49,2,"Bagel","Onion");
        Bagel bagel2 = new Bagel(Sku.BGLP,0.39,12,"Bagel","Plain");
        bagel.getFillings().add(new Filling(Sku.FILB,0.12,1,"Filling","Bacon"));
        Bagel bagel3 = new Bagel(Sku.BGLE,0.49,6,"Bagel","Everything");
        Coffee coffee = new Coffee(Sku.COFC,1.29,3,"Coffee","Capuccino");
//        System.out.println(bagel.getPrice());
        basket.addItem(bagel); // 3.99
        basket.addItem(bagel2);
        basket.addItem(bagel3);
        basket.addItem(coffee); // 1.25
//        Assertions.assertEquals(10.39,basket.getTotalPrice(),0.001);
//        System.out.println("Total amount: "+basket.getTotalPrice());
        basket.printReceipt();
        System.out.println(basket.getTotalPrice());
    }
}
