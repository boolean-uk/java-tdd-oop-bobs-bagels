package com.booleanuk.core;

import com.booleanuk.core.products.bagels.EverythingBagel;
import com.booleanuk.core.products.bagels.OnionBagel;
import com.booleanuk.core.products.bagels.SesameBagel;
import com.booleanuk.core.products.coffees.BlackCoffee;
import com.booleanuk.core.products.coffees.WhiteCoffee;
import com.booleanuk.core.products.fillings.HamFilling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountTest {

    public DiscountTest() {

    }

    @Test
    public void test6EverythingBagelDiscount() {
        Basket basket = new Basket();

        basket.changeCapacity(10, true);

        basket.addProduct(new EverythingBagel());
        basket.addProduct(new EverythingBagel());
        basket.addProduct(new EverythingBagel());
        basket.addProduct(new EverythingBagel());
        basket.addProduct(new EverythingBagel());
        basket.addProduct(new EverythingBagel());

        basket.addProduct(new BlackCoffee());

        Assertions.assertEquals(3.48, basket.getTotalCost(), 0.001);
    }

    @Test
    public void test6OnionBagelDiscount() {
        Basket basket = new Basket();

        basket.changeCapacity(10, true);

        basket.addProduct(new OnionBagel());
        basket.addProduct(new OnionBagel());
        basket.addProduct(new OnionBagel());
        basket.addProduct(new OnionBagel());
        basket.addProduct(new OnionBagel());
        basket.addProduct(new OnionBagel());

        Assertions.assertEquals(2.49, basket.getTotalCost(), 0.001);

        basket.addProduct(new BlackCoffee());

        Assertions.assertEquals(3.48, basket.getTotalCost(), 0.001);
    }

}
