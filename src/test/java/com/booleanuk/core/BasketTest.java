package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class BasketTest {

    @Test
    public void testAddBagel() {
        Basket basket = new Basket(12);
        Bagel bagel = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel);
        Assertions.assertEquals(1, basket.size());
    }

    @Test
    public void testAddBagelToFullBasket() {
        Basket basket = new Basket(1);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel1);
        Assertions.assertEquals(1, basket.size());
        basket.addProduct(bagel2);
        Assertions.assertEquals(1, basket.size());
    }

    @Test
    public void testRemoveBagel() {
        Basket basket = new Basket(12);
        Bagel bagel = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel);
        Assertions.assertEquals(1, basket.size());
        basket.removeProduct(bagel);
        Assertions.assertEquals(0, basket.size());
    }

    @Test
    public void testRemoveNonexistentBagel() {
        Basket basket = new Basket(12);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        basket.addProduct(bagel1);
        Assertions.assertThrows(NoSuchElementException.class, () -> basket.removeProduct(bagel2));
    }

    @Test
    public void testGetBagelsIsClone() {
        Basket basket = new Basket(12);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel1);
        basket.addProduct(bagel2);
        Assertions.assertEquals(2, basket.size());
        ArrayList<Product> bagelsCopy = basket.getProducts();
        bagelsCopy.remove(bagel1);
        Assertions.assertEquals(2, basket.size());
        Assertions.assertEquals(1, bagelsCopy.size());
    }

    @Test
    public void testChangeSize() {
        Basket basket = new Basket(1);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel1);
        Assertions.assertEquals(1, basket.size());
        basket.addProduct(bagel2);
        Assertions.assertEquals(1, basket.size());
        basket.setBasketSize(12);
        basket.addProduct(bagel2);
        Assertions.assertEquals(2, basket.size());
    }

    @Test
    public void testChangeSizeToSmallerThanNumberOfBagels() {
        Basket basket = new Basket(2);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Assertions.assertEquals(0, basket.size());
        basket.addProduct(bagel1);
        basket.addProduct(bagel2);
        Assertions.assertEquals(2, basket.size());
        basket.setBasketSize(1);
        Assertions.assertEquals(0, basket.size());
    }

    @Test
    public void testCalculateCost() {
        Basket basket = new Basket(2);
        Bagel bagel1 = new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB"));
        Bagel bagel2 = new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB"));
        basket.addProduct(bagel1);
        Assertions.assertEquals(0.61f, basket.calculateCost(), 0.001);
        basket.addProduct(bagel2);
        Assertions.assertEquals(1.12f, basket.calculateCost(), 0.001);
    }

    @Test
    public void testCalculateCostOnEmptyBasket() {
        Basket basket = new Basket(2);
        Assertions.assertEquals(0.0f, basket.calculateCost(), 0.001);
    }

    @Test
    public void testFindDiscountOn13Bagels() {
        Basket b = new Basket(24);
        b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        for (int i = 0; i < 12; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
        }
        Assertions.assertEquals(1.89f, b.findDiscount(), 0.001);
    }

    @Test
    public void testFindDiscountOn12PlainBagels() {
        Basket b = new Basket(24);
        for (int i = 0; i < 12; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        }
        Assertions.assertEquals(0.69f, b.findDiscount(), 0.001);
    }

    @Test
    public void testFindDiscountOn12BagelsWithPlainBagels() {
        Basket b = new Basket(24);
        b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        for (int i = 0; i < 6; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
            b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        }
        Assertions.assertEquals(1.29f, b.findDiscount(), 0.001);
    }

    @Test
    public void testFindDiscountOn18Bagels() {
        Basket b = new Basket(24);
        b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        for (int i = 0; i < 18; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
        }
        Assertions.assertEquals(2.34f, b.findDiscount(), 0.001);
    }



    @Test
    public void testFindDiscountOn18BagelsWithPlainBagels() {
        Basket b = new Basket(24);
        b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        for (int i = 0; i < 9; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
            b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        }
        Assertions.assertEquals(1.44f, b.findDiscount(), 0.001);
    }

    @Test
    public void testFindDiscountOn19Bagels() {
        Basket b = new Basket(24);
        b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        for (int i = 0; i < 19; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
        }
        Assertions.assertEquals(2.34f, b.findDiscount(), 0.001);
    }



    @Test
    public void testFindDiscountOn20BagelsWithPlainBagels() {
        Basket b = new Basket(24);
        b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        for (int i = 0; i < 10; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
            b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        }
        Assertions.assertEquals(1.54f, b.findDiscount(), 0.001);
    }

    @Test
    public void testFindDiscountOnOneBagelAndOneCoffee() {
        Basket b = new Basket(24);
        b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
        b.addProduct(new Coffee(Controller.prices.get("COFB")));
        Assertions.assertEquals(0.23f, b.findDiscount(), 0.001);
    }

    @Test
    public void testFindDiscountOnTwoBagelsAndTwoCoffees() {
        Basket b = new Basket(24);
        b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
        b.addProduct(new Coffee(Controller.prices.get("COFB")));
        b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        b.addProduct(new Coffee(Controller.prices.get("COFC")));
        Assertions.assertEquals(0.66f, b.findDiscount(), 0.001);
    }

    @Test
    public void testFindDiscountOn19BagelsAndOneCoffee() {
        Basket b = new Basket(24);
        b.addProduct(new Coffee(Controller.prices.get("COFB")));
        b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        for (int i = 0; i < 18; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLO"), Controller.prices.get("FILB")));
        }
        Assertions.assertEquals(2.47f, b.findDiscount(), 0.001);
    }

    @Test
    public void testReceiptInfo() {
        Basket b = new Basket(24);
        for (int i = 0; i < 12; i++) {
            b.addProduct(new Bagel(Controller.prices.get("BGLP"), Controller.prices.get("FILB")));
        }
        Basket.ReceiptInfo i = b.receiptInformation();
        Assertions.assertEquals(12, i.fillings().get("Bacon"));
        Assertions.assertEquals(0, i.remaining().size());
        Assertions.assertEquals(1, i.deals().size());
    }
}