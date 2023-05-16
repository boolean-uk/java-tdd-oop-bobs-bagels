package com.booleanuk.core;


import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Coffee;
import com.booleanuk.core.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    List<Item> basket;
    ArrayList<Integer> basketQuantity;
    private ArrayList<Integer> itemQuantityAfterDiscount;
    private int capacity;
    int sizeOfBasket;

    private Inventory inventory;


    public Basket() {
        basket = new ArrayList<>();
        basketQuantity = new ArrayList<>();
        inventory = new Inventory();
        itemQuantityAfterDiscount = new ArrayList<>();
        capacity = 3;
        sizeOfBasket = 0;
    }

    boolean add(Item item, int quantity) {
        if (quantity < 0) {
            return false;
        }
        if (quantity + sizeOfBasket >= capacity) {
            return false;
        }
        //Check if its a item of the Invetory!
        boolean isValid = isValidInvetoryItem(item);
        if (isValid) {
            if (basket.contains(item)) {
                int index = basket.indexOf(item);
                int previousQuantity = basketQuantity.get(index);
                basketQuantity.set(index, previousQuantity + quantity);
            } else {
                basket.add(item);
                basketQuantity.add(quantity);
            }
            sizeOfBasket += quantity;
        }
        return isValid;
    }


    boolean remove(Item item, int quantity) {
        if (!basket.contains(item) || (quantity < 0)) {
            return false;
        }
        int index = basket.indexOf(item);
        int previousQuantity = basketQuantity.get(index);
        if (previousQuantity < quantity) {
            return false;
        } else if (previousQuantity == quantity) {
            basket.remove(index);
            basketQuantity.remove(index);
        } else {
            basketQuantity.set(index, previousQuantity - quantity);
        }
        sizeOfBasket -= quantity;
        return true;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean setCapacity(int newCapacity) {
        if (sizeOfBasket <= newCapacity && newCapacity > 0) {
            this.capacity = newCapacity;
            return true;
        }
        return false;
    }

    public double getTotalOfBasket() {
        double totalPrice = 0.0;
        for (Item item : basket) {
            int index = basket.indexOf(item);
            int quantityOfItem = basketQuantity.get(index);
            if (item.getClass() == Bagel.class) {
                double priceOfBagelFillings = getPriceOfBagelFillings((Bagel) item, index);
                totalPrice += priceOfBagelFillings + item.getPrice() * quantityOfItem;
            } else {
                totalPrice += item.getPrice() * quantityOfItem;
            }
        }
        totalPrice = (double) Math.round(totalPrice * 100) / 100;
        return totalPrice;
    }

    public double getTotalWithDiscountBasket() {
        double totalPrice = 0.0;
        itemQuantityAfterDiscount.addAll(basketQuantity);
        //First check the bagel only and get the discount price
        for (Item item : basket) {
            if (Bagel.class != item.getClass()) {
                continue;
            }
            int indexOfBasket = basket.indexOf(item);
            //Price with Discount
            double priceAfterDiscount = discountBagelCalculator(indexOfBasket);

            //Fillings Price
            double priceOfBagelFillings = getPriceOfBagelFillings((Bagel) item, indexOfBasket);

            //Price of Bagel+coffee
            double priceOFBagelPlusCoffee = getPriceOfBagelPlusCoffee(indexOfBasket);

            totalPrice += priceOfBagelFillings + priceAfterDiscount + priceOFBagelPlusCoffee;
        }
        //LeftOverItems
        for (Item item : basket) {
            int index = basket.indexOf(item);
            int quantity = itemQuantityAfterDiscount.get(index);
            totalPrice += item.getPrice() * quantity;
        }
        totalPrice = (double) Math.round(totalPrice * 100) / 100;
        return totalPrice;
    }

    private double getPriceOfBagelPlusCoffee(int indexOfBagel) {
        double total = 0.0;
        int bagelsLeft = itemQuantityAfterDiscount.get(indexOfBagel);
        for (Item item : basket) {
            if (item.getClass() != Coffee.class) {
                continue;
            }
            int indexOfCoffee = basket.indexOf(item);
            int quantityOfCoffee = basketQuantity.get(indexOfCoffee);
            if (bagelsLeft > quantityOfCoffee) {
                itemQuantityAfterDiscount.set(indexOfBagel, bagelsLeft - quantityOfCoffee);
                itemQuantityAfterDiscount.set(indexOfCoffee, 0);
                total += quantityOfCoffee * 1.25;
            } else if (bagelsLeft < quantityOfCoffee) {
                itemQuantityAfterDiscount.set(indexOfBagel, 0);
                itemQuantityAfterDiscount.set(indexOfCoffee, quantityOfCoffee - bagelsLeft);
                total += bagelsLeft * 1.25;
            } else {
                itemQuantityAfterDiscount.set(indexOfBagel, 0);
                itemQuantityAfterDiscount.set(indexOfCoffee, 0);
                total += quantityOfCoffee * 1.25;
            }
        }
        return total;

    }

    private double getPriceOfBagelFillings(Bagel item, int indexOfBasket) {
        int quantityOfItemForFillings = basketQuantity.get(indexOfBasket);
        double priceOfBagelFillings = item.getFillingsPrice() * quantityOfItemForFillings;
        return priceOfBagelFillings;
    }

    private double discountBagelCalculator(int index) {
        double total = 0.0;
        int q12 = 0;
        int q6 = 0;
        int quantity = basketQuantity.get(index);
        while (quantity >= 12) {
            q12 += 1;
            quantity -= 12;
        }
        while (quantity >= 6) {
            q6 += 1;
            quantity -= 6;
        }
        itemQuantityAfterDiscount.set(index, quantity);
        total += 2.49 * q6 + 3.99 * q12;
        return total;
    }

    private boolean isValidInvetoryItem(Item item) {
        boolean isValid = false;
        for (Bagel bagel : inventory.bagels) {
            String sku = bagel.getSKU();
            if (Objects.equals(item.getSKU(), sku)) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            for (Coffee coffee : inventory.coffees) {
                String sku = coffee.getSKU();
                if (Objects.equals(item.getSKU(), sku)) {
                    isValid = true;
                    break;
                }
            }
        }
        return isValid;
    }
}
