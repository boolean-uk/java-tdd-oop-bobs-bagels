package com.booleanuk.core;

public class Checkout {

    public Checkout() {

    }

    public Receipt makeCheckout(Basket b) {
        return new Receipt(b.getProductsNotInDiscount(), b.getDiscounts());
    }

}
