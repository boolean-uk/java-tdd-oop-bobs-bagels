package com.booleanuk.core;

import java.util.HashMap;

public class Basket {

    private HashMap<String, Integer> products;
    private Inventory inventory;
    private static int maxSize;

    public Basket(){

    }

    public boolean add(String id){
        return false;
    }

    public boolean remove(String id){
        return false;
    }

    public String setMaxSize(String id){
        return "";
    }
}
