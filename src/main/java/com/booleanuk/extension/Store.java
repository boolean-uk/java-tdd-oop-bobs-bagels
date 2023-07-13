package com.booleanuk.extension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Store {
    private List<Basket> baskets;
    private List<Order> orders;

    public Store() {
        this.baskets = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public UUID placeOrder(Basket basket) {
        if (basket.getItems().size() > 0) {
            Order order = new Order(basket);
            orders.add(order);
            baskets.remove(basket);
            return order.getId();
        }
        return null;
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

    public Order getOrder(UUID id) {
        return orders.stream().
                filter(order -> order.getId().equals(id))
                .findFirst().orElse(null);
    }
}
