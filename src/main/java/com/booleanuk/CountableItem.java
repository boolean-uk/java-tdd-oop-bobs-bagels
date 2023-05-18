package com.booleanuk;

public class CountableItem {
    private int amount;

    public int getAmount(){
        return this.amount;
    }

    public CountableItem(int amount) {
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
}
