package com.booleanuk.extension;

import com.booleanuk.extension.Bagel;
import com.booleanuk.extension.Basket;
import com.booleanuk.extension.Filling;
import com.booleanuk.extension.Inventory;
import com.booleanuk.extension.Item;
import com.booleanuk.extension.Shop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BagelTest {

    /*Extension 1 tests*/
    /* Test use case 1*/
    @Test
    public void testGettingAValidDiscount(){
        Inventory.resetInstance();
        Basket basket = new Basket(30);
        basket.addItem("BGLP", 16);
        Assertions.assertEquals(5.55, basket.getTotalCost());
    }
    @Test
    public void testGettingAValidDiscount6PlainBagels(){
        Inventory.resetInstance();
        Basket basket = new Basket(30);
        basket.addItem("BGLP", 6);
        Assertions.assertEquals(2.34, basket.getTotalCost());

    }
    @Test
    public void testGettingDiscountsOnBigOrder(){
        Inventory.resetInstance();
        Basket basket = new Basket(40);
        basket.addItem("BGLO", 2);
        basket.addItem("BGLP", 12);
        basket.addItem("BGLE", 6);
        basket.addItem("COFB", 3);
        Assertions.assertEquals(10.43, basket.getTotalCost());
    }

    @Test
    public void testGettingBagelAndCoffeeDiscount(){
        Basket basket = new Basket(20);
        basket.addItem("COFB", 1);
        basket.addItem("BGLO", 1);
        Assertions.assertEquals(1.25, basket.getTotalCost());
    }

    /* Test extension 2 & 3 */
    @Test
    public void testGettingReceiptWhenBasketHasItems(){
        Inventory.resetInstance();
        Basket basket = new Basket(40);
        basket.addItem("BGLP", 12);
        basket.addItem("BGLE", 6);
        basket.addItem("COFB", 3);
        basket.addItem("BGLO", 2);
        String expected =
                """
                ~~~ Bob's Bagels ~~~
                                
                                """ +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +

                """
                
                ----------------------------
                BGLE			   6	2.49
                					(-0.45)
                BGLP			   12	3.99
                					(-0.69)
                BGLO			   2	0.98
                COFB			   3	2.97
                                
                ----------------------------
                Total				    10.43
                 You saved a total of 1.14
                       on this shop
                                
                        Thank you
                     for your order!
                """;
        Assertions.assertEquals(expected, basket.getReceipt());

    }

}
