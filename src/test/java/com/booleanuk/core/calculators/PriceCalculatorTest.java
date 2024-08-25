package com.booleanuk.core.calculators;

import com.booleanuk.core.basket.Bagel;
import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.basket.BasketItem;
import com.booleanuk.core.basket.Coffee;
import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.inventory.SpecialOffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PriceCalculatorTest {
    PriceCalculator priceCalculator;
    Inventory inventory;
    Basket basket;

    @Test
    public void calculateBagelOnionDicountShouldGetDiscount() {
        inventory = new Inventory();
        ArrayList<SpecialOffer> specialOffers = inventory.getSpecialOffers();

        basket = new Basket(new Inventory());
        for (int i = 0; i < 6; i++) {
            basket.add(new Bagel("BAGO"));
        }

        Map<Integer, BasketItem> basketItems = basket.getAll();

        priceCalculator = new PriceCalculator();
        double discount = priceCalculator.calculateDiscount(inventory, basketItems, specialOffers);

        // Standard price 6 * 0.49 = 2.94
        // Discount 2.94 - 2.49 = 0.45
        Assertions.assertEquals(0.45, discount);
    }

    @Test
    public void calculateBagelOnionDicountShouldNotGetDiscountForFiveBagels() {
        inventory = new Inventory();
        ArrayList<SpecialOffer> specialOffers = inventory.getSpecialOffers();

        basket = new Basket(new Inventory());
        for (int i = 0; i < 5; i++) {
            basket.add(new Bagel("BAGO"));
        }

        Map<Integer, BasketItem> basketItems = basket.getAll();

        priceCalculator = new PriceCalculator();
        double discount = priceCalculator.calculateDiscount(inventory, basketItems, specialOffers);
        Assertions.assertEquals(0.0, discount);
    }

    @Test
    public void calculateBagelOnionDicountShouldGetDiscountOnlyForSixBagels() {
        inventory = new Inventory();
        ArrayList<SpecialOffer> specialOffers = inventory.getSpecialOffers();

        basket = new Basket(new Inventory());
        for (int i = 0; i < 7; i++) {
            basket.add(new Bagel("BAGO"));
        }

        Map<Integer, BasketItem> basketItems = basket.getAll();

        priceCalculator = new PriceCalculator();
        double discount = priceCalculator.calculateDiscount(inventory, basketItems, specialOffers);

        // Standard price 6 * 0.49 = 2.94
        // Discount 2.94 - 2.49 = 0.45
        Assertions.assertEquals(0.45, discount);
    }

    @Test
    public void calculateBagelPlainDicountShouldGetDiscountForTwelveBagels() {
        inventory = new Inventory();
        ArrayList<SpecialOffer> specialOffers = inventory.getSpecialOffers();

        basket = new Basket(new Inventory());
        for (int i = 0; i < 12; i++) {
            basket.add(new Bagel("BAGP"));
        }

        Map<Integer, BasketItem> basketItems = basket.getAll();

        priceCalculator = new PriceCalculator();
        double discount = priceCalculator.calculateDiscount(inventory, basketItems, specialOffers);

        // Standard price 12 * 0.39 = 4.68
        // Discount 4.68 - 3.99 = 0.69
        Assertions.assertEquals(0.69, discount);
    }

    @Test
    public void calculateCombinationDiscountShouldReturnDiscount() {
        inventory = new Inventory();
        ArrayList<SpecialOffer> specialOffers = inventory.getSpecialOffers();

        basket = new Basket(new Inventory());
        basket.add(new Coffee("COFB"));
        basket.add(new Bagel("BAGE", Arrays.asList("FILS","FILB")));
        basket.add(new Bagel("BAGP"));

        Map<Integer, BasketItem> basketItems = basket.getAll();

        priceCalculator = new PriceCalculator();
        double discount = priceCalculator.calculateDiscount(inventory, basketItems, specialOffers);

        // Special offer for COFB: Coffee + Bagel for 1.25


        // TODO: If special offers are added to other coffee types, this test will not work
        // Coffee + Cheapest Bagel = 0.99 + 0.39 = 1.38
        // Coffee + other Bagel = 0.99 + 0.49 = 1,48

        // Should use discount on cheapest Bagel first
        Assertions.assertEquals(1.38, discount);
    }





    // TODO:
    // Check why BGLO doesn't exist - WRITE IN README THAT I HAVE DIFFERENT SKU's
    // Work with calculateDiscount()
}
