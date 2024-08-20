package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Filling;
import com.booleanuk.core.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserTest {

    @Test
    public void discountPlainTest(){

        Order order=new Order();
        for (int i=0; i<12; i++){
            Bagel bagel=new Bagel("Plain");
            bagel.addFilling(new Filling("Cheese"));
            order.addItem(bagel);
        }
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPrice(order));
        Assertions.assertEquals(3.99+12*0.12, order.getTotal(), 0.001);




    }

    @Test
    public void discountOnionTest(){

        Order order=new Order();
        for (int i=0; i<6; i++){
            order.addItem(new Bagel("Onion"));
        }
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPrice(order));
        Assertions.assertEquals(2.49, order.getTotal(), 0.001);


    }

    @Test
    public void discountEverythingTest(){

        Order order=new Order();
        for (int i=0; i<6; i++){
            Bagel bagel=new Bagel("Everything");
            bagel.addFilling(new Filling("Cheese"));
            order.addItem(bagel);
        }
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPrice(order));
        Assertions.assertEquals(2.49+6*0.12, order.getTotal(), 0.001);


    }

    @Test
    public void discountCoffeeTest(){

        Order order=new Order();
        Bagel bagel1=new Bagel("Plain");
        Bagel bagel2=new Bagel("Onion");
        Coffee coffee1=new Coffee("Black");
        Coffee coffee2=new Coffee("Black");
        order.addItem(bagel1);
        order.addItem(bagel2);
        order.addItem(coffee1);
        order.addItem(coffee2);
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPrice(order));
        Assertions.assertEquals(2.50, order.getTotal(), 0.001);


    }
    /*
    @Test
    public void discountManyTest(){
        Order order=new Order();
        for (int i=0; i<13; i++){
            Bagel bagel=new Bagel("Plain");
            bagel.addFilling(new Filling("Cheese"));
            order.addItem(bagel);
            order.addItem(new Bagel("Onion"));
        }

        order.addItem(new Coffee("Black"));
        order.addItem(new Coffee("Black"));

        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPrice(order));

        Assertions.assertEquals(2*2.49+3.99+1.25, order.getTotal(), 0.001);

    }

     */


}
