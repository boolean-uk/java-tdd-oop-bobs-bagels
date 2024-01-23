package com.booleanuk.extension;
import com.booleanuk.core.*;

import java.util.HashMap;
import java.util.Map;

public class Discount {
    private Basket basket;

    public Discount(){
        this.basket = new Basket(new Inventory(), 8);
    }

    public int countItemsInBasket(Basket basket, Product item){
        int countItem = 0;
        for (int i = 0; i < basket.getItemBasket().size(); i++){
            if (item == basket.getItemBasket().get(i)){
                countItem++;
            }
        }
        return countItem;
    }

    public double getDiscount(Basket basket){
        double discounted = 0;

        return discounted;

    }

}
