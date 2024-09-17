package com.booleanuk.extension;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Basket> baskets;
    private int maxCapacity;
    public Shop(){
        baskets = new ArrayList<>();
        this.maxCapacity = 5;
    }

    public void createBasket(){
        baskets.add(new Basket(maxCapacity));
    }
    public boolean changeMaxCapacity(int maxCapacity){
        for(Basket b : baskets){
            if (b.changeBasketCapacity(maxCapacity)){
                b.changeBasketCapacity(maxCapacity);
            }
            else {
                return false;
            }
        }
        return true;
    }

    public boolean checkoutBasket(int index){
        try{
            baskets.get(index).getReceipt();
            baskets.remove(index);
            return true;
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
    }
    public ArrayList<Basket> getAllBaskets(){
        return this.baskets;
    }
}
