package com.booleanuk.core.user;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.products.Product;

public class Customer extends User {
    private Basket basket;

    public Customer(String fullName)
    {
        super(fullName);
        basket = new Basket();
    }



    public double checkProductPrice(Product product) {
        return 0;
    }

    public Basket getBasket() {
        return basket;
    }


}
