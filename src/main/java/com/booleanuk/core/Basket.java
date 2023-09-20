package com.booleanuk.core;
import com.booleanuk.core.Products.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private static final String HEADER = "~~~ Bob's Bagels ~~~";
    private static final String SEPARATOR = "----------------------------\n";
    private static final String THANK_YOU_MESSAGE = "Thank you for your order!";
    private static final String BASKET_CAPACITY_FORMAT = "Your basket's capacity is %d/%d.\n";
    private static final String NO_ITEMS_MESSAGE = "You have no items in your basket yet.";
    private static final String NOT_ENOUGH_SPACE_MESSAGE = "Not enough space in the basket!";
    private static final String ITEM_NOT_FOUND_MESSAGE = "Item not found.";
    private static final String PRODUCT_ADDED_MESSAGE = "Product was added to the basket";
    private static final String PRODUCT_AMOUNT_INCREASED_MESSAGE = "Product was already in the basket. Quantity increased.";
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String ITEM_ON_RECEIPT_FORMAT = "%-18s x%2d  € %.2f\n";
    private static final String DISCOUNT_FORMAT = "  >> Discount:  € -%s\n";
    private static final String FILLING_FORMAT = " >> %-15s x%2d  € %.2f\n";
    private static final String TOTAL_COST_MESSAGE = "Total                  € %.2f\n";
    private static final String TOTAL_SAVINGS_MESSAGE = "You saved a total of € %.2f\n       on this shop\n";
    private static final String ITEM_ON_BASKET_OVERVIEW_FORMAT = "%s x %s pcs x %s = %s";



    private int capacity;
    private Map<Item, Integer> itemsMap;
    private Inventory inventory;

    public Basket(int capacity) {
        this.itemsMap = new HashMap<>();
        setCapacity(capacity);
        this.inventory = Inventory.getInstance();
    }

    public int getBasketSize() {
        return itemsMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean setCapacity(int capacity) {
        if (capacity < getBasketSize()) {
            return false;
        }
        this.capacity = capacity;
        return true;
    }

    public Map<Item, Integer> getItemsMap() {
        return itemsMap;
    }

    public void setItemsMap(Map<Item, Integer> itemsMap) {
        this.itemsMap = itemsMap;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean addToBasket(Item item, int amount) {
        if (!itemIsAvailable(item)) {
            printErrorMessage(ITEM_NOT_FOUND_MESSAGE);
            return false;
        }
        if (amount <= 0) {
            System.out.println("Invalid input! Please enter a valid quantity.");
            return false;
        }


        if (getRemainingCapacity() < amount) {
            printErrorMessage(NOT_ENOUGH_SPACE_MESSAGE);
            return false;
        }

        itemsMap.put(item, itemsMap.getOrDefault(item, 0) + amount);

        if (itemsMap.get(item) == amount) {
            System.out.println(PRODUCT_ADDED_MESSAGE);
        } else {
            System.out.println(PRODUCT_AMOUNT_INCREASED_MESSAGE);
        }
        return true;
    }

    public int getRemainingCapacity() {
        return capacity - getBasketSize();
    }

    public boolean removeFromBasket(Item item, int amount) {
        if (!itemsMap.containsKey(item) || amount <= 0) {
            return false;
        }

        int currentAmount = itemsMap.get(item);

        if (amount >= currentAmount) {
            itemsMap.remove(item);
        } else {
            itemsMap.put(item, currentAmount - amount);
        }

        return true;
    }
    public boolean removeFromBasket(Item item) {
        return itemsMap.remove(item) != null;
    }

    public boolean isFull() {
        return capacity <= getBasketSize();
    }

    public BigDecimal calculateTotalCost() {
        BigDecimal totalCost = BigDecimal.ZERO;

        for (Map.Entry<Item, Integer> entry : itemsMap.entrySet()) {
            Sellable item = (Sellable) entry.getKey();
            int quantity = entry.getValue();

            if (item instanceof Bagel) {
                totalCost = totalCost.add(calculateBagelsDiscountedPrice((Bagel) item, quantity)[0]);
                for (Filling filling : ((Bagel) item).getFillings()) {
                    totalCost = totalCost.add(filling.getPrice().multiply(BigDecimal.valueOf(quantity)));
                }
            } else {
                BigDecimal itemPrice = item.calculateTotalPriceItem();
                BigDecimal itemTotalCost = itemPrice.multiply(BigDecimal.valueOf(quantity));
                totalCost = totalCost.add(itemTotalCost);
            }
        }
        return totalCost;
    }

    public StringBuilder printReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append(HEADER).append(System.lineSeparator()).append(SEPARATOR);

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        String formattedTime = currentTime.format(formatter);

        receipt.append(formattedTime).append(System.lineSeparator()).append(SEPARATOR);

        BigDecimal totalSavings = BigDecimal.ZERO;

        for (Map.Entry<Item, Integer> entry : itemsMap.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            if (item instanceof Coffee) {
                BigDecimal itemTotalCost = calculateItemTotalCost(item, quantity);
                receipt.append(String.format(ITEM_ON_RECEIPT_FORMAT, item, quantity, itemTotalCost));

                if (((Coffee) item).isBagelAdded()) {
                    BigDecimal itemSavings = Coffee.COFFEE_AND_BAGEL_SAVINGS;
                    receipt.append(String.format(DISCOUNT_FORMAT, itemSavings.multiply(BigDecimal.valueOf(quantity))));
                    totalSavings = totalSavings.add(itemSavings.multiply(BigDecimal.valueOf(quantity)));
                }
            } else if (item instanceof Bagel) {
                BigDecimal[] bagelDiscountInfo = calculateBagelsDiscountedPrice((Bagel) item, quantity);
                BigDecimal itemTotalCost = bagelDiscountInfo[0];
                BigDecimal currentSavings = bagelDiscountInfo[1];
                totalSavings = totalSavings.add(currentSavings);

                receipt.append(String.format(ITEM_ON_RECEIPT_FORMAT, item, quantity, itemTotalCost));

                for (Filling filling : ((Bagel) item).getFillings()) {
                    BigDecimal fillingTotalPrice = filling.getPrice().multiply(BigDecimal.valueOf(quantity));
                    receipt.append(String.format(FILLING_FORMAT,  filling, quantity, fillingTotalPrice));
                }

                if (currentSavings.compareTo(BigDecimal.ZERO) != 0) {
                    receipt.append(String.format(DISCOUNT_FORMAT, currentSavings));
                }
            }
        }

        receipt.append(SEPARATOR).append(String.format(TOTAL_COST_MESSAGE, calculateTotalCost()))
                .append(SEPARATOR)
                .append(String.format(TOTAL_SAVINGS_MESSAGE, totalSavings))
                .append(THANK_YOU_MESSAGE);

        return receipt;
    }

    @Override
    public String toString() {
        StringBuilder basketContent = new StringBuilder();
        basketContent.append(String.format(BASKET_CAPACITY_FORMAT, getBasketSize(), getCapacity()));
        basketContent.append("Your products:\n");

        if (getBasketSize() == 0) {
            basketContent.append(NO_ITEMS_MESSAGE);
        } else {
            int number = 0;

            for (Map.Entry<Item, Integer> entry : itemsMap.entrySet()) {
                Item item = entry.getKey();
                int quantity = entry.getValue();

                BigDecimal currentSavings = BigDecimal.ZERO;

                if (item instanceof Bagel) {
                    basketContent.append(String.format(ITEM_ON_BASKET_OVERVIEW_FORMAT,
                                    number + ". " + item,
                                    quantity,
                                    "€ " + item.getPrice(),
                                    "€ " + item.getPrice().multiply(BigDecimal.valueOf(quantity))))
                            .append("\n");

                    currentSavings = calculateBagelsDiscountedPrice((Bagel) item, quantity)[1];

                    if (currentSavings.compareTo(BigDecimal.ZERO) != 0) {
                        basketContent.append(String.format(DISCOUNT_FORMAT, currentSavings));
                    }

                    for (Filling filling : ((Bagel) item).getFillings()) {
                        basketContent.append(String.format(FILLING_FORMAT,
                                        filling,
                                        quantity,
                                        filling.getPrice().multiply(BigDecimal.valueOf(quantity))));
                    }
                } else if (item instanceof Coffee) {
                    basketContent.append(String.format(ITEM_ON_BASKET_OVERVIEW_FORMAT,
                                    number + ". " + item,
                                    quantity,
                                    "€ " + ((Coffee) item).calculateTotalPriceItem(),
                                    "€ " + ((Coffee) item).calculateTotalPriceItem().multiply(BigDecimal.valueOf(quantity))))
                            .append("\n");

                    if (((Coffee) item).isBagelAdded()) {
                        currentSavings = Coffee.COFFEE_AND_BAGEL_SAVINGS;

                        basketContent.append(String.format("  >> You save:  € %s\n", currentSavings.multiply(BigDecimal.valueOf(quantity))));
                    }
                }

                number++;
            }
        }

        return basketContent.toString();
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }

    private boolean itemIsAvailable(Item item) {
        return inventory.itemIsAvailable(item);
    }

    BigDecimal calculateItemTotalCost(Item item, int quantity) {
        if (item instanceof Sellable) {
            return ((Sellable) item).calculateTotalPriceItem().multiply(BigDecimal.valueOf(quantity));
        } else {
            return item.getPrice().multiply(BigDecimal.valueOf(quantity));
        }
    }

    private BigDecimal[] calculateBagelsDiscountedPrice(Bagel bagel, int quantity) {
        BigDecimal discountedPrice = BigDecimal.ZERO;
        BigDecimal originalPrice = BigDecimal.ZERO;

        if (bagel != null && quantity > 0) {
            BigDecimal itemPrice = bagel.getPrice();
            int setsOf12 = quantity / 12;
            int remainingBagels = quantity % 12;
            BigDecimal setsPrice = BigDecimal.valueOf(setsOf12).multiply(BigDecimal.valueOf(3.99));

            if ("BGLP".equals(bagel.getSku())) {
                BigDecimal individualPrice = itemPrice.multiply(BigDecimal.valueOf(remainingBagels));
                originalPrice = itemPrice.multiply(BigDecimal.valueOf(quantity));
                discountedPrice = setsPrice.add(individualPrice);
            } else {
                BigDecimal remainingSetsPrice = BigDecimal.valueOf(remainingBagels / 6).multiply(BigDecimal.valueOf(2.49));
                BigDecimal individualPrice = itemPrice.multiply(BigDecimal.valueOf(remainingBagels % 6));
                originalPrice = itemPrice.multiply(BigDecimal.valueOf(quantity));
                discountedPrice = setsPrice.add(remainingSetsPrice).add(individualPrice);
            }
        }

        BigDecimal amountSaved = originalPrice.subtract(discountedPrice);

        return new BigDecimal[]{discountedPrice, amountSaved};
    }
}
