package com.booleanuk.core.user;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.products.Bagel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class UserTest {

    @Test
    public void shouldCreateCustomerProperly() {
        String fullName = "fullname";
        Customer customer = new Customer(fullName);

        Assertions.assertEquals(fullName, customer.getFullName());
    }

    @Test
    public void shouldNewCustomerBasketBeEmpty() {
        String fullName = "fullname";
        Customer customer = new Customer(fullName);

        Assertions.assertEquals(0, customer.getBasket().getProductsAmount());
    }

    @Test
    public void shouldCreateManagerProperly() {
        String fullName = "fullname";
        Manager manager = new Manager(fullName);

        Assertions.assertEquals(fullName, manager.getFullName());
    }

    @Test
    public void shouldManagerChangeTheBasketCapacity() {
        Basket basket = new Basket();
        String fullName = "fullname";
        Manager manager = new Manager(fullName);

        Assertions.assertNotEquals(12, basket.getCapacity());

        boolean changeResult = manager.changeBasketSize(basket, 12);
        Assertions.assertEquals(12, basket.getCapacity());
        Assertions.assertTrue(changeResult);
    }

    @Test
    public void shouldCustomerCheckThePrice() {
        Bagel bagel = new Bagel("BGLO", BigDecimal.valueOf(0.25));
        Customer customer = new Customer("fullname");

        Assertions.assertEquals(bagel.getPrice(), customer.checkProductPrice(bagel));
    }
}
