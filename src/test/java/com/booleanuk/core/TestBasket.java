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
        Basket.BagelType typeOfBagel = Basket.BagelType.ONION;
        Bagel bagel = new Bagel(typeOfBagel);

        basket.addToBasket(bagel);

        Assertions.assertEquals(List.of(bagel), basket.getBagelList());
    }
}
