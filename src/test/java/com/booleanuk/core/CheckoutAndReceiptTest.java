package com.booleanuk.core;

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

        Assertions.assertEquals(1.1, b.getTotalCost());

        Receipt receipt = checkout.makeCheckout(b);

        Assertions.assertEquals(b.getTotalCost(), receipt.getTotalCost());
        Assertions.assertEquals(1.1, receipt.getTotalCost());
    }

}
