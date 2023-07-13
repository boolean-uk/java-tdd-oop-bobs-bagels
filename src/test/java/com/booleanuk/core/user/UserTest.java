package com.booleanuk.core.user;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.products.Bagel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        String fullName = "Fullname";
        Manager manager = new Manager(fullName);

        Assertions.assertNotEquals(12, basket.getCapacity());

        manager.changeBasketSize(basket, 12);
        Assertions.assertEquals(12, basket.getCapacity());
    }

    @Test
    public void shouldCustomerCheckThePrice() {
        Bagel bagel = new Bagel("BGLO", 0.25);
        Customer customer = new Customer("fullname");

        Assertions.assertEquals(bagel.getPrice(), customer.checkProductPrice(bagel));
    }
}
