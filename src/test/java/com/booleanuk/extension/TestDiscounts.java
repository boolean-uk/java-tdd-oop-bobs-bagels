package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDiscounts {
    @Test
    public void testDiscounts(){
        Basket basket = new Basket();
        Bagel bagel = new Bagel(Sku.BGLO,0.49,0.0,2,"Bagel","Onion");
        Bagel bagel2 = new Bagel(Sku.BGLP,0.39,0.0,12,"Bagel","Plain");
        bagel.getFillings().add(new Filling(Sku.FILB,0.12,0.0,0,"Filling","Bacon"));
        Bagel bagel3 = new Bagel(Sku.BGLE,0.49,0.0,6,"Bagel","Everything");
        Coffee coffee = new Coffee(Sku.COFC,1.29,0.0,3,"Coffee","Capuccino");
        System.out.println(bagel.getPrice());
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
