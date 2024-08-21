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
        for (int i=0; i<13; i++){
            Bagel bagel=new Bagel("Plain");
            bagel.addFilling(new Filling("Cheese"));
            order.addItem(bagel);
        }
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPriceAlt(order)[3]);
        Assertions.assertEquals(3.99+0.39+13*0.12, order.getTotal(), 0.001);




    }

    @Test
    public void discountOnionTest(){

        Order order=new Order();
        for (int i=0; i<6; i++){
            order.addItem(new Bagel("Onion"));
        }
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPriceAlt(order)[3]);
        Assertions.assertEquals(2.49, order.getTotal(), 0.001);


    }

    @Test
    public void discountMoreOnionTest(){

        Order order=new Order();
        for (int i=0; i<7; i++){
            order.addItem(new Bagel("Onion"));
        }
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPriceAlt(order)[3]);
        Assertions.assertEquals(2.49+0.49, order.getTotal(), 0.001);


    }

    @Test
    public void discountEverythingTest(){

        Order order=new Order();
        for (int i=0; i<7; i++){
            Bagel bagel=new Bagel("Everything");
            bagel.addFilling(new Filling("Cheese"));
            order.addItem(bagel);
        }
        order.addItem(new Coffee("Black"));
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPriceAlt(order)[3]);
        Assertions.assertEquals(2.49+7*0.12+1.25, order.getTotal(), 0.001);


    }

    @Test
    public void discountCoffeeTest(){

        Order order=new Order();
        Bagel bagel1=new Bagel("Plain");
        bagel1.addFilling(new Filling("Cheese"));
        Bagel bagel2=new Bagel("Onion");
        bagel2.addFilling(new Filling("Cheese"));
        Coffee coffee1=new Coffee("Black");
        order.addItem(bagel1);
        order.addItem(bagel2);
        order.addItem(coffee1);
        //order.addItem(coffee2);
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPriceAlt(order)[3]);
        Assertions.assertEquals(1.25+0.39+0.12*2, order.getTotal(), 0.001);


    }

    @Test
    public void discountManyTest(){
        Order order=new Order();
        for (int i=0; i<13; i++){
            Bagel bagel=new Bagel("Plain");
            order.addItem(bagel);
            if(i%2==0){
                order.addItem(new Bagel("Onion"));
            }

        }
        order.addItem(new Coffee("Black"));
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPriceAlt(order)[3]);

        Assertions.assertEquals(3.99+2.49+0.39+1.25, order.getTotal(), 0.001);

    }

    @Test
    public void receiptTest(){
        Order order=new Order();
        for (int i=0; i<13; i++){
            Bagel bagel=new Bagel("Plain");
            bagel.addFilling(new Filling("Cheese"));
            order.addItem(bagel);
            if(i%2==0){
                order.addItem(new Bagel("Onion"));
            }

        }
        order.addItem(new Coffee("Black"));
        Basket basket=new Basket(26);
        basket.add(order);

        Receipt receipt=new Receipt();

        receipt.printReceipt(order);



    }






}
