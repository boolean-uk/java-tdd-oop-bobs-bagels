package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Basket {
    private int capacity;
    public final static int SIX_BAGELS_PRICE = 249;
    public final static int TWELVE_BAGELS_PRICE = 399;
    public final static int SINGLE_FILLING_PRICE = 12;
    public final static int COFFEE_PLUS_BAGEL = 125;

    private final Map<Item, Integer> items;

    public Basket(int capacity) {
        this.capacity = capacity;
        this.items = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return this.getItemCount() >= capacity;
    }

    public boolean checkIfExists(Item item) {
        return items.containsKey(item);
    }

    public int getItemCount() {
        return items.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getRemainingSpace() {
        return capacity - getItemCount();
    }

    public void clearBasket() {
        items.clear();
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void add(Item item) {
        if (isFull()) throw new IllegalStateException("You can't add this item");
        else {
            int quantity = items.getOrDefault(item, 0);
            items.put(item, quantity + 1);
        }
    }

    public void remove(Item item) {
        if (checkIfExists(item)) items.remove(item);
        else throw new IllegalArgumentException("You can't remove this item");
    }

    public double getTotalCost() {
        List<Long> coffeePrices = getCoffeePrices();

        List<Long> remainingBagelsPrices = items.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof Bagel)
                .filter(entry -> entry.getValue() % 6 != 0)
                .flatMap(entry -> Collections.nCopies(entry.getValue() % 6, ((Bagel) entry.getKey()).getBagelType().getPrice()).stream())
                .sorted()
                .toList();

        int numberOfCoffeeAndBagelSpecialOffers = Math.min(coffeePrices.size(), remainingBagelsPrices.size());

        long coffeeAndBagelPrice = (long) numberOfCoffeeAndBagelSpecialOffers * COFFEE_PLUS_BAGEL;

        long remainingItemsPrice = 0L;
        if (coffeePrices.size() > remainingBagelsPrices.size()) {
            remainingItemsPrice = coffeePrices.subList(numberOfCoffeeAndBagelSpecialOffers, coffeePrices.size())
                    .stream()
                    .mapToLong(Long::longValue)
                    .sum();
        } else if (coffeePrices.size() < remainingBagelsPrices.size()) {
            remainingItemsPrice = remainingBagelsPrices.subList(numberOfCoffeeAndBagelSpecialOffers, remainingBagelsPrices.size())
                    .stream()
                    .mapToLong(Long::longValue)
                    .sum();
        }

        return (getBagelFillingsPrice() + getPriceOf6And12BagelsCombos() + coffeeAndBagelPrice + remainingItemsPrice) / 100.0;
    }

    public String getReceipt() {
        long priceWithoutDiscount = items.entrySet().stream().mapToLong(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
        StringBuilder receipt = new StringBuilder();
        receipt.append("Bob's Bagels - Receipt\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        receipt.append(LocalDateTime.now().format(formatter));
        receipt.append("\n");

        int remainingBagels = 0;

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            long itemPrice = item.getPrice() * quantity;
            long discount = 0;

            if (item instanceof Bagel bagel) {
                receipt.append(bagel.getBagelType()).append(" Bagel x").append(quantity);
                if (quantity >= 6) {
                    int specialOfferCount = quantity / 6;
                    int remainingCount = quantity % 6;
                    long discountedPrice = ((long) (specialOfferCount / 2) * TWELVE_BAGELS_PRICE + (specialOfferCount % 2) * SIX_BAGELS_PRICE);
                    discount = (quantity - remainingCount) * ((Bagel) item).getBagelType().getPrice() - discountedPrice;
                    receipt.append(" (Special Offer: ").append(specialOfferCount * 6).append(" for $").append(discountedPrice / 100.0).append(")");
                    if (remainingCount > 0) {
                        receipt.append(" + ").append(remainingCount).append(" at $").append(bagel.getPrice() / 100.0);
                        remainingBagels += remainingCount;
                    }
                } else {
                    receipt.append(" at $").append(bagel.getPrice() / 100.0);
                    remainingBagels += quantity;
                }
            } else if (item instanceof Coffee) {
                receipt.append("Coffee x").append(quantity).append(" at $").append(item.getPrice() / 100.0);
            }

            receipt.append(" = $").append(itemPrice / 100.0).append("\n");
            if (item instanceof Coffee) {
                long coffeeDiscount = Math.min(remainingBagels, quantity);
                if (coffeeDiscount > 0)
                    receipt.append(" (Special Offer: Coffee+Bagel: ").append(coffeeDiscount).append(" for $").append(coffeeDiscount * COFFEE_PLUS_BAGEL / 100.0).append(")\n");
            }

            if (discount > 0) receipt.append("discount is equal to: $").append(discount / 100.0).append("\n");
        }

        double totalCost = getTotalCost();
        receipt.append("Total Cost: $").append(totalCost).append("\n");
        receipt.append("Total Discount: $").append((priceWithoutDiscount - (long) totalCost * 100) / 100.0).append("\n");
        receipt.append("Thank you for your order!");

        return receipt.toString();
    }

    private List<Long> getCoffeePrices() {
        return items.entrySet()
                .stream()
                .filter(entry -> entry.getKey() instanceof Coffee)
                .flatMap(entry -> Collections.nCopies(entry.getValue(), entry.getKey().getPrice()).stream())
                .sorted()
                .toList();
    }

    private long getBagelFillingsPrice() {
        return items.entrySet().stream().filter(entry -> entry.getKey() instanceof Bagel)
                .map(entry -> entry.getValue() * ((Bagel) entry.getKey()).getFillingType().getPrice())
                .reduce(0L, Long::sum);
    }

    private long getPriceOf6And12BagelsCombos() {
        return items.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof Bagel)
                .map(entry -> {
                    if (entry.getValue() >= 6) {
                        int result = entry.getValue() / 6;
                        return (long) TWELVE_BAGELS_PRICE * (result / 2) + SIX_BAGELS_PRICE * (result % 2);
                    } else return 0L;
                }).reduce(0L, Long::sum);
    }
}
