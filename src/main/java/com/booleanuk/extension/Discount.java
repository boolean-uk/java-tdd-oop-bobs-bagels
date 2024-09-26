package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.booleanuk.extension.Discount.DiscountType.*;

/*
    Implemented discount policy is as follows:
    1. only bagels of the same SKU are counted for "6 for..." and "12 for..." discount;
    2. "12 for..." discount is calculated first, then for the remainder may be applied "6 for..." (if < 12),
        and then "Coffee and Bagel" discount respectively (only one discount applies for a given item).
    3. "Coffee and bagel" discount is calculated starting from the cheapest coffee and bagel.
    4. Savings on "coffee and bagel" are calculated as follows:
        4.1. if coffee costs more than black coffee, savings = original price - cost of black coffee
        4.2. the remaining savings are assigned to the bagel discount.
*/

public class Discount {
    public static final BigDecimal SIX = BigDecimal.valueOf(6);
    public static final BigDecimal TWELVE = BigDecimal.valueOf(12);

    private final DiscountType type;
    private final Item discountedItem;
    private final Item relatedItem;
    private final BigDecimal discountedPrice;
    private BigDecimal discountedItemSavings;
    private BigDecimal relatedItemSavings;

    public Discount(DiscountType type, Item discountedItem) {
        this.type = type;
        this.discountedItem = discountedItem;
        relatedItem = null;
        discountedPrice = type.getPrice();
        calculateSavings();
    }

    public Discount(DiscountType type, Item discountedItem, Item relatedItem) {
        this.type = type;
        this.discountedItem = discountedItem;
        this.relatedItem = relatedItem;
        discountedPrice = type.getPrice();
        calculateSavings();
    }

    private void calculateSavings() {
        switch (this.type) {
            case TWELVE_BAGELS -> {
                discountedItemSavings = discountedItem.getPrice().multiply(TWELVE).subtract(discountedPrice);
            }
            case SIX_BAGELS -> {
                discountedItemSavings = discountedItem.getPrice().multiply(SIX).subtract(discountedPrice);
            }
            case COFFEE_AND_BAGEL -> {
                if (discountedItem.getPrice().compareTo(SKU.COFB.getPrice()) > 0) {
                    discountedItemSavings = discountedItem.getPrice().subtract(SKU.COFB.getPrice());
                } else {
                    discountedItemSavings = BigDecimal.ZERO;
                }
                relatedItemSavings = discountedItem.getPrice()
                        .add(relatedItem.getPrice())
                        .subtract(discountedPrice)
                        .subtract(discountedItemSavings);
            }
        }
    }

    public static List<Discount> calculateDiscounts(Order order) {
        List<Discount> discounts = new ArrayList<>();
        LinkedHashMap<Coffee, Integer> coffees = getSortedByPrice(order, Coffee.class);
        LinkedHashMap<Bagel, Integer> bagels = getSortedByPrice(order, Bagel.class);
        for (Map.Entry<Bagel, Integer> bagel : bagels.entrySet()) {
            int count = bagel.getValue();
            IntStream.range(0, count / 12)
                    .mapToObj(i -> new Discount(TWELVE_BAGELS, bagel.getKey()))
                    .forEach(discounts::add);
            IntStream.range(0, (count % 12) / 6)
                    .mapToObj(i -> new Discount(SIX_BAGELS, bagel.getKey()))
                    .forEach(discounts::add);
            for (Map.Entry<Coffee, Integer> coffee : coffees.entrySet()) {
                int coffeeVal = coffee.getValue();
                for (int i = 0; i < Math.min(coffeeVal, count % 6); i++) {
                    discounts.add(new Discount(COFFEE_AND_BAGEL, coffee.getKey(), bagel.getKey()));
                    coffee.setValue(coffee.getValue() - 1);
                }
            }
        }
        return discounts;
    }

    private static <T extends Item> LinkedHashMap<T, Integer> getSortedByPrice(Order order, Class<T> type) {
        return order.getItems().entrySet().stream()
                .filter(entry -> type.isInstance(entry.getKey()))
                .sorted(Comparator.comparing(entry -> entry.getKey().getPrice()))
                .collect(Collectors.toMap(
                        entry -> type.cast(entry.getKey()),
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
    }

    public DiscountType getType() {
        return type;
    }

    public Item getDiscountedItem() {
        return discountedItem;
    }

    public Item getRelatedItem() {
        return relatedItem;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public BigDecimal getDiscountedItemSavings() {
        return discountedItemSavings;
    }

    public BigDecimal getRelatedItemSavings() {
        return relatedItemSavings;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "type=" + type +
                ", discountedItem=" + discountedItem.getSku() +
                (relatedItem == null ? "" : ", relatedItem=" + relatedItem.getSku()) +
                ", price=" + discountedPrice +
                '}';
    }

    enum DiscountType {
        SIX_BAGELS(BigDecimal.valueOf(2.49)),
        TWELVE_BAGELS(BigDecimal.valueOf(3.99)),
        COFFEE_AND_BAGEL(BigDecimal.valueOf(1.25));

        private final BigDecimal price;

        DiscountType(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getPrice() {
            return price;
        }
    }
}
