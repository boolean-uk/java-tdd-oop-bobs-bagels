package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public static int capacity =2;
    enum BagelType { ONION, PLAIN, EVERYTHING, SESAME}

    private List<Bagel> bagelList = new ArrayList<Bagel>();
    public List<Bagel> getBagelList()
    {
        return bagelList;
    }
    public void  addToBasket(Bagel bagel) throws Exception
    {
        if (bagelList.size()<capacity)
        {
            bagelList.add(bagel);
        }
        else throw new Exception("Basket is full");

    }
    public void removeFromBasket(Bagel bagel){
        bagelList.remove(bagel);
    }

}
