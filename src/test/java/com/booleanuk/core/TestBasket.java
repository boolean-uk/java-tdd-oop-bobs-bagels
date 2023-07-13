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
        Manager manager = new Manager();
        manager.changeBasketCapacity(2);
    }

    @Test
    public void whenAddToBasketExistingBagelType_bagelIsAddedToBasket() throws Exception {
        //Setup
        String bagel = "BGLO";

        //Execute
        basket.addToBasket(bagel);

        Assertions.assertEquals(List.of(bagel), basket.getListOfItemsInBasket());
    }
    @Test
    public void whenRemoveFromBasketBagelDoesExistInBasket_bagelIsRemovedFromBasket() throws Exception {
        //Setup
        String bagel = "BGLO";
        basket.addToBasket(bagel);
        basket.removeFromBasket(bagel);
        Assertions.assertFalse(basket.getListOfItemsInBasket().contains(bagel));
    }

    @Test
    public void whenIsBasketFullCalled_basketCapacityIsChecked() throws Exception {
        //Setup
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLP");

         boolean result = basket.addToBasket("BGLS");


        Assertions.assertEquals(false, result);
    }
    @Test
    public void whenSetBasketCapacityCorrectCapacity_capacityIsChanged(){
        basket.setBasketCapacity(4);
        Assertions.assertEquals(4,basket.getCapacity());
    }

    @Test
    public void whenGetTotalCostCalled_totalCostIsReturned() throws Exception {
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLP");

        Assertions.assertEquals(0.88,basket.getTotalCost());
    }
    @Test
    public void whenGetTotalCostCalledWithFillings_totalCostIsReturned() throws Exception {
        basket.addToBasket("BGLO");
        basket.addToBasket("FILE");

        Assertions.assertEquals(0.61,basket.getTotalCost());
    }

}
