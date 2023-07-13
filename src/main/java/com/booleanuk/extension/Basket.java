package com.booleanuk.extension;

import com.booleanuk.extension.product.BagelSandwich;
import com.booleanuk.extension.product.Coffee;
import com.booleanuk.extension.product.Product;
import com.booleanuk.extension.product.specialoffer.BagelOffer;
import com.booleanuk.extension.product.specialoffer.BreakfastOffer;
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
    private final Map<BagelSandwich.Bagel, Integer> bagelTypeCounter = new HashMap<>();

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addBagel(BagelSandwich bagel) {
        if (isFull()) {
            throw new IllegalStateException("Cannot add new bagel - basket is full");
        }

        products.add(bagel);

        bagelTypeCounter.merge(bagel.getBagel(), 1, Integer::sum);
    }

    public void removeBagel(BagelSandwich bagel) {
        if (!products.contains(bagel)) {
            throw new NoSuchElementException("Cannot remove bagel because it's not in the basket");
        }

        products.remove(bagel);

        bagelTypeCounter.merge(bagel.getBagel(), -1, Integer::sum);
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
        var products = groupProductsIntoOffers(this.products);

        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal totalPriceNoDiscounts() {
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

    public void printReceipt() {
        var receiptData = groupProductsIntoOffers(this.products);
        var total = totalPrice();
        var saved = totalPriceNoDiscounts().subtract(total);
        var receipt = ReceiptFormatter.formatReceipt(receiptData, total, saved);
        System.out.println(receipt);
    }

    private int itemAmount() {
        return products.size();
    }

    private boolean isFull() {
        return itemAmount() == capacity;
    }

    private List<Product> groupProductsIntoOffers(List<Product> products) {
        List<Product> productsGrouped = new ArrayList<>(products);
        productsGrouped = groupBagelOffers(productsGrouped);
        productsGrouped = groupBreakfastOffers(productsGrouped);

        return productsGrouped;
    }

    private List<Product> groupBagelOffers(List<Product> products) {
        var productsGrouped = new ArrayList<>(products);
        for (var e : bagelTypeCounter.entrySet()) {
            var type = e.getKey();
            if (type.equals(BagelSandwich.Bagel.BGLS)) {
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
                    .filter(p -> p instanceof BagelSandwich)
                    .map(p -> (BagelSandwich) p)
                    .filter(b -> b.getBagel().equals(type))
                    .limit((long) offerAmount * offerQuantity)
                    .toList());

            productsGrouped.removeAll(bagelsForAllOffers);

            while (!bagelsForAllOffers.isEmpty()) {
                var bagelsForSingleOffer = new ArrayList<BagelSandwich>();
                for (int i = 0; i < offerQuantity; i++) {
                    bagelsForSingleOffer.add(bagelsForAllOffers.remove(0));
                }
                var bagelOffer = BagelOffer.of(bagelsForSingleOffer.toArray(BagelSandwich[]::new));
                productsGrouped.add(bagelOffer);
            }
        }

        return productsGrouped;
    }

    private List<Product> groupBreakfastOffers(List<Product> products) {
        var productsGrouped = new ArrayList<>(products);
        var coffees = extractCoffees(productsGrouped);
        var bagels = extractBagels(productsGrouped);

        productsGrouped.removeAll(coffees);
        productsGrouped.removeAll(bagels);

        var breakfastOfferAmount = Math.min(coffees.size(), bagels.size());

        for (int i = 0; i < breakfastOfferAmount; i++) {
            var breakfastOffer = BreakfastOffer.of(bagels.remove(0), coffees.remove(0));
            productsGrouped.add(breakfastOffer);
        }

        productsGrouped.addAll(coffees);
        productsGrouped.addAll(bagels);

        return productsGrouped;
    }

    private List<Coffee> extractCoffees(List<Product> products) {
        return new ArrayList<>(products.stream()
                .filter(p -> p instanceof Coffee)
                .map(p -> (Coffee) p)
                .toList());
    }

    private List<BagelSandwich> extractBagels(List<Product> products) {
        return new ArrayList<>(products.stream()
                .filter(p -> p instanceof BagelSandwich)
                .map(p -> (BagelSandwich) p)
                .toList());
    }
}
