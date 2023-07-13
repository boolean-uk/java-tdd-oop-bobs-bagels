package com.booleanuk.extension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import static com.booleanuk.extension.SKU.*;

public class Order {
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
        BigDecimal priceBeforeDiscount = getTotalPrice();
        BigDecimal priceAfterDiscount = priceBeforeDiscount;
        int bgloCount = getItemQuantity(BGLO);
        int bgloNotDiscounted = 0;
        int bglpCount = getItemQuantity(BGLP);
        int bglpNotDiscounted = 0;
        int bgleCount = getItemQuantity(BGLE);
        int bgleNotDiscounted = 0;
        int bglsCount = getItemQuantity(BGLS);
        int cofbCount = getItemQuantity(COFB);

        if (bgloCount % 6 >= 1) {
            BigDecimal discountPer6Bglo = BigDecimal.valueOf(0.45);
            priceAfterDiscount = priceBeforeDiscount.subtract((BigDecimal.valueOf(bgleCount / 6).multiply(discountPer6Bglo)));
            bgleNotDiscounted = bgleCount - (bgleCount / 6);
        }
        if (bglpCount % 12 >= 1) {
            BigDecimal discountPer12Bglp = BigDecimal.valueOf(0.69);
            priceAfterDiscount = priceBeforeDiscount.subtract((BigDecimal.valueOf(bgleCount / 12).multiply(discountPer12Bglp)));
            bglpNotDiscounted = bglpCount - (bglpCount / 12);
        }
        if (bgleCount % 6 >= 1) {
            BigDecimal discountPer6Bgle = BigDecimal.valueOf(0.45);
            priceAfterDiscount = priceBeforeDiscount.subtract((BigDecimal.valueOf(bgleCount / 6).multiply(discountPer6Bgle)));
            bgleNotDiscounted = bgleCount - (bgleCount / 6);
        }

        int bglNotDiscounted = bgloNotDiscounted + bgleNotDiscounted + bglsCount;

        if (cofbCount > 0) {
            int tempCofbCount = cofbCount;
            if (bglNotDiscounted > 0) {
                int multiplier = Math.max(bglNotDiscounted, tempCofbCount);
                tempCofbCount -= multiplier;
                BigDecimal discountPerCofbBgl = BigDecimal.valueOf(0.23);
                priceAfterDiscount = priceBeforeDiscount.subtract(discountPerCofbBgl.multiply(BigDecimal.valueOf(multiplier)));
            }
            if (bglpNotDiscounted > 0 && tempCofbCount > 0) {
                int multiplier = Math.max(bglpNotDiscounted, tempCofbCount);
                BigDecimal discountPerCofbBglp = BigDecimal.valueOf(0.13);
                priceAfterDiscount = priceBeforeDiscount.subtract(discountPerCofbBglp.multiply(BigDecimal.valueOf(multiplier)));
            }
        }

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Entry<Item, Integer> entry : basket.getItems().entrySet()) {
            totalPrice = totalPrice.add(entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
        }

        return priceAfterDiscount;
    }

    public int getItemQuantity(SKU sku) {
        Item item = basket.getItems().keySet().stream()
                .filter(key -> key.getSku().equals(sku))
                .findFirst().orElse(null);
        return item == null ? 0 : basket.getItems().get(item);
    }
}
