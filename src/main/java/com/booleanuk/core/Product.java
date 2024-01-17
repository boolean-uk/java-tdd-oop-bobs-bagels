package com.booleanuk.core;

public class Product {
    public String type;
    public String [] variant;
    public String [] sku;
    public double [] price;
}

class Bagel extends Product{
    public String [][] bagels = new String[4][4];
    public Bagel() {
        super();
        this.type = "Bagel";
        sku = new String[]{"BGLO","BGLP","BGLE","BLGS"};
        variant = new String[]{"Onion", "Plain","Everything","Sesame"};
        price = new double[]{0.49, 0.39,0.49,0.49};
        for (int i = 0; i <sku.length; i++){
            bagels[i][0] = sku[i];
            bagels[i][1] = type;
            bagels[i][2] = variant[i];
            bagels[i][3] = String.valueOf(price[i]);
        }
    }
}

class Coffee extends Product{
    public String [][] coffee = new String[4][4];
    public Coffee() {
        super();
        this.type = "Coffee";
        sku = new String[]{"COFB","COFW","COFC","COFL"};
        variant = new String[]{"Black", "White","Cappuccino","Latte"};
        price = new double[]{0.99, 1.99, 1.29, 1.29};
        for (int i = 0; i <sku.length; i++){
            coffee[i][0] = sku[i];
            coffee[i][1] = type;
            coffee[i][2] = variant[i];
            coffee[i][3] = String.valueOf(price[i]);
        }
    }
}

class Filling extends Product{
    public String [][] filling = new String[6][4];
    public Filling() {
        super();
        this.type = "Filling";
        sku = new String[]{"FILB","FILE","FILC","FILX", "FILS", "FILH"};
        variant = new String[]{"Bacon", "Egg","Cheese","Cream Cheese",
                "Smoked Salmon", "Ham"};
        price = new double[]{0.12};
        for (int i = 0; i <sku.length; i++){
            filling[i][0] = sku[i];
            filling[i][1] = type;
            filling[i][2] = variant[i];
            filling[i][3] = String.valueOf(price[0]);
        }
    }
}


