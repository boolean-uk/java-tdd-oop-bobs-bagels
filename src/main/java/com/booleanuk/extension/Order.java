package com.booleanuk.extension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.booleanuk.extension.SKU.*;

public class Order {
    private static final BigDecimal PRICE_FOR_6_BAGELS = BigDecimal.valueOf(2.49);
    private static final BigDecimal PRICE_FOR_12_BAGELS = BigDecimal.valueOf(3.99);
    private static final BigDecimal PRICE_FOR_BAGEL_AND_COFFEE = BigDecimal.valueOf(1.25);
    private static final BigDecimal SIX = BigDecimal.valueOf(6);
    private static final BigDecimal TWELVE = BigDecimal.valueOf(12);

    private UUID id;
    private LocalDateTime orderDate;
    private final Basket basket;

    public Order(Basket basket) {
        id = UUID.randomUUID();
        orderDate = LocalDateTime.now();
        this.basket = basket;
    }

    public UUID getId() {
        return id;
    }

    public Map<Item, Integer> getItems() {
        return basket.getItems();
    }

    public BigDecimal getTotalPrice() {
        return basket.getTotalPrice();
    }

    public BigDecimal getTotalPriceAfterDiscount() {
        BigDecimal priceAfterDiscount = getTotalPrice();
        for (SKU bagelSKU : getSKUInBasket("Bagel")) {
            int tempBagelCount = getItemQuantity(bagelSKU);
            BigDecimal per12BagelCount = BigDecimal.valueOf(tempBagelCount / 12);
            BigDecimal per6BagelCount = BigDecimal.valueOf((tempBagelCount % 12) / 6);
            BigDecimal per1BagelPrice = bagelSKU.getPrice();
            priceAfterDiscount = priceAfterDiscount
                    .subtract(per1BagelPrice.multiply(per12BagelCount.multiply(TWELVE)))
                    .subtract(per1BagelPrice.multiply(per6BagelCount.multiply(SIX)))
                    .add(per12BagelCount.multiply(PRICE_FOR_12_BAGELS))
                    .add(per6BagelCount.multiply(PRICE_FOR_6_BAGELS));
        }
        return priceAfterDiscount;
    }

    private List<SKU> getSKUInBasket(String itemName) {
        return basket.getItems().keySet().stream()
                .filter(el -> el.getName().equals(itemName))
                .map(Item::getSku)
                .toList();
    }

    public int getItemQuantity(SKU sku) {
        Item item = getItems().keySet().stream()
                .filter(key -> key.getSku().equals(sku))
                .findFirst().orElse(null);
        return item == null ? 0 : getItems().get(item);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", basket=" + basket +
                '}';
    }
}
