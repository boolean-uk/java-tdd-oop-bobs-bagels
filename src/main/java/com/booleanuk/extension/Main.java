package com.booleanuk.extension;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.setCapacity(24);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLO);
        basket.addItem(BagelType.BGLE);
        basket.addItem(CoffeeType.COFB);

        basket.addItem(CoffeeType.COFB);
        Bagel bagel = new Bagel(BagelType.BGLP);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILB);
        bagel.addFilling(FillingType.FILC);
        basket.addItem(bagel);
        Receipt receipt = new Receipt(basket.getItems(), basket.calculateDiscounts());
        System.out.println(receipt);
    }
}
