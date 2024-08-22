package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.ItemFactory;

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));

        basket.increaseBasketSize(10);
        basket.addItemToBasket(ItemFactory.coffeeFactory("COFB"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.coffeeFactory("COFB"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.coffeeFactory("COFB"));

        basket.printOutReceiptOfBasket();

    }
}
