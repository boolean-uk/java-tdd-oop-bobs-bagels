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


}
