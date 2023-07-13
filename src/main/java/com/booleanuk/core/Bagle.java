package com.booleanuk.core;

import java.util.ArrayList;

public class Bagle extends Product{
    private BagleType bagleType;
    private ArrayList<FillingType> bagleFillingList = new ArrayList<>();;

    public Bagle(BagleType bagleType) {
        this.bagleType = bagleType;
        updatePrice();
    }
    public void addFilling(FillingType fillingType){
        bagleFillingList.add(fillingType);
        addToPrice(fillingType.getPrice());
    }
    private void updatePrice(){
        setPrice(bagleType.getPrice());
    }
}