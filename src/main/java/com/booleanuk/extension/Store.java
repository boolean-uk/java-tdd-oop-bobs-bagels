package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Basket> baskets;
    private List<Order> orders;

    public Store() {
        this.baskets = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public boolean placeOrder(Basket basket) {
        if (basket.getItems().size() > 0) {
            orders.add(new Order(basket.getItems()));
            baskets.remove(basket);
            return true;
        }
        return false;
    }

    public BigDecimal applySpecialOffers() {
        return null;
    }

    public void addBasket(Basket basket) {
        baskets.add(basket);
    }

    public List<Basket> getBaskets() {
        return baskets;
    }
}
