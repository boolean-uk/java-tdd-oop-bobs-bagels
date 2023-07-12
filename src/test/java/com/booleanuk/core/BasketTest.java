package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void addProductTest_ByProduct1_IfCapacityIsNotFull(){
        Basket basket = new Basket(2);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        String message = basket.addProduct(product1);

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(product1));
        Assertions.assertEquals(basket.getBasketList().get(product1), 1);
        Assertions.assertEquals(basket.getProductsQuantity(), 1);
    }
    @Test
    public void addProductTest_ByProduct1_IfCapacityIsFull(){
        Basket basket = new Basket(1);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        Product product2 = inventory.getInventoryList().get(1);
        basket.addProduct(product1);
        String message = basket.addProduct(product2);

        Assertions.assertEquals("Basket is full", message);
    }

    @Test
    public void addProductTest_ByProductQuantity_IfCapacityIsNotFull(){
        Basket basket = new Basket(5);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        Product product0 = inventory.getInventoryList().get(1);
        basket.addProduct(product0);
        String message = basket.addProduct(product1, 3);

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(product1));
        Assertions.assertEquals(basket.getBasketList().get(product1), 3);
        Assertions.assertEquals(basket.getProductsQuantity(), 4);
    }

    @Test
    public void addProductTest_ByProductQuantity_IfCapacityIsFull() {
        Basket basket = new Basket(1);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        String message = basket.addProduct(product1, 2);

        Assertions.assertEquals("Basket is full", message);
    }


    @Test
    public void addProductTest_BySku1_IfCapacityIsNotFull(){
        Basket basket = new Basket(2);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        String message = basket.addProduct(product1.getSku());

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(product1));
        Assertions.assertEquals(basket.getBasketList().get(product1), 1);
        Assertions.assertEquals(basket.getProductsQuantity(), 1);
    }


    @Test
    public void addProductTest_BySku1_IfCapacityIsFull(){
        Basket basket = new Basket(1);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        Product product2 = inventory.getInventoryList().get(1);
        basket.addProduct(product1.getSku());
        String message = basket.addProduct(product2.getSku());

        Assertions.assertEquals("Basket is full", message);
    }


    @Test
    public void addProductTest_BySkuQuantity_IfCapacityIsNotFull(){
        Basket basket = new Basket(5);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        Product product0 = inventory.getInventoryList().get(1);
        basket.addProduct(product0.getSku());
        String message = basket.addProduct(product1.getSku(), 3);

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(product1));
        Assertions.assertEquals(basket.getBasketList().get(product1), 3);
        Assertions.assertEquals(basket.getProductsQuantity(), 4);
    }

    @Test
    public void addProductTest_BySkuQuantity_IfCapacityIsFull() {
        Basket basket = new Basket(1);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        String message = basket.addProduct(product1.getSku(), 2);

        Assertions.assertEquals("Basket is full", message);
    }

    @Test
    public void addBagelByVariantTest_ByBagel1_IfCapacityIsNotFull(){
        Basket basket = new Basket(2);
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = basket.addBagelByVariant(bagel1.getVariant());

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(bagel1));
        Assertions.assertEquals(basket.getBasketList().get(bagel1), 1);
        Assertions.assertEquals(basket.getProductsQuantity(), 1);
    }

    @Test
    public void addBagelByVariantTest_ByBagel1_IfCapacityIsFull(){
        Basket basket = new Basket(0);
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = basket.addBagelByVariant(bagel1.getVariant());

        Assertions.assertEquals("Basket is full", message);
    }


    @Test
    public void addBagelByVariantTest_ByBagelQuantity_IfCapacityIsNotFull(){
        Basket basket = new Basket(5);
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = basket.addBagelByVariant(bagel1.getVariant(), 3);

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(bagel1));
        Assertions.assertEquals(basket.getBasketList().get(bagel1), 3);
        Assertions.assertEquals(basket.getProductsQuantity(), 3);
    }

    @Test
    public void addBagelByVariantTest_ByBagelQuantity_IfCapacityIsFull() {
        Basket basket = new Basket(1);
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = basket.addBagelByVariant(bagel1.getVariant(), 3);

        Assertions.assertEquals("Basket is full", message);
    }

    @Test
    public void removeProductTest_ByProduct1_IfProductIsInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1);
        String message = basket.removeProduct(product1);

        Assertions.assertEquals("Product removed", message);
    }

    @Test
    public void removeProductTest_ByProduct1_IfProductIsNotInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        String message = basket.removeProduct(product1);

        Assertions.assertEquals("Product is not in basket", message);
    }

    @Test
    public void removeProductTest_ByProductQuantity_IfProductIsInBasketAndWeWantToRemoveMore(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1);
        String message = basket.removeProduct(product1, 2);

        Assertions.assertEquals("Quantity of this product is less than given", message);
    }


    @Test
    public void removeProductTest_ByProductQuantity_IfProductIsInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1, 2);
        String message = basket.removeProduct(product1, 2);

        Assertions.assertEquals("Product removed", message);
    }

    @Test
    public void removeProductTest_ByProductQuantity_IfProductIsNotInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        Product product2 = inventory.getInventoryList().get(1);
        basket.addProduct(product1);
        String message = basket.removeProduct(product2, 2);

        Assertions.assertEquals("Product is not in the basket", message);
    }

    @Test
    public void removeProductTest_BySku1_IfProductIsInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1);
        String message = basket.removeProduct(product1.getSku());

        Assertions.assertEquals("Product removed", message);
    }

    @Test
    public void removeProductTest_ByProduct1_IfProductIsNotInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        String message = basket.removeProduct(product1.getSku());

        Assertions.assertEquals("Product is not in basket", message);
    }


    @Test
    public void removeProductTest_ByProductQuantity_IfProductIsInBasketAndWeWantToRemoveMore(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1);
        String message = basket.removeProduct(product1.getSku(), 2);

        Assertions.assertEquals("Quantity of this product is less than given", message);
    }


    @Test
    public void removeProductTest_ByProductQuantity_IfProductIsInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1, 2);
        String message = basket.removeProduct(product1.getSku(), 2);

        Assertions.assertEquals("Product removed", message);
    }

    @Test
    public void removeProductTest_ByProductQuantity_IfProductIsNotInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        Product product2 = inventory.getInventoryList().get(1);
        basket.addProduct(product1);
        String message = basket.removeProduct(product2.getSku(), 2);

        Assertions.assertEquals("Product is not in the basket", message);
    }

    @Test
    public void isOverfilledTest_IfBasketIsFull(){
        Basket basket = new Basket(1);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1);

        Assertions.assertTrue(basket.isOverfilled());
    }

    @Test
    public void isOverfilledTest_IfBasketIsNotFull(){
        Basket basket = new Basket(2);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1);

        Assertions.assertFalse(basket.isOverfilled());
    }


    @Test
    public void changeCapacityTest_IfNewCapacityIsBiggerThanActual(){
        Basket basket = new Basket(2);
        String message = basket.changeCapacity(5);

        Assertions.assertEquals("Capacity changed", message);
    }

    @Test
    public void changeCapacityTest_IfNewCapacityIsSmallerThanActualAndProductsQuantityIsLess(){
        Basket basket = new Basket(10);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1, 5);
        String message = basket.changeCapacity(7);

        Assertions.assertEquals("Capacity changed", message);
    }

    @Test
    public void changeCapacityTest_IfNewCapacityIsSmallerThanActualAndProductsQuantityIsMore(){
        Basket basket = new Basket(10);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1, 5);
        String message = basket.changeCapacity(4);

        Assertions.assertEquals("Capacity can not be changed", message);
    }


    @Test
    public void totalCostTest(){
        Basket basket = new Basket(10);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1, 5);
        double result = basket.totalCost();

        Assertions.assertEquals(product1.getPrice()*5, result);
    }


}
