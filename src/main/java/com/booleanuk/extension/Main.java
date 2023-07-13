package com.booleanuk.extension;

import com.booleanuk.extension.product.BagelSandwich;
import com.booleanuk.extension.product.Coffee;

public class Main {
    public static void main(String[] args) {
        var basket = new Basket(6 + 2 + 1);

        for (int i = 0; i < 6; i++) {
            basket.addBagel(new BagelSandwich(BagelSandwich.Bagel.BGLO, BagelSandwich.Filling.FILH));
        }
        basket.addBagel(new BagelSandwich(BagelSandwich.Bagel.BGLS, BagelSandwich.Filling.FILC));
        basket.addCoffee(Coffee.COFL);
        basket.addBagel(new BagelSandwich(BagelSandwich.Bagel.BGLP, BagelSandwich.Filling.values()));

        basket.printReceipt();
    }
}
