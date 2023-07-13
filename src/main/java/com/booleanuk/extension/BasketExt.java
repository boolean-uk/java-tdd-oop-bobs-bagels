package com.booleanuk.extension;

import java.util.ArrayList;

public class BasketExt {

    private ArrayList<CoffeeExt> coffeesInBasket;
    private ArrayList<BagelExt> bagelsInBasket;
    private ArrayList<FillingExt> fillingInBasket;


    public BasketExt() {
        this.coffeesInBasket =new ArrayList<>();
        this.bagelsInBasket = new ArrayList<>();
        this.fillingInBasket = new ArrayList<>();
    }




    public void add(BagelExt bagelExt){
        bagelsInBasket.add(bagelExt);
    }

    public void add(CoffeeExt coffeeExt){
        coffeesInBasket.add(coffeeExt);
    }
    public void add(FillingExt fillingExt){
        fillingInBasket.add(fillingExt);
    }


    public ArrayList<CoffeeExt> getCoffeesInBasket() {
        return coffeesInBasket;
    }

    public ArrayList<BagelExt> getBagelsInBasket() {
        return bagelsInBasket;
    }

    public ArrayList<FillingExt> getFillingInBasket() {
        return fillingInBasket;
    }
}
