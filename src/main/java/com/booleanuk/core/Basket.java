package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Order> orders = new ArrayList<>();
    private int capacity = 24;

    public void addCallback(String uuid, int amount) {
        switch (add(uuid, amount)) {
            case VAL_TOO_LOW ->
                System.out.println("Adding a value smaller than 1 is considered invalid. Value must be between 1 to " + getLeftovers());
            case VAL_TOO_HIGH ->
                System.out.println("Adding " + amount + " of new items exceeds the current set limit of " + capacity);
            case INVALID ->
                System.out.println("Cannot add the selected item. Item invalid UUID: Cannot have an id of: " + uuid);
            case OK ->
                System.out.println(amount + " item(s) successfully added to your basket. Current available item slots left: " + getLeftovers());
        }
    }

    public void removeCallback(String uuid, int amount) {
        switch (remove(uuid, amount)) {
            case INVALID ->
                System.out.println("The amount cannot be 0. No action will be taken.");
            case EMPTY ->
                System.out.println("The provided item was already empty. Cannot remove more items for as it is already 0");
            case OK ->
                System.out.println("Successfully removed items from your order.");
        }
    }

    public Error add(String itemID, int amount) {
        if (amount < 1) return Error.VAL_TOO_LOW;
        if (capacity < getCurrentCapacityUsage() + amount) return Error.FULL;

        for (Order order : orders) {
            if (order.itemUUID.equals(itemID)) {
                order.amount += amount;
                return Error.OK;
            }
        }

        if (ShoppingManager.getItem(itemID) == null) return Error.INVALID;

        orders.add(new Order(itemID, amount));
        return Error.OK;
    }

    public Error remove(String itemID, int amount) {
        if (amount == 0) return Error.INVALID;

        Order _itemGet = null;

        for (Order order : orders) {
            if (order.itemUUID.equals(itemID)) {
                order.amount = amount < 0 ? 0 : order.amount - amount;
                _itemGet = order;
                break;
            }
        }

        if (_itemGet == null)
            return Error.EMPTY;

        if (_itemGet.amount <= 0)
            orders.remove(_itemGet);

        return Error.OK;
    }

    public double calculateTotalPrice() {
        double _outPrice = 0.0;

        for (Order order : orders) {
            Item _item = ShoppingManager.getItem(order.itemUUID);
            if (_item == null) continue; // item is somehow invalid
            _outPrice += _item.price * order.amount;
        }

        return _outPrice;
    }

    public double calculateTotalPriceWithDiscounts() {
        double _outPrice = 0.0;

        for (Order order : orders) {
            Item _item = ShoppingManager.getItem(order.itemUUID);
            if (_item == null) continue; // item is somehow invalid
            _outPrice += _item.price * order.amount;

            if (_item.discount != null) {
                double _priceOff = _item.discount.applyDiscount(order, getOrders());
                System.out.println(_priceOff);
                _outPrice -= _priceOff;
            }
        }

        return _outPrice;
    }

    public void clearBasket() {
        orders.clear();
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public Error setCapacity(int newCapacity) {
        if (newCapacity < 1) return Error.INVALID;
        capacity = newCapacity;

        if (capacity < orders.size()) {
            ArrayList<Order> _newOrderList = new ArrayList<>();

            for (int i = 0; i < capacity; i++)
                _newOrderList.add(orders.get(i));

            orders = _newOrderList;

            // this is not really an error, but more of a warning. we still changed the capacity
            // however it is to notify the end user that some items from the basket will be removed
            return Error.VAL_TOO_LOW;
        }

        return Error.OK;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentCapacityUsage() {
        int _capacityUsage = 0;
        for (Order order : orders)
            _capacityUsage += order.amount;
        return _capacityUsage;
    }

    private int getLeftovers() {
        return capacity - getCurrentCapacityUsage();
    }

    public Order[] getOrders() {
        Order[] _outOrders = new Order[orders.size()];
        for (int i = 0; i < orders.size(); i++)
            _outOrders[i] = orders.get(i);
        return _outOrders;
    }
}
