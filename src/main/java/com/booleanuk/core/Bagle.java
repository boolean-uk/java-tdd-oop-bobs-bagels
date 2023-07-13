package com.booleanuk.core;

import java.util.ArrayList;

public class Bagle extends Product{
    private BagleType bagleType;
    private ArrayList<FillingType> bagleFillingList = new ArrayList<>();;

    public Bagle(BagleType bagleType) {
        this.bagleType = bagleType;
    }
    public void addFilling(FillingType fillingType){

    }
    private void updatePrice(){

    }
}
