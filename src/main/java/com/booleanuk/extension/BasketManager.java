package com.booleanuk.extension;

public class BasketManager {


    private BasketExt basketExt;


    public BasketManager(BasketExt basketExt) {
        this.basketExt = basketExt;
    }


    public BasketExt getBasketExt() {
        return basketExt;
    }


    public void add(BagelExt bagelExt) {
        basketExt.add(bagelExt);
    }
    public void add(CoffeeExt coffeeExt) {
            basketExt.add(coffeeExt);
    }
    public void add(FillingExt fillingExt) {
        basketExt.add(fillingExt);
    }

    public void remove(BagelExt bagelExt) {
        basketExt.remove(bagelExt);
    }
    public void remove(FillingExt fillingExt) {
        basketExt.remove(fillingExt);
    }
    public void remove(CoffeeExt coffeeExt) {
        basketExt.remove(coffeeExt);
    }

    private boolean isBasketFull(){
        int occupiedCapacity = basketExt.getBagelsInBasket().size() + basketExt.getCoffeesInBasket().size() + basketExt.getFillingInBasket().size();
        if(occupiedCapacity == basketExt.getCapacity()){
            return true;
        }
        return false;


    }
}
