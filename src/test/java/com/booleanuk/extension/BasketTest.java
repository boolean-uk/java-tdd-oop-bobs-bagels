package com.booleanuk.extension;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTest {
    Basket basket;
    Bagel onionBagel;
    Bagel onionBagel2;
    Bagel onionBagel3;
    Bagel onionBagel4;
    Bagel onionBagel5;
    Bagel onionBagel6;
    Bagel onionBagel7;
    Bagel onionBagel8;
    Bagel onionBagel9;
    Bagel onionBagel10;
    Bagel onionBagel11;
    Bagel onionBagel12;
    Bagel onionBagel13;

    Bagel everythingBagel2;
    Bagel everythingBagel3;
    Bagel everythingBagel4;
    Bagel everythingBagel5;
    Bagel everythingBagel6;
    Bagel everythingBagel7;
    Bagel everythingBagel8;
    Bagel everythingBagel9;
    Bagel everythingBagel10;
    Bagel plainBagel1;
    Bagel plainBagel2;
    Bagel plainBagel3;
    Bagel plainBagel4;
    Bagel plainBagel5;
    Bagel plainBagel6;
    Bagel plainBagel7;
    Bagel plainBagel8;
    Bagel plainBagel9;
    Bagel plainBagel10;
    Bagel plainBagel11;
    Bagel plainBagel12;
    Bagel plainBagel13;
    Bagel everythingBagel;
    Bagel sesameBagel;
    Coffee blackCoffee;
    Coffee blackCoffee1;
    Coffee blackCoffee2;
    Coffee blackCoffee3;
    Coffee blackCoffee4;
    Coffee blackCoffee5;
    Coffee whiteCoffee;
    Coffee cappuccinoCoffee;
    Coffee latteCoffee;
    Filling baconFilling;
    Filling eggFilling;
    Filling cheeseFilling;
    Filling creamCheeseFilling;
    Filling smokeSalmonFilling;
    Filling hamFilling;


    @BeforeEach
    public void setUp() {
        basket = new Basket(8);

        onionBagel = new Bagel("BGLO", "Bagel", "Onion", 0.49);
        onionBagel2 = new Bagel("BGLO","Bagel", "Onion", 0.49);
        onionBagel3 = new Bagel("BGLO", "Bagel", "Onion", 0.49);
        onionBagel4 = new Bagel("BGLO","Bagel", "Onion", 0.49);
        onionBagel5 = new Bagel("BGLO","Bagel", "Onion", 0.49);
        onionBagel6 = new Bagel("BGLO","Bagel", "Onion", 0.49);
        onionBagel7 = new Bagel( "BGLO","Bagel", "Onion", 0.49);
        onionBagel8 = new Bagel("BGLO","Bagel", "Onion", 0.49);
        onionBagel9 = new Bagel("BGLO","Bagel", "Onion", 0.49);
        onionBagel10 = new Bagel("BGLO","Bagel", "Onion", 0.49);
        onionBagel11 = new Bagel("BGLO","Bagel", "Onion", 0.49);
        onionBagel12 = new Bagel("BGLO","Bagel", "Onion", 0.49);
        onionBagel13 = new Bagel("BGLO","Bagel", "Onion", 0.49);

        plainBagel1 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel2 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel3 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel4 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel5 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel6 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel7 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel8 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel9 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel10 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel11 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel12 = new Bagel("BGLP","Bagel", "Plain", 0.39);
        plainBagel13 = new Bagel("BGLP","Bagel", "Plain", 0.39);

        everythingBagel = new Bagel("BGLE","Bagel", "Everything", 0.49);
        everythingBagel2 = new Bagel("BGLE","Bagel", "Everything", 0.49);
        everythingBagel3 = new Bagel("BGLE","Bagel", "Everything", 0.49);
        everythingBagel4 = new Bagel("BGLE","Bagel", "Everything", 0.49);
        everythingBagel5 = new Bagel("BGLE","Bagel", "Everything", 0.49);
        everythingBagel6 = new Bagel("BGLE","Bagel", "Everything", 0.49);
        everythingBagel7 = new Bagel("BGLE","Bagel", "Everything", 0.49);
        everythingBagel8 = new Bagel("BGLE","Bagel", "Everything", 0.49);
        everythingBagel9 = new Bagel("BGLE","Bagel", "Everything", 0.49);
        everythingBagel10 = new Bagel("BGLE","Bagel", "Everything", 0.49);


        sesameBagel = new Bagel("BGLS","Bagel", "Sesame", 0.49);

        blackCoffee = new Coffee("COFB", "Coffee", "Black", 0.99);
        blackCoffee1 = new Coffee("COFB", "Coffee", "Black", 0.99);
        blackCoffee2 = new Coffee("COFB", "Coffee", "Black", 0.99);
        blackCoffee3 = new Coffee("COFB", "Coffee", "Black", 0.99);
        blackCoffee4 = new Coffee("COFB", "Coffee", "Black", 0.99);
        blackCoffee5 = new Coffee("COFB", "Coffee", "Black", 0.99);

        whiteCoffee = new Coffee("COFW", "Coffee", "White", 1.19);
        cappuccinoCoffee = new Coffee("COFC","Coffee", "Cappuccino", 1.29);
        latteCoffee = new Coffee("COFL","Coffee", "Latte", 1.29);

        baconFilling = new Filling("FILB", "Filling", "Bacon", 0.12);
        eggFilling = new Filling("FILE", "Filling", "Egg", 0.12);
        cheeseFilling = new Filling("FILC", "Filling", "Cheese", 0.12);
        creamCheeseFilling = new Filling("FILX", "Filling", "Cream Cheese", 0.12);
        smokeSalmonFilling = new Filling("FILS", "Filling", "Smoked Salmon", 0.12);
        hamFilling = new Filling("FILH", "Filling", "Ham", 0.12);

    }

    @Test
    public void totalCostSpecialOfferShouldReturnEqual() {
        basket.add(onionBagel);
        basket.add(onionBagel2);
        basket.add(onionBagel3);
        basket.add(onionBagel4);
        basket.add(onionBagel5);
        basket.add(onionBagel6);
        basket.add(onionBagel7);
        basket.add(hamFilling);
        Assertions.assertEquals(3.1, basket.totalCost());
    }

    @Test
    public void totalCostSpecialOfferReturnEqualFor13OnionBagels() {
        basket.changeCapacity(14);
        basket.add(onionBagel);
        basket.add(onionBagel2);
        basket.add(onionBagel3);
        basket.add(onionBagel4);
        basket.add(onionBagel5);
        basket.add(onionBagel6);
        basket.add(onionBagel7);
        basket.add(onionBagel8);
        basket.add(onionBagel9);
        basket.add(onionBagel10);
        basket.add(onionBagel11);
        basket.add(onionBagel12);
        basket.add(onionBagel13);
        basket.add(hamFilling);
        Assertions.assertEquals(5.59, basket.totalCost());
    }

    @Test
    public void totalCostSpecialOfferReturnEqualFor8EverythingBagels() {
        basket.changeCapacity(10);
        basket.add(everythingBagel);
        basket.add(everythingBagel2);
        basket.add(everythingBagel3);
        basket.add(everythingBagel4);
        basket.add(everythingBagel5);
        basket.add(everythingBagel6);
        basket.add(everythingBagel7);
        basket.add(everythingBagel8);
        basket.add(hamFilling);
        Assertions.assertEquals(3.59, basket.totalCost());
    }

    @Test
    public void totalCostSpecialOfferReturnEqualFor13PlainBagels() {
        basket.changeCapacity(14);
        basket.add(plainBagel1);
        basket.add(plainBagel2);
        basket.add(plainBagel3);
        basket.add(plainBagel4);
        basket.add(plainBagel5);
        basket.add(plainBagel6);
        basket.add(plainBagel7);
        basket.add(plainBagel8);
        basket.add(plainBagel9);
        basket.add(plainBagel10);
        basket.add(plainBagel11);
        basket.add(plainBagel12);
        basket.add(plainBagel13);
        basket.add(hamFilling);
        Assertions.assertEquals(4.5, basket.totalCost());
    }

    @Test
    public void totalCostSpecialOfferReturnEqualFor4CoffeeBagels() {
        basket.changeCapacity(14);
        basket.add(plainBagel1);
        basket.add(plainBagel2);
        basket.add(plainBagel3);
        basket.add(plainBagel4);
        basket.add(plainBagel5);
        basket.add(plainBagel6);
        basket.add(plainBagel7);
        basket.add(blackCoffee1);
        basket.add(blackCoffee2);
        basket.add(blackCoffee3);
        basket.add(blackCoffee4);
        basket.add(blackCoffee5);
        basket.add(hamFilling);
        Assertions.assertEquals(7.15, basket.totalCost());
    }
}
