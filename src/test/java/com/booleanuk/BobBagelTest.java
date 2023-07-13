package com.booleanuk;

import com.booleanuk.core.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BobBagelTest {


    @Test
    public void shouldAddBagelToBasket(){
        //given
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION);
        int quantity = 1;
        //given
        basket.add(bagel,quantity);
        //then
        assertTrue(basket.getBasket().containsKey(bagel));
    }

    @Test
    public void shouldRemoveBagelFromBasket(){
        //given
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION);
        int quantity = 1;
        basket.add(bagel,quantity);
        //given
        basket.removeProduct(bagel,1);
        //then
        assertFalse(basket.getBasket().containsKey(bagel));
    }

    @Test
    public void shouldCheckBasketCapacity(){
        //given
        Basket basket = new Basket();
        int capacity = 10;
        //when
        basket.changeCapacity(10);
        //then
        assertEquals(10,basket.getCapacity());
    }

    @Test
    public void ShouldReturnTrueAfterAddFillingsToTheBagel(){
        //given
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION);
        int quantity = 3;
        Filling filling = new Filling("Bacon",0.12,"FILB", FillingVariant.BACON);
        //when
        bagel.addFilling(filling);

        //then
        assertTrue(bagel.getFillings().contains(filling));

    }


    @Test
    public void shouldReturnTotalBasketCost(){
        //given
        Basket basket = new Basket();
        basket.setCapacity(10);
        Bagel bagel = new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION);
        Bagel bagel1 = new Bagel("Plain", 0.39, "BGLP", BagelVariant.PLAIN);
        int quantity = 5;

        basket.add(bagel,2);
        basket.add(bagel1, 8);
        //when
        double totalCost = basket.getTotalCost();

        //then
        assertEquals(4.1,totalCost);
    }

    @Test
    public void  shouldReturn5afterAddingTooManyBagels(){
        //given
        Basket basket = new Basket();
        Bagel bagel =new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION);
        Bagel bagel1 = new Bagel("Plain", 0.39, "BGLP", BagelVariant.PLAIN);
        int quantity = 5;
        //when
        basket.add(bagel,quantity);
        basket.add(bagel1, quantity*2);
        double totalCost = basket.getTotalCost();
        //then
        assertEquals(2.45,totalCost);
    }


    @Test
    public  void shouldReturnTrueIfSanityIsOk(){
        //given
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION);
        Bagel bagel1 = new Bagel("Plain", 0.39, "BGLP", BagelVariant.PLAIN);
        int quantity = 3;

        basket.add(bagel,quantity);
        //when
       boolean sanity = basket.removeProduct(bagel,1);
        //then
        assertTrue(sanity);

    }


    @Test
    public  void shouldReturnFalseIfSanityIsNotOK(){
        //given
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION);
        Bagel bagel1 = new Bagel("Plain", 0.39, "BGLP", BagelVariant.PLAIN);
        int quantity = 3;

        basket.add(bagel,quantity);
        //when
        boolean sanity = basket.removeProduct(bagel1,1);
        //then
        assertFalse(sanity);

    }


    @Test
    public void shouldNotAddProductsIfCapacityIsLessThanQuantity() {
        //given
        Basket basket = new Basket();
        Bagel bagel = new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION);
        Bagel bagel1 = new Bagel("Plain", 0.39, "BGLP", BagelVariant.PLAIN);
        int quantity = 3;
        //when
        boolean isAdded = basket.add(bagel1, 10);

        //then
        assertFalse(isAdded);
    }



    @Test
    public void shouldReturnFalseAfterAddingProductThatDoesNotExist() {
        //given
        Basket basket = new Basket();
        Bagel bagel = new Bagel();
        int quantity = 1;
        //when
        basket.add(bagel, quantity);
        //then
        assertFalse(basket.getBasket().containsKey(bagel));

    }

    @Test
    public void shouldReturnBagelPriceList(){
        //given
        Inventory inventory = new Inventory();
        //when
        String bagelPriceList= inventory.returnAllBagels();
        //then

        assertEquals("All Bagel Cost:\n" +
                "Bagel: Onion Price: 0.49\n" +
                "Bagel: Plain Price: 0.39\n" +
                "Bagel: Everything Price: 0.49\n" +
                "Bagel: Sesame Price: 0.49\n", bagelPriceList);
    }










}
