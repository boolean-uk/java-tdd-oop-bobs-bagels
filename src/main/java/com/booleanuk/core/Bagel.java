package com.booleanuk.core;

import java.util.HashMap;

public class Bagel {
    String bagel;
    HashMap<Integer, String> bagelList;
    int key=0;
    public Bagel(){
        this.bagelList=new HashMap<>();
    }

    public String addBagel(String bagel){
        if (bagelList.containsValue(bagel)){
            return null;
        }
        bagelList.put(key++,bagel);
        return bagel;
    }


}

