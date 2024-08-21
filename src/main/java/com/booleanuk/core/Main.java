package com.booleanuk.core;

import com.booleanuk.core.products.bagels.EverythingBagel;
import com.booleanuk.core.products.bagels.OnionBagel;
import com.booleanuk.core.products.bagels.PlainBagel;
import com.booleanuk.core.products.bagels.SesameBagel;
import com.booleanuk.core.products.coffees.BlackCoffee;
import com.booleanuk.core.products.coffees.CapuccinoCoffee;
import com.booleanuk.core.products.coffees.WhiteCoffee;
import com.booleanuk.core.products.fillings.HamFilling;
import com.booleanuk.core.products.fillings.SmokedSalmonFilling;

public class Main {
    public static void main(String[] args) {

        Basket basket = new Basket();
        basket.changeCapacity(100, true);
        Checkout checkout = new Checkout();

        basket.addProduct(new OnionBagel());
        basket.addProduct(new OnionBagel());

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

        basket.addProduct(new EverythingBagel());
        basket.addProduct(new EverythingBagel());
        basket.addProduct(new EverythingBagel());
        basket.addProduct(new EverythingBagel());
        basket.addProduct(new EverythingBagel());
        basket.addProduct(new EverythingBagel());

        basket.addProduct(new BlackCoffee());

        basket.addProduct(new HamFilling());
        basket.addProduct(new SmokedSalmonFilling());
        basket.addProduct(new SmokedSalmonFilling());

        Receipt receipt = checkout.makeCheckout(basket);

        for (String s : receipt.getReceiptPrintout()) {
            System.out.println(s);
        }
    }
}
