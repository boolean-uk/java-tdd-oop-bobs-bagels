package com.booleanuk.core;

import java.util.ArrayList;

enum NOTIFICATION {
    NOERROR,
    BAGELNOTFOUND,
    FILLINGNOTFOUND,
    MAXCAPACITY
}

public class Basket {
    ArrayList<Bagel> bagels;
    static int capacity = 1;
    NOTIFICATION notification;

    public Basket() {
        this.bagels = new ArrayList<>(capacity);
        this.notification = NOTIFICATION.NOERROR;
    }

    public boolean addBagel(Bagel bagel) {
        if (bagels.size() >= capacity) {
            notification = NOTIFICATION.MAXCAPACITY;
            return false;
        }

        notification = NOTIFICATION.NOERROR;
        bagels.add(bagel);
        return true;
    }

    public boolean removeBagel(Bagel bagel) {
        int position = bagels.indexOf(bagel);

        if (position == -1) {
            notification = NOTIFICATION.BAGELNOTFOUND;
            return false;
        }

        notification = NOTIFICATION.NOERROR;
        bagels.remove(position);
        return true;
    }

    static boolean setCapacity(int size) {
        if (size < 0) return false;

        capacity = size;
        return true;
    }
}
