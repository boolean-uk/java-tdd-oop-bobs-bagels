package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.booleanuk.extension.Discount.DiscountType.*;

public class Discount {
    private final DiscountType type;
    private final Item discountedItem;
    private Item relatedItem;
    private final BigDecimal discountedPrice;

    public Discount(DiscountType type, Item discountedItem) {
        this.type = type;
        this.discountedItem = discountedItem;
        relatedItem = null;
        discountedPrice = type.getPrice();
    }

    public Discount(DiscountType type, Item discountedItem, Item relatedItem) {
        this(type, discountedItem);
        this.relatedItem = relatedItem;
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

    @Override
    public String toString() {
        return "Discount{" +
                "type=" + type +
                ", discountedItem=" + discountedItem.getSku() +
                ", relatedItem=" + relatedItem.getSku() +
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
