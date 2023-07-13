package com.booleanuk.core;

import java.util.ArrayList;

enum NOTIFICATION {
    NOERROR,
    ITEMNOTFOUND,
    ITEMNOTAVAILABLE,
    MAXCAPACITY
}

public class Basket {
    final ArrayList<IProduct> products;
    private static int capacity = 1;
    private NOTIFICATION notification;

    public ArrayList<IProduct> getProducts() { return products; }
    public static int getCapacity() { return capacity; }
    public static boolean setCapacity(int size) {
        if (size < 0) return false;

        capacity = size;
        return true;
    }
    public NOTIFICATION getNotification() { return notification; }

    public Basket() {
        this.products = new ArrayList<>(capacity);
        this.notification = NOTIFICATION.NOERROR;
    }

    public boolean add(IProduct product) {
        if (products.size() >= capacity) {
            notification = NOTIFICATION.MAXCAPACITY;
            return false;
        }

        if(!product.getAvailable()) {
            notification = NOTIFICATION.ITEMNOTAVAILABLE;
            return false;
        }

        notification = NOTIFICATION.NOERROR;
        products.add(product);
        return true;
    }

    public boolean remove(IProduct product) {
        int position = products.indexOf(product);

        if (position == -1) {
            notification = NOTIFICATION.ITEMNOTFOUND;
            return false;
        }

        notification = NOTIFICATION.NOERROR;
        products.remove(position);
        return true;
    }

    public double totalCost() {
        return products.stream().reduce(0.0, (x, y) -> x + y.getCost(), Double::sum);
    }

    @Override
    public String toString() {
        String result = products.stream().reduce("", (x, y) -> x.concat(y.toString()), String::concat);

        return result;
    }
}
