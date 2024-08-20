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
            order.addItem(new Bagel("Plain"));
        }
        Discount discount=new Discount();
        order.setTotal(order.getTotal()- discount.discPrice(order));
        Assertions.assertEquals(3.99, order.getTotal(), 0.001);


    }


}
