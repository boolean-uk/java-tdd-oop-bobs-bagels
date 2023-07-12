package com.booleanuk;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BobBagelTest {



    @Test
    public void shouldAddBagelToBasket(){
        //when
        Basket basket = new Basket();
        Bagel bagel = new Bagel();
        //given
        basket.add(bagel);
        //then
        assertTrue(basket.getBasket().containsKey(bagel));


    }

}
