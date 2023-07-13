package com.booleanuk.extension;


import com.booleanuk.extension.Basket;
import com.booleanuk.extension.Inventory;
import com.booleanuk.extension.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTest {
    Basket basket;
    Item onionBagel;
    Item onionBagel2;
    Item onionBagel3;
    Item onionBagel4;
    Item onionBagel5;
    Item onionBagel6;
    Item onionBagel7;
    Item onionBagel8;
    Item onionBagel9;
    Item onionBagel10;
    Item onionBagel11;
    Item onionBagel12;
    Item onionBagel13;

    Item everythingBagel2;
    Item everythingBagel3;
    Item everythingBagel4;
    Item everythingBagel5;
    Item everythingBagel6;
    Item everythingBagel7;
    Item everythingBagel8;
    Item everythingBagel9;
    Item everythingBagel10;
    Item plainBagel1;
    Item plainBagel2;
    Item plainBagel3;
    Item plainBagel4;
    Item plainBagel5;
    Item plainBagel6;
    Item plainBagel7;
    Item plainBagel8;
    Item plainBagel9;
    Item plainBagel10;
    Item plainBagel11;
    Item plainBagel12;
    Item plainBagel13;
    Item everythingBagel;
    Item sesameBagel;
    Item blackCoffee;
    Item whiteCoffee;
    Item cappuccinoCoffee;
    Item latteCoffee;
    Item baconFilling;
    Item eggFilling;
    Item cheeseFilling;
    Item creamCheeseFilling;
    Item smokeSalmonFilling;
    Item hamFilling;


    @BeforeEach
    public void setUp() {
        basket = new Basket(8);

        onionBagel = new Item("Bagel", "Onion", 0.49);
        onionBagel2 = new Item("Bagel", "Onion", 0.49);
        onionBagel3 = new Item("Bagel", "Onion", 0.49);
        onionBagel4 = new Item("Bagel", "Onion", 0.49);
        onionBagel5 = new Item("Bagel", "Onion", 0.49);
        onionBagel6 = new Item("Bagel", "Onion", 0.49);
        onionBagel7 = new Item("Bagel", "Onion", 0.49);
        onionBagel8 = new Item("Bagel", "Onion", 0.49);
        onionBagel9 = new Item("Bagel", "Onion", 0.49);
        onionBagel10 = new Item("Bagel", "Onion", 0.49);
        onionBagel11 = new Item("Bagel", "Onion", 0.49);
        onionBagel12 = new Item("Bagel", "Onion", 0.49);
        onionBagel13 = new Item("Bagel", "Onion", 0.49);

        plainBagel1 = new Item("Bagel", "Plain", 0.39);
        plainBagel2 = new Item("Bagel", "Plain", 0.39);
        plainBagel3 = new Item("Bagel", "Plain", 0.39);
        plainBagel4 = new Item("Bagel", "Plain", 0.39);
        plainBagel5 = new Item("Bagel", "Plain", 0.39);
        plainBagel6 = new Item("Bagel", "Plain", 0.39);
        plainBagel7 = new Item("Bagel", "Plain", 0.39);
        plainBagel8 = new Item("Bagel", "Plain", 0.39);
        plainBagel9 = new Item("Bagel", "Plain", 0.39);
        plainBagel10 = new Item("Bagel", "Plain", 0.39);
        plainBagel11 = new Item("Bagel", "Plain", 0.39);
        plainBagel12 = new Item("Bagel", "Plain", 0.39);
        plainBagel13 = new Item("Bagel", "Plain", 0.39);

        everythingBagel = new Item("Bagel", "Everything", 0.49);
        everythingBagel2 = new Item("Bagel", "Everything", 0.49);
        everythingBagel3 = new Item("Bagel", "Everything", 0.49);
        everythingBagel4 = new Item("Bagel", "Everything", 0.49);
        everythingBagel5 = new Item("Bagel", "Everything", 0.49);
        everythingBagel6 = new Item("Bagel", "Everything", 0.49);
        everythingBagel7 = new Item("Bagel", "Everything", 0.49);
        everythingBagel8 = new Item("Bagel", "Everything", 0.49);
        everythingBagel9 = new Item("Bagel", "Everything", 0.49);
        everythingBagel10 = new Item("Bagel", "Everything", 0.49);


        sesameBagel = new Item("Bagel", "Sesame", 0.49);

        blackCoffee = new Item("Coffee", "Black", 0.99);
        whiteCoffee = new Item("Coffee", "White", 1.19);
        cappuccinoCoffee = new Item("Coffee", "Cappuccino", 1.29);
        latteCoffee = new Item("Coffee", "Latte", 1.29);

        baconFilling = new Item("Filling", "Bacon", 0.12);
        eggFilling = new Item("Filling", "Egg", 0.12);
        cheeseFilling = new Item("Filling", "Cheese", 0.12);
        creamCheeseFilling = new Item("Filling", "Cream Cheese", 0.12);
        smokeSalmonFilling = new Item("Filling", "Smoked Salmon", 0.12);
        hamFilling = new Item("Filling", "Ham", 0.12);

    }

    @Test
    public void totalCostSpecialOfferShouldReturnEqual(){
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
    public void totalCostSpecialOfferReturnEqualFor13OnionBagels(){
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
    public void totalCostSpecialOfferReturnEqualFor8EverythingBagels(){
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
      public void totalCostSpecialOfferReturnEqualFor13PlainBagels(){
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
}
