package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestBasket {
    public Basket basket;
    public Manager manager;
    public String ONION_BAGEL = "BGLO";
    public String PLAIN_BAGEL = "BGLP";
    public String SESAME_BAGEL = "BGLS";
    public String EGG_FILLING = "FILE";
    public String BLACK_COFFEE = "COFB";


    @BeforeEach
    public void setUp() {

        basket = new Basket();
        manager = new Manager();
        manager.changeBasketCapacity(2);
    }

    @Test
    public void whenAddToBasketExistingBagelType_bagelIsAddedToBasket()  {
        //Execute
        basket.addToBasket(ONION_BAGEL);

        Assertions.assertEquals(List.of(ONION_BAGEL), basket.getListOfItemsInBasket());
    }
    @Test
    public void whenRemoveFromBasketBagelDoesExistInBasket_bagelIsRemovedFromBasket()  {
        //Setup
        basket.addToBasket(ONION_BAGEL);
        basket.removeFromBasket(ONION_BAGEL);
        Assertions.assertFalse(basket.getListOfItemsInBasket().contains(ONION_BAGEL));
    }

    @Test
    public void whenIsBasketFullCalled_basketCapacityIsChecked() {
        //Setup
        basket.addToBasket(ONION_BAGEL);
        basket.addToBasket(PLAIN_BAGEL);

         boolean result = basket.addToBasket(SESAME_BAGEL);

        Assertions.assertEquals(false, result);
    }
    @Test
    public void whenSetBasketCapacityCorrectCapacity_capacityIsChanged(){
        basket.setBasketCapacity(4);
        Assertions.assertEquals(4,basket.getCapacity());
    }

    @Test
    public void whenGetTotalCostCalled_totalCostIsReturned() {
        basket.addToBasket(ONION_BAGEL);
        basket.addToBasket(PLAIN_BAGEL);

        Assertions.assertEquals(88,basket.getTotalCost());
    }
    @Test
    public void whenGetTotalCostCalledWithFillings_totalCostIsReturned()  {
        basket.addToBasket(ONION_BAGEL);
        basket.addToBasket(EGG_FILLING);

        Assertions.assertEquals(61,basket.getTotalCost());
    }
    @Test
    public void when6BagelsAnd6CofffesAreInTheBasket_totalDiscoutPriceIsReturned()
    {
        manager.changeBasketCapacity(12);
        for (int i=0;i<6;i++)
        {
            basket.addToBasket(PLAIN_BAGEL);
            basket.addToBasket(BLACK_COFFEE);
        }
        Assertions.assertEquals(750,basket.getTotalCost());
    }

}
