package com.booleanuk.core;

import java.util.HashMap;
// The Filling Class is used to create fillings.

public class Filling extends Item{

    public Filling(String type){

        this.setPurchase(false);
        switch (type){
            case "Bacon":
                this.setSku("FILB");
                this.setName("Bacon");
                this.setPrice(0.12);
                break;
            case "Egg":
                this.setSku("FILE");
                this.setName("Egg");
                this.setPrice(0.12);
                break;
            case "Cheese":
                this.setSku("FILC");
                this.setName("Cheese");
                this.setPrice(0.12);
                break;
            case "Cream cheese":
                this.setSku("FILX");
                this.setName("Cream cheese");
                this.setPrice(0.12);
                break;
            case "Smoked Salmon":
                this.setSku("FILS");
                this.setName("Smoked Salmon");
                this.setPrice(0.12);
                break;
            case "Ham":
                this.setSku("FILH");
                this.setName("Ham");
                this.setPrice(0.12);
                break;

            default:
                System.out.println("Not available");

        }
    }


}
