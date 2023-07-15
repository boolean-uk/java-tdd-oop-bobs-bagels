package com.booleanuk.core;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BasketTest {
    private Basket basket;

    public BasketTest() {
        basket = new Basket(16);
    }

    @Test
    public void addToBasketTest() {
        Assertions.assertEquals(0,basket.getItems().size());
        List<String> fillings = new ArrayList<>();
        fillings.add("FILB");
        fillings.add("FILE");
        fillings.add("FILXXXXXX");

        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");


        basket.addItem("BGLO",fillings);
        basket.addItem("fake",fillings);
        basket.addItem("wrong item",fillings);
        Assertions.assertEquals(3,basket.getItems().size());

        basket.addItem("FILB",fillings);
        Assertions.assertEquals(3,basket.getItems().size());
        basket.addItem("COFL", fillings);
        Assertions.assertEquals(4,basket.getItems().size());
        basket.addItem("BGLS",fillings2);
        Assertions.assertEquals(8,basket.getItems().size());
    }

    @Test
    public void checkIfWeCanAddToBasketOverTheSizeOfCapacityTest() {
        List<String> filling = new ArrayList<>();
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");


        basket.addItem("BGLO",filling);
        basket.addItem("BGLO",filling);
        basket.addItem("FILB",filling);
        basket.addItem("FILB",filling);
        Assertions.assertEquals(2,basket.getItems().size());
        basket.addItem("BGLO",fillings2);
        Assertions.assertEquals(10,basket.getItems().size());
        basket.addItem("BGLP",fillings2);
        Assertions.assertEquals(10,basket.getItems().size());
    }

    @Test
    public void removeCoffeeFromBasketTest() {

        List<String> filling = new ArrayList<>();
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");


        basket.addItem("BGLO",filling);
        basket.addItem("BGLO",filling);
        basket.addItem("FILB",filling);
        basket.addItem("FILB",filling);
        Assertions.assertEquals(2,basket.getItems().size());
        basket.removeCoffee("COFL");
        Assertions.assertEquals(2,basket.getItems().size());

        basket.addItem("COFL",fillings2);
        Assertions.assertEquals(3,basket.getItems().size());

        basket.removeCoffee("COFL");
        Assertions.assertEquals(2,basket.getItems().size());
    }

    @Test
    public void removeFillingTest() {
        List<String> filling = new ArrayList<>();
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");

        basket.addItem("BGLO",fillings2);
        basket.addItem("BGLP",fillings2);

        Assertions.assertEquals(16,basket.getItems().size());
        basket.removeFilling("BGLO","wrong name");
        Assertions.assertEquals(16,basket.getItems().size());
        basket.removeFilling("BGLO","FILH");
        Assertions.assertEquals(15,basket.getItems().size());
        basket.removeFilling("BGLS","FILH");
        Assertions.assertEquals(15,basket.getItems().size());
    }

    @Test
    public void removeWholeBagleTest() {
        List<String> filling = new ArrayList<>();
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");

        basket.addItem("BGLO",fillings2);
        basket.addItem("BGLP",fillings2);
        Assertions.assertEquals(16,basket.getItems().size());
        basket.removeBagle("BGLO");
        Assertions.assertEquals(8,basket.getItems().size());
    }

    @Test
    public void isBasketFullTest() {
        List<String> filling = new ArrayList<>();
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");
        Assertions.assertTrue(basket.addItem("BGLO",fillings2));
        Assertions.assertFalse(basket.addItem("FILB",fillings2));
        Assertions.assertTrue(basket.addItem("BGLO",fillings2));

        Assertions.assertFalse(basket.addItem("FILB",filling));
    }


    @Test
    public void changingCapacityTest() {
        List<String> filling = new ArrayList<>();
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");
        basket.addItem("BGLO",fillings2);
        basket.addItem("FILB",fillings2);
        basket.addItem("BGLO",filling);
        basket.addItem("FILB",filling);
        Assertions.assertEquals(9,basket.getItems().size());

        basket.changeCapacity(10);
        basket.addItem("COFC",filling);
        basket.addItem("COFC",filling);
        basket.addItem("COFC",filling);
        basket.addItem("COFC",filling);
        Assertions.assertEquals(10,basket.getItems().size());
        basket.changeCapacity(6);

        basket.addItem("BGLO",fillings2);

        Assertions.assertEquals(10,basket.getItems().size());
    }

    @Test
    public void getTotalPriceOfItemsInBasketTest() {
        Assertions.assertEquals(0.00, basket.calculateTotalPrice());

        List<String> filling = new ArrayList<>();
        filling.add("FILB");
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");

        basket.addItem("BGLO",filling);

        Assertions.assertEquals(0.61, basket.calculateTotalPrice());

        basket.addItem("COFL",fillings2);
        Assertions.assertEquals(1.90, basket.calculateTotalPrice());
        basket.addItem("COFW",fillings2);
        Assertions.assertEquals(3.09, basket.calculateTotalPrice());

        basket.addItem("BGLO",fillings2);
        Assertions.assertEquals(4.42, basket.calculateTotalPrice());

    }

    @Test
    public void changingCapacityOfBasketWithNegativeNumber() {
        List<String> filling = new ArrayList<>();
        filling.add("FILB");


        basket.addItem("BGLO",filling);

        basket.addItem("BGLO",filling);

        Assertions.assertEquals(4,basket.getItems().size());

        basket.changeCapacity(-10);
        basket.addItem("BGLO",filling);

        Assertions.assertEquals(6,basket.getItems().size());
    }


    @Test
    public void changingCapacityOfBasketWithItemsAlreadyInBasketExceedingNewCapacityGivenByUser() {
        List<String> filling = new ArrayList<>();
        filling.add("FILB");
        List<String> fillings2 = new ArrayList<>();
        fillings2.add("FILE");
        fillings2.add("FILC");
        fillings2.add("FILX");
        fillings2.add("FILS");
        fillings2.add("FILH");
        fillings2.add("FILB");
        fillings2.add("FILE");
        basket.addItem("BGLO",fillings2);

        Assertions.assertEquals(8,basket.getItems().size());
        basket.changeCapacity(2);
        Assertions.assertEquals(8,basket.getItems().size());
        basket.addItem("BGLO",filling);
        basket.addItem("BGLO",filling);
        Assertions.assertEquals(8,basket.getItems().size());

    }

        @Test
        public void testCalculateTotalPriceForSingleItems() {
            Basket basket = new Basket(20);

            basket.addItem("BGLO",null);
            basket.addItem("BGLP", null);
            double totalPrice = basket.calculateTotalPrice();
            double expectedPrice = 0.88;
            Assertions.assertEquals(expectedPrice, totalPrice);
        }

        @Test
        public void testCalculateTotalPriceWithSpecialOffer() {
            Basket basket = new Basket(20);

            for(int i=0;i<12;i++){
                basket.addItem("BGLP", null);
            }

            double totalPrice = basket.calculateTotalPrice();
            double expectedPrice = 3.99;
            Assertions.assertEquals(expectedPrice, totalPrice);
        }

        @Test
        public void testCalculateTotalPriceWithSpecialOfferAndRegularItems() {
            Basket basket = new Basket(24);


            basket.addItem("BGLO", null);
            basket.addItem("BGLO", null);
            for(int i=0;i<12;i++){
                basket.addItem("BGLP", null);
            }
            for(int i=0;i<6;i++){
                basket.addItem("BGLE", null);
            }
            basket.addItem("COFB",null);
            basket.addItem("COFB",null);
            basket.addItem("COFB",null);

            double totalPrice = basket.calculateTotalPrice();
            double expectedPrice = 10.43;
            Assertions.assertEquals(expectedPrice, totalPrice);
        }
        @Test
        public void testCalculateTotalPriceWithOfferItems() {
            Basket basket = new Basket(20);

            for(int i =0;i<16;i++){
                basket.addItem("BGLP", null);
            }
            double totalPrice = basket.calculateTotalPrice();
            double expectedPrice = 5.55;
            Assertions.assertEquals(expectedPrice, totalPrice);
        }


    @Test
    public void testCalculateTotalPriceWithOfferItemsCoffeandbagel() {
        Basket basket = new Basket(20);

        basket.addItem("COFB", null);
        basket.addItem("BGLP", null);


        double totalPrice = basket.calculateTotalPrice();
        double expectedPrice = 1.25;
        Assertions.assertEquals(expectedPrice, totalPrice);
    }

    @Test
    public void testCalculateTotalPriceWithSpecialMultipleOffersAndRegularItems() {
        Basket basket = new Basket(24);

        for(int i=0;i<12;i++){
            basket.addItem("BGLP", null);
        }
        //Koszt kosztyka 3.99 bo tylko 12 bajgli
        Assertions.assertEquals(3.99, basket.calculateTotalPrice());

        //3.99 + 0.99 = 4.98
        basket.addItem("COFB",null);
        Assertions.assertEquals(4.98, basket.calculateTotalPrice());

        for(int i=0;i<12;i++){
            basket.addItem("BGLP", null);
        }
        //4.98 + 1.25 + 11*0.39 = 9 .53
        Assertions.assertEquals(9.53, basket.calculateTotalPrice());

    }

    @Test
    public void calculateTotalCostOfOfferWithFillingsTest() {
        Basket basket = new Basket(24);
        List<String> filling = new ArrayList<>();
        filling.add("FILB");
        for(int i=0;i<12;i++){
            basket.addItem("BGLS", filling);
        }
        basket.calculateTotalPrice();
        Assertions.assertEquals(7.32, basket.calculateTotalPrice());
    }

        private void initializeInventory(Inventory inventory) {
            // Inicjalizacja inventarza
        }
    }






