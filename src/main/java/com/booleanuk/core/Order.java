package com.booleanuk.core;

import java.util.ArrayList;
// The Order class is used to create orders for items and store them in an ArrayList
// , and keeps track of how many there are
public class Order {

    private ArrayList<Item> Items;
    private int num;
    private double total;

    public Order(){
        Items=new ArrayList<>();
        num=0;
    }
    // the addItem() method refuses any item which cannot be purchased
    public boolean addItem(Item item){
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

    public void setTotal(double total) {
        this.total = total;
    }
}
