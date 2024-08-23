package com.booleanuk.core;

import java.util.HashMap;
// The Filling Class is used to create fillings.

public class Filling extends Item{

    public Filling(String type){
        switch (type){
            case "Bacon":
                SKU="FILB";
                name="Bacon";
                Price=0.12;
                break;
            case "Egg":
                SKU="FILE";
                name="Egg";
                Price=0.12;
                break;
            case "Cheese":
                SKU="FILC";
                name="Cheese";
                Price=0.12;
                break;
            case "Cream cheese":
                SKU="FILX";
                name="Cream cheese";
                Price=0.12;
                break;
            case "Smoked Salmon":
                SKU="FILS";
                name="Smoked Salmon";
                Price=0.12;
                break;
            case "Ham":
                SKU="FILH";
                name="Ham";
                Price=0.12;
                break;

            default:
                System.out.println("Not available");

        }
    }


}
