package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountHandlerTest {

    @Test
    public void applyDiscount6Bagels(){
        Basket basket = new Basket();
        basket.changeCapacity(20);
        for (int i = 0; i < 6; i++) {
            basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        }
        Assertions.assertEquals(2.49, basket.calculateTotal());
    }
    @Test
    public void dontApplyDiscountIf6PlainBagels(){
        Basket basket = new Basket();
        basket.changeCapacity(20);
        for (int i = 0; i < 6; i++) {
            basket.add(new Product("Bagel", 0.39, "BGLP", "Plain"));
        }
        Assertions.assertEquals(2.34, basket.calculateTotal());
    }

    @Test
    public void applyDiscount6BagelsAndOtherProducts(){
        Basket basket = new Basket();
        basket.changeCapacity(20);
        for (int i = 0; i < 6; i++) {
            basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        }
        basket.add(new Product("Coffee", 0.99, "COFW", "White"));
        basket.add(new Product("Coffee", 0.99, "COFW", "White"));
        basket.add(new Product("Coffee", 0.99, "COFW", "White"));
        Assertions.assertEquals(5.46, basket.calculateTotal());
    }

    @Test
    public void testExampleExtension1(){
        Basket basket = new Basket();
        basket.changeCapacity(30);
        basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        for (int i = 0; i < 12; i++) {
            System.out.println("Bagel: " + i);
            basket.add(new Product("Bagel", 0.39, "BGLP", "Plain"));
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("Bagel: " + i);
            basket.add(new Product("Bagel", 0.49, "BGLE", "Everything"));
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Coffee: " + i);
            basket.add(new Product("Coffee", 0.99, "COFB", "Black"));
        }
        // Accounts for coffee + bagel combo, it doesnt in the example
        Assertions.assertEquals(9.97, basket.calculateTotal());
    }
    @Test
    public void testExampleExtension2(){
        Basket basket = new Basket();
        basket.changeCapacity(20);
        for (int i = 0; i < 16; i++) {
            basket.add(new Product("Bagel", 0.39, "BGLP", "Plain"));
        }
        Assertions.assertEquals(5.55, basket.calculateTotal());
    }

    @Test
    public void applyDiscount12Bagels(){
        Basket basket = new Basket();
        basket.changeCapacity(20);
        for (int i = 0; i < 12; i++) {
            basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        }
        Assertions.assertEquals(3.99, basket.calculateTotal());
    }

    @Test public void applyDiscount12AndAdd4WithNoDiscount(){
        Basket basket = new Basket();
        basket.changeCapacity(20);
        for (int i = 0; i < 16; i++) {
            basket.add(new Product("Bagel", 0.49, "BGLO", "Onion"));
        }
        Assertions.assertEquals(5.95, basket.calculateTotal());
    }
}
