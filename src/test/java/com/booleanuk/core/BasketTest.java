package com.booleanuk.core;

import com.booleanuk.core.enums.BagelType;
import com.booleanuk.core.enums.CoffeeType;
import com.booleanuk.core.enums.FillingType;
import com.booleanuk.core.exceptions.FullBasketException;
import com.booleanuk.core.exceptions.NonExistingProductException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasketTest {
    private Order order;

    @BeforeEach
    public void setUp() throws FullBasketException {
        this.order = new Order();
        Basket basket = this.order.getBasket();
        basket.addProduct(BagelType.ONION);
    }

    @Test
    public void testAddProduct() {
        Basket basket = this.order.getBasket();
        Assertions.assertFalse(basket.getProducts().isEmpty());
    }

    @Test
    public void testRemoveProduct() throws NonExistingProductException {
        Basket basket = this.order.getBasket();
        basket.removeProduct(BagelType.ONION);
        Assertions.assertTrue(basket.getProducts().isEmpty());
    }

    @Test
    public void testIsFull() throws FullBasketException {
        Basket basket = this.order.getBasket();
        basket.addProduct(BagelType.SESAME);
        basket.addProduct(BagelType.EVERYTHING);
        basket.addProduct(BagelType.PLAIN);
        basket.addProduct(BagelType.PLAIN);

        Assertions.assertThrows(FullBasketException.class, () -> {
            basket.addProduct(BagelType.SESAME);
        });
    }

    @Test
    public void testChangeCapacity() {
        Basket basket = this.order.getBasket();
        basket.changeCapacity(10);
        Assertions.assertEquals(10, basket.getCapacity());
    }

    @Test
    public void testRemoveProductThrowException() {
        Basket basket = this.order.getBasket();

        Assertions.assertThrows(NonExistingProductException.class, () -> {
            basket.removeProduct(CoffeeType.BLACK);
        });
    }

    @Test
    public void testGetTotalCost() throws FullBasketException {
        Basket basket = this.order.getBasket();
        basket.addProduct(BagelType.PLAIN);

        System.out.println("Products: " + basket.getProducts());

        double totalCostInBasket = this.order.getTotalCost();
        Assertions.assertEquals(totalCostInBasket, 0.88);
    }
}
