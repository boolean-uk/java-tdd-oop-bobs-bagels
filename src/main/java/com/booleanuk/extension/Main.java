package com.booleanuk.extension;

import com.booleanuk.extension.BagelType;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.setCapacity(24);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        System.out.println(basket.getTotalPrice());
    }
}
