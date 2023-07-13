package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductManager productManager;

    @BeforeEach
    public void initializeTest() {
        productManager = new ProductManager();
    }

    @Test
    public void shouldAddBagelToBasket() {
        //Execute
        boolean result = productManager.orderProduct("Sesame");

        //Verify
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotAddBagelToBasket() {
        //Execute
        boolean result = productManager.orderProduct("Fake");

        //Verify
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldRemoveBagelFromBasket() {
        //Setup
        productManager.orderProduct("Plain");


        //Execute
        boolean result = productManager.removeProduct("Plain");

        //Verify

        Assertions.assertEquals(0, productManager.getBasket().getList().size());
    }

    @Test
    public void shouldNotRemoveFromBasket() {
        //Execute
        boolean result = productManager.removeProduct("Plain");

        //Verify
        Assertions.assertFalse(result);
    }

    @Test
    public void fillHashMapFromFileTest() {
        // Executed

        // Verify
        Assertions.assertFalse(productManager.getInventory().isEmpty());
        Assertions.assertEquals("Onion", productManager.getInventory().get("BGLO").getVariant());
    }

    @Test
    public void shouldChangeBasketCapacity() {
        //Setup
        int expectedCapacity = 11;

        //Execute
        productManager.changeBasketCapacity(expectedCapacity);

        //Verify
        Assertions.assertEquals(expectedCapacity, productManager.getBasket().getCapacity());
    }

    @Test
    public void shouldNotChangeBasketCapacity() {
        //Setup
        productManager.orderProduct("Plain");
        productManager.orderProduct("Plain");
        productManager.orderProduct("Plain");
        int expectedCapacity = productManager.getBasket().getCapacity();
        int newCapacity = 2;

        //Execute
        productManager.changeBasketCapacity(newCapacity);

        //Verify
        Assertions.assertEquals(expectedCapacity, productManager.getBasket().getCapacity());
    }

    @Test
    public void shouldReturnTotalBasketCost() {
        //Setup
        productManager.orderProduct("Plain");
        productManager.orderProduct("Plain");
        productManager.orderProduct("Plain");
        double expected = 0.39 * 3;

        //Execute
        double total = productManager.getBasket().total();

        //Verify
        Assertions.assertEquals(expected, total);
    }
}
