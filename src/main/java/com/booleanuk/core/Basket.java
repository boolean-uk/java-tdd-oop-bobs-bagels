package com.booleanuk.core;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
public class Basket {
    private final Map<Bagel, Integer> bagels = new HashMap<>();
    private final Map<Coffee, Integer> coffees = new HashMap<>();
    private int capacity;

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addBagel(Bagel bagel) {
        if (isFull()) {
            throw new IllegalStateException("Cannot add new bagel - basket is full");
        }
        bagels.merge(bagel, 1, Integer::sum);
    }

    public void removeBagel(Bagel bagel) {
        if (!bagels.containsKey(bagel)) {
            throw new NoSuchElementException(String.format("Cannot remove %s - it's not in the basket", bagel));
        }

        if (bagels.get(bagel) > 1) {
            bagels.put(bagel, bagels.get(bagel) - 1);
        } else {
            bagels.remove(bagel);
        }
    }

    public void addCoffee(Coffee coffee) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        coffees.merge(coffee, 1, Integer::sum);
    }

    public void removeCoffee(Coffee coffee) {
        if (!coffees.containsKey(coffee)) {
            throw new NoSuchElementException(String.format("Cannot remove %s - it's not in the basket", coffee));
        }

        if (coffees.get(coffee) > 1) {
            coffees.put(coffee, bagels.get(coffee) - 1);
        } else {
            coffees.remove(coffee);
        }
    }

    public BigDecimal totalPrice() {
        var discounts = getDiscounts();
        var totalPrice = discounts.entrySet().stream()
                .map(e -> {
                    var price = e.getKey().getPrice();
                    var amount = e.getValue();

                    return price.multiply(BigDecimal.valueOf(amount));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // TODO add prices of non-discount bagels and coffees to the total

        return bagels.keySet().stream()
                .map(b -> Arrays.stream(b.getFillings())
                        .map(Filling::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                )
                .reduce(totalPrice, BigDecimal::add);
    }

    public void resize(int capacity) {
        if (capacity < itemAmount()) {
            throw new IllegalArgumentException(String.format("New capacity cannot be smaller than amount of items in basket [%d]", itemAmount()));
        }

        this.capacity = capacity;
    }

    private int itemAmount() {
        var amount = bagels.values().stream()
                .reduce(0, Integer::sum);
        return coffees.values().stream()
                .reduce(amount, Integer::sum);
    }

    private boolean isFull() {
        return itemAmount() == capacity;
    }

    private Map<Discount, Integer> getDiscounts() {
        var onionBagelAmount = countBagelType(BagelType.BGLO);
        var plainBagelAmount = countBagelType(BagelType.BGLP);
        var everythingBagelAmount = countBagelType(BagelType.BGLE);
        var sesameBagelAmount = countBagelType(BagelType.BGLS);
        var leftoverBagelAmount = onionBagelAmount % 6 + plainBagelAmount % 12 + everythingBagelAmount % 6 + sesameBagelAmount;
        var coffeeAmount = countCoffees();
        var breakfastSetAmount = Math.min(leftoverBagelAmount, coffeeAmount);

        var discounts = new HashMap<Discount, Integer>();

        discounts.put(Discount.SixOnion, onionBagelAmount / 6);
        discounts.put(Discount.TwelvePlain, plainBagelAmount / 12);
        discounts.put(Discount.SixEverything, everythingBagelAmount / 6);
        discounts.put(Discount.BreakfastSet, breakfastSetAmount);

        return discounts;
    }

    private int countBagelType(BagelType type) {
        return bagels.entrySet().stream()
                .filter(e -> {
                    var bagelType = e.getKey().getType();
                    return bagelType.equals(type);
                })
                .map(Map.Entry::getValue)
                .reduce(0, Integer::sum);
    }

    private int countCoffees() {
        return coffees.values().stream()
                .reduce(0, Integer::sum);
    }
}
