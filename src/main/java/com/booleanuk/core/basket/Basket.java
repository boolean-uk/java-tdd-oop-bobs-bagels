package com.booleanuk.core.basket;

import com.booleanuk.core.discount.NoDiscount;
import com.booleanuk.core.discount.Offer;
import com.booleanuk.core.items.BobsInventory;
import com.booleanuk.core.items.Inventory;
import com.booleanuk.core.items.Item;
import com.booleanuk.core.discount.Discount;
import com.booleanuk.core.receipt.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Basket {
    private final List<Order> orders;
    private final Inventory inventory;
    private final Offer offer;
    private final Receipt receipt;
    private int capacity;

    public Basket(int capacity) {
        this(capacity, new BobsInventory(), new Offer(List.of(new NoDiscount())), new Receipt());
    }

    public Basket(int capacity, Offer offer) {
        this(capacity, new BobsInventory(), offer, new Receipt());
    }

    public Basket(int capacity, Inventory inventory, Offer offer, Receipt receipt) {
        this.capacity = capacity;
        this.inventory = inventory;
        this.offer = offer;
        this.receipt = receipt;
        this.orders = new ArrayList<>();
    }

    public boolean add(Item item) {
        if (orders.size() == capacity) return false;
        if (!inventory.contains(item)) return false;

        Optional<Order> foundOrder = orders.stream().filter(o -> o.has(item)).findFirst();

        if (foundOrder.isPresent())
            foundOrder.get().increaseAmountBy(1);
        else
            orders.add(new Order(item, 1));

        return true;
    }

    public boolean remove(Item item) {
        Optional<Order> foundOrder = orders.stream().filter(o -> o.has(item)).findFirst();

        if (foundOrder.isEmpty()) return false;

        Order o = foundOrder.get();
        o.decreaseAmountBy(1);

        if (o.amountZero()) this.orders.remove(o);

        return true;
    }

    public boolean updateCapacity(int capacity) {
        if (orders.size() >= capacity) return false;

        this.capacity = capacity;
        return true;
    }

    public double cost() {
        return this.offer.discountedCost(orders);
    }

    public String receipt() {
        return receipt.receipt();
    }
    public String detailedReceipt() {
        return receipt.detailedReceipt();
    }
}
