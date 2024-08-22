package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Filling;
import com.booleanuk.core.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
// This class contains tests for the extensions
public class UserTest {

    // This test is to see if we can get discounts on plain bagels
    @Test
    public void discountPlainTest(){
        Bagel bagel=new Bagel("Plain");
        bagel.addFilling(new Filling("Cheese"));
        Basket basket=new Basket(15);
        basket.add(bagel,13);

        Discount discount=new Discount();
        basket.setTotal(basket.getTotal()- discount.discPrice(basket)[3]);
        Assertions.assertEquals(3.99+0.39+13*0.12, basket.getTotal(), 0.001);




    }

    // This test is to see if we can get discounts on flavoured bagels
    @Test
    public void discountOnionTest(){

        Bagel bagel=new Bagel("Onion");
        Basket basket=new Basket(15);
        basket.add(bagel, 6);

        Discount discount=new Discount();
        basket.setTotal(basket.getTotal()- discount.discPrice(basket)[3]);
        Assertions.assertEquals(2.49, basket.getTotal(), 0.001);


    }
    // This test is to see if we can get discounts on siz flavoured bagels, while a seventh does not
    @Test
    public void discountMoreOnionTest(){

        Bagel bagel=new Bagel("Onion");
        Basket basket=new Basket(15);
        basket.add(bagel, 7);

        Discount discount=new Discount();
        basket.setTotal(basket.getTotal()- discount.discPrice(basket)[3]);
        Assertions.assertEquals(2.49+0.49, basket.getTotal(), 0.001);


    }
    // The next two tests see if we can get a coffee/bagel discount
    @Test
    public void discountEverythingTest(){
        Bagel bagel=new Bagel("Everything");
        bagel.addFilling(new Filling("Cheese"));
        Basket basket=new Basket(15);
        basket.add(bagel, 7);


        Order order0=new Order(new Coffee("Black"),1);
        basket.add(order0);
        Discount discount=new Discount();
        basket.setTotal(basket.getTotal()- discount.discPrice(basket)[3]);
        Assertions.assertEquals(2.49+7*0.12+1.25, basket.getTotal(), 0.001);


    }

    @Test
    public void discountCoffeeTest(){


        Bagel bagel1=new Bagel("Plain");
        bagel1.addFilling(new Filling("Cheese"));
        Bagel bagel2=new Bagel("Onion");
        bagel2.addFilling(new Filling("Cheese"));
        Coffee coffee1=new Coffee("Black");

        Basket basket=new Basket(16);

        basket.add(bagel1,1);
        basket.add(bagel2,1);
        basket.add(coffee1, 1);
        Discount discount=new Discount();
        basket.setTotal(basket.getTotal()- discount.discPrice(basket)[3]);
        Assertions.assertEquals(1.25+0.39+0.12*2, basket.getTotal(), 0.001);


    }
    // This test is to see if we can get discounts with multiple types of bagels and coffee
    @Test
    public void discountManyTest(){



        Basket basket=new Basket(30);
        basket.add(new Bagel("Plain"),13);
        basket.add(new Bagel("Onion"),7);
        basket.add(new Coffee("Black"),1);

        Discount discount=new Discount();
        basket.setTotal(basket.getTotal()- discount.discPrice(basket)[3]);

        Assertions.assertEquals(3.99+2.49+0.39+1.25, basket.getTotal(), 0.001);

    }

    // This test is to see if we can get a receipt
    @Test
    public void receiptTest(){
        Basket basket=new Basket(30);
        basket.add(new Bagel("Plain"),13);
        basket.add(new Bagel("Onion"),7);
        basket.add(new Coffee("Black"),1);

        Receipt receipt=new Receipt();

        receipt.printReceipt(basket, true);



    }








}
