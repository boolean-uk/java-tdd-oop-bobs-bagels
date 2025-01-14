package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class discountTest {

    @Test
    public void testDiscountOnBasketList() {
        Basket basket = new Basket();
        Discount discount = new Discount();

        basket.changeCapasity(30);

        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("BGLO");
        basket.addToBasket("COFB");

        //discount on 12 bagel, discount on 6 bagels, discount on bagel with coffee and one bagel
        Assertions.assertEquals(8.22,discount.discountPrice(basket));
    }
}
