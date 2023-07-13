package com.booleanuk.extension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BobBagelsExtensionTest {


    BasketExt basketExt;
    InventoryExt inventoryExt;
    BasketManager basketManager;
    BagelExt bagelO;
    BagelExt bagelP;
    BagelExt bagelE;
    BagelExt bagelS;
    CoffeeExt coffeeB;
    CoffeeExt coffeeW;
    CoffeeExt coffeeC;
    CoffeeExt coffeeL;
    FillingExt fillingB;
    FillingExt fillingE;
    FillingExt fillingC;
    FillingExt fillingX;
    FillingExt fillingS;
    FillingExt fillingH;

    @BeforeEach
    public void prepareToTests() {
        basketExt = new BasketExt();
        basketManager = new BasketManager(basketExt);
        inventoryExt = new InventoryExt();
        bagelO = new BagelExt(SKU.BGLO, "Bagel", 0.49);
        bagelP = new BagelExt(SKU.BGLP, "Bagel", 0.39);
        bagelE = new BagelExt(SKU.BGLE, "Bagel", 0.49);
        bagelS = new BagelExt(SKU.BGLS, "Bagel", 0.49);
        coffeeB = new CoffeeExt(SKU.COFB, "Coffee", 0.99);
        coffeeW = new CoffeeExt(SKU.COFW, "Coffee", 1.19);
        coffeeC = new CoffeeExt(SKU.COFC, "Coffee", 1.29);
        coffeeL = new CoffeeExt(SKU.COFL, "Coffee", 1.29);
        fillingB = new FillingExt(SKU.FILB, "Filling", 0.12);
        fillingE = new FillingExt(SKU.FILE, "Filling", 0.12);
        fillingC = new FillingExt(SKU.FILC, "Filling", 0.12);
        fillingX = new FillingExt(SKU.FILX, "Filling", 0.12);
        fillingS = new FillingExt(SKU.FILS, "Filling", 0.12);
        fillingH = new FillingExt(SKU.FILX, "Filling", 0.12);
    }


    @Test
    public void shouldAddBagelToBasket() {
        //when
        basketManager.add(bagelO);
        //then
        assertTrue(basketExt.getBagelsInBasket().contains(bagelO));

    }

    @Test
    public void shouldAddCoffeeToBasket(){
        //when
        basketManager.add(coffeeB);
        //then
        assertTrue(basketExt.getCoffeesInBasket().contains(coffeeB));
    }

    @Test
    public void shouldAddFillingToBasket(){
        //when
        basketManager.add(fillingB);
        //then
        assertTrue(basketExt.getFillingInBasket().contains(fillingB));
    }

    @Test
    public void shouldRemoveBagelFromBasket(){
        //given
        basketManager.add(bagelO);
        //when
        basketManager.remove(bagelO);
        //then
        assertFalse(basketExt.getBagelsInBasket().contains(bagelO));
    }

    @Test
    public void shouldRemoveCoffeeFromBasket(){
        //given
        basketManager.add(coffeeB);
        //when
        basketManager.remove(coffeeB);
        //then
        assertFalse(basketExt.getCoffeesInBasket().contains(coffeeB));
    }

    @Test
    public void shouldRemoveFillingFromBasket(){
        //given
        basketManager.add(fillingB);
        //when
        basketManager.remove(fillingB);
        //then
        assertFalse(basketExt.getFillingInBasket().contains(fillingB));
    }

    @Test
    public void shouldNotAdd6ProductToBasket(){
        //given
        basketManager.add(fillingB);
        basketManager.add(fillingB);
        basketManager.add(fillingS);
        basketManager.add(bagelE);
        basketManager.add(coffeeB);
        basketManager.add(coffeeC);
        //when
        basketManager.add(fillingE);

        //then
        assertFalse(basketExt.getFillingInBasket().contains(fillingE));

    }

    @Test
    public void shouldChangeCapacityTo10() {
        //when
        basketExt.setCapacity(10);
        //then
        assertEquals(10, basketExt.getCapacity());
    }

    @Test
    public void shouldReturnFalseIfSanityIsNotOk() {
        //given
        boolean isOk;
        //when
        isOk = basketManager.remove(bagelE);
        //then
        assertFalse(isOk);
    }

    @Test
    public void shouldReturnTotalCostOfBasket(){
        //given //0.36+
        basketManager.add(fillingB);
        basketManager.add(fillingB);
        basketManager.add(fillingS);
        basketManager.add(bagelE);
        basketManager.add(coffeeB);
        //when
        double totalCost = basketManager.getTotalCost();

        //then
        assertEquals(1.48,totalCost);

    }


}

