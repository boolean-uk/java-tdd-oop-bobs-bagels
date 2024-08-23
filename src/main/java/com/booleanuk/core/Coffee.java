package com.booleanuk.core;

// The Coffee Class is used to create Coffee items
public class Coffee extends Item{
    public Coffee(String type){

        switch (type) {
            case "Black":
                SKU="COFB";
                name="Black Coffee";
                Purchase=true;
                Price=0.99;
                break;
            case "White":
                SKU="COFW";
                name="White Coffee";
                Purchase=true;
                Price=1.19;
                break;
            case "Capuccino":
                SKU="COFC";
                name="Capuccino";
                Purchase=true;
                Price=1.29;
                break;
            case "Latte":
                SKU="COFL";
                name="Latte";
                Purchase=true;
                Price=1.29;
                break;
            default:
                System.out.println("Not available");


        }

    }
}
