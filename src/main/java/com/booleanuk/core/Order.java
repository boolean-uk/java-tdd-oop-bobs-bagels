package com.booleanuk.core;

import java.util.ArrayList;
// The Order class is used to create orders for items and store them in an ArrayList
// , and keeps track of how many there are
public class Order {

    private Item item;
    private int num;
    private double total;

    public Order(Item item, int num){
        this.item=item;
        this.num=num;
        if (item.getPrice()!=null){
            this.total= item.getPrice()*num;
        }
        else{
            total=0;
        }


    }
    // the addItem() method refuses any item which cannot be purchased

    public int getNum(){
        return num;
    }

    public double getTotal(){
        return total;
    }

    public Item getItems(){
        return item;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
