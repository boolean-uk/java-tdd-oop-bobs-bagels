package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private ArrayList<Product> list = new ArrayList<>();
    private int capacity = 10;

    public boolean add(Product product) {
        if (list.size() <= capacity) {
            return list.add(product);
        } else {
            return false;
        }
    }

    public boolean remove(Product product) {
        if (list.contains(product)) {
            return list.remove(product);
        }
        return false;
    }

    public double total(){
        // TODO: Podwaliny pod EXTENSION1 (mapa duplikatow)
        double total = 0;
        HashMap<Product, Integer> duplicatesHashMap = new HashMap<>();
        list.forEach(product -> {
            if (!duplicatesHashMap.containsKey(product)) {
                duplicatesHashMap.put(product, 1);
            } else {
                duplicatesHashMap.computeIfPresent(product, (k, v) -> v + 1);
            }
        });
        duplicatesHashMap.forEach((product, integer) -> {
            if (integer >= 12) {

            }
        });
//        double total = 0;
//        for (Product product : list) {
//            total += product.getPrice();
//        }
//        total = Math.round(total * 100);
//        total = total/100;
//        return total;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean setCapacity(int capacity) {
        if (capacity <= list.size()) {
            return false;
        }
        this.capacity = capacity;
        return true;
    }

    public ArrayList<Product> getList() {
        return list;
    }
}
