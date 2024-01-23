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
        basket.addItem(basket.inventory.getProduct("BGLO"));
        basket.addItem(basket.inventory.getProduct("BGLP"));
        basket.addItem(basket.inventory.getProduct("BGLP"));
        basket.addItem(basket.inventory.getProduct("BGLP"));
        basket.printReceipt();
        Assertions.assertEquals(1.66,basket.calculateTotalCost());

    }

}
