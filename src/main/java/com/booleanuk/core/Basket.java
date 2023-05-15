package com.booleanuk.core;


import com.booleanuk.core.models.Bagel;
import com.booleanuk.core.models.Coffee;
import com.booleanuk.core.models.Item;

import java.util.ArrayList;

public class Basket {
    ArrayList<Bagel> bagels;
    ArrayList<Integer> bagelQuantity;
    ArrayList<Coffee> coffees;
    ArrayList<Integer> coffeeQuantity;
    int capacity;
    int sizeOfBasket;

    public Basket() {
        bagels = new ArrayList<>();
        bagelQuantity = new ArrayList<>();
        coffees = new ArrayList<>();
        coffeeQuantity = new ArrayList<>();
        capacity = 3;
        sizeOfBasket = 0;
    }

    boolean add(Item item, int quantity) {
        if (quantity + sizeOfBasket <= capacity) {
            if (item.getClass() == Bagel.class) {
                return add((Bagel) item, quantity);
            } else if (item.getClass() == Coffee.class) {
                return add((Coffee) item, quantity);
            }
        }
        return false;
    }

    boolean remove(Item item, int quantity) {
        boolean result = false;
        if (item.getClass() == Bagel.class) {
            result = remove((Bagel) item, quantity);
        } else if (item.getClass() == Coffee.class) {
            result = remove((Coffee) item, quantity);
        }
        return result;
    }

    boolean add(Bagel bagel, int quantity) {
        bagels.add(bagel);
        bagelQuantity.add(quantity);
        sizeOfBasket += quantity;
        return true;
    }

    boolean add(Coffee coffee, int quantity) {
        coffees.add(coffee);
        coffeeQuantity.add(quantity);
        sizeOfBasket += quantity;
        return true;
    }
    boolean remove(Bagel bagel,int quantity){
        if (!bagels.contains(bagel)){
            return false;
        }
        int index = bagels.indexOf(bagel);
        if (bagelQuantity.get(index)<quantity){
            return false;
        }else if (bagelQuantity.get(index)>quantity){
            bagelQuantity.set(index,bagelQuantity.get(index)-quantity);
        }else {
            bagels.remove(index);
            bagelQuantity.remove(index);
        }
        sizeOfBasket-=quantity;
        return true;
    }
    boolean remove(Coffee coffee,int quantity){
        if (!coffees.contains(coffee)){
            return false;
        }
        int index = coffees.indexOf(coffee);
        if (coffeeQuantity.get(index)<quantity){
            return false;
        }else if (coffeeQuantity.get(index)>quantity){
            coffeeQuantity.set(index,coffeeQuantity.get(index)-quantity);
        }else {
            coffees.remove(index);
            coffeeQuantity.remove(index);
        }
        sizeOfBasket-=quantity;
        return true;
    }
}
