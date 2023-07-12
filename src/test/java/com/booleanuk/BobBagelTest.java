package com.booleanuk;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BobBagelTest {







    @Test
    public void shouldAddBagelToBasket(){
        //when
        Basket basket = new Basket();
        Bagel bagel = new Bagel();
        int quantity = 1;
        //given
        basket.add(bagel,quantity);
        //then
        assertTrue(basket.getBasket().containsKey(bagel));
    }

    @Test
    public void shouldRemoveBagelFromBasket(){
        //when
        Basket basket = new Basket();
        Bagel bagel = new Bagel();
        int quantity = 1;
        basket.add(bagel,quantity);
        //given
        basket.removeProduct(bagel,1);
        //then
        assertFalse(basket.getBasket().containsKey(bagel));
    }

    @Test
    public void shouldCheckBasketCapacity(){
        //when
        Basket basket = new Basket();
        int capacity = 10;
        //given
        basket.changeCapacity(10);
        //then
        assertEquals(10,basket.getCapacity());
    }

    @Test
    public void shouldReturnTotalBasketCost(){
        //when
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion Bagel", 1,"BGLO");
        Bagel bagel1 = new Bagel("Plain Bagel", 2,"BGLO");
        int quantity = 3;

        basket.add(bagel,quantity);
        basket.add(bagel1, quantity*2);
        //given
        double totalCost = basket.getTotalPrice();

        //then
        assertEquals(15,totalCost);
    }






}
