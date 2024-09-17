package com.booleanuk.extension;

import com.booleanuk.extension.Bagel;
import com.booleanuk.extension.Filling;
import com.booleanuk.extension.Item;
import com.booleanuk.extension.Shop;
import com.booleanuk.extension.Basket;
import com.booleanuk.extension.Inventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BagelTest {


    /* core tests */
    @Test
    public void testAddingItemToBasket(){
        Basket basket = new Basket(15);
        Assertions.assertTrue(basket.addItem("COFB", 10));


    }

    /*  Test use case 2*/
    @Test
    public void testRemovingItemFromBasket(){
        Basket basket = new Basket(15);
        basket.addItem("COFB", 1);
        Assertions.assertTrue(basket.removeItem("COFB"));
    }

    /* Test use case 3 */

    @Test
    public void testAddingOverMaxCapacity(){

        Basket basket = new Basket(2);
        basket.addItem("COFB", 1);
        basket.addItem("FILB", 1);
        Assertions.assertFalse(basket.addItem("BGLO", 1));
    }

    /* Test use case 4 */
    @Test
    public void testChangingBasketCapacity(){
        Shop shop = new Shop();
        shop.createBasket();
        shop.getAllBaskets().get(0).addItem("COFB", 5);
        Assertions.assertFalse(shop.changeMaxCapacity(2));


    }
    /* Test use case 5 */
    @Test
    public void testRemovingItemFromBasketThatDoesNotExist(){
        Basket basket = new Basket(20);
        Assertions.assertFalse(basket.removeItem("COFB"));
    }

    /* Test use case 6 */
    @Test
    public void testGetTotalCostOfBasket(){
        Inventory.resetInstance();
        Basket basket = new Basket(20);
        basket.addItem("COFB", 3);
        basket.addItem("BGLO", 3);
        Assertions.assertEquals(4.44, basket.getTotalCost());
    }
    /* Test use case 7 */
    @Test
    public void testGetPriceOfSpecificItem(){
        Assertions.assertEquals("0.99", com.booleanuk.core.Inventory.getInstance().getPriceInfo("COFB"));
    }

    /* Test use case 8 */
    @Test
    public void testAddFillingsToBagel(){
        Basket basket = new Basket(3);
        ArrayList<String> fillingsTest = new ArrayList<>();
        fillingsTest.add("FILB");
        fillingsTest.add("FILC");
        Assertions.assertTrue(basket.addFillingWithBagel("BGLO", fillingsTest));
    }
    @Test
    public void testAddingFillingToBagelWhenOutOfStock(){
        Basket basket = new Basket(40);
        ArrayList<String> fillingsTest = new ArrayList<>();
        for(int i = 0; i < 22; i++){
            fillingsTest.add("FILB");
        }
        Assertions.assertFalse(basket.addFillingWithBagel("BGLO", fillingsTest));
        Assertions.assertTrue(com.booleanuk.core.Inventory.getInstance().checkInventory("FILB", 20));
    }

    /* Test use case 9 */
    @Test
    public void testGettingCostOfAllFillings(){
        Inventory i = Inventory.getInstance();
        String expected = "List of Fillings:\n" +
                "Filling{SKU='FILB', type='Bacon', price=0.12}\n" +
                "Filling{SKU='FILE', type='Egg', price=0.12}\n" +
                "Filling{SKU='FILC', type='Cheese', price=0.12}\n" +
                "Filling{SKU='FILX', type='Cream Cheese', price=0.12}\n" +
                "Filling{SKU='FILS', type='Smoked Salmon', price=0.12}\n" +
                "Filling{SKU='FILH', type='Ham', price=0.12}\n";
        Assertions.assertEquals(expected, i.listFillings());

    }
    /* Test use case 10 */
    @Test
    public void testAddingItemNotInInventory(){
        Basket basket = new Basket(10);
        Assertions.assertFalse(basket.addItem("BGLX", 2));
    }
    @Test
    public void testAddingBagelWithFillingNotInInventory(){
        Basket basket = new Basket(20);
        ArrayList<String> fillings = new ArrayList<>();
        fillings.add("FILX");
        fillings.add("FILS");
        fillings.add("FILZ");
        Assertions.assertFalse(basket.addFillingWithBagel("BGLO", fillings));
    }

    /* Additional tests */
    @Test
    public void testCreatingAndPrintingBagel(){
        Bagel bagel = new Bagel("BGLO", "Bagel", "Onion", 0.49);

        Assertions.assertEquals("BGLO", bagel.getSKU());
        Assertions.assertEquals("Bagel", bagel.getName());
    }
    @Test
    public void testCreatingBagelWithFillings(){
        Bagel bagel = new Bagel("BGLO", "Bagel", "Onion", 0.49);
        Inventory i = Inventory.getInstance();

        Filling filling1 = new Filling("FILX", "Filling", "Cream Cheese", 0.12);
        Filling filling2 = new Filling("FILS", "Filling", "Smoked Salmon", 0.12);

        ArrayList<Item> fillings = new ArrayList<>();
        fillings.addAll(i.getItems("FILX", 2));
        fillings.addAll(i.getItems("FILS", 2));
        bagel.addFillings(fillings);


        ArrayList<Item> expected = new ArrayList<>();
        expected.add(filling1);
        expected.add(filling1);
        expected.add(filling2);
        expected.add(filling2);

        Assertions.assertEquals(expected.get(0).toString(), fillings.get(0).toString());
        Assertions.assertEquals(expected.get(1).toString(), fillings.get(1).toString());
        Assertions.assertEquals(expected.get(2).toString(), fillings.get(2).toString());
        Assertions.assertEquals(expected.get(3).toString(), fillings.get(3).toString());

    }



    /*Extension 1 tests*/
    /* Test use case 1*/
    @Test
    public void testGettingAValidDiscount(){
        Inventory.resetInstance();
        Basket basket = new Basket(30);
        basket.addItem("BGLP", 16);
        Assertions.assertEquals(5.55, basket.getTotalCost());
    }
    @Test
    public void testGettingAValidDiscount6PlainBagels(){
        Inventory.resetInstance();
        Basket basket = new Basket(30);
        basket.addItem("BGLP", 6);
        Assertions.assertEquals(2.34, basket.getTotalCost());

    }
    @Test
    public void testGettingDiscountsOnBigOrder(){
        Inventory.resetInstance();
        Basket basket = new Basket(40);
        basket.addItem("BGLO", 2);
        basket.addItem("BGLP", 12);
        basket.addItem("BGLE", 6);
        basket.addItem("COFB", 3);
        Assertions.assertEquals(10.43, basket.getTotalCost());
    }

    @Test
    public void testGettingBagelAndCoffeeDiscount(){
        Basket basket = new Basket(20);
        basket.addItem("COFB", 1);
        basket.addItem("BGLO", 1);
        Assertions.assertEquals(1.25, basket.getTotalCost());
    }

    @Test
    public void testCheckingOutBasket(){
        Shop shop = new Shop();
        shop.createBasket();
        shop.changeMaxCapacity(40);
        shop.getAllBaskets().get(0).addItem("COFB", 1);
        shop.getAllBaskets().get(0).addItem("BGLO", 1);
        Assertions.assertTrue(shop.checkoutBasket(0));
    }

    /* Test extension 2 & 3 */
    @Test
    public void testGettingReceiptWhenBasketHasItems(){
        Inventory.resetInstance();
        Basket basket = new Basket(40);
        basket.addItem("BGLP", 12);
        basket.addItem("BGLE", 6);
        basket.addItem("COFB", 3);
        basket.addItem("BGLO", 2);

        Inventory.resetInstance();
        Basket basket2 = new Basket(40);
        basket2.addItem("BGLP", 12);
        basket2.addItem("BGLE", 6);
        basket2.addItem("COFB", 3);
        basket2.addItem("BGLO", 2);



        Assertions.assertEquals(basket.getReceipt(), basket2.getReceipt());

    }

}
