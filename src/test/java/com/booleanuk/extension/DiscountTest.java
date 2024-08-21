package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.products.bagels.EverythingBagel;
import com.booleanuk.core.products.bagels.OnionBagel;
import com.booleanuk.core.products.bagels.PlainBagel;
import com.booleanuk.core.products.bagels.SesameBagel;
import com.booleanuk.core.products.coffees.BlackCoffee;
import com.booleanuk.core.products.coffees.WhiteCoffee;
import com.booleanuk.core.products.fillings.BaconFilling;
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

    @Test
    public void test12PlainBagelDiscount() {
        Basket basket = new Basket();
        basket.changeCapacity(1000, true);

        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());

        Assertions.assertEquals(3.99, basket.getTotalCost(), 0.001);

        basket.addProduct(new WhiteCoffee()); // 1.19 cost
        basket.addProduct(new BaconFilling()); // 0.12 cost

        Assertions.assertEquals(5.3, basket.getTotalCost(), 0.001);
    }

    @Test
    public void testCoffeeAndBagelDiscount() {
        Basket basket = new Basket();

        basket.addProduct(new WhiteCoffee());
        basket.addProduct(new SesameBagel());

        Assertions.assertEquals(1.25, basket.getTotalCost(), 0.001);

        basket.addProduct(new BlackCoffee()); // 0.99 cost
        Assertions.assertEquals(2.24, basket.getTotalCost(), 0.001);

        basket.addProduct(new OnionBagel()); // Discount added when this gets added
        Assertions.assertEquals(2.5, basket.getTotalCost(), 0.001);
    }

}
