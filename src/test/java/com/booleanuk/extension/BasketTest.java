package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasketTest {
    private static Inventory inventory;

    @BeforeAll
    static void setup() {
        inventory = new Inventory();
    }

    @Test
    public void testGetTotal_WhenUsingDiscount_ShouldTotalCostOfProductsInTheBasket() {
        //Given
        Basket basket = new Basket(inventory, 20);
        basket.addProduct("BGLO", 6);
        basket.addProduct("BGLP", 12);

        //When
        float result = basket.getTotalCost();

        //Then
        Assertions.assertEquals(result, 2.49F + 3.99F);
    }

    @Test
    public void testGetTotal_WhenMixingDiscountWithNoDiscount_ShouldTotalCostOfProductsInTheBasket() {
        //Given
        Basket basket = new Basket(inventory, 22);
        basket.addProduct("BGLO", 8);
        basket.addProduct("BGLP", 12);
        basket.addProduct("COFW", 2);

        //When
        float result = basket.getTotalCost();

        //Then
        Assertions.assertEquals(result, 2.49F + 3.99F + 0.98F + 1.19F*2);
    }

    @Test
    public void testGetReceipt_WhenBasketIsNotEmpty_ShouldReturnReceipt() {
        //Given
        StringBuilder expected = new StringBuilder();
        LocalDateTime ldt = LocalDateTime.now();

        expected.append("    ~~~ Bob's Bagels ~~~    \n\n")
                .append("    " + ldt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "   \n\n")
                .append("-".repeat(28) + "\n\n")
                .append("Onion Bagel       2   $0.98\n")
                .append("Plain Bagel       12  $3.99\n")
                .append(" ".repeat(20) + "(-$0.69)\n")
                .append("Everything Bagel  6   $2.49\n")
                .append(" ".repeat(20) + "(-$0.45)\n")
                .append("Black Coffee      3   $2.97\n\n")
                .append("-".repeat(28) + "\n\n")
                .append("Total                $10.43\n\n")
                .append("        Thank you\n")
                .append("      for your order! \n");


        Basket basket = new Basket(inventory, 23);
        basket.addProduct("BGLO", 2);
        basket.addProduct("BGLP", 12);
        basket.addProduct("BGLE", 6);
        basket.addProduct("COFB", 3);

        //When
        String result = basket.getReceipt();

        //Then
        Assertions.assertEquals(expected.toString(), result);
    }
}
