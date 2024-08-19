package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private HashMap<String, Integer> Items;
    private int capacity;
    private int numItems;
    private double total;

    public Basket(int num){
        capacity=num;
        numItems=0;
        Items = new HashMap<String, Integer>();
        total=0;
    }

    public boolean add(Order order){

        for (Item i: order.getItems()) {

            if (!Items.containsKey(i.getName()) & checkCapacity()) {
                Items.put(i.getName(), 1);
                total+=i.getPrice();
                this.numItems+=1;
            } else if (Items.containsKey(i.getName()) & checkCapacity()) {
                Items.replace(i.getName(), Items.get(i.getName())+1);
                total+=i.getPrice();
                this.numItems+=1;
            }
            else{
                System.out.println("Basket is full");
                return false;

            }


        }
        return true;

    }

    public boolean remove(Item item, int num){
        if (Items.containsKey(item.getName())){
            if (Items.get(item.getName())==0){
                System.out.println("The basket does not contain this item");
                return false;
            }

            Items.replace(item.getName(), Items.get(item.getName())-num);
            this.numItems--;
            total-=item.getPrice();
            return true;
        }
        else{
            System.out.println("The basket does not contain this item");
            return false;
        }
    }

    public boolean checkCapacity(){
        //int num=0;
        /*
        for (String key: bagels.keySet()){
            num+=bagels.get(key);

            if (num>=capacity){
                return false;
            }
        }

         */

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
}
