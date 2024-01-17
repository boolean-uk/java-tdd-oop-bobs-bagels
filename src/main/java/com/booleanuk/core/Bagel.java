package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bagel {
    String bagel;
    ArrayList<String> bagelList;
    int key=0;
    public Bagel(){
        this.bagelList=new ArrayList<>();
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


}

