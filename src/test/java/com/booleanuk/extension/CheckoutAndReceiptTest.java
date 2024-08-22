package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Checkout;
import com.booleanuk.core.Receipt;
import com.booleanuk.core.products.bagels.*;
import com.booleanuk.core.products.fillings.HamFilling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutAndReceiptTest {

    public CheckoutAndReceiptTest() {
    }

    @Test
    public void testGetReceiptFromPurchase() {
        Checkout checkout = new Checkout();

        Basket b = new Basket();

        Bagel ob = new OnionBagel(); // 0.49
        Bagel sb = new SesameBagel(); // 0.49
        ob.setFilling(new HamFilling()); // Ham = 0.12, total=1.1

        b.addProduct(ob);
        b.addProduct(sb);

        Assertions.assertEquals(1.1, b.getTotalCost());

        Receipt receipt = checkout.makeCheckout(b);

        Assertions.assertEquals(b.getTotalCost(), receipt.getTotalCost());
        Assertions.assertEquals(1.1, receipt.getTotalCost());
    }

    @Test
    public void testGetReceiptAndDiscount() {
        Checkout checkout = new Checkout();

        Basket basket = new Basket();
        basket.changeCapacity(100, true);

        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel()); // 3.99 discount

        Receipt r = checkout.makeCheckout(basket);

        Assertions.assertEquals(3.99, r.getTotalCost());

    }

    @Test
    public void testGetReceiptAndDiscountTotalSaved() {
        Checkout checkout = new Checkout();

        Basket basket = new Basket();
        basket.changeCapacity(100, true);

        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());
        basket.addProduct(new PlainBagel());

        Receipt r = checkout.makeCheckout(basket);

        // 3.99 discount total cost. So before discount it is 0.39 * 12 = 4.68 so total saved is 0.69.
        Assertions.assertEquals(3.99, r.getTotalCost(), 0.001);
        Assertions.assertEquals(0.69, r.getTotalSaved(), 0.001);
    }

}
