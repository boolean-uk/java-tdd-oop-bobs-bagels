package com.booleanuk.core.basket;

import com.booleanuk.core.items.Category;
import com.booleanuk.core.items.Item;
import com.booleanuk.core.receipt.Receipt;
import com.booleanuk.old.ReceiptItem;

public class Order {
    private final Item item;
    private int amount;

    public Order(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public void increaseAmountBy(int amount) {
        this.amount += amount;
    }

    public void decreaseAmountBy(int amount) {
        this.amount -= amount;
    }

    public boolean amountZero() {
        return amount <= 0;
    }

    public boolean has(Item item) {
        return this.item.equals(item);
    }

    public double cost() {
        return item.cost() * amount;
    }

    public int amount() {
        return amount;
    }

    public boolean itemIsType(Category type) {
        return this.item.isType(type);
    }

    public String name() {
        return item.variant();
    }
}