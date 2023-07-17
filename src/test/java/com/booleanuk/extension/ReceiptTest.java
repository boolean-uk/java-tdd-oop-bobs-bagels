package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptTest {

    @Test
    void shouldReturnReceiptString() {
        Basket basket = new Basket(100);
        Bagel BGLO = new Bagel("BGLO", BigDecimal.valueOf(0.49), "Onion");
        Filling FILE = new Filling("FILE", BigDecimal.valueOf(3.00), "Egg");
        BGLO.setFillings(List.of(FILE, FILE));
        Bagel BGLP = new Bagel("BGLP", BigDecimal.valueOf(0.39), "Plain");
        basket.add(BGLO);
        basket.add(BGLP);
        basket.add(BGLP);
        Receipt receipt = new Receipt(basket);
        String actual = receipt.printReceipt();
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = time.format(formatter);
        String expected = String.format("""
                    ~~~ Bob's Bagels ~~~
                                
                    %s
                                
                ----------------------------
                                
                Onion Bagel         1  £0.49
                Egg Filling          2  £6.0
                Plain Bagel         2  £0.78
                
                ----------------------------
                                
                Total                  £7.27
                                
                 You saved a total of £0.0
                        on this shop
                                
                         Thank you
                      for your order!""", formattedTime);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnReceiptStringWithDiscounts() {
        Basket basket = new Basket(100);
        Bagel BGLO = new Bagel("BGLO", BigDecimal.valueOf(0.49), "Onion");
        Bagel BGLP = new Bagel("BGLP", BigDecimal.valueOf(0.39), "Plain");
        Coffee COFB = new Coffee("COFB", BigDecimal.valueOf(0.99), "Black");

        for(int i = 0; i < 6; i++)
            basket.add(BGLO);

        basket.add(COFB);
        basket.add(BGLP);

        Receipt receipt = new Receipt(basket);
        String actual = receipt.printReceipt();
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = time.format(formatter);
        String expected = String.format("""
                    ~~~ Bob's Bagels ~~~
                                
                    %s
                                
                ----------------------------
                                
                Onion Bagel         6  £2.94
                                     (-£0.45)
                Black Coffee        1  £0.99
                                     (-£0.13)
                Plain Bagel         1  £0.39
                                
                ----------------------------
                                
                Total                  £3.74
                                
                 You saved a total of £0.58
                        on this shop
                                
                         Thank you
                      for your order!""", formattedTime);

        Assertions.assertEquals(expected, actual);
    }
}
