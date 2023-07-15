package com.booleanuk.extension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Order {
    private static final BigDecimal SIX = BigDecimal.valueOf(6);
    private static final BigDecimal TWELVE = BigDecimal.valueOf(12);

    private final UUID id;
    private final LocalDateTime orderDate;
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
        BigDecimal totalPriceAfterDiscount = getTotalPrice();
        List<Discount> discounts = Discount.calculateDiscounts(this);

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

//    public BigDecimal getTotalPriceAfterDiscount() {
//        BigDecimal priceAfterDiscount = getTotalPrice();
//        for (SKU bagelSKU : getSKUInBasketFromCheapest("Bagel")) {
//            int tempBagelCount = getItemQuantity(bagelSKU);
//            BigDecimal per12BagelCount = BigDecimal.valueOf(tempBagelCount / 12);
//            BigDecimal per6BagelCount = BigDecimal.valueOf((tempBagelCount % 12) / 6);
//            BigDecimal per1BagelPrice = bagelSKU.getPrice();
//            priceAfterDiscount = priceAfterDiscount
//                    .subtract(per1BagelPrice.multiply(per12BagelCount.multiply(TWELVE)))
//                    .subtract(per1BagelPrice.multiply(per6BagelCount.multiply(SIX)))
//                    .add(per12BagelCount.multiply(PRICE_FOR_12_BAGELS))
//                    .add(per6BagelCount.multiply(PRICE_FOR_6_BAGELS));
//        }
//        return priceAfterDiscount;
//    }

    private List<SKU> getSKUInBasketFromCheapest(String itemName) {
        return basket.getItems().keySet().stream()
                .filter(el -> el.getName().equals(itemName))
                .map(Item::getSku)
                .sorted(Comparator.comparing(SKU::getPrice))
                .toList();
    }

    public int getItemQuantity(SKU sku) {
        Item item = getItems().keySet().stream()
                .filter(key -> key.getSku().equals(sku))
                .findFirst().orElse(null);
        return item == null ? 0 : getItems().get(item);
    }
}
