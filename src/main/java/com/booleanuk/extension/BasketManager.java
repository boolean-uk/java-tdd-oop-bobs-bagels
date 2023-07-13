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
}
