package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    enum BagelType { ONION, PLAIN, EVERYTHING, SESAME}

    private List<Bagel> bagelList = new ArrayList<Bagel>();
    public List<Bagel> getBagelList()
    {
        return bagelList;
    }
    public void  addToBasket(Bagel bagel)
    {
        bagelList.add(bagel);
    }
    public void removeFromBasket(Bagel bagel){
        bagelList.remove(bagel);
    }

}
