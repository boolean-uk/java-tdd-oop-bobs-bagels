package com.booleanuk.core.user;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.products.Bagel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void shouldCreateCustomerProperly() {
        String fullName = "fullname";
        Customer customer1 = new Customer(fullName);
        Assertions.assertEquals(fullName, customer1.getFullName());
    }

    @Test
    public void shouldNewCustomerBasketBeEmpty() {
        String fullName = "fullname";
        Customer customer1 = new Customer(fullName);
        Assertions.assertEquals(0, customer1.getBasket().getProductsAmount());
    }

    @Test
    public void shouldCreateManagerProperly() {
        String fullName = "fullname";
        Manager manager1 = new Manager(fullName);
        Assertions.assertEquals(fullName, manager1.getFullName());
    }

    @Test
    public void shouldManagerChangeTheBasketCapacity() {
        Basket basket = new Basket();
        String fullName = "Fullname";
        Manager manager1 = new Manager(fullName);
        Assertions.assertNotEquals(12, basket.getCapacity);
        manager1.changeBasketSize(basket, 12);
        Assertions.assertEquals(12, basket.getCapacity);
        //add getter to Basket
    }

    @Test
    public void shouldCustomerCheckThePrice() {
        Bagel bagel = new Bagel("BGLO", 0.25);
        Customer customer1 = new Customer("fullname");
        Assertions.assertEquals(bagel.getPrice(), customer1.checkProductPrice(bagel));
    }


}
