package com.booleanuk;

import com.booleanuk.core.*;
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
    public void ShouldReturnTrueAfterAddFillingsToTheBagel(){
        //when
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion Bagel", 1,"BGLO", BagelVariant.ONION);
        int quantity = 3;
        Filling filling = new Filling("Bacon",0.5,"FILB", FillingVariant.BACON);
        //given
        bagel.addFilling(filling);

        //then
        assertTrue(bagel.getFillings().contains(filling));

    }


    @Test
    public void shouldReturnTotalBasketCost(){
        //when
        Basket basket = new Basket();
        basket.setCapacity(20);
        Bagel bagel = new Bagel("Onion Bagel", 1,"BGLO", BagelVariant.ONION);
        Bagel bagel1 = new Bagel("Plain Bagel", 2,"BGLO",BagelVariant.ONION);
        int quantity = 3;

        basket.add(bagel,quantity);
        basket.add(bagel1, quantity*2);
        //given
        double totalCost = basket.getTotalCost();

        //then
        assertEquals(15,totalCost);
    }

    @Test
    public void  shouldReturn5afterAddingTooManyBagels(){
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion Bagel", 1,"BGLO", BagelVariant.ONION);
        Bagel bagel1 = new Bagel("Plain Bagel", 2,"BGLO",BagelVariant.ONION);
        int quantity = 5;
        //given
        basket.add(bagel,quantity);
        basket.add(bagel1, quantity*2);
        double totalCost = basket.getTotalCost();
        //then
        assertEquals(5,totalCost);
    }


    @Test
    public  void shouldReturnTrueIfSanityIsOk(){
        //when
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion Bagel", 1,"BGLO",BagelVariant.ONION);
        Bagel bagel1 = new Bagel("Plain Bagel", 2,"BGLP",BagelVariant.PLAIN);
        int quantity = 3;

        basket.add(bagel,quantity);
        //given
       boolean sanity = basket.removeProduct(bagel,1);
        //then
        assertTrue(sanity);

    }


    @Test
    public  void shouldReturnFalseIfSanityIsNotOK(){
        //when
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion Bagel", 1,"BGLO",BagelVariant.ONION);
        Bagel bagel1 = new Bagel("Plain Bagel", 2,"BGLP",BagelVariant.PLAIN);
        int quantity = 3;

        basket.add(bagel,quantity);
        //given
        boolean sanity = basket.removeProduct(bagel1,1);
        //then
        assertFalse(sanity);

    }


    @Test
    public void shouldNotAddProductsIfCapacityIsLessThanQuantity(){
        //when
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion Bagel", 1,"BGLO",BagelVariant.ONION);
        Bagel bagel1 = new Bagel("Plain Bagel", 2,"BGLP",BagelVariant.PLAIN);
        int quantity = 3;
    }







}
