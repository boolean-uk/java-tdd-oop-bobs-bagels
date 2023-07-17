package com.booleanuk.extension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.booleanuk.extension.Discount.SIX;
import static com.booleanuk.extension.Discount.TWELVE;

public class Order {
    private final UUID id;
    private final LocalDateTime dateTime;
    private final Basket basket;
    private final List<Discount> discounts;

    public Order(Basket basket) {
        id = UUID.randomUUID();
        dateTime = LocalDateTime.now();
        this.basket = basket;
        discounts = Discount.calculateDiscounts(this);
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Map<Item, Integer> getItems() {
        return basket.getItems();
    }

    public BigDecimal getTotalPrice() {
        return basket.getTotalPrice();
    }

    public BigDecimal getTotalPriceAfterDiscount() {
        BigDecimal totalPriceAfterDiscount = getTotalPrice();

        for (Discount discount : discounts) {
            switch (discount.getType()) {
                case TWELVE_BAGELS -> {
                    SKU sku = discount.getDiscountedItem().getSku();
                    totalPriceAfterDiscount = totalPriceAfterDiscount
                            .subtract(sku.getPrice().multiply(TWELVE))
                            .add(discount.getDiscountedPrice());
                }
                case SIX_BAGELS -> {
                    SKU sku = discount.getDiscountedItem().getSku();
                    totalPriceAfterDiscount = totalPriceAfterDiscount
                            .subtract(sku.getPrice().multiply(SIX))
                            .add(discount.getDiscountedPrice());
                }
                case COFFEE_AND_BAGEL -> {
                    SKU coffeeSKU = discount.getDiscountedItem().getSku();
                    SKU bagelSKU = discount.getRelatedItem().getSku();
                    totalPriceAfterDiscount = totalPriceAfterDiscount
                            .subtract(coffeeSKU.getPrice())
                            .subtract(bagelSKU.getPrice())
                            .add(discount.getDiscountedPrice());
                }
            }
        }
        return totalPriceAfterDiscount;
    }

    public BigDecimal getTotalSavings() {
        return getTotalPrice().subtract(getTotalPriceAfterDiscount());
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
