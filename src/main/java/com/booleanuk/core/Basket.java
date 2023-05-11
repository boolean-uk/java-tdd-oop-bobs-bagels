package com.booleanuk.core;

import com.booleanuk.core.models.Bagel;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Bagel> shoppingBasket;
    int capacity;

    public Basket() {
        shoppingBasket=new ArrayList<>();
        capacity=3;
    }
}
