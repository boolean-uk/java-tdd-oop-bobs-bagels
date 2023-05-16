package com.booleanuk.core;


import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Coffee;
import com.booleanuk.core.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    List<Item> basket;
    List<Integer> basketQuantity;
    private int capacity;
    int sizeOfBasket;

    private Invetory invetory;


    public Basket() {
        basket = new ArrayList<>();
        basketQuantity = new ArrayList<>();
        invetory = new Invetory();
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
                sizeOfBasket += quantity;
            }
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
                /* TODO: getPriceOfFillings*/
                double priceOfSingleBagelFilling = ((Bagel) item).getFillingsPrice();
                totalPrice+=priceOfSingleBagelFilling*quantityOfItem+item.getPrice()*quantityOfItem;
            } else {
                totalPrice += item.getPrice() * quantityOfItem;
            }
        }
        totalPrice = (double) Math.round(totalPrice * 100) / 100;
        return totalPrice;
    }

    private boolean isValidInvetoryItem(Item item) {
        boolean isValid = false;
        for (Bagel bagel : invetory.bagels) {
            String sku = bagel.getSKU();
            if (Objects.equals(item.getSKU(), sku)) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            for (Coffee coffee : invetory.coffees) {
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
