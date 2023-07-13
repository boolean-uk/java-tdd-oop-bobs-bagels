package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTest {
    Basket basket;
    Item onionBagel;
    Item plainBagel;
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
    Inventory inventory;

    @BeforeEach
    public void setUp(){
        basket = new Basket(2);

        onionBagel = new Item("Bagel","Onion", 0.49);
        plainBagel = new Item("Bagel", "Plain", 0.39);
        everythingBagel = new Item("Bagel", "Everything", 0.49);
        sesameBagel = new Item("Bagel", "Sesame", 0.49);

        blackCoffee = new Item("Coffee","Black", 0.99);
        whiteCoffee = new Item("Coffee","White", 1.19);
        cappuccinoCoffee = new Item("Coffee","Cappuccino", 1.29);
        latteCoffee = new Item("Coffee","Latte", 1.29);

        baconFilling = new Item("Filling", "Bacon", 0.12);
        eggFilling = new Item("Filling","Egg", 0.12);
        cheeseFilling = new Item("Filling","Cheese", 0.12);
        creamCheeseFilling = new Item("Filling","Cream Cheese", 0.12);
        smokeSalmonFilling = new Item("Filling","Smoked Salmon", 0.12);
        hamFilling = new Item("Filling","Ham", 0.12);

        inventory = new Inventory();
        inventory.getItems().add(onionBagel);
        inventory.getItems().add(plainBagel);
        inventory.getItems().add(everythingBagel);
        inventory.getItems().add(sesameBagel);
        inventory.getItems().add(blackCoffee);
        inventory.getItems().add(whiteCoffee);
        inventory.getItems().add(cappuccinoCoffee);
        inventory.getItems().add(latteCoffee);
        inventory.getItems().add(baconFilling);
        inventory.getItems().add(eggFilling);
        inventory.getItems().add(cheeseFilling);
        inventory.getItems().add(creamCheeseFilling);
        inventory.getItems().add(smokeSalmonFilling);
        inventory.getItems().add(hamFilling);

    }

    @Test
    public void addTestShouldReturnTrue(){
        Assertions.assertTrue(basket.add(onionBagel));
        Assertions.assertTrue(basket.add(plainBagel));
    }

    @Test
    public void addTestShouldReturnFalse(){
        basket.add(onionBagel);
        basket.add(plainBagel);
        Assertions.assertFalse(basket.add(everythingBagel));
    }

    @Test
    public void addTestShouldReturnEqual(){
        basket.add(onionBagel);
        Assertions.assertEquals(1, basket.getItems().size());
    }

    @Test
    public void removeTestShouldReturnTrue(){
        basket.add(onionBagel);
        basket.add(everythingBagel);
        Assertions.assertTrue(basket.removeItem(onionBagel));
    }

    @Test
    public void removeTestShouldReturnFalse(){
        basket.add(onionBagel);
        basket.add(everythingBagel);
        Assertions.assertFalse(basket.removeItem(plainBagel));
    }

    @Test
    public void getItemsCountShouldReturnEqual(){
        basket.add(onionBagel);
        basket.add(plainBagel);
        Assertions.assertEquals(2, basket.getItemsCount());
    }

    @Test
    public void getItemsCountShouldReturnNotEqual(){
        basket.add(onionBagel);
        Assertions.assertNotEquals(10, basket.getItemsCount());
    }

    @Test
    public void changeCapacityShouldThrowException(){
        Assertions.assertThrows(RuntimeException.class, () -> basket.changeCapacity(1));
    }

    @Test
    public void changeCapacityShouldReturnEqual(){
        basket.changeCapacity(4);
        Assertions.assertEquals(4, basket.getCapacity());
    }

    @Test
    public void isFullShouldThrowException(){
        basket.add(onionBagel);
        basket.add(everythingBagel);
        Assertions.assertTrue(basket.isFull());
    }

    @Test
    public void isFullShouldReturnFalse(){
        basket.add(onionBagel);
        Assertions.assertFalse(basket.isFull());
    }

    @Test
    public void totalCostShouldReturnEqual(){
        basket.add(onionBagel);
        basket.add(hamFilling);
        Assertions.assertEquals(0.61, basket.totalCost());
    }

    @Test
    public void totalCostShouldReturnNotEqual(){
        basket.add(blackCoffee);
        basket.add(whiteCoffee);
        Assertions.assertNotEquals(1.11, basket.totalCost());
    }

    @Test
    public void totalCostEmptyBasketReturnEqual(){
        Assertions.assertEquals(0.0, basket.totalCost());
    }

    @Test
    public void getPriceOfABagelShouldReturnEqual(){
        Assertions.assertEquals(0.49, inventory.getPriceOfParticularBagel(onionBagel.getVariant()));
    }

    @Test
    public void getPriceOfABagelShouldReturnNotEqual(){
        Assertions.assertNotEquals(0.49, inventory.getPriceOfParticularBagel(smokeSalmonFilling.getVariant()));
    }

    @Test
    public void getPriceOfAFillingShouldReturnEqual(){
        Assertions.assertEquals(0.12, inventory.getPriceOfParticularFilling(baconFilling.getVariant()));
    }

    @Test
    public void getPriceOfParticularFillingShouldReturnNotEqual(){
        Assertions.assertNotEquals(0.21, inventory.getPriceOfParticularFilling(hamFilling.getVariant()));
    }

    @Test
    public void checkIfItemIsInInventoryShouldThrowException(){
        Item itemNotInInventory = new Item("Coffee", "Mocha", 1.20);
        Assertions.assertThrows(RuntimeException.class, () -> inventory.checkIfItemIsInInventory(itemNotInInventory));
    }

    @Test
    public void checkIfItemIsInInventoryShouldReturnTrue(){
        Assertions.assertTrue(inventory.checkIfItemIsInInventory(baconFilling));
    }
}
