package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTestExtenstion1 {
    @Test
    public void testDiscount() {
        Basket basket = new Basket ();
        basket.changeCapacity(25);
        basket.addItem("BGLO");
        basket.addItem("BGLO");

        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");

        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");
        basket.addItem("BGLE");

        basket.addItem("COFB");
        basket.addItem("COFB");
        basket.addItem("COFB");

        Assertions.assertEquals(9.97,basket.discount());
    }

    @Test
    public void testDiscount2() {
        Basket basket = new Basket();
        basket.changeCapacity(25);
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");

        Assertions.assertEquals(5.55,basket.discount());
    }
    @Test
    public void testDiscount3() {
        Basket basket = new Basket();
        basket.changeCapacity(25);
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("COFB"); //0.99 => 1.25
        basket.addItem("COFC"); //1.29 => 1.25

        Assertions.assertEquals(3.99+1.25+1.25+0.39+0.39,basket.discount());
    }

    @Test
    public void testDiscount4() {
        Basket basket = new Basket();
        basket.changeCapacity(25);
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("FILE"); // .12


        Assertions.assertEquals(0.9,basket.discount());
    }

    @Test
    public void testDiscount5() {
        Basket basket = new Basket();
        basket.changeCapacity(25);
        basket.addItem("BGLP"); // 16 bgl
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP"); // 12 pcs => 3.99
        basket.addItem("BGLP");
        basket.addItem("BGLP");
        basket.addItem("BGLP"); // 0.39 => 0.00 (COF + BGL)
        basket.addItem("BGLP"); // 0.39 => 0.00 (COF + BGL)
        basket.addItem("COFB"); // 0.99 => 1.25 (COF + BGL)
        basket.addItem("COFC"); // 1.29 => 1.25 (COF + BGL)
        basket.addItem("FILE");
        basket.addItem("FILE");
        basket.addItem("FILE");

        Assertions.assertEquals(3.99+1.25+1.25+0.39+0.39+0.12+0.12+0.12,basket.discount());
    }

    @Test
    public void testDiscountMix() {
        Basket basket = new Basket();
        basket.changeCapacity(12);
        basket.addItem("BGLO"); // 0.49 => 0.00
        basket.addItem("COFB"); // 0.99 => 1.25
        basket.addItem("COFC");
        basket.addFilling("BGLO","FILC");
        basket.addFilling("BGLO","FILX");


        Assertions.assertEquals(2.48,basket.discount());
    }

    @Test
    public void testDiscountMixDifferentOrder() {
        Basket basket = new Basket();
        basket.changeCapacity(12);
        basket.addItem("BGLO"); // 0.49 => 0.00
        basket.addItem("COFC");
        basket.addItem("COFB"); // 0.99 => 1.25
        basket.addFilling("BGLO","FILC");
        basket.addFilling("BGLO","FILX");

        Assertions.assertEquals(2.48,basket.discount());
    }
}
