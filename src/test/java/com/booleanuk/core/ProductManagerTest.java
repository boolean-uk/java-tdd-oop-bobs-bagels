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
        Product result = productManager.orderProduct("Sesame");

        //Verify
        Assertions.assertNotNull(result);
    }

    @Test
    public void shouldNotAddBagelToBasket() {
        //Execute
        Product result = productManager.orderProduct("Fake");

        //Verify
        Assertions.assertNull(result);
    }

    @Test
    public void shouldRemoveBagelFromBasket() {
        //Setup
        productManager.orderProduct("Plain");


        //Execute
        productManager.removeProduct(0);

        //Verify
        Assertions.assertEquals(0, productManager.getItems().size());
    }

    @Test
    public void shouldNotRemoveFromBasket() {
        //Setup
        productManager.orderProduct("Plain");

        //Execute
        productManager.removeProduct(1);

        //Verify
        Assertions.assertEquals(1, productManager.getItems().size());
    }

    @Test
    public void shouldChangeBasketCapacity() {
        //Setup
        int expectedCapacity = 11;

        //Execute
        productManager.changeBasketCapacity(expectedCapacity);

        //Verify
        Assertions.assertEquals(expectedCapacity, productManager.getBasketCapacity());
    }

    @Test
    public void shouldNotChangeBasketCapacity() {
        //Setup
        productManager.orderProduct("Plain");
        productManager.orderProduct("Plain");
        productManager.orderProduct("Plain");
        int expectedCapacity = productManager.getBasketCapacity();
        int newCapacity = 2;

        //Execute
        productManager.changeBasketCapacity(newCapacity);

        //Verify
        Assertions.assertEquals(expectedCapacity, productManager.getBasketCapacity());
    }

    @Test
    public void shouldReturnTotalBasketCost() {
        //Setup
        productManager.orderProduct("Plain");
        productManager.orderProduct("Plain");
        productManager.orderProduct("Plain");
        double expected = 0.39 * 3;

        //Execute
        double total = productManager.getTotal();

        //Verify
        Assertions.assertEquals(expected, total);
    }

    @Test
    public void shouldfillListTest() {
        // Verify
        Assertions.assertFalse(productManager.getInventory().isEmpty());
        Assertions.assertEquals("Onion", productManager.getInventory().get(0).getVariant());
    }
}