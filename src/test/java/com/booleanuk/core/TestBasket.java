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
        String typeOfBagel = "BGLO";
        Bagel bagel = new Bagel(typeOfBagel);
        //Execute
        basket.addToBasket(bagel);

        Assertions.assertEquals(List.of(bagel), basket.getBagelList());
    }
    @Test
    public void whenRemoveFromBasketBagelDoesExistInBasket_bagelIsRemovedFromBasket() throws Exception {
        //Setup
        String typeOfBagel = "BGLO";
        Bagel bagel = new Bagel(typeOfBagel);
        basket.addToBasket(bagel);
        basket.removeFromBasket(bagel);
        Assertions.assertFalse(basket.getBagelList().contains(bagel));
    }

    @Test
    public void whenIsBasketFullCalled_basketCapacityIsChecked() throws Exception {
        //Setup
        basket.addToBasket(new Bagel("BGLO"));
        basket.addToBasket(new Bagel("BGLP"));
        String message = "";
        try{
            basket.addToBasket(new Bagel("BGLS"));
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
        basket.addToBasket(new Bagel("BGLO"));
        basket.addToBasket(new Bagel("BGLP"));

        Assertions.assertEquals(0.88,basket.getTotalCost());
    }
    @Test
    public void whenGetTotalCostCalledWithFillings_totalCostIsReturned() throws Exception {
        basket.addToBasket(new Bagel("BGLO"));
        basket.addFilling("FILE");
        
        Assertions.assertEquals(0.61,basket.getTotalCost());
    }

}
