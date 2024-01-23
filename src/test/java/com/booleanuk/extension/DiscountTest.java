package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Store;
import com.booleanuk.core.StoreInventory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountTest {
    @Test
    public void checkingIfDiscountedPriceIsCorrect() {
        StoreInventory inventory = new StoreInventory();
        Store store = new Store(inventory);
        Basket basket = new Basket();
        Discount discount = new Discount(basket, store);

        basket.modifyCapacity(30);

        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLO");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "BGLP");
        store.addToBasket(basket, "COFB");
        store.addToBasket(basket, "COFB");

        Assertions.assertEquals(10.48, discount.discountTotalCost());
    }
}
