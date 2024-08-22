package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Reciept;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecieptTest {

    @Test
    public void TestShouldPrintReciept(){
        Basket basket = new Basket();

        basket.add("BGLO");

        Assertions.assertEquals(1, basket.retrieveProductCount());

        Reciept reciept = new Reciept(basket);
        reciept.printReciept();
    }

}
