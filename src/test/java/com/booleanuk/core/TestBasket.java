package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestBasket {
    public Basket basket;
    @BeforeEach
    public void setUp() {
        basket = new Basket();
    }

    @Test
    public void whenAddToBasketExistingBagelType_bagelIsAddedToBasket(){
        //Setup
        Basket.BagelType typeOfBagel = Basket.BagelType.ONION;
        Bagel bagel = new Bagel(typeOfBagel);
        //Execute
        basket.addToBasket(bagel);

        Assertions.assertEquals(List.of(bagel), basket.getBagelList());
    }
    @Test
    public void whenRemoveFromBasketBagelDoesExistInBasket_bagelIsRemovedFromBasket(){
        //Setup
        Basket.BagelType typeOfBagel = Basket.BagelType.ONION;
        Bagel bagel = new Bagel(typeOfBagel);
        basket.addToBasket(bagel);
        basket.removeFromBasket(bagel);
        Assertions.assertFalse(basket.getBagelList().contains(bagel));
    }

    @Test
    public void whenIsBasketFullCalled_basketCapacityIsChecked(){
        //Setup
        basket.addToBasket(new Bagel(Basket.BagelType.ONION));
        basket.addToBasket(new Bagel(Basket.BagelType.PLAIN));
        String message = "";
        try{
            basket.addToBasket(new Bagel(Basket.BagelType.SESAME));
        } catch (Exception e) {
            message = e.getMessage();
        }

        Assertions.assertEquals("Basket is full", message);
    }

}
