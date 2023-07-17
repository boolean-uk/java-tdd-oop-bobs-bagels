package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.IntStream;

import static com.booleanuk.extension.SKU.*;

public class Main {
    public static void main(String[] args) {

        Store store = new Store();
        Basket basket = new Basket();
        store.addBasket(basket);
        IntStream.range(0, 16).mapToObj(i -> new Bagel(SKU.BGLP)).forEach(basket::addItem);

        UUID id = store.placeOrder(basket);
        Order order = store.getOrder(id);

        BigDecimal expectedTotalPrice = BigDecimal.valueOf(10.43);
        Receipt receipt = new Receipt(order);
        receipt.printReceipt();

    }
}
