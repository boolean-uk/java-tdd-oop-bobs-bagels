package com.booleanuk.core.order;

import com.booleanuk.core.Bagel;
import com.booleanuk.core.Basket;
import com.booleanuk.core.Coffee;
import com.booleanuk.core.Filling;
import com.booleanuk.core.Inventory;

public class Order {

    Inventory inv = new Inventory();

    Basket basket = new Basket(4);

    public boolean add(Bagel bagel){
        return true;
    }

    public boolean add(Bagel bagel, Filling filling){
        return true;
    }

    public boolean add(Coffee coffee){
        return true;
    }

    public boolean remove(Bagel bagel){
        return true;
    }

    public boolean remove(Coffee coffee){
        return true;
    }
}
