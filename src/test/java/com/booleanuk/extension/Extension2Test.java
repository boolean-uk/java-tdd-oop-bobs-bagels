package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.CashRegister;
import com.booleanuk.core.NormalReceipt;
import com.booleanuk.core.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Extension2Test {

    // Extension 2 requirements tests
    @Test
    public void printingNormalReceipt(){
        Basket basket = new Basket();
        Receipt receipt = new NormalReceipt();
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
                        " Onion Bagel         12    $3.99," +
                        " Coffee & Bagel       1    $1.25," +
                        " Cheese Filling       1    $0.12," +
                        "  ," +
                        " -------------------------------," +
                        " Total                     $7.85," +
                        "  ," +
                        "             Thank you," +
                        "          for your order!";

        Assertions.assertTrue(receiptFinal.contains(receiptExcerpt));
    }
}
