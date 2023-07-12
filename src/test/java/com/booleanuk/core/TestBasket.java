package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestBasket {
    @BeforeEach
    public void setUp() {
        Basket basket = new Basket();
    }

    @Test
    public void whenAddToBasketExistingBagelType_bagelIsAddedToBasket(){
        BagelType typeOfBagel = BagelType.ONION;
        Bagel bagel = new Bagel(typeOfBagel);

        basket.addToBasket(bagel);

        Assertions.assertEquals(List.of(bagel), basket.getBagelList());
    }
}
