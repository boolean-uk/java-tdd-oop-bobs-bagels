package com.booleanuk.extension;

import com.booleanuk.core.basket.Basket;
import com.booleanuk.core.basket.BasketSummary;
import com.booleanuk.core.products.Bagel;
import com.booleanuk.core.products.BagelVariant;
import com.booleanuk.core.products.Coffee;
import com.booleanuk.core.products.CoffeeVariant;
import com.booleanuk.core.products.Filling;
import com.booleanuk.core.products.FillingVariant;
import com.booleanuk.core.store.Discount;
import com.booleanuk.core.store.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BasketTest {

    Store store = Store.getInstance();

    @Test
    public void shouldReturnFalseWhenProductIsNotInStore() {

        Bagel bagel = new Bagel("BGLO", BigDecimal.valueOf(0.99), BagelVariant.Plain);

        Assertions.assertFalse(store.isProductAvailable(bagel));
    }

    @Test
    public void shouldDiscountOnSingleBagels() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);

        Discount discountBagelOnion = new Discount(bagelOnion, 6, BigDecimal.valueOf(2.49));

        store.addDiscount(discountBagelOnion);

        Basket basket = new Basket(6);
        boolean addingResult = basket.addProduct(bagelOnion, 6);

        Assertions.assertTrue(addingResult);
        Assertions.assertEquals(BigDecimal.valueOf(2.49), basket.summarizeBasket().total());
    }

    @Test
    public void shouldDiscountOnMultipleBagels() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);
        Bagel bagelPlain = new Bagel("BGLP", BigDecimal.valueOf(0.39), BagelVariant.Plain);

        Discount discountBagelPlain = new Discount(bagelPlain, 12, BigDecimal.valueOf(3.99));
        Discount discountBagelOnion = new Discount(bagelOnion, 6, BigDecimal.valueOf(2.49));

        store.addDiscount(discountBagelPlain);
        store.addDiscount(discountBagelOnion);

        Basket basket = new Basket(18);
        basket.addProduct(bagelOnion, 6);
        basket.addProduct(bagelPlain, 12);

        Assertions.assertEquals(BigDecimal.valueOf(2.49).add(BigDecimal.valueOf(3.99)), basket.summarizeBasket().total());

    }

    @Test
    public void shouldDiscountBagelWithCoffee() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);
        Coffee coffeeBlack = new Coffee("COFB", BigDecimal.valueOf(0.99), CoffeeVariant.Black);

        Discount discount = new Discount(coffeeBlack, 1, BigDecimal.valueOf(1.25), bagelOnion);

        store.addDiscount(discount);

        Basket basket = new Basket(2);
        basket.addProduct(bagelOnion);
        basket.addProduct(coffeeBlack);

        Assertions.assertEquals(BigDecimal.valueOf(1.25), basket.summarizeBasket().total());
    }

    @Test
    public void shouldCalculateTripleDiscountsBagelsWithEighteenBagels() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);

        Discount discountBagelOnion = new Discount(bagelOnion, 6, BigDecimal.valueOf(2.49));

        store.setAvailableDiscounts(new ArrayList<>());
        store.addDiscount(discountBagelOnion);

        Basket basket = new Basket(18);
        basket.addProduct(bagelOnion, 18);

        Assertions.assertEquals(BigDecimal.valueOf(2.49).multiply(BigDecimal.valueOf(3)), basket.summarizeBasket().total());
    }

    @Test
    public void shouldCalculateDoubleDiscountsBagelsWithSeventeenBagels() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);

        Discount discountBagelOnion = new Discount(bagelOnion, 6, BigDecimal.valueOf(2.49));

        store.setAvailableDiscounts(new ArrayList<>());
        store.addDiscount(discountBagelOnion);

        Basket basket = new Basket(17);
        basket.addProduct(bagelOnion, 17);

        Assertions.assertEquals(BigDecimal.valueOf(2.49).multiply(BigDecimal.valueOf(2)).add(BigDecimal.valueOf(5).multiply(BigDecimal.valueOf(0.49))), basket.summarizeBasket().total());
    }

    @Test
    public void shouldDiscountOnMultipleBagelsWithCoffee() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);
        Bagel bagelPlain = new Bagel("BGLP", BigDecimal.valueOf(0.39), BagelVariant.Plain);
        Bagel bagelEverything = new Bagel("BGLE", BigDecimal.valueOf(0.49), BagelVariant.Everything);
        Coffee coffeeBlack = new Coffee("COFB", BigDecimal.valueOf(0.99), CoffeeVariant.Black);

        Discount discountCoffeeBlack = new Discount(coffeeBlack, 1, BigDecimal.valueOf(1.25), bagelEverything);
        Discount discountBagelPlain = new Discount(bagelPlain, 12, BigDecimal.valueOf(3.99));
        Discount discountBagelOnion = new Discount(bagelOnion, 6, BigDecimal.valueOf(2.49));

        store.setAvailableDiscounts(new ArrayList<>());
        store.addDiscount(discountBagelPlain);
        store.addDiscount(discountBagelOnion);
        store.addDiscount(discountCoffeeBlack);

        Basket basket = new Basket(19);
        basket.addProduct(bagelOnion, 6);
        basket.addProduct(bagelPlain, 12);
        basket.addProduct(coffeeBlack);
        BasketSummary total = basket.summarizeBasket();
        Assertions.assertEquals(BigDecimal.valueOf(2.49).add(BigDecimal.valueOf(3.99).add(BigDecimal.valueOf(1.25))), total.total());
    }

    @Test
    public void shouldReturnHowMuchMoneySavedOnDiscount() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);
        Bagel bagelPlain = new Bagel("BGLP", BigDecimal.valueOf(0.39), BagelVariant.Plain);
        Bagel bagelEverything = new Bagel("BGLE", BigDecimal.valueOf(0.49), BagelVariant.Everything);
        Coffee coffeeBlack = new Coffee("COFB", BigDecimal.valueOf(0.99), CoffeeVariant.Black);

        Discount discountCoffeeBlack = new Discount(coffeeBlack, 1, BigDecimal.valueOf(1.25), bagelEverything);
        Discount discountBagelPlain = new Discount(bagelPlain, 12, BigDecimal.valueOf(3.99));
        Discount discountBagelOnion = new Discount(bagelOnion, 6, BigDecimal.valueOf(2.49));

        store.setAvailableDiscounts(new ArrayList<>());
        store.addDiscount(discountBagelPlain);
        store.addDiscount(discountBagelOnion);
        store.addDiscount(discountCoffeeBlack);

        Basket basket = new Basket(19);
        basket.addProduct(bagelOnion, 6);
        basket.addProduct(bagelPlain, 12);
        basket.addProduct(coffeeBlack);
        BasketSummary total = basket.summarizeBasket();

        Assertions.assertEquals(BigDecimal.valueOf(0.45), total.discounts().get(bagelOnion));
        Assertions.assertEquals(BigDecimal.valueOf(0.69), total.discounts().get(bagelPlain));
    }

    @Test
    public void shouldDiscountOnMultipleBagelsWithFillings() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);
        Bagel bagelPlain = new Bagel("BGLP", BigDecimal.valueOf(0.39), BagelVariant.Plain);
        Bagel bagelEverything = new Bagel("BGLE", BigDecimal.valueOf(0.49), BagelVariant.Everything);

        Discount discountBagelPlain = new Discount(bagelPlain, 12, BigDecimal.valueOf(3.99));
        Discount discountBagelOnion = new Discount(bagelOnion, 6, BigDecimal.valueOf(2.49));

        store.setAvailableDiscounts(new ArrayList<>());
        store.addDiscount(discountBagelPlain);
        store.addDiscount(discountBagelOnion);

        bagelPlain.addFilling(new Filling("FILL", BigDecimal.valueOf(0.12), FillingVariant.Egg));

        Basket basket = new Basket(19);
        basket.addProduct(bagelOnion, 6);
        basket.addProduct(bagelPlain, 12);
        basket.addProduct(bagelEverything);
        BasketSummary total = basket.summarizeBasket();

        Assertions.assertEquals(BigDecimal.valueOf(2.49 + 3.99 + 12 * 0.12 + 0.49), total.total());
    }
}
