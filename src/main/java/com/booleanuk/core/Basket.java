package com.booleanuk.core;

import com.booleanuk.core.product.Coffee;
import com.booleanuk.core.product.Product;
import com.booleanuk.core.product.bagel.Bagel;
import com.booleanuk.core.product.bagel.BagelType;
import com.booleanuk.core.product.specialoffer.BagelOffer;
import com.booleanuk.core.product.specialoffer.BreakfastOffer;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
public class Basket {
    private final List<Product> products = new ArrayList<>();
    private int capacity;
    private final Map<BagelType, Integer> bagelTypeCounter = new HashMap<>();

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addBagel(Bagel bagel) {
        if (isFull()) {
            throw new IllegalStateException("Cannot add new bagel - basket is full");
        }

        products.add(bagel);

        bagelTypeCounter.merge(bagel.type(), 1, Integer::sum);
    }

    public void removeBagel(Bagel bagel) {
        if (!products.contains(bagel)) {
            throw new NoSuchElementException("Cannot remove bagel because it's not in the basket");
        }

        products.remove(bagel);

        bagelTypeCounter.merge(bagel.type(), -1, Integer::sum);
    }

    public void addCoffee(Coffee coffee) {
        if (isFull()) {
            throw new IllegalStateException("Cannot add new coffee - basket is full");
        }

        products.add(coffee);
    }

    public void removeCoffee(Coffee coffee) {
        if (!products.contains(coffee)) {
            throw new NoSuchElementException("Cannot remove coffee because it's not in the basket");
        }

        products.remove(coffee);
    }

    public BigDecimal totalPrice() {
        var products = new ArrayList<>(this.products);

        groupProductsIntoOffers(products);

        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void resize(int capacity) {
        if (capacity < itemAmount()) {
            throw new IllegalArgumentException(String.format("New capacity cannot be smaller than amount of items in basket [%d]", itemAmount()));
        }

        this.capacity = capacity;
    }

    private int itemAmount() {
        return products.size();
    }

    private boolean isFull() {
        return itemAmount() == capacity;
    }

    private void groupProductsIntoOffers(List<Product> products) {
        groupBagelOffers(products);
        groupBreakfastOffers(products);
    }

    private void groupBagelOffers(List<Product> products) {
        var productsGrouped = new ArrayList<>(products);
        for (var e : bagelTypeCounter.entrySet()) {
            var type = e.getKey();
            if (type.equals(BagelType.BGLS)) {
                continue;
            }
            var amount = e.getValue();
            var offerQuantity = switch (type) {
                case BGLO, BGLE -> 6;
                case BGLP -> 12;
                default -> throw new IllegalStateException("Unexpected value: " + type);
            };
            var offerAmount = amount / offerQuantity;

            var bagelsForAllOffers = new ArrayList<>(productsGrouped.stream()
                    .filter(p -> p instanceof Bagel)
                    .map(p -> (Bagel) p)
                    .filter(b -> b.type().equals(type))
                    .limit((long) offerAmount * offerQuantity)
                    .toList());

            while (!bagelsForAllOffers.isEmpty()) {
                var bagelsForSingleOffer = new ArrayList<Bagel>();
                for (int i = 0; i < offerQuantity; i++) {
                    bagelsForSingleOffer.add(bagelsForAllOffers.remove(0));
                }
                var bagelOffer = BagelOffer.of(bagelsForSingleOffer.toArray(Bagel[]::new));
                productsGrouped.add(bagelOffer);
            }
        }
    }

    private void groupBreakfastOffers(List<Product> products) {
        var coffees = extractCoffees(products);
        var bagels = extractBagels(products);

        var breakfastOfferAmount = Math.min(coffees.size(), bagels.size());

        for (int i = 0; i < breakfastOfferAmount; i++) {
            var breakfastOffer = BreakfastOffer.of(bagels.remove(0), coffees.remove(0));
            products.add(breakfastOffer);
        }

        products.addAll(coffees);
        products.addAll(bagels);
    }

    private List<Coffee> extractCoffees(List<Product> products) {
        var coffees = new ArrayList<>(products.stream()
                .filter(p -> p instanceof Coffee)
                .map(p -> (Coffee) p)
                .toList());

        products.removeAll(coffees);

        return coffees;
    }

    private List<Bagel> extractBagels(List<Product> products) {
        var bagels = new ArrayList<>(products.stream()
                .filter(p -> p instanceof Bagel)
                .map(p -> (Bagel) p)
                .toList());

        products.removeAll(bagels);

        return bagels;
    }
}
