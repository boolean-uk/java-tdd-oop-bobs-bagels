package com.booleanuk.core;

import java.util.ArrayList;

enum NOTIFICATION {
    NOERROR,
    ITEMNOTFOUND,
    ITEMNOTAVAILABLE,
    MAXCAPACITY
}

public class Basket {
    ArrayList<Item> items;
    static int capacity = 1;
    NOTIFICATION notification;

    public Basket() {
        this.items = new ArrayList<>(capacity);
        this.notification = NOTIFICATION.NOERROR;
    }

    public boolean add(Item item) {
        if (items.size() >= capacity) {
            notification = NOTIFICATION.MAXCAPACITY;
            return false;
        }

        if(!item.getAvailable()) {
            notification = NOTIFICATION.ITEMNOTAVAILABLE;
            return false;
        }

        notification = NOTIFICATION.NOERROR;
        items.add(item);
        return true;
    }

    public boolean remove(Item item) {
        int position = items.indexOf(item);

        if (position == -1) {
            notification = NOTIFICATION.ITEMNOTFOUND;
            return false;
        }

        notification = NOTIFICATION.NOERROR;
        items.remove(position);
        return true;
    }

    public double totalCost() {
        return items.stream().reduce(0.0, (x, y) -> x + y.getCost(), Double::sum);
    }

    static boolean setCapacity(int size) {
        if (size < 0) return false;

        capacity = size;
        return true;
    }
}
