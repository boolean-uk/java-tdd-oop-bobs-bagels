package com.booleanuk.extension;


import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;
import com.booleanuk.core.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class BasketExtensionTest {

    @Test
    public void checkTotalCost(){
        BasketExtension basket =new BasketExtension();
        basket.setSize(5);
        basket.addItem(basket.inventory.getProduct("BGLO"),1);
        basket.addItem(basket.inventory.getProduct("BGLP"),1);
        basket.addItem(basket.inventory.getProduct("BGLP"),1);
        basket.addItem(basket.inventory.getProduct("BGLP"),1);
        basket.printReceipt();
        Assertions.assertEquals(1.66,basket.calculateTotalCost());

    }

    @Test
    public void TestDiscount(){
        BasketExtension basket =new BasketExtension();
        basket.setSize(15);
        basket.addItem(basket.inventory.getProduct("BGLO"),15);
        basket.printReceipt();
        Assertions.assertEquals(5.46,basket.calculateTotalCost());

    }

    @Test
    public void TestDiscount2(){
        BasketExtension basket =new BasketExtension();
        basket.setSize(25);
        basket.addItem(basket.inventory.getProduct("BGLO"),15);
        basket.addItem(basket.inventory.getProduct("BGLP"),6);
        basket.printReceipt();
        Assertions.assertEquals(7.95,basket.calculateTotalCost());

    }

}
