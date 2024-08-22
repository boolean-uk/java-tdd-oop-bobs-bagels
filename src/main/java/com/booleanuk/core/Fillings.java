package com.booleanuk.core;

public class Fillings extends Product implements Helper{

    Fillings(String SKU, double price, String variant) {
        super(SKU, price, variant);
    }

    public boolean addProduct(Order order) {
        if(!order.isBagelInBasket()) {
            System.out.println("You have to choose a bagel first before you can add a filling");
            return false;
        }

        order.addToTotalPrice(this.getPrice());
        Bagels lastBagel = order.getLastAddedBagel();
        lastBagel.addFilling(this);
        return true;
    }
}
