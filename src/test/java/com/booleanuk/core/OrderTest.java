package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {

    OrderTest(){

    }

    @Test
    public void getOrderTotal(){
        Order order=new Order();
        Bagel bagel0=new Bagel("Plain");
        bagel0.addFilling(new Filling("Ham"));
        Coffee black=new Coffee("Black");
        order.addItem(bagel0);
        order.addItem(black);

        Assertions.assertEquals(0.49+0.12+0.99, order.getTotal());
    }


}

