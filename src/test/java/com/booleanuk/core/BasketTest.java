package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BasketTest {

    @Test
    public void addProductTest_ByProduct1_IfCapacityIsNotFull() {
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
    public void addProductTest_ByProduct1_IfCapacityIsFull() {
        Basket basket = new Basket(1);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        Product product2 = inventory.getInventoryList().get(1);
        basket.addProduct(product1);
        String message = basket.addProduct(product2);

        Assertions.assertEquals("Basket is full", message);
    }

    @Test
    public void addProductTest_ByProduct1_IfProductIsNotInInventory() {
        Basket basket = new Basket();
        Product product1 = new Product("B", 0.49, "B", "Onion");
        String message = basket.addProduct(product1);

        Assertions.assertEquals("Product is not in inventory", message);
    }

    @Test
    public void addProductTest_ByProduct1_IfProductIsAFillingAndEmptyBagelExists() {
        Basket basket = new Basket();
        Product bagel = new Product("BGLO", 0.49, "Bagel", "Onion");
        Product filling = new Product("FILB", 0.12, "Filling", "Bacon");
        basket.addProduct(bagel);
        String message = basket.addProduct(filling);
        List<Product> productsFromBasket = basket.getBasketList().keySet().stream().toList();
        Bagel bagelFromBasket = (Bagel) productsFromBasket.get(0);

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(bagelFromBasket));
        Assertions.assertFalse(basket.getBasketList().containsKey(filling));
        Assertions.assertEquals(basket.getBasketList().get(bagelFromBasket), 1);
        Assertions.assertEquals(basket.getProductsQuantity(), 1);
        Assertions.assertEquals(bagelFromBasket.getFilling(), filling);
    }


    @Test
    public void addProductTest_ByProduct1_IfProductIsAFillingAndEmptyBagelDoesNotExist() {
        Basket basket = new Basket();
        Product filling = new Product("FILB", 0.12, "Filling", "Bacon");
        String message = basket.addProduct(filling);

        Assertions.assertEquals("There is no empty bagel to add filling", message);
        Assertions.assertFalse(basket.getBasketList().containsKey(filling));
    }

    @Test
    public void addProductTest_ByProduct1_IfProductIsAFillingAndNotEmptyBagelExists() {
        Basket basket = new Basket();
        Product bagel = new Product("BGLO", 0.49, "Bagel", "Onion");
        Product filling = new Product("FILB", 0.12, "Filling", "Bacon");
        Product filling2 = new Product("FILE", 0.12, "Filling", "Egg");
        basket.addProduct(bagel);
        basket.addProduct(filling);
        String message = basket.addProduct(filling2);
        List<Product> productsFromBasket = basket.getBasketList().keySet().stream().toList();
        Bagel bagelFromBasket = (Bagel) productsFromBasket.get(0);

        Assertions.assertEquals("There is no empty bagel to add filling", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(bagelFromBasket));
        Assertions.assertFalse(basket.getBasketList().containsKey(filling));
        Assertions.assertEquals(basket.getBasketList().get(bagelFromBasket), 1);
        Assertions.assertEquals(basket.getProductsQuantity(), 1);
        Assertions.assertEquals(bagelFromBasket.getFilling(), filling);
    }

    @Test
    public void addProductTest_ByProductQuantity_IfCapacityIsNotFull() {
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
    public void addProductTest_ByProductQuantity_IfProductIsNotInInventory() {
        Basket basket = new Basket();
        Product product1 = new Product("B", 0.49, "B", "Onion");
        String message = basket.addProduct(product1, 3);

        Assertions.assertEquals("Product is not in inventory", message);
    }

    @Test
    public void addProductTest_ByProductQuantity_IfProductIsAFillingAndQuantityIsMoreThan1() {
        Basket basket = new Basket();
        Product filling = new Product("FILB", 0.12, "Filling", "Bacon");
        String message = basket.addProduct(filling, 3);

        Assertions.assertEquals("You can add only 1 filling", message);
    }
    @Test
    public void addProductTest_ByProductQuantity_IfProductIsAFillingAndQuantityIs1() {
        Basket basket = new Basket();
        Product bagel = new Product("BGLO", 0.49, "Bagel", "Onion");
        Product filling = new Product("FILB", 0.12, "Filling", "Bacon");
        basket.addProduct(bagel);
        String message = basket.addProduct(filling, 1);
        List<Product> productsFromBasket = basket.getBasketList().keySet().stream().toList();
        Bagel bagelFromBasket = (Bagel) productsFromBasket.get(0);

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(bagelFromBasket));
        Assertions.assertFalse(basket.getBasketList().containsKey(filling));
        Assertions.assertEquals(basket.getBasketList().get(bagelFromBasket), 1);
        Assertions.assertEquals(basket.getProductsQuantity(), 1);
        Assertions.assertEquals(bagelFromBasket.getFilling(), filling);
    }


    @Test
    public void addProductTest_BySku1_IfCapacityIsNotFull() {
        Basket basket = new Basket(2);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        String message = basket.addProduct(product1.getSku());
        Product productFromBasket = basket.getBasketList().keySet().stream().toList().get(0);

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(productFromBasket));
        Assertions.assertEquals(basket.getBasketList().get(productFromBasket), 1);
        Assertions.assertEquals(basket.getProductsQuantity(), 1);
    }


    @Test
    public void addProductTest_BySku1_IfCapacityIsFull() {
        Basket basket = new Basket(1);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        Product product2 = inventory.getInventoryList().get(1);
        basket.addProduct(product1.getSku());
        String message = basket.addProduct(product2.getSku());

        Assertions.assertEquals("Basket is full", message);
    }


    @Test
    public void addProductTest_BySkuQuantity_IfCapacityIsNotFull() {
        Basket basket = new Basket(5);
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
//        Product product0 = inventory.getInventoryList().get(1);
//        basket.addProduct(product0.getSku());
        String message = basket.addProduct(product1.getSku(), 3);

        Product productFromBasket = basket.getBasketList().keySet().stream().toList().get(0);

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(productFromBasket));
        Assertions.assertEquals(basket.getBasketList().get(productFromBasket), 3);
        Assertions.assertEquals(basket.getProductsQuantity(), 3);
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
    public void addProductTest_BySkuQuantity_IfProductIsNotInInventory() {
        Basket basket = new Basket();
        Product product1 = new Product("B", 0.49, "B", "Onion");
        String message = basket.addProduct(product1.getSku(), 2);

        Assertions.assertEquals("Product is not in inventory", message);
    }

    @Test
    public void addBagelByVariantTest_ByBagel1_IfCapacityIsNotFull() {
        Basket basket = new Basket(2);
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = basket.addBagelByVariant(bagel1.getVariant());
        Product productFromBasket = basket.getBasketList().keySet().stream().toList().get(0);

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(productFromBasket));
        Assertions.assertEquals(basket.getBasketList().get(productFromBasket), 1);
        Assertions.assertEquals(basket.getProductsQuantity(), 1);
    }

    @Test
    public void addBagelByVariantTest_ByBagel1_IfCapacityIsFull() {
        Basket basket = new Basket(0);
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = basket.addBagelByVariant(bagel1.getVariant());

        Assertions.assertEquals("Basket is full", message);
    }

    @Test
    public void addBagelByVariantTest_ByBagelQuantity_IfCapacityIsNotFull() {
        Basket basket = new Basket(5);
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = basket.addBagelByVariant(bagel1.getVariant(), 3);
        Product productFromBasket = basket.getBasketList().keySet().stream().toList().get(0);

        Assertions.assertEquals("Product added", message);
        Assertions.assertTrue(basket.getBasketList().containsKey(productFromBasket));
        Assertions.assertEquals(basket.getBasketList().get(productFromBasket), 3);
        Assertions.assertEquals(basket.getProductsQuantity(), 3);
    }

    @Test
    public void addBagelByVariantTest_ByBagelQuantity_IfCapacityIsFull() {
        Basket basket = new Basket(1);
        Bagel bagel1 = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        String message = basket.addBagelByVariant(bagel1.getVariant(), 3);

        Assertions.assertEquals("Basket is full", message);
    }

    //-------------------------------------------
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
        basket.addProduct(product1);
        Product product2 = inventory.getInventoryList().get(1);
        String message = basket.removeProduct(product2);

        Assertions.assertEquals("Product is not in the basket", message);
    }

    @Test
    public void removeProductTest_ByProduct1_IfProductIsNotInInventory(){
        Basket basket = new Basket();
        Product product = new Bagel("BO", 0.49, "Bagel", "Cheeseee");
        String message = basket.removeProduct(product);

        Assertions.assertEquals("Product is not in inventory", message);
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
    public void removeProductTest_ByProductQuantity_IfProductIsInBasketAndProductIsNotCompletelyRemoved(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1, 2);
        String message = basket.removeProduct(product1, 1);

        Assertions.assertEquals("Products removed", message);
    }

    @Test
    public void removeProductTest_ByProductQuantity_IfProductIsInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1, 2);
        String message = basket.removeProduct(product1, 2);

        Assertions.assertEquals("Products removed", message);
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
    public void removeProductTest_BySku1_IfProductIsNotInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        String message = basket.removeProduct(product1.getSku());

        Assertions.assertEquals("Product is not in the basket", message);
    }


    @Test
    public void removeProductTest_BySkuQuantity_IfProductIsInBasketAndWeWantToRemoveMore(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1);
        String message = basket.removeProduct(product1.getSku(), 2);

        Assertions.assertEquals("Quantity of this product is less than given", message);
    }


    @Test
    public void removeProductTest_BySkuQuantity_IfProductIsInBasket(){
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Product product1 = inventory.getInventoryList().get(0);
        basket.addProduct(product1, 2);
        String message = basket.removeProduct(product1.getSku(), 2);

        Assertions.assertEquals("Products removed", message);
    }

    @Test
    public void removeProductTest_BySkuQuantity_IfProductIsNotInBasket(){
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
        String message = basket.addProduct(product1, 3);

        Assertions.assertEquals("Basket is full", message);
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
    public void changeCapacityTest_IfNewCapacityIsEqualToActual(){
        Basket basket = new Basket(4);
        String message = basket.changeCapacity(4);

        Assertions.assertEquals("Nothing to change", message);
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

    @Test
    public void totalCostTest_SpecialOfferBagelOnion(){
        Basket basket = new Basket(10);
        Product product1 = new Product("BGLO", 0.49, "Bagel", "Onion");
        basket.addProduct(product1, 6);
        double result = basket.totalCost();

        Assertions.assertEquals(2.49, result);
    }

    @Test
    public void totalCostTest_SpecialOfferBagelOnionWithRest(){
        Basket basket = new Basket(10);
        Product product1 = new Product("BGLO", 0.49, "Bagel", "Onion");
        basket.addProduct(product1, 8);
        double result = basket.totalCost();

        Assertions.assertEquals(3.47, result);
    }

    @Test
    public void totalCostTest_SpecialOfferBagelEverything(){

        Basket basket = new Basket(10);
        Product product1 = new Product("BGLE", 0.49, "Bagel", "Everything");
        basket.addProduct(product1, 6);
        double result = basket.totalCost();

        Assertions.assertEquals(2.49, result);
    }

    @Test
    public void totalCostTest_SpecialOfferBagelPlain(){

        Basket basket = new Basket(25);
        Product product1 = new Product("BGLO", 0.49, "Bagel", "Onion");
        Product product2 = new Product("BGLP", 0.39, "Bagel", "Plain");
        Product product3 = new Product("BGLE", 0.49, "Bagel", "Everything");
        Product product4 = new Product("COFB", 0.99, "Coffee", "Black");
        basket.addProduct(product1, 2);
        basket.addProduct(product2, 12);
        basket.addProduct(product3, 6);
        basket.addProduct(product4, 3);
        double result = basket.totalCost();

        Assertions.assertEquals(10.43, result);
    }

    @Test
    public void totalCostTest_SpecialOfferExample1(){

        Basket basket = new Basket(20);
        Product product1 = new Product("BGLP", 0.39, "Bagel", "Plain");
        basket.addProduct(product1, 12);
        double result = basket.totalCost();

        Assertions.assertEquals(3.99, result);
    }
    @Test
    public void totalCostTest_SpecialOfferExample2(){

        Basket basket = new Basket(20);
        Product product1 = new Product("BGLP", 0.39, "Bagel", "Plain");
        basket.addProduct(product1, 16);
        double result = basket.totalCost();

        Assertions.assertEquals(5.55, result);
    }


}
