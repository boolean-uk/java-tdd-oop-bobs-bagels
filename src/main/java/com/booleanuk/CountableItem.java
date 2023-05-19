package com.booleanuk;

import java.lang.annotation.Inherited;

public class CountableItem {
    private Item item;
    private int amount;

    public CountableItem(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public void increaseAmount() {
        this.amount++;
    }

    public void decreaseAmount() {
        if (amount > 0) amount--;
    }

    public boolean amountIsZero() {
        return amount == 0;
    }

    public double getPrice() { return item.getPrice(); }

    public int getAmount(){
        return this.amount;
    }

    public Item getItem() {
        return this.item;
    }

    @Override
    public String toString() {
        int space = 40 - item.getVariant().split("").length;
        return String.format("%s %" + space + "d", item.getVariant(), amount);
    }
}
