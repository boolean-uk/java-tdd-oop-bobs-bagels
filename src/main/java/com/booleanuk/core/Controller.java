package com.booleanuk.core;

import java.util.HashMap;

public class Controller {
    private View view;
    private HashMap<String, Float> prices;
    private Basket basket;
    private int basketSize;

    public Controller(View view, HashMap<String, Float> prices, Basket basket, int basketSize) {
        this.view = view;
        this.prices = prices;
        this.basket = basket;
        this.basketSize = basketSize;
    }

    public static void main(String[] args) {

    }
}
