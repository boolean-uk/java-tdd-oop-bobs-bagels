package com.booleanuk.core;

public class Manager {

    public boolean changeBasketCapacity(int newCapacity)
    {
        if (newCapacity>Basket.getCapacity()){
            Basket.setBasketCapacity(newCapacity);
            return true;
        }
        return false;
    }
}
