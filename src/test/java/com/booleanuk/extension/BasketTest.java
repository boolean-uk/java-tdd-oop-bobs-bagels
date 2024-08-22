package com.booleanuk.extension;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.ItemFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    public void addTenItemsToBasket(Basket basket) {
        Bagel b1 = ItemFactory.bagelFactory("BGLO");
        Bagel b2 = ItemFactory.bagelFactory("BGLO");
        Bagel b3 = ItemFactory.bagelFactory("BGLO");
        Bagel b4 = ItemFactory.bagelFactory("BGLO");
        Bagel b5 = ItemFactory.bagelFactory("BGLO");
        Bagel b6 = ItemFactory.bagelFactory("BGLO");
        Bagel b7 = ItemFactory.bagelFactory("BGLO");
        Bagel b8 = ItemFactory.bagelFactory("BGLO");
        Bagel b9 = ItemFactory.bagelFactory("BGLO");
        Bagel b10 = ItemFactory.bagelFactory("BGLO");
        basket.addItemToBasket(b1);
        basket.addItemToBasket(b2);
        basket.addItemToBasket(b3);
        basket.addItemToBasket(b4);
        basket.addItemToBasket(b5);
        basket.addItemToBasket(b6);
        basket.addItemToBasket(b7);
        basket.addItemToBasket(b8);
        basket.addItemToBasket(b9);
        basket.addItemToBasket(b10);
    }

    @Test
    public void add6BagelsForDiscountTest() {
        Basket basket = new Basket();

        Bagel b1 = ItemFactory.bagelFactory("BGLO");
        Bagel b2 = ItemFactory.bagelFactory("BGLO");
        Bagel b3 = ItemFactory.bagelFactory("BGLO");
        Bagel b4 = ItemFactory.bagelFactory("BGLO");
        Bagel b5 = ItemFactory.bagelFactory("BGLO");
        Bagel b6 = ItemFactory.bagelFactory("BGLO");
        basket.addItemToBasket(b1);
        basket.addItemToBasket(b2);
        basket.addItemToBasket(b3);
        basket.addItemToBasket(b4);
        basket.addItemToBasket(b5);
        basket.addItemToBasket(b6);

        Assertions.assertEquals(2.49f, basket.countTotalValueOfItems());
    }

    @Test
    public void add10BagelsForDiscountTest() {
        Basket basket = new Basket();
        addTenItemsToBasket(basket);

        Assertions.assertEquals(4.45f, basket.countTotalValueOfItems());
    }

    @Test
    public void add12BagelsForDiscountTest() {
        Basket basket = new Basket();
        addTenItemsToBasket(basket);

        basket.increaseBasketSize(2);

        basket.addItemToBasket(new Bagel("BGLO"));
        basket.addItemToBasket(new Bagel("BGLO"));

        Assertions.assertEquals(3.99f, basket.countTotalValueOfItems());
    }

    @Test
    public void add18BagelsForDiscountTest() {
        Basket basket = new Basket();
        addTenItemsToBasket(basket);
        basket.increaseBasketSize(8);

        basket.addItemToBasket(new Bagel("BGLO"));
        basket.addItemToBasket(new Bagel("BGLO"));
        basket.addItemToBasket(new Bagel("BGLO"));
        basket.addItemToBasket(new Bagel("BGLO"));
        basket.addItemToBasket(new Bagel("BGLO"));
        basket.addItemToBasket(new Bagel("BGLO"));
        basket.addItemToBasket(new Bagel("BGLO"));
        basket.addItemToBasket(new Bagel("BGLO"));

        Assertions.assertEquals(6.48f, basket.countTotalValueOfItems());
    }

    @Test
    public void addBagelAndCoffeeDiscountTest() {
        Basket basket = new Basket();
        Bagel bagel = ItemFactory.bagelFactory("BGLO");
        Coffee coffee = ItemFactory.coffeeFactory("COFB");

        basket.addItemToBasket(bagel);
        basket.addItemToBasket(coffee);

        Assertions.assertEquals(1.25f, basket.countTotalValueOfItems());
    }

    @Test
    public void addBagelAndCoffeeAnd12BagelsTest() {
        Basket basket = new Basket();
        basket.increaseBasketSize(6);
        addTenItemsToBasket(basket);

        Bagel bagel = ItemFactory.bagelFactory("BGLO");
        Coffee coffee = ItemFactory.coffeeFactory("COFB");

        basket.addItemToBasket(bagel);
        basket.addItemToBasket(coffee);

        Assertions.assertEquals(5.7f, basket.countTotalValueOfItems());

    }

    @Test
    public void add6BagelsWith3FillingTest() {
        Basket basket = new Basket();
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelWithFillingFactory("BGLO", "FILS"));
        basket.addItemToBasket(ItemFactory.bagelWithFillingFactory("BGLO", "FILX"));
        basket.addItemToBasket(ItemFactory.bagelWithFillingFactory("BGLO", "FILB"));

        Assertions.assertEquals(2.85f, basket.countTotalValueOfItems());
    }

    @Test
    public void add6bagelsWith3FillingAnd3CoffeeTest() {
        Basket basket = new Basket();
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelFactory("BGLO"));
        basket.addItemToBasket(ItemFactory.bagelWithFillingFactory("BGLO", "FILX"));
        basket.addItemToBasket(ItemFactory.bagelWithFillingFactory("BGLO", "FILS"));
        basket.addItemToBasket(ItemFactory.bagelWithFillingFactory("BGLO", "FILB"));
        basket.increaseBasketSize(10);
        basket.addItemToBasket(ItemFactory.coffeeFactory("COFW"));
        basket.addItemToBasket(ItemFactory.coffeeFactory("COFC"));
        basket.addItemToBasket(ItemFactory.coffeeFactory("COFB"));
        Assertions.assertEquals(6.32, basket.printOutReceiptOfBasket(), 0.001);

    }
}
