package com.booleanuk.core.calculators;

import com.booleanuk.core.basket.Bagel;
import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.basket.BasketItem;
import com.booleanuk.core.basket.Coffee;
import com.booleanuk.core.inventory.Inventory;
import com.booleanuk.core.inventory.SpecialOffer;
import com.booleanuk.core.inventory.SpecialOfferCombination;
import com.booleanuk.core.inventory.SpecialOfferMultiPrice;
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
        ArrayList<SpecialOfferMultiPrice> specialOffers = inventory.getSpecialOffersMultiPrice();

        basket = new Basket(new Inventory());
        for (int i = 0; i < 6; i++) {
            basket.add(new Bagel("BAGO"));
        }
        for (int i = 0; i < 12; i++) {
            basket.add(new Bagel("BAGP"));
        }
        Map<Integer, BasketItem> basketItems = basket.getAll();

        // TODO : Looks confusing with dependecies and names
        priceCalculator = new PriceCalculator();
        ArrayList<DiscountObjectMultiPrice> discountList = priceCalculator.calculateSpecialOfferMultiPrice(
                inventory, basketItems, specialOffers);

        // Print values
        for (DiscountObjectMultiPrice d : discountList) {
            System.out.println("SKU: "+d.getSKU() +
                    ", x"+d.getNumOfDiscountItems()+" items gives" +
                    " x"+d.getNumberOfDiscounts()+" discounts" +
                    ", ordinary items x"+d.getNumOfOrdinaryItems() +
                    ", discount: "+d.getDiscount());
        }

        // Standard price 6 * 0.49 = 2.94
        // Discount 2.94 - 2.49 = 0.45
        Assertions.assertEquals(1, discountList.get(1).getNumberOfDiscounts());
        Assertions.assertEquals(6, discountList.get(1).getNumOfDiscountItems());
        Assertions.assertEquals(0, discountList.get(1).getNumOfOrdinaryItems());
        Assertions.assertEquals(0.45, discountList.get(1).getDiscount());

        // Standard price 12 * 0.39 = 4.68
        // Discount 4.68 - 3.99 = 0.69
        Assertions.assertEquals(1, discountList.get(0).getNumberOfDiscounts());
        Assertions.assertEquals(12, discountList.get(0).getNumOfDiscountItems());
        Assertions.assertEquals(0, discountList.get(0).getNumOfOrdinaryItems());
        Assertions.assertEquals(0.69, discountList.get(0).getDiscount());
    }

    @Test
    public void calculateBagelOnionDicountShouldNotGetDiscountForFiveBagels() {
        inventory = new Inventory();
        ArrayList<SpecialOfferMultiPrice> specialOffers = inventory.getSpecialOffersMultiPrice();

        basket = new Basket(new Inventory());
        for (int i = 0; i < 5; i++) {
            basket.add(new Bagel("BAGO"));
        }
        Map<Integer, BasketItem> basketItems = basket.getAll();

        // Setup calculation and print result
        priceCalculator = new PriceCalculator();
        ArrayList<DiscountObjectMultiPrice> discountList = priceCalculator.calculateSpecialOfferMultiPrice(
                inventory, basketItems, specialOffers);

        for (DiscountObjectMultiPrice d : discountList) {
            System.out.println("SKU: "+d.getSKU() +
                    ", x"+d.getNumOfDiscountItems()+" items gives" +
                    " x"+d.getNumberOfDiscounts()+" discounts" +
                    ", ordinary items x"+d.getNumOfOrdinaryItems() +
                    ", discount: "+d.getDiscount());
        }

        Assertions.assertEquals(0, discountList.get(0).getNumberOfDiscounts());
        Assertions.assertEquals(0, discountList.get(0).getNumOfDiscountItems());
        Assertions.assertEquals(5, discountList.get(0).getNumOfOrdinaryItems());
        Assertions.assertEquals(0.0, discountList.get(0).getDiscount());
    }

    @Test
    public void calculateBagelOnionDicountShouldGetDiscountOnlyForSixBagels() {
        inventory = new Inventory();
        ArrayList<SpecialOfferMultiPrice> specialOffers = inventory.getSpecialOffersMultiPrice();

        basket = new Basket(new Inventory());
        for (int i = 0; i < 7; i++) {
            basket.add(new Bagel("BAGO"));
        }
        Map<Integer, BasketItem> basketItems = basket.getAll();

        // Setup calculation and print result
        priceCalculator = new PriceCalculator();
        ArrayList<DiscountObjectMultiPrice> discountList = priceCalculator.calculateSpecialOfferMultiPrice(
                inventory, basketItems, specialOffers);

        for (DiscountObjectMultiPrice d : discountList) {
            System.out.println("SKU: "+d.getSKU() +
                    ", x"+d.getNumOfDiscountItems()+" items gives" +
                    " x"+d.getNumberOfDiscounts()+" discounts" +
                    ", ordinary items x"+d.getNumOfOrdinaryItems() +
                    ", discount: "+d.getDiscount());
        }

        // Standard price 6 * 0.49 = 2.94
        // Discount 2.94 - 2.49 = 0.45
        Assertions.assertEquals(1, discountList.get(0).getNumberOfDiscounts());
        Assertions.assertEquals(6, discountList.get(0).getNumOfDiscountItems());
        Assertions.assertEquals(1, discountList.get(0).getNumOfOrdinaryItems());
        Assertions.assertEquals(0.45, discountList.get(0).getDiscount());
    }


    // TODO: Test fillings

    @Test
    public void calculateCombinationDiscountShouldReturnDiscount() {
        inventory = new Inventory();
        ArrayList<SpecialOfferCombination> specialOffers = inventory.getSpecialOffersCombination();

        basket = new Basket(new Inventory());
        basket.add(new Coffee("COFB"));
        basket.add(new Bagel("BAGE", Arrays.asList("FILS","FILB")));
        basket.add(new Bagel("BAGP"));
        basket.add(new Bagel("BAGE"));
        basket.add(new Bagel("BAGO"));
        Map<Integer, BasketItem> basketItems = basket.getAll();

        // Setup calculation and print result
        priceCalculator = new PriceCalculator();
        ArrayList<DiscountObjectCombination> discountList = priceCalculator.calculateSpecialOfferCombination(
                inventory, basketItems, specialOffers);

        for (DiscountObjectCombination d : discountList) {
            System.out.println("Offer items: "+d.getOfferItems() +
                    " x"+d.getNumOfDiscounts()+" discounts" +
                    ", discount: "+d.getDiscountSum());
        }

        // Special offer for COFB: Coffee + Bagel for 1.25
        // BAGE 0.49
        // BAGP 0.39
        // COFB 0.99
        // (cheapest combo) Ordinary price 0.99 + 0.39 = 1.38
        // Ordinary - specialPrice 1.38 - 1.25 = 0.13
        Assertions.assertEquals(1, discountList.get(0).getNumOfDiscounts());
        Assertions.assertEquals(0.13, discountList.get(0).getDiscountSum());
    }

    @Test
    public void calculateCombinationDiscountShouldReturnDiscounts() {
        inventory = new Inventory();
        ArrayList<SpecialOfferCombination> specialOffers = inventory.getSpecialOffersCombination();

        basket = new Basket(new Inventory());
        basket.add(new Coffee("COFB"));
        basket.add(new Bagel("BAGE", Arrays.asList("FILS","FILB")));
        basket.add(new Bagel("BAGP"));
        basket.add(new Bagel("BAGE"));
        basket.add(new Bagel("BAGO"));
        basket.add(new Coffee("COFW"));
        Map<Integer, BasketItem> basketItems = basket.getAll();

        // Setup calculation and print result
        priceCalculator = new PriceCalculator();
        ArrayList<DiscountObjectCombination> discountList = priceCalculator.calculateSpecialOfferCombination(
                inventory, basketItems, specialOffers);

        for (DiscountObjectCombination d : discountList) {
            System.out.println("Offer items: "+d.getOfferItems() +
                    " x"+d.getNumOfDiscounts()+" discounts" +
                    ", discount: "+d.getDiscountSum());
        }

        // Special offer for COFB: Coffee + Bagel for 1.25
        // BAGE 0.49
        // BAGP 0.39
        // COFB 0.99
        // COFW 1.19

        // (combo 1) Ordinary price 0.99 + 0.39 = 1.38
        // Ordinary - specialPrice 1.38 - 1.25 = 0.13

        // (combo 2) Ordinary price 1.19 + 0.49 = 1.68
        // Ordinary - specialPrice 1.68 - 1.25 = 0.43

        // 0.13 + 0.43 = 0.56

        Assertions.assertEquals(2, discountList.get(0).getNumOfDiscounts());
        Assertions.assertEquals(0.56, discountList.get(0).getDiscountSum());
    }





    // TODO:
    // Check why BGLO doesn't exist - WRITE IN README THAT I HAVE DIFFERENT SKU's
    // Work with calculateDiscount()
}
