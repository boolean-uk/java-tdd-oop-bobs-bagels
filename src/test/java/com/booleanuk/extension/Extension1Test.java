package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.CashRegister;
import com.booleanuk.core.NormalReceipt;
import com.booleanuk.core.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Extension1Test {

    // Extension 1 requirements tests
    @Test
    public void bagelDiscount(){
        Basket basket = new Basket();
        Receipt receipt = new NormalReceipt();
        CashRegister register = new CashRegister(basket, receipt);
        basket.setMaxBasketSize(25);
        basket.addItem("BGLO", 18);
        basket.addItem("BGLP", 1);
        basket.addItem("COFB",1);

        Assertions.assertEquals("The sum of your order is: 7.73", register.sumOrder());

    }

    @Test
    public void bagelAndCoffeeDiscount(){
        Basket basket = new Basket();
        Receipt receipt = new NormalReceipt();
        CashRegister register = new CashRegister(basket, receipt);

        basket.addItem("BGLO", 2);
        basket.addItem("COFW", 1);

        Assertions.assertEquals("The sum of your order is: 1.74", register.sumOrder());
    }

    @Test
    public void allDiscounts(){
        Basket basket = new Basket();
        Receipt receipt = new NormalReceipt();
        CashRegister register = new CashRegister(basket, receipt);
        basket.setMaxBasketSize(25);

        basket.addItem("BGLS", 6);
        basket.addItem("BGLO", 13);
        basket.addItem("FILC", 1);
        basket.addItem("COFL", 1);

        Assertions.assertEquals("The sum of your order is: 7.85", register.sumOrder());
    }
}
