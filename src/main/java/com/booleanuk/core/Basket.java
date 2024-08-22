package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

// The Basket class is used to create baskets to hold items
// It contaisn two HashMaps, giving oversight over the number of certain items and their prices

public class Basket {
    private HashMap<Item, Integer> Items;
    private int capacity;
    private int numItems;
    private double total;





    public Basket(int num){
        capacity=num;
        numItems=0;
        Items = new HashMap<Item, Integer>();
        total=0;

    }

    public boolean add(Order order){

        Item item= order.getItems();
        int num= order.getNum();

        if (!Items.containsKey(item) & checkCapacity()) {
            Items.put(item, num);
            total+=item.getPrice()*num;
            this.numItems+=num;
        } else if (Items.containsKey(item) & checkCapacity()) {
            Items.replace(item, Items.get(item)+num);
            total+=item.getPrice()*num;
            this.numItems+=1;
        }
        else{
            System.out.println("Basket is full");
            return false;

        }



        return true;

    }

    public boolean add(Item item, int num){




        if (!Items.containsKey(item) & checkCapacity()) {
            Items.put(item, num);
            total+=item.getPrice()*num;
            this.numItems+=num;
        } else if (Items.containsKey(item) & checkCapacity()) {
            Items.replace(item, Items.get(item)+num);
            total+=item.getPrice()*num;
            this.numItems+=1;
        }
        else{
            System.out.println("Basket is full");
            return false;

        }



        return true;

    }



    public boolean remove(Item item, int num){
        if (Items.containsKey(item)){
            if (Items.get(item)==0){
                System.out.println("The basket does not contain this item");
                return false;
            }

            Items.replace(item, Items.get(item)-num);
            this.numItems-=num;
            total-=item.getPrice()*num;
            return true;
        }
        else{
            System.out.println("The basket does not contain this item");
            return false;
        }
    }

    public boolean checkCapacity(){


        if (numItems>=capacity){
            return false;
        }
        return true;

    }

    public boolean incCapacity(int num){
        capacity+=num;
        return true;
    }

    public int getNumItems(){
        return numItems;
    }

    public double getTotal() {
        return total;
    }

    public HashMap<Item, Integer> getItems() {
        return Items;
    }


    public void setTotal(double change){
        total=change;
    }
}
