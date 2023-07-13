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
        boolean result = productManager.orderBagel("Plain");

        //Verify
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotAddBagelToBasket() {
        //Execute
        boolean result = productManager.orderBagel("Fake");

        //Verify
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldRemoveBagelFromBasket() {
        //Setup
        productManager.orderBagel("Plain");


        //Execute
        boolean result = productManager.removeBagel("Plain");

        //Verify

        Assertions.assertEquals(0,productManager.getBasket().getList().size());
    }

    @Test
    public void shouldNotRemoveFromBasket() {
        //Execute
        boolean result = productManager.removeBagel("Plain");

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
        productManager.orderBagel("Plain");
        productManager.orderBagel("Plain");
        productManager.orderBagel("Plain");
        int expectedCapacity = productManager.getBasket().getCapacity();
        int newCapacity = 2;

        //Execute
        productManager.changeBasketCapacity(newCapacity);

        //Verify
        Assertions.assertEquals(expectedCapacity, productManager.getBasket().getCapacity());
    }
}
