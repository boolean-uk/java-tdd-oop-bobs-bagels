package com.booleanuk.core;

public class Manager {

    Basket basket;
    public Manager() {
        basket = new Basket();
    }

    public void changeBasketCapacity(int newCapacity)
    {
        basket.setBasketCapacity(newCapacity);
    }
}
