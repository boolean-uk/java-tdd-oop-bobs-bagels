package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTest {
    Basket basket;
    Bagel onionBagel;
    Bagel plainBagel;
    Bagel everythingBagel;
    Bagel sesameBagel;
    Coffee blackCoffee;
    Coffee whiteCoffee;
    Coffee cappuccinoCoffee;
    Coffee latteCoffee;
    Filling baconFilling;
    Filling eggFilling;
    Filling cheeseFilling;
    Filling creamCheeseFilling;
    Filling smokeSalmonFilling;
    Filling hamFilling;
    Inventory inventory;

    @BeforeEach
    public void setUp(){
        basket = new Basket(2);

        onionBagel = new Bagel("BGLO", "Bagel","Onion", 0.49);
        plainBagel = new Bagel("BGLP", "Bagel", "Plain", 0.39);
        everythingBagel = new Bagel("BGLE", "Bagel", "Everything", 0.49);
        sesameBagel = new Bagel("BGLS", "Bagel", "Sesame", 0.49);

        blackCoffee = new Coffee("COFB", "Coffee","Black", 0.99);
        whiteCoffee = new Coffee("COFW","Coffee","White", 1.19);
        cappuccinoCoffee = new Coffee("COFC","Coffee","Cappuccino", 1.29);
        latteCoffee = new Coffee("COFL","Coffee","Latte", 1.29);

        baconFilling = new Filling("FILB","Filling", "Bacon", 0.12);
        eggFilling = new Filling("FILE", "Filling","Egg", 0.12);
        cheeseFilling = new Filling("FILC", "Filling","Cheese", 0.12);
        creamCheeseFilling = new Filling("FILX", "Filling","Cream Cheese", 0.12);
        smokeSalmonFilling = new Filling("FILS", "Filling","Smoked Salmon", 0.12);
        hamFilling = new Filling("FILH","Filling","Ham", 0.12);

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
        Assertions.assertEquals(0.49, inventory.getPriceOfParticularItem(onionBagel.getVariant()));
    }

    @Test
    public void getPriceOfABagelShouldReturnNotEqual(){
        Assertions.assertNotEquals(0.49, inventory.getPriceOfParticularItem(smokeSalmonFilling.getVariant()));
    }

    @Test
    public void getPriceOfAFillingShouldReturnEqual(){
        Assertions.assertEquals(0.12, inventory.getPriceOfParticularItem(baconFilling.getVariant()));
    }

    @Test
    public void getPriceOfParticularFillingShouldReturnNotEqual(){
        Assertions.assertNotEquals(0.21, inventory.getPriceOfParticularItem(hamFilling.getVariant()));
    }

    @Test
    public void checkIfItemIsInInventoryShouldThrowException(){
        Item itemNotInInventory = new Item("COFM", "Coffee", "Mocha", 1.20);
        Assertions.assertThrows(RuntimeException.class, () -> inventory.checkIfItemIsInInventory(itemNotInInventory));
    }

    @Test
    public void checkIfItemIsInInventoryShouldReturnTrue(){
        Assertions.assertTrue(inventory.checkIfItemIsInInventory(baconFilling));
    }
}
