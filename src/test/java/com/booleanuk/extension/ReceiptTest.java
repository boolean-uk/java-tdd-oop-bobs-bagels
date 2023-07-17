package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReceiptTest {
    @Test
    public void testPrintingReceipt() {
        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);
        IntStream.range(0, 2).mapToObj(i -> new Bagel(SKU.BGLO)).forEach(basket::addItem);
        IntStream.range(0, 12).mapToObj(i -> new Bagel(SKU.BGLP)).forEach(basket::addItem);
        IntStream.range(0, 6).mapToObj(i -> new Bagel(SKU.BGLE)).forEach(basket::addItem);
        IntStream.range(0, 3).mapToObj(i -> new Coffee(SKU.COFB)).forEach(basket::addItem);

        UUID id = store.placeOrder(basket);
        Order order = store.getOrder(id);

        BigDecimal expectedTotalPrice = BigDecimal.valueOf(9.97);
        assertEquals(expectedTotalPrice, order.getTotalPriceAfterDiscount());

        Receipt receipt = new Receipt(order);
        receipt.printReceipt();
    }

    @Test
    public void testPrintingReceiptTwo() {
        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);
        IntStream.range(0, 16).mapToObj(i -> new Bagel(SKU.BGLO)).forEach(basket::addItem);

        UUID id = store.placeOrder(basket);
        Order order = store.getOrder(id);
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(5.95);
        assertEquals(expectedTotalPrice, order.getTotalPriceAfterDiscount());

        Receipt receipt = new Receipt(order);
        receipt.printReceipt();
    }

    @Test
    public void testPrintingReceiptWithSavings() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);
        IntStream.range(0, 16).mapToObj(i -> new Bagel(SKU.BGLP)).forEach(basket::addItem);

        UUID id = store.placeOrder(basket);
        Order order = store.getOrder(id);

        Receipt receipt = new Receipt(order);
        receipt.printReceipt();
        String result = output.toString();
        assertTrue(result.contains("~~~ Bob's Bagels ~~~"));
        assertTrue(result.contains("------------------------------"));
        assertTrue(result.contains(LocalDate.now().toString()));
        assertTrue(result.contains("Bagel   Plain      16   €6.24"));
        assertTrue(result.contains("(-€0.69)"));
        assertTrue(result.contains("Total                   €5.55"));
        assertTrue(result.contains("You saved a total of €0.69"));
        assertTrue(result.contains("on this shop"));
        assertTrue(result.contains("Thank you"));
        assertTrue(result.contains("for your order!"));
    }
}
