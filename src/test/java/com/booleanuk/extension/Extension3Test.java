package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.CashRegister;
import com.booleanuk.core.DiscountReceipt;
import com.booleanuk.core.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Extension3Test {

    // Extension 3 requirements tests
    @Test
    public void printingDiscountReceipt(){
        Basket basket = new Basket();
        Receipt receipt = new DiscountReceipt();
        CashRegister register = new CashRegister(basket, receipt);
        basket.setMaxBasketSize(25);

        basket.addItem("BGLS", 6);
        basket.addItem("BGLO", 13);
        basket.addItem("FILC", 1);
        basket.addItem("COFL", 1);
        register.printReceipt();
        String receiptFinal = receipt.getFinalReceipt().toString();

        String receiptExcerpt =
                        " -------------------------------," +
                        "  ," +
                        " Sesame Bagel         6    $2.49," +
                        "                        (-$0.45)," +
                        " Onion Bagel         12    $3.99," +
                        "                        (-$1.89)," +
                        " Coffee & Bagel       1    $1.25," +
                        "                        (-$0.53)," +
                        " Cheese Filling       1    $0.12," +
                        "  ," +
                        " -------------------------------," +
                        " Total                     $7.85," +
                        "  ," +
                        "   You saved a total of  $2.87," +
                        "            on this shop," +
                        "  ,             Thank you," +
                        "          for your order!]";

        Assertions.assertTrue(receiptFinal.contains(receiptExcerpt));
    }
}
