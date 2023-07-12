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
    public void whenAddToBasketExistingBagelType_bagelIsAddedToBasket() throws Exception {
        //Setup
        Basket.BagelType typeOfBagel = Basket.BagelType.ONION;
        Bagel bagel = new Bagel(typeOfBagel);
        //Execute
        basket.addToBasket(bagel);

        Assertions.assertEquals(List.of(bagel), basket.getBagelList());
    }
    @Test
    public void whenRemoveFromBasketBagelDoesExistInBasket_bagelIsRemovedFromBasket() throws Exception {
        //Setup
        Basket.BagelType typeOfBagel = Basket.BagelType.ONION;
        Bagel bagel = new Bagel(typeOfBagel);
        basket.addToBasket(bagel);
        basket.removeFromBasket(bagel);
        Assertions.assertFalse(basket.getBagelList().contains(bagel));
    }

    @Test
    public void whenIsBasketFullCalled_basketCapacityIsChecked() throws Exception {
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
    @Test
    public void whenSetBasketCapacityCorrectCapacity_capacityIsChanged(){
        basket.setBasketCapacity(4);
        Assertions.assertEquals(4,basket.getCapacity());
    }

    @Test
    public void whenGetTotalCostCalled_totalCostIsReturned() throws Exception {
        basket.addToBasket(new Bagel(Basket.BagelType.ONION));
        basket.addToBasket(new Bagel(Basket.BagelType.PLAIN));

        Assertions.assertEquals(0.88,basket.getTotalCost());
    }

}
