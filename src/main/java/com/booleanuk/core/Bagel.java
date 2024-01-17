package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bagel {
    String bagel;
    ArrayList<String> bagelList;
    int key=0;

    int capacity=4;
    public Bagel(){
        this.bagelList=new ArrayList<>(capacity);
    }

    public String addBagel(String bagel){
        if (bagelList.contains(bagel)){
            return null;
        }
        bagelList.add(bagel);
        return bagel;
    }

    public boolean removeBagel(String bagel){
        if (bagelList.contains(bagel)){
            bagelList.remove(bagel);
            return true;
        }
        return false;
    }

    public boolean basketFull(){
        if (bagelList.size()>capacity){
            System.out.println("Basket Full");
            return true;
        }
        System.out.println("Basket has space");
        return false;
    }


}

