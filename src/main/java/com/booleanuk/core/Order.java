package com.booleanuk.core;

import java.util.ArrayList;

public class Order {

    private ArrayList<Item> Items;
    private int num;
    private double total;

    Order(){
        Items=new ArrayList<>();
        num=0;
    }

    boolean addItem(Item item){
        if (!item.canPurchase()){
            return false;
        }
        Items.add(item);
        total+=item.getPrice();
        num++;
        return true;
    }

    public int getNum(){
        return num;
    }

    public double getTotal(){
        return total;
    }

    public ArrayList<Item> getItems(){
        return Items;
    }


}
